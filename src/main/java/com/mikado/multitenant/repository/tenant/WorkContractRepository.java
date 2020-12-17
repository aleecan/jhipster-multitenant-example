package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.WorkContract;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WorkContract entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkContractRepository extends JpaRepository<WorkContract, Long> {
}
