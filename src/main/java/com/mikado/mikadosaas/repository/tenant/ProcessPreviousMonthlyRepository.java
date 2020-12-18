package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessPreviousMonthly;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessPreviousMonthly entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessPreviousMonthlyRepository extends JpaRepository<ProcessPreviousMonthly, Long> {
}
