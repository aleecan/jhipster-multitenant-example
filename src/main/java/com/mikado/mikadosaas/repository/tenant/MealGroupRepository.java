package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MealGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MealGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MealGroupRepository extends JpaRepository<MealGroup, Long> {
}
