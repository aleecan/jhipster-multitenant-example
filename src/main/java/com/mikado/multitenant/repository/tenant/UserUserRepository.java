package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.UserUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserUserRepository extends JpaRepository<UserUser, Long> {
}
