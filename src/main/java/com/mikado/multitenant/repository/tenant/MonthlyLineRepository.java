package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyLine;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyLine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyLineRepository extends JpaRepository<MonthlyLine, Long> {
}
