package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Weekly;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Weekly entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyRepository extends JpaRepository<Weekly, Long> {
}
