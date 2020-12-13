package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Authorization;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Authorization entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
}
