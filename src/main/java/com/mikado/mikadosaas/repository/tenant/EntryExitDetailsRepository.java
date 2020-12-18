package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExitDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EntryExitDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntryExitDetailsRepository extends JpaRepository<EntryExitDetails, Long> {
}
