package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ZoneGate;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ZoneGate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneGateRepository extends JpaRepository<ZoneGate, Long> {
}
