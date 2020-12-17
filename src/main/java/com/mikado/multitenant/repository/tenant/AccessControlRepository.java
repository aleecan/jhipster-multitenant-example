package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AccessControl;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessControl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccessControlRepository extends JpaRepository<AccessControl, Long> {
}
