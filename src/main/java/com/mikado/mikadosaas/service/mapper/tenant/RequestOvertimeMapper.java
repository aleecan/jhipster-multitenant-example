package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.RequestOvertimeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RequestOvertime} and its DTO {@link RequestOvertimeDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, OvertimeReasonMapper.class})
public interface RequestOvertimeMapper extends EntityMapper<RequestOvertimeDTO, RequestOvertime> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "overtimeReason.id", target = "overtimeReasonId")
    RequestOvertimeDTO toDto(RequestOvertime requestOvertime);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "overtimeReasonId", target = "overtimeReason")
    RequestOvertime toEntity(RequestOvertimeDTO requestOvertimeDTO);

    default RequestOvertime fromId(Long id) {
        if (id == null) {
            return null;
        }
        RequestOvertime requestOvertime = new RequestOvertime();
        requestOvertime.setId(id);
        return requestOvertime;
    }
}
