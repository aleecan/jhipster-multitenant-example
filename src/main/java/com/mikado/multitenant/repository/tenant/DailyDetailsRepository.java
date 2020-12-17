package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.DailyDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DailyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyDetailsRepository extends JpaRepository<DailyDetails, Long> {
}
