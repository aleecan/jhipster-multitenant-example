package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AccessLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessLog entity.
 */
@Repository
public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
