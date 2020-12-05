package com.mikado.mikadosaas.security;

import com.mikado.mikadosaas.config.Constants;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Optional.of(SecurityUtils.getCurrentUserLogin()).orElse(Constants.SYSTEM_ACCOUNT));
    }
}
