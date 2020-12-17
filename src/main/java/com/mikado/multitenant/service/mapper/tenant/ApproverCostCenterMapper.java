package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ApproverCostCenterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ApproverCostCenter} and its DTO {@link ApproverCostCenterDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CostCenterMapper.class})
public interface ApproverCostCenterMapper extends EntityMapper<ApproverCostCenterDTO, ApproverCostCenter> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "costCenter.id", target = "costCenterId")
    ApproverCostCenterDTO toDto(ApproverCostCenter approverCostCenter);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "costCenterId", target = "costCenter")
    ApproverCostCenter toEntity(ApproverCostCenterDTO approverCostCenterDTO);

    default ApproverCostCenter fromId(Long id) {
        if (id == null) {
            return null;
        }
        ApproverCostCenter approverCostCenter = new ApproverCostCenter();
        approverCostCenter.setId(id);
        return approverCostCenter;
    }
}
