package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ApproverDepartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ApproverDepartment} and its DTO {@link ApproverDepartmentDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, DepartmentMapper.class, SubDepartmentMapper.class})
public interface ApproverDepartmentMapper extends EntityMapper<ApproverDepartmentDTO, ApproverDepartment> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "subDepartment.id", target = "subDepartmentId")
    ApproverDepartmentDTO toDto(ApproverDepartment approverDepartment);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "subDepartmentId", target = "subDepartment")
    ApproverDepartment toEntity(ApproverDepartmentDTO approverDepartmentDTO);

    default ApproverDepartment fromId(Long id) {
        if (id == null) {
            return null;
        }
        ApproverDepartment approverDepartment = new ApproverDepartment();
        approverDepartment.setId(id);
        return approverDepartment;
    }
}
