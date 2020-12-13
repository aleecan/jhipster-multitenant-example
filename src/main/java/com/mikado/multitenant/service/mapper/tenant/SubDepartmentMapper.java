package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.SubDepartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SubDepartment} and its DTO {@link SubDepartmentDTO}.
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface SubDepartmentMapper extends EntityMapper<SubDepartmentDTO, SubDepartment> {

    @Mapping(source = "department.id", target = "departmentId")
    SubDepartmentDTO toDto(SubDepartment subDepartment);

    @Mapping(source = "departmentId", target = "department")
    SubDepartment toEntity(SubDepartmentDTO subDepartmentDTO);

    default SubDepartment fromId(Long id) {
        if (id == null) {
            return null;
        }
        SubDepartment subDepartment = new SubDepartment();
        subDepartment.setId(id);
        return subDepartment;
    }
}
