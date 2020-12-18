package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.CostCenter;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CostCenter entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
