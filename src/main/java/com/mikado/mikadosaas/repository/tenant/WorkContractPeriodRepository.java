package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.WorkContractPeriod;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WorkContractPeriod entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkContractPeriodRepository extends JpaRepository<WorkContractPeriod, Long> {
}
