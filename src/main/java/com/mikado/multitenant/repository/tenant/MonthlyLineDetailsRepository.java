package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyLineDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonthlyLineDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyLineDetailsRepository extends JpaRepository<MonthlyLineDetails, Long> {
}
