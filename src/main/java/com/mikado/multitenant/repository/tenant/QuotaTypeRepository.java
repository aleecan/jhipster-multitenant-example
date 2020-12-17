package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.QuotaType;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaTypeRepository extends JpaRepository<QuotaType, Long> {
}
