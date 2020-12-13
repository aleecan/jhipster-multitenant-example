package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Normal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Normal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NormalRepository extends JpaRepository<Normal, Long> {
}
