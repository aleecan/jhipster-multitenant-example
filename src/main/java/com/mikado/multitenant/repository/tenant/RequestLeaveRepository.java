package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.RequestLeave;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RequestLeave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestLeaveRepository extends JpaRepository<RequestLeave, Long> {
}
