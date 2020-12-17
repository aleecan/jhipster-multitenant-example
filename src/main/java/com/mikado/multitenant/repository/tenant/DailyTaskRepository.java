package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.DailyTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DailyTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
}
