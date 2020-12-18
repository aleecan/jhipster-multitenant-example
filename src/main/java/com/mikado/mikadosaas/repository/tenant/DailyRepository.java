package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Daily;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Daily entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyRepository extends JpaRepository<Daily, Long> {
}
