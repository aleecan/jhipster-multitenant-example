package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlySum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlySum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlySumRepository extends JpaRepository<MonthlySum, Long> {
}
