package com.mikado.multitenant.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import io.github.jhipster.config.liquibase.SpringLiquibaseUtil;
import org.hibernate.MultiTenancyStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codahale.metrics.MetricRegistry;
import com.mikado.multitenant.config.multitenant.CurrentTenantIdentifierResolverImpl;
import com.mikado.multitenant.config.multitenant.MultiTenantConnectionProviderImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.github.jhipster.config.JHipsterConstants;
import io.github.jhipster.config.liquibase.AsyncSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableJpaRepositories("com.mikado.multitenant.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Autowired
    MultiTenantConnectionProviderImpl dsProvider;

    @Autowired
    CurrentTenantIdentifierResolverImpl tenantResolver;

    @Autowired
    DataSource defaultDataSource;

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private final Environment env;

    @Autowired
    ApplicationContext context;

    @Autowired(required = false)
    private MetricRegistry metricRegistry;

    public DatabaseConfiguration(Environment env) {
        this.env = env;
    }


    @Bean
    public SpringLiquibase liquibase(@Qualifier("taskExecutor") Executor executor,
                                     @LiquibaseDataSource ObjectProvider<DataSource> liquibaseDataSource, LiquibaseProperties liquibaseProperties,
                                     ObjectProvider<DataSource> dataSource, DataSourceProperties dataSourceProperties) {

        // If you don't want Liquibase to start asynchronously, substitute by this:
        // SpringLiquibase liquibase = SpringLiquibaseUtil.createSpringLiquibase(liquibaseDataSource.getIfAvailable(), liquibaseProperties, dataSource.getIfUnique(), dataSourceProperties);
        SpringLiquibase liquibase = SpringLiquibaseUtil.createAsyncSpringLiquibase(this.env, executor,
            liquibaseDataSource.getIfAvailable(), liquibaseProperties, dataSource.getIfUnique(), dataSourceProperties);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
        liquibase.setLiquibaseTablespace(liquibaseProperties.getLiquibaseTablespace());
        liquibase.setDatabaseChangeLogLockTable(liquibaseProperties.getDatabaseChangeLogLockTable());
        liquibase.setDatabaseChangeLogTable(liquibaseProperties.getDatabaseChangeLogTable());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setLabels(liquibaseProperties.getLabels());
        liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
        liquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
        liquibase.setTestRollbackOnUpdate(liquibaseProperties.isTestRollbackOnUpdate());
        if (env.acceptsProfiles(Profiles.of(JHipsterConstants.SPRING_PROFILE_NO_LIQUIBASE))) {
            liquibase.setShouldRun(false);
        } else {
            liquibase.setShouldRun(liquibaseProperties.isEnabled());
            log.debug("Configuring Liquibase");
        }
        return liquibase;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        // Generate DDL is not supported in Hibernate to multi-tenancy features
        // https://hibernate.atlassian.net/browse/HHH-7395
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        String prefix = "spring.jpa.";
        String end = ".enabled";
        //RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "spring.jpa.");
        hibernateJpaVendorAdapter.setDatabase(Database.valueOf(Objects.requireNonNull(env.getProperty(prefix + "database"))));
        hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean(env.getProperty(prefix + "show-sql")));
        hibernateJpaVendorAdapter.setDatabasePlatform(env.getProperty(prefix + "database-platform"));
        return hibernateJpaVendorAdapter;
    }


/*    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        log.debug("Configuring Datasource");
        String prefix = "spring.datasource.";
        String end = ".enabled";
        if (env.getProperty(prefix + "url" + end) == null && env.getProperty(prefix + "databaseName" + end) == null) {
            log.error("Your database connection pool configuration is incorrect! The application" +
                    "cannot start. Please check your Spring profile, current profiles are: {}",
                    Arrays.toString(env.getActiveProfiles()));

            throw new ApplicationContextException("Database connection pool is not configured correctly");
        }
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(env.getProperty(prefix + "dataSourceClassName" + end));
        if (env.getProperty(prefix + "url" + end) == null || "".equals(env.getProperty(prefix + "url" + end))) {
            config.addDataSourceProperty("databaseName", env.getProperty(prefix + "databaseName" + end));
            config.addDataSourceProperty("serverName", env.getProperty(prefix + "serverName" + end));
        } else {
            config.setJdbcUrl(env.getProperty(prefix + "url" + end));
        }
        config.setUsername(env.getProperty(prefix + "username" + end));
        config.setPassword(env.getProperty(prefix + "password" + end));

        if (metricRegistry != null) {
            config.setMetricRegistry(metricRegistry);
        }
        return new HikariDataSource(config);
    }*/

    /**
     * Configures the Hibernate JPA service with multi-tenant support enabled.
     *
     * @param builder
     * @return
     */
    @PersistenceContext
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        String prefix = "spring.jpa.properties";
        String end = ".enabled";

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.multiTenancy", MultiTenancyStrategy.DATABASE.name());
        props.put("hibernate.multi_tenant_connection_provider", dsProvider);
        props.put("hibernate.tenant_identifier_resolver", tenantResolver);
        props.put("hibernate.id.new_generator_mappings", env.getProperty(prefix + "hibernate.id.new_generator_mappings"));
        props.put("hibernate.cache.use_second_level_cache", env.getProperty(prefix + "hibernate.cache.use_second_level_cache"));
        props.put("hibernate.cache.use_query_cache", env.getProperty(prefix + "hibernate.cache.use_query_cache"));
        props.put("hibernate.generate_statistics", env.getProperty(prefix + "hibernate.generate_statistics"));

        LocalContainerEntityManagerFactoryBean result = builder.dataSource(defaultDataSource)
            .persistenceUnit("default")
            .properties(props)
            .packages("com.mikado").build();
        result.setJpaVendorAdapter(jpaVendorAdapter());
        return result;
    }
}
