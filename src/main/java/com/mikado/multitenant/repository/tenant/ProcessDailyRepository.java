package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ProcessDaily;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProcessDaily entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessDailyRepository extends JpaRepository<ProcessDaily, Long> {
}
