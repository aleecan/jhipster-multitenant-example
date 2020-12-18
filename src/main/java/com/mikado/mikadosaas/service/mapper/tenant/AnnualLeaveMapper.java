package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeave} and its DTO {@link AnnualLeaveDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ScheduleMapper.class})
public interface AnnualLeaveMapper extends EntityMapper<AnnualLeaveDTO, AnnualLeave> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "schedule.id", target = "scheduleId")
    AnnualLeaveDTO toDto(AnnualLeave annualLeave);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "scheduleId", target = "schedule")
    AnnualLeave toEntity(AnnualLeaveDTO annualLeaveDTO);

    default AnnualLeave fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeave annualLeave = new AnnualLeave();
        annualLeave.setId(id);
        return annualLeave;
    }
}
