package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Visitor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Visitor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
