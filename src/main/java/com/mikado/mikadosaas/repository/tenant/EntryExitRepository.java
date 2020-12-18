package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitRepository extends JpaRepository<EntryExit, Long> {
}
