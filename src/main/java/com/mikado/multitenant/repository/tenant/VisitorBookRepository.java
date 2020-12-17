package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.VisitorBook;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the VisitorBook entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisitorBookRepository extends JpaRepository<VisitorBook, Long> {
}
