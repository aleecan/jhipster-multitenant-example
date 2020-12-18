package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ProcessMonthlyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessMonthly} and its DTO {@link ProcessMonthlyDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyLineMapper.class})
public interface ProcessMonthlyMapper extends EntityMapper<ProcessMonthlyDTO, ProcessMonthly> {

    @Mapping(source = "lineForDiffMax.id", target = "lineForDiffMaxId")
    @Mapping(source = "lineForDiffMin.id", target = "lineForDiffMinId")
    ProcessMonthlyDTO toDto(ProcessMonthly processMonthly);

    @Mapping(source = "lineForDiffMaxId", target = "lineForDiffMax")
    @Mapping(source = "lineForDiffMinId", target = "lineForDiffMin")
    ProcessMonthly toEntity(ProcessMonthlyDTO processMonthlyDTO);

    default ProcessMonthly fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessMonthly processMonthly = new ProcessMonthly();
        processMonthly.setId(id);
        return processMonthly;
    }
}
