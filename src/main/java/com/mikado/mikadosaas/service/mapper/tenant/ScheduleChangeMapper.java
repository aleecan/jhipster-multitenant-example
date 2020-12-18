package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ScheduleChangeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ScheduleChange} and its DTO {@link ScheduleChangeDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class})
public interface ScheduleChangeMapper extends EntityMapper<ScheduleChangeDTO, ScheduleChange> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    ScheduleChangeDTO toDto(ScheduleChange scheduleChange);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    ScheduleChange toEntity(ScheduleChangeDTO scheduleChangeDTO);

    default ScheduleChange fromId(Long id) {
        if (id == null) {
            return null;
        }
        ScheduleChange scheduleChange = new ScheduleChange();
        scheduleChange.setId(id);
        return scheduleChange;
    }
}
