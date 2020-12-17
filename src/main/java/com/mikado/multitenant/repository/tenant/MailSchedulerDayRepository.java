package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.MailSchedulerDay;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MailSchedulerDay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MailSchedulerDayRepository extends JpaRepository<MailSchedulerDay, Long> {
}
