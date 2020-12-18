package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyWork;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyWork entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyWorkRepository extends JpaRepository<WeeklyWork, Long> {
}
