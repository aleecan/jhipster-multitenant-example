package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AnnualLeaveTotal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AnnualLeaveTotal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnnualLeaveTotalRepository extends JpaRepository<AnnualLeaveTotal, Long> {
}
