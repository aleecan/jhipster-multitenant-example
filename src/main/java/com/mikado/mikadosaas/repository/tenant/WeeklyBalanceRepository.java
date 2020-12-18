package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyBalance;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyBalance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyBalanceRepository extends JpaRepository<WeeklyBalance, Long> {
}
