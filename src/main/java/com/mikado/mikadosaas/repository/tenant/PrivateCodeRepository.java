package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.PrivateCode;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PrivateCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PrivateCodeRepository extends JpaRepository<PrivateCode, Long> {
}
