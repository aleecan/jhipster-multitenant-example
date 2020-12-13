package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.AdditionalGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AdditionalGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdditionalGroupRepository extends JpaRepository<AdditionalGroup, Long> {
}
