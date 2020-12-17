package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Staff;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Staff entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
