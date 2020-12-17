package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Daily;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Daily entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DailyRepository extends JpaRepository<Daily, Long> {
}
