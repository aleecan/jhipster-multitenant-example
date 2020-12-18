package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyPreviousDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyPreviousDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyPreviousDetailsRepository extends JpaRepository<MonthlyPreviousDetails, Long> {
}
