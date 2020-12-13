package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ProcessEntryExit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessEntryExit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessEntryExitRepository extends JpaRepository<ProcessEntryExit, Long> {
}
