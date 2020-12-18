package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.JobScheduler;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JobScheduler entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobSchedulerRepository extends JpaRepository<JobScheduler, Long> {
}
