package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository
		extends JpaRepository<Category, Long>, QueryDslPredicateExecutor<Category> {

}
