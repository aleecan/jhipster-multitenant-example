package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AuthorizationGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AuthorizationGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorizationGroupRepository extends JpaRepository<AuthorizationGroup, Long> {
}
