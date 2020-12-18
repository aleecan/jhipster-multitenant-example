package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalMessage;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TerminalMessage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalMessageRepository extends JpaRepository<TerminalMessage, Long> {
}
