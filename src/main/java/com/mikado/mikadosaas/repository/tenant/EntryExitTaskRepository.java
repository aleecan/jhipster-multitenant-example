package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExitTask;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitTaskRepository extends JpaRepository<EntryExitTask, Long> {
}
