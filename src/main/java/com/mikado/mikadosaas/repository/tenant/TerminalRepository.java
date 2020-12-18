package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Terminal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Terminal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
