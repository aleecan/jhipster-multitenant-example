package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.UserForgetPasswordToken;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserForgetPasswordToken entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserForgetPasswordTokenRepository extends JpaRepository<UserForgetPasswordToken, Long> {
}
