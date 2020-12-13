package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.JobScheduler;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JobScheduler entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobSchedulerRepository extends JpaRepository<JobScheduler, Long> {
}
