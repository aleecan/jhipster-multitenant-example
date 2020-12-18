package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalActivitySchedule;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TerminalActivitySchedule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalActivityScheduleRepository extends JpaRepository<TerminalActivitySchedule, Long> {
}
