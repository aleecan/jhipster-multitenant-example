package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.DailyTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DailyTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
}
