package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.UserUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserUserRepository extends JpaRepository<UserUser, Long> {
}
