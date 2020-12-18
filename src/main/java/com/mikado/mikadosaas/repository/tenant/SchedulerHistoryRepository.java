package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.SchedulerHistory;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SchedulerHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchedulerHistoryRepository extends JpaRepository<SchedulerHistory, Long> {
}
