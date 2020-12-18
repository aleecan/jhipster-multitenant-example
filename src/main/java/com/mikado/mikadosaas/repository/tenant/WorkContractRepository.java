package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.WorkContract;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WorkContract entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkContractRepository extends JpaRepository<WorkContract, Long> {
}
