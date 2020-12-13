package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AccessControlDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccessControl} and its DTO {@link AccessControlDTO}.
 */
@Mapper(componentModel = "spring", uses = {TerminalMapper.class, AccessCodeMapper.class, EmployeeMapper.class, VisitorBookMapper.class, CategoryMapper.class})
public interface AccessControlMapper extends EntityMapper<AccessControlDTO, AccessControl> {

    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    @Mapping(source = "reason.id", target = "reasonId")
    AccessControlDTO toDto(AccessControl accessControl);

    @Mapping(source = "terminalId", target = "terminal")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitorBookId", target = "visitorBook")
    @Mapping(source = "reasonId", target = "reason")
    AccessControl toEntity(AccessControlDTO accessControlDTO);

    default AccessControl fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccessControl accessControl = new AccessControl();
        accessControl.setId(id);
        return accessControl;
    }
}
