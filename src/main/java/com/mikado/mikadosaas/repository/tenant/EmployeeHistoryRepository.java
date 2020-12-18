package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.EmployeeHistory;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EmployeeHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeHistoryRepository extends JpaRepository<EmployeeHistory, Long> {
}
