package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.QuotaBalance;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaBalance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaBalanceRepository extends JpaRepository<QuotaBalance, Long> {
}
