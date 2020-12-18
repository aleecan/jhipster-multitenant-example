package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TimezoneDay;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TimezoneDay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimezoneDayRepository extends JpaRepository<TimezoneDay, Long> {
}
