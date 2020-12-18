package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MailScheduler;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MailScheduler entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MailSchedulerRepository extends JpaRepository<MailScheduler, Long> {
}
