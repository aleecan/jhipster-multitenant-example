package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.CalendarHoliday;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CalendarHoliday entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CalendarHolidayRepository extends JpaRepository<CalendarHoliday, Long> {
}
