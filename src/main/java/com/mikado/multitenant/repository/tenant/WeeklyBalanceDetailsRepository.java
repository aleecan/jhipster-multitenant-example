package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.WeeklyBalanceDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyBalanceDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyBalanceDetailsRepository extends JpaRepository<WeeklyBalanceDetails, Long> {
}
