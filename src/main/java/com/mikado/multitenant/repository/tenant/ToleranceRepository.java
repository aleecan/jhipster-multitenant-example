package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Tolerance;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Tolerance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ToleranceRepository extends JpaRepository<Tolerance, Long> {
}
