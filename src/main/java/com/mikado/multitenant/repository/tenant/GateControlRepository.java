package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.GateControl;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GateControl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateControlRepository extends JpaRepository<GateControl, Long> {
}
