package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.CompanySubFirm;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CompanySubFirm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanySubFirmRepository extends JpaRepository<CompanySubFirm, Long> {
}
