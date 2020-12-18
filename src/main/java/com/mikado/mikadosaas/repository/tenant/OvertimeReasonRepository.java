package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.OvertimeReason;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OvertimeReason entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OvertimeReasonRepository extends JpaRepository<OvertimeReason, Long> {
}
