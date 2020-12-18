package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.VwScheduleChange;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the VwScheduleChange entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VwScheduleChangeRepository extends JpaRepository<VwScheduleChange, Long> {
}
