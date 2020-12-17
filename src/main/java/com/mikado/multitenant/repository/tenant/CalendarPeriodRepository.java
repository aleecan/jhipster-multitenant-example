package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.CalendarPeriod;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CalendarPeriod entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CalendarPeriodRepository extends JpaRepository<CalendarPeriod, Long> {
}
