package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.groups.AnnualLeaveGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualLeaveGroupRepository
		extends JpaRepository<AnnualLeaveGroup, Long>, QueryDslPredicateExecutor<AnnualLeaveGroup> {

}
