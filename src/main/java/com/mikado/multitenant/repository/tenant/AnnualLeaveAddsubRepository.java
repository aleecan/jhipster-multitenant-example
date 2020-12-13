package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveAddsub;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AnnualLeaveAddsub entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnnualLeaveAddsubRepository extends JpaRepository<AnnualLeaveAddsub, Long> {
}
