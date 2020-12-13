package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.JobSchedulerDay;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JobSchedulerDay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobSchedulerDayRepository extends JpaRepository<JobSchedulerDay, Long> {
}
