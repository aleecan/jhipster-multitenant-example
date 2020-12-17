package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MailScheduler;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MailScheduler entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MailSchedulerRepository extends JpaRepository<MailScheduler, Long> {
}
