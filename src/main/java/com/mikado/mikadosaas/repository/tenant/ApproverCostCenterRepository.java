package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ApproverCostCenter;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ApproverCostCenter entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApproverCostCenterRepository extends JpaRepository<ApproverCostCenter, Long> {
}
