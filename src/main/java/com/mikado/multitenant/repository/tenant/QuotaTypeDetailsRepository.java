package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.QuotaTypeDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaTypeDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaTypeDetailsRepository extends JpaRepository<QuotaTypeDetails, Long> {
}
