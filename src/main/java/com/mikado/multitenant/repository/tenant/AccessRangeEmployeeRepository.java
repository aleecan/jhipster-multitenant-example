package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AccessRangeEmployee;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessRangeEmployee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccessRangeEmployeeRepository extends JpaRepository<AccessRangeEmployee, Long> {
}
