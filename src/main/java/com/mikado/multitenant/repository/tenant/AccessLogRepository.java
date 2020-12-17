package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AccessLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessLog entity.
 */
@Repository
public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
