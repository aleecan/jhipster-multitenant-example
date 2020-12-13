package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.GroupCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GroupCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GroupCodeRepository extends JpaRepository<GroupCode, Long> {
}
