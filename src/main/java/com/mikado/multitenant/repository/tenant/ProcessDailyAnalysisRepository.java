package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ProcessDailyAnalysis;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessDailyAnalysis entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessDailyAnalysisRepository extends JpaRepository<ProcessDailyAnalysis, Long> {
}
