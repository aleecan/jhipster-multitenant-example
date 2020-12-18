package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntryExit} and its DTO {@link EntryExitDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class, OvertimeReasonMapper.class})
public interface EntryExitMapper extends EntityMapper<EntryExitDTO, EntryExit> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    @Mapping(source = "defaultSchedule.id", target = "defaultScheduleId")
    @Mapping(source = "overtimeReason.id", target = "overtimeReasonId")
    EntryExitDTO toDto(EntryExit entryExit);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    @Mapping(source = "defaultScheduleId", target = "defaultSchedule")
    @Mapping(source = "overtimeReasonId", target = "overtimeReason")
    EntryExit toEntity(EntryExitDTO entryExitDTO);

    default EntryExit fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntryExit entryExit = new EntryExit();
        entryExit.setId(id);
        return entryExit;
    }
}
