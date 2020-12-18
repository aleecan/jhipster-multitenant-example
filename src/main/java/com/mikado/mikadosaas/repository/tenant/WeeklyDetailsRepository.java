package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WeeklyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeeklyDetailsRepository extends JpaRepository<WeeklyDetails, Long> {
}
