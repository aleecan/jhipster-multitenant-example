package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.RequestOvertime;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RequestOvertime entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestOvertimeRepository extends JpaRepository<RequestOvertime, Long> {
}
