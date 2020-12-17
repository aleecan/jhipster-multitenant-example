package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.TimezoneDay;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TimezoneDay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimezoneDayRepository extends JpaRepository<TimezoneDay, Long> {
}
