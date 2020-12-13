package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.UserForgetPasswordToken;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserForgetPasswordToken entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserForgetPasswordTokenRepository extends JpaRepository<UserForgetPasswordToken, Long> {
}
