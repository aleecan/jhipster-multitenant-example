package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Monthly;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Monthly entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonthlyRepository extends JpaRepository<Monthly, Long> {
}
