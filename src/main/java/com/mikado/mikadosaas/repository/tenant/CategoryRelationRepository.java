package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.CategoryRelation;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CategoryRelation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRelationRepository extends JpaRepository<CategoryRelation, Long> {
}
