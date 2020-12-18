package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.RequestLeave;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RequestLeave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestLeaveRepository extends JpaRepository<RequestLeave, Long> {
}
