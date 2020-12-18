package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.MusteringPoint;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MusteringPoint entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MusteringPointRepository extends JpaRepository<MusteringPoint, Long> {
}
