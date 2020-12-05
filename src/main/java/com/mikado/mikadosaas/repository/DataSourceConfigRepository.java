package com.mikado.mikadosaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikado.mikadosaas.domain.DataSourceConfig;


/**
 * Spring Data JPA repository for the DataSourceConfig entity.
 */
@Repository
public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {

}
