package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExitAdditional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitAdditional entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitAdditionalRepository extends JpaRepository<EntryExitAdditional, Long> {
}
