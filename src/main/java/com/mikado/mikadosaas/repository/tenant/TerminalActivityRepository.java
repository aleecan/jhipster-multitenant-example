package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalActivity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TerminalActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalActivityRepository extends JpaRepository<TerminalActivity, Long> {
}
