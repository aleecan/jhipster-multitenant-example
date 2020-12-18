package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AccessRangeEmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccessRangeEmployee} and its DTO {@link AccessRangeEmployeeDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface AccessRangeEmployeeMapper extends EntityMapper<AccessRangeEmployeeDTO, AccessRangeEmployee> {

    @Mapping(source = "employee.id", target = "employeeId")
    AccessRangeEmployeeDTO toDto(AccessRangeEmployee accessRangeEmployee);

    @Mapping(source = "employeeId", target = "employee")
    AccessRangeEmployee toEntity(AccessRangeEmployeeDTO accessRangeEmployeeDTO);

    default AccessRangeEmployee fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccessRangeEmployee accessRangeEmployee = new AccessRangeEmployee();
        accessRangeEmployee.setId(id);
        return accessRangeEmployee;
    }
}
