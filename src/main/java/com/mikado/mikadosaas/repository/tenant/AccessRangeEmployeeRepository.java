package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AccessRangeEmployee;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessRangeEmployee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccessRangeEmployeeRepository extends JpaRepository<AccessRangeEmployee, Long> {
}
