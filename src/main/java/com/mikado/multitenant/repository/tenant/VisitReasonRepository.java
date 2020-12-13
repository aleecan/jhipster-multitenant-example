package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.VisitReason;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the VisitReason entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisitReasonRepository extends JpaRepository<VisitReason, Long> {
}
