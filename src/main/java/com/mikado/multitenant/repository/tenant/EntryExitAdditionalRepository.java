package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.EntryExitAdditional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitAdditional entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitAdditionalRepository extends JpaRepository<EntryExitAdditional, Long> {
}
