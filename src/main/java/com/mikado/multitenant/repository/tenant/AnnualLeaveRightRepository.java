package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveRight;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AnnualLeaveRight entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnnualLeaveRightRepository extends JpaRepository<AnnualLeaveRight, Long> {
}
