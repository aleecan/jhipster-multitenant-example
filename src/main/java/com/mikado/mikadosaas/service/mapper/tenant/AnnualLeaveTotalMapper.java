package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveTotalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeaveTotal} and its DTO {@link AnnualLeaveTotalDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface AnnualLeaveTotalMapper extends EntityMapper<AnnualLeaveTotalDTO, AnnualLeaveTotal> {

    @Mapping(source = "employee.id", target = "employeeId")
    AnnualLeaveTotalDTO toDto(AnnualLeaveTotal annualLeaveTotal);

    @Mapping(source = "employeeId", target = "employee")
    AnnualLeaveTotal toEntity(AnnualLeaveTotalDTO annualLeaveTotalDTO);

    default AnnualLeaveTotal fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeaveTotal annualLeaveTotal = new AnnualLeaveTotal();
        annualLeaveTotal.setId(id);
        return annualLeaveTotal;
    }
}
