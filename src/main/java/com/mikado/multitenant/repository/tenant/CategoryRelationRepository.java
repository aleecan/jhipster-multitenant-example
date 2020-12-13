package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.CategoryRelation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CategoryRelation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRelationRepository extends JpaRepository<CategoryRelation, Long> {
}
