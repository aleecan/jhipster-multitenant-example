package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.CompanySubFirm;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CompanySubFirm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompanySubFirmRepository extends JpaRepository<CompanySubFirm, Long> {
}
