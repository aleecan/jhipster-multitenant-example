package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.Additional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Additional entity.
 */

@Repository
public interface AdditionalRepository extends JpaRepository<Additional, Long> {

}
