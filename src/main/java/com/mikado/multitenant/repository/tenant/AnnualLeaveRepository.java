package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeave;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AnnualLeave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnnualLeaveRepository extends JpaRepository<AnnualLeave, Long> {
}
