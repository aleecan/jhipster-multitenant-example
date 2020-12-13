package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AccessCode;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessCode entity.
 */
@Repository
public interface AccessCodeRepository extends JpaRepository<AccessCode, Long> {
}
