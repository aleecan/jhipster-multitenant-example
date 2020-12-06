package com.mikado.multitenant.config.multitenant;

import com.mikado.multitenant.security.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("tenantResolver")
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	private static final String DEFAULT_TENANTID = "default";

    @Override
    public String resolveCurrentTenantIdentifier() {
    	UserDetails currentUserDetail = SecurityUtils.getCurrentUserDetail();
    	if (currentUserDetail != null && currentUserDetail instanceof com.mikado.multitenant.security.UserDetails) {
    		String tenantId = ((com.mikado.multitenant.security.UserDetails) currentUserDetail).getTenantId();
    		if (StringUtils.isNotBlank(tenantId)) {
    			return tenantId;
    		}
    	}
        return DEFAULT_TENANTID;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
