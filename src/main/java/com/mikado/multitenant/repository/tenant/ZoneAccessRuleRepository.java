package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ZoneAccessRule;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ZoneAccessRule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneAccessRuleRepository extends JpaRepository<ZoneAccessRule, Long> {
}
