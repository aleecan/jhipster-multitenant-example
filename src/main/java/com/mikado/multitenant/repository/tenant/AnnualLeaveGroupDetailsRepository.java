package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveGroupDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AnnualLeaveGroupDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnnualLeaveGroupDetailsRepository extends JpaRepository<AnnualLeaveGroupDetails, Long> {
}
