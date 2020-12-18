package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyTaskRepository extends JpaRepository<MonthlyTask, Long> {
}
