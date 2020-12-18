package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Normal;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Normal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NormalRepository extends JpaRepository<Normal, Long> {
}
