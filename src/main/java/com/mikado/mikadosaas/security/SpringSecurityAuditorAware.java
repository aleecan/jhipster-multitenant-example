package com.mikado.mikadosaas.security;

import com.mikado.mikadosaas.config.Constants;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentUserLogin();
        return userName != null ? Optional.of(userName) : Optional.of(Constants.SYSTEM_ACCOUNT);
    }
}
