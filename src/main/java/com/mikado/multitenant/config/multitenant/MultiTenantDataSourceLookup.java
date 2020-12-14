package com.mikado.multitenant.config.multitenant;

import java.util.ArrayList;
import java.util.Collection;

import com.mikado.multitenant.config.DatabaseConfiguration;
import com.mikado.multitenant.domain.DataSourceConfig;
import com.mikado.multitenant.repository.DataSourceConfigRepository;
import com.zaxxer.hikari.metrics.micrometer.MicrometerMetricsTrackerFactory;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import liquibase.integration.spring.MultiTenantSpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

import io.github.jhipster.config.JHipsterConstants;
import io.github.jhipster.config.liquibase.AsyncSpringLiquibase;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

@Component(value = "dataSourceLookup")
public class MultiTenantDataSourceLookup extends MapDataSourceLookup {

    private static final String DEFAULT_TENANTID = "default";
    private final Logger logger = LoggerFactory.getLogger(MultiTenantDataSourceLookup.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private LiquibaseProperties liquibaseProperties;

    @Autowired
    private Environment environment;

    @Autowired
    private ResourceLoader resourceLoader;

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    public MultiTenantDataSourceLookup(HikariDataSource defaultDataSource, ApplicationContext context) {
        super();
        addDataSource(DEFAULT_TENANTID, defaultDataSource);
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) throws LiquibaseException, Exception {
        DataSourceConfigRepository configRepository = context.getBean(DataSourceConfigRepository.class);
        addTenantDataSources(configRepository.findAll());
    }

    void addTenantDataSources(Collection<DataSourceConfig> dataSources) throws LiquibaseException, Exception {
        for (DataSourceConfig dataSource : dataSources) {
            // Add new datasource with own configuration per tenant
            HikariDataSource customDataSource = createTenantDataSource(dataSource);
            addDataSource(dataSource.getName(), customDataSource);
            liquibaseUpdate(customDataSource);
            logger.info("Configured tenant: " + dataSource.getName());
        }
    }

    private void liquibaseUpdate(HikariDataSource customDataSource) throws Exception {

        MultiTenantSpringLiquibase multi = new MultiTenantSpringLiquibase();
        multi.setDataSource(customDataSource);
        multi.setChangeLog("classpath:config/tenant-liquibase/master.xml");
        multi.setContexts(liquibaseProperties.getContexts());
        multi.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        multi.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
        multi.setLiquibaseTablespace(liquibaseProperties.getLiquibaseTablespace());
        multi.setDatabaseChangeLogLockTable(liquibaseProperties.getDatabaseChangeLogLockTable());
        multi.setDatabaseChangeLogTable(liquibaseProperties.getDatabaseChangeLogTable());
        multi.setDropFirst(liquibaseProperties.isDropFirst());
        multi.setLabels(liquibaseProperties.getLabels());
        multi.setRollbackFile(liquibaseProperties.getRollbackFile());

        if (environment.acceptsProfiles(Profiles.of(JHipsterConstants.SPRING_PROFILE_NO_LIQUIBASE))) {
            multi.setShouldRun(false);
        } else {
            multi.setShouldRun(liquibaseProperties.isEnabled());
            log.debug("Configuring Liquibase multitenant mode");
        }
        multi.afterPropertiesSet();

    }

    private HikariDataSource createTenantDataSource(DataSourceConfig dataSource) {
        HikariDataSource customDataSource = new HikariDataSource();
        customDataSource.setJdbcUrl(dataSource.getUrl());
        customDataSource.setUsername(dataSource.getUsername());
        customDataSource.setPassword(dataSource.getPassword());
        customDataSource.setAutoCommit(false);
        customDataSource.setAllowPoolSuspension(false);
        customDataSource.setIdleTimeout(600000);
        customDataSource.setIsolateInternalQueries(false);
        customDataSource.setMaxLifetime(1800000);
        customDataSource.setMaximumPoolSize(10);
        customDataSource.setMinimumIdle(10);
        customDataSource.setReadOnly(false);
        customDataSource.setValidationTimeout(5000);
        customDataSource.setInitializationFailTimeout(1);
        customDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        customDataSource.setRegisterMbeans(false);
        customDataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        customDataSource.addDataSourceProperty("useServerPrepStmts", "true");
        customDataSource.addDataSourceProperty("cachePrepStmts", "true");
        customDataSource.addDataSourceProperty("prepStmtCacheSize", "250");
        MicrometerMetricsTrackerFactory tracker = new MicrometerMetricsTrackerFactory(new SimpleMeterRegistry());
        customDataSource.setMetricsTrackerFactory(tracker);
        return customDataSource;
    }

}
