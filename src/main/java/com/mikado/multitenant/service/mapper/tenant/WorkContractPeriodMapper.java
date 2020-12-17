package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.WorkContractPeriodDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkContractPeriod} and its DTO {@link WorkContractPeriodDTO}.
 */
@Mapper(componentModel = "spring", uses = {WorkContractMapper.class, ProcessEntryExitMapper.class, ProcessHolidayLeaveMapper.class, ProcessDailyAnalysisMapper.class, ProcessDailyMapper.class, ProcessMonthlyMapper.class, ProcessPreviousMonthlyMapper.class})
public interface WorkContractPeriodMapper extends EntityMapper<WorkContractPeriodDTO, WorkContractPeriod> {

    @Mapping(source = "workContract.id", target = "workContractId")
    @Mapping(source = "processEntryExit.id", target = "processEntryExitId")
    @Mapping(source = "processHolidayLeave.id", target = "processHolidayLeaveId")
    @Mapping(source = "processDailyAnalysis.id", target = "processDailyAnalysisId")
    @Mapping(source = "processDaily.id", target = "processDailyId")
    @Mapping(source = "processMonthly.id", target = "processMonthlyId")
    @Mapping(source = "processPreviousMonthly.id", target = "processPreviousMonthlyId")
    WorkContractPeriodDTO toDto(WorkContractPeriod workContractPeriod);

    @Mapping(source = "workContractId", target = "workContract")
    @Mapping(source = "processEntryExitId", target = "processEntryExit")
    @Mapping(source = "processHolidayLeaveId", target = "processHolidayLeave")
    @Mapping(source = "processDailyAnalysisId", target = "processDailyAnalysis")
    @Mapping(source = "processDailyId", target = "processDaily")
    @Mapping(source = "processMonthlyId", target = "processMonthly")
    @Mapping(source = "processPreviousMonthlyId", target = "processPreviousMonthly")
    WorkContractPeriod toEntity(WorkContractPeriodDTO workContractPeriodDTO);

    default WorkContractPeriod fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkContractPeriod workContractPeriod = new WorkContractPeriod();
        workContractPeriod.setId(id);
        return workContractPeriod;
    }
}
