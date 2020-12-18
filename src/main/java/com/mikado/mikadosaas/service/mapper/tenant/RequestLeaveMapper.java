package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.RequestLeaveDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RequestLeave} and its DTO {@link RequestLeaveDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class})
public interface RequestLeaveMapper extends EntityMapper<RequestLeaveDTO, RequestLeave> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    RequestLeaveDTO toDto(RequestLeave requestLeave);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    RequestLeave toEntity(RequestLeaveDTO requestLeaveDTO);

    default RequestLeave fromId(Long id) {
        if (id == null) {
            return null;
        }
        RequestLeave requestLeave = new RequestLeave();
        requestLeave.setId(id);
        return requestLeave;
    }
}
