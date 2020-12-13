package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AccessRangeVisitor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AccessRangeVisitor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccessRangeVisitorRepository extends JpaRepository<AccessRangeVisitor, Long> {
}
