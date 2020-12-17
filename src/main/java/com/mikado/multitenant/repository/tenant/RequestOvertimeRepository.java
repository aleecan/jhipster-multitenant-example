package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.RequestOvertime;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RequestOvertime entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestOvertimeRepository extends JpaRepository<RequestOvertime, Long> {
}
