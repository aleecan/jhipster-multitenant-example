package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.CalendarHoliday;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CalendarHoliday entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CalendarHolidayRepository extends JpaRepository<CalendarHoliday, Long> {
}
