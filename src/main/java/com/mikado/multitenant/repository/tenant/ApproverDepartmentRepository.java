package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.ApproverDepartment;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ApproverDepartment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApproverDepartmentRepository extends JpaRepository<ApproverDepartment, Long> {
}
