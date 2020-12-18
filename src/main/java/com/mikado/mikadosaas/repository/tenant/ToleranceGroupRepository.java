package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ToleranceGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ToleranceGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ToleranceGroupRepository extends JpaRepository<ToleranceGroup, Long> {
}
