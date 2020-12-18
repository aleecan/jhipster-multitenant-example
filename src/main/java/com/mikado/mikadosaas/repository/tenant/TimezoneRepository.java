package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Timezone;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Timezone entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
}
