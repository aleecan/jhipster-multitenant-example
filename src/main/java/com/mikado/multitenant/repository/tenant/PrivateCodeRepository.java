package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.PrivateCode;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PrivateCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PrivateCodeRepository extends JpaRepository<PrivateCode, Long> {
}
