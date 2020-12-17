package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyPreviousDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyPreviousDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyPreviousDetailsRepository extends JpaRepository<MonthlyPreviousDetails, Long> {
}
