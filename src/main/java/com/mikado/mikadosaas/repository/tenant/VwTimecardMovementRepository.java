package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.VwTimecardMovement;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the VwTimecardMovement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VwTimecardMovementRepository extends JpaRepository<VwTimecardMovement, Long> {
}
