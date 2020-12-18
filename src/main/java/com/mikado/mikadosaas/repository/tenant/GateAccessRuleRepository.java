package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.GateAccessRule;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GateAccessRule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateAccessRuleRepository extends JpaRepository<GateAccessRule, Long> {
}
