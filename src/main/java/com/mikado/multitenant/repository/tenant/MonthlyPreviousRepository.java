package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyPrevious;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyPrevious entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyPreviousRepository extends JpaRepository<MonthlyPrevious, Long> {
}
