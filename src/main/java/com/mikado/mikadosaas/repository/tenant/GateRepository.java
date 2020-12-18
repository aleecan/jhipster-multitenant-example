package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Gate;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Gate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
}
