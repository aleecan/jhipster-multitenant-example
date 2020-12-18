package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.NormalGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NormalGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NormalGroupRepository extends JpaRepository<NormalGroup, Long> {
}
