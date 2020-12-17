package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.WeeklyTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyTaskRepository extends JpaRepository<WeeklyTask, Long> {
}
