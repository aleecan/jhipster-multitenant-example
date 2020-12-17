package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.DailyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Daily} and its DTO {@link DailyDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class, OvertimeReasonMapper.class, CategoryMapper.class})
public interface DailyMapper extends EntityMapper<DailyDTO, Daily> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    @Mapping(source = "overtimeReason.id", target = "overtimeReasonId")
    @Mapping(source = "absentCategory.id", target = "absentCategoryId")
    @Mapping(source = "weekOvertimeCategory.id", target = "weekOvertimeCategoryId")
    DailyDTO toDto(Daily daily);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    @Mapping(source = "overtimeReasonId", target = "overtimeReason")
    @Mapping(source = "absentCategoryId", target = "absentCategory")
    @Mapping(source = "weekOvertimeCategoryId", target = "weekOvertimeCategory")
    Daily toEntity(DailyDTO dailyDTO);

    default Daily fromId(Long id) {
        if (id == null) {
            return null;
        }
        Daily daily = new Daily();
        daily.setId(id);
        return daily;
    }
}
