package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.AnnualLeaveGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualLeaveGroupRepository
		extends JpaRepository<AnnualLeaveGroup, Long>, QuerydslPredicateExecutor<AnnualLeaveGroup> {

}
