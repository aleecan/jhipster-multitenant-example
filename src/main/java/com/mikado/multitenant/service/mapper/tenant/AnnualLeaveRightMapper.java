package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveRightDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeaveRight} and its DTO {@link AnnualLeaveRightDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface AnnualLeaveRightMapper extends EntityMapper<AnnualLeaveRightDTO, AnnualLeaveRight> {

    @Mapping(source = "employee.id", target = "employeeId")
    AnnualLeaveRightDTO toDto(AnnualLeaveRight annualLeaveRight);

    @Mapping(source = "employeeId", target = "employee")
    AnnualLeaveRight toEntity(AnnualLeaveRightDTO annualLeaveRightDTO);

    default AnnualLeaveRight fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeaveRight annualLeaveRight = new AnnualLeaveRight();
        annualLeaveRight.setId(id);
        return annualLeaveRight;
    }
}
