package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.QuotaType;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaTypeRepository extends JpaRepository<QuotaType, Long> {
}
