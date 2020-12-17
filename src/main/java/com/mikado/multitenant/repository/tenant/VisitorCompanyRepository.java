package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.VisitorCompany;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the VisitorCompany entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisitorCompanyRepository extends JpaRepository<VisitorCompany, Long> {
}
