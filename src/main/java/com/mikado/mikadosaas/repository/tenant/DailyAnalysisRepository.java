package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.DailyAnalysis;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DailyAnalysis entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyAnalysisRepository extends JpaRepository<DailyAnalysis, Long> {
}
