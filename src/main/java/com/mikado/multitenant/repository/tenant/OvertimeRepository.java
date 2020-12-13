package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Overtime;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Overtime entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
}
