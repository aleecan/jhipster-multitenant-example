package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.GateAccessRule;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GateAccessRule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateAccessRuleRepository extends JpaRepository<GateAccessRule, Long> {
}
