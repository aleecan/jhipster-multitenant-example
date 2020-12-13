package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.UserPermission;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserPermission entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
}
