package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.WeeklyBalance;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyBalance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyBalanceRepository extends JpaRepository<WeeklyBalance, Long> {
}
