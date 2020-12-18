package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.QuotaBalanceDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaBalanceDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaBalanceDetailsRepository extends JpaRepository<QuotaBalanceDetails, Long> {
}
