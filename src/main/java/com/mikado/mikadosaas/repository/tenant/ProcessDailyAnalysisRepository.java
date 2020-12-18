package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessDailyAnalysis;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessDailyAnalysis entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessDailyAnalysisRepository extends JpaRepository<ProcessDailyAnalysis, Long> {
}
