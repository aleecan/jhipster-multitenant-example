package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.OvertimeGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OvertimeGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OvertimeGroupRepository extends JpaRepository<OvertimeGroup, Long> {
}
