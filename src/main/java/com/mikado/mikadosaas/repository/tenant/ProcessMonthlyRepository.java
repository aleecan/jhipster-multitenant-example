package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessMonthly;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessMonthly entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessMonthlyRepository extends JpaRepository<ProcessMonthly, Long> {
}
