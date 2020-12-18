package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.QuotaTypeDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the QuotaTypeDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuotaTypeDetailsRepository extends JpaRepository<QuotaTypeDetails, Long> {
}
