package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.EntryExitTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitTaskRepository extends JpaRepository<EntryExitTask, Long> {
}
