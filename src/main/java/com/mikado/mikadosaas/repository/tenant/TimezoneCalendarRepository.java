package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TimezoneCalendar;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TimezoneCalendar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimezoneCalendarRepository extends JpaRepository<TimezoneCalendar, Long> {
}
