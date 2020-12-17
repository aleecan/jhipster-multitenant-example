package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.EntryExitChange;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitChange entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitChangeRepository extends JpaRepository<EntryExitChange, Long> {
}
