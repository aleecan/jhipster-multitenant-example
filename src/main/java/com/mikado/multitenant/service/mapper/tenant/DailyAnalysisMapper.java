package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.DailyAnalysisDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DailyAnalysis} and its DTO {@link DailyAnalysisDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class, OvertimeReasonMapper.class, CategoryMapper.class})
public interface DailyAnalysisMapper extends EntityMapper<DailyAnalysisDTO, DailyAnalysis> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    @Mapping(source = "overtimeReason.id", target = "overtimeReasonId")
    @Mapping(source = "defaultSchedule.id", target = "defaultScheduleId")
    @Mapping(source = "startReason.id", target = "startReasonId")
    @Mapping(source = "finishReason.id", target = "finishReasonId")
    DailyAnalysisDTO toDto(DailyAnalysis dailyAnalysis);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    @Mapping(source = "overtimeReasonId", target = "overtimeReason")
    @Mapping(source = "defaultScheduleId", target = "defaultSchedule")
    @Mapping(source = "startReasonId", target = "startReason")
    @Mapping(source = "finishReasonId", target = "finishReason")
    DailyAnalysis toEntity(DailyAnalysisDTO dailyAnalysisDTO);

    default DailyAnalysis fromId(Long id) {
        if (id == null) {
            return null;
        }
        DailyAnalysis dailyAnalysis = new DailyAnalysis();
        dailyAnalysis.setId(id);
        return dailyAnalysis;
    }
}
