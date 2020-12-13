package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyDetailsRepository extends JpaRepository<MonthlyDetails, Long> {
}
