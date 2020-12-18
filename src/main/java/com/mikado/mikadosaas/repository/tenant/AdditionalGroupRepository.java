package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AdditionalGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AdditionalGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdditionalGroupRepository extends JpaRepository<AdditionalGroup, Long> {
}
