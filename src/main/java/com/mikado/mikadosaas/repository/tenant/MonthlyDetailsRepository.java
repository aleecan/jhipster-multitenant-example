package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyDetailsRepository extends JpaRepository<MonthlyDetails, Long> {
}
