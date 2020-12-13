package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ToleranceGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ToleranceGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ToleranceGroupRepository extends JpaRepository<ToleranceGroup, Long> {
}
