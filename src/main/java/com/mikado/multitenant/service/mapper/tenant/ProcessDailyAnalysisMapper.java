package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ProcessDailyAnalysisDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessDailyAnalysis} and its DTO {@link ProcessDailyAnalysisDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProcessDailyAnalysisMapper extends EntityMapper<ProcessDailyAnalysisDTO, ProcessDailyAnalysis> {



    default ProcessDailyAnalysis fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessDailyAnalysis processDailyAnalysis = new ProcessDailyAnalysis();
        processDailyAnalysis.setId(id);
        return processDailyAnalysis;
    }
}
