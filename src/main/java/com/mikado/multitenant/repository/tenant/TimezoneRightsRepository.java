package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.TimezoneRights;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TimezoneRights entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimezoneRightsRepository extends JpaRepository<TimezoneRights, Long> {
}
