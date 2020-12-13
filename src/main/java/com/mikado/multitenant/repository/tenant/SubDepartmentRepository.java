package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.SubDepartment;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SubDepartment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Long> {
}
