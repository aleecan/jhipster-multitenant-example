package com.mikado.multitenant.repository.tenant;

import com.mikado.multitenant.domain.tenant.TextFileFormat;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TextFileFormat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TextFileFormatRepository extends JpaRepository<TextFileFormat, Long> {
}
