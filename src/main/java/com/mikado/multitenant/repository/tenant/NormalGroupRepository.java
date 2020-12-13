package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.NormalGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NormalGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NormalGroupRepository extends JpaRepository<NormalGroup, Long> {
}
