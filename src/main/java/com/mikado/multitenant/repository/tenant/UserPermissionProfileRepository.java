package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.UserPermissionProfile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserPermissionProfile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPermissionProfileRepository extends JpaRepository<UserPermissionProfile, Long> {
}
