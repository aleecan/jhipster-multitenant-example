package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.TerminalSlave;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TerminalSlave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalSlaveRepository extends JpaRepository<TerminalSlave, Long> {
}
