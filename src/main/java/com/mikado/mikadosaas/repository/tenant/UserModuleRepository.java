package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.UserModule;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserModule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserModuleRepository extends JpaRepository<UserModule, Long> {
}
