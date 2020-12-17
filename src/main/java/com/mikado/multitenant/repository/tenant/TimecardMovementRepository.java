package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.TimecardMovement;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TimecardMovement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimecardMovementRepository extends JpaRepository<TimecardMovement, Long> {
}
