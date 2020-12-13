package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ProcessHolidayLeave;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessHolidayLeave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessHolidayLeaveRepository extends JpaRepository<ProcessHolidayLeave, Long> {
}
