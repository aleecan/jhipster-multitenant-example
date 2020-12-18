package com.mikado.mikadosaas.repository.tenant;

import com.mikado.mikadosaas.domain.tenant.TextFileFormat;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TextFileFormat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TextFileFormatRepository extends JpaRepository<TextFileFormat, Long> {
}
