package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.GateControl;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GateControl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateControlRepository extends JpaRepository<GateControl, Long> {
}
