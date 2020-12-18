package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.ZoneControl;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ZoneControl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneControlRepository extends JpaRepository<ZoneControl, Long> {
}
