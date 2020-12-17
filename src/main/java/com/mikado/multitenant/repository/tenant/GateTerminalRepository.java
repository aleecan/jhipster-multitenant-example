package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.GateTerminal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GateTerminal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateTerminalRepository extends JpaRepository<GateTerminal, Long> {
}
