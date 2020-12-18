package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Overtime;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Overtime entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
}
