package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ApproverCompanyFirm;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ApproverCompanyFirm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApproverCompanyFirmRepository extends JpaRepository<ApproverCompanyFirm, Long> {
}
