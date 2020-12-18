package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ScheduleChange;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ScheduleChange entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ScheduleChangeRepository extends JpaRepository<ScheduleChange, Long> {
}
