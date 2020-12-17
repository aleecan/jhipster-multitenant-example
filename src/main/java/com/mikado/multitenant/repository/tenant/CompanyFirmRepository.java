package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.CompanyFirm;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CompanyFirm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanyFirmRepository extends JpaRepository<CompanyFirm, Long> {
}
