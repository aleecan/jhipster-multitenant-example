package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ProcessPreviousMonthlyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessPreviousMonthly} and its DTO {@link ProcessPreviousMonthlyDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyLineMapper.class})
public interface ProcessPreviousMonthlyMapper extends EntityMapper<ProcessPreviousMonthlyDTO, ProcessPreviousMonthly> {

    @Mapping(source = "lineForDiffMax.id", target = "lineForDiffMaxId")
    ProcessPreviousMonthlyDTO toDto(ProcessPreviousMonthly processPreviousMonthly);

    @Mapping(source = "lineForDiffMaxId", target = "lineForDiffMax")
    ProcessPreviousMonthly toEntity(ProcessPreviousMonthlyDTO processPreviousMonthlyDTO);

    default ProcessPreviousMonthly fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessPreviousMonthly processPreviousMonthly = new ProcessPreviousMonthly();
        processPreviousMonthly.setId(id);
        return processPreviousMonthly;
    }
}
