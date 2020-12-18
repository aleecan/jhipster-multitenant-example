package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.UserFilter;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserFilter entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserFilterRepository extends JpaRepository<UserFilter, Long> {
}
