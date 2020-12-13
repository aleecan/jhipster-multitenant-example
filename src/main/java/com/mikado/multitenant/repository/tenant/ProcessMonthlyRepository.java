package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ProcessMonthly;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessMonthly entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessMonthlyRepository extends JpaRepository<ProcessMonthly, Long> {
}
