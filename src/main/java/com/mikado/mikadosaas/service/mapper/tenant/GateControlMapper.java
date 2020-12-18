package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.GateControlDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GateControl} and its DTO {@link GateControlDTO}.
 */
@Mapper(componentModel = "spring", uses = {GateMapper.class, AccessCodeMapper.class, EmployeeMapper.class, VisitorBookMapper.class, AccessControlMapper.class})
public interface GateControlMapper extends EntityMapper<GateControlDTO, GateControl> {

    @Mapping(source = "gate.id", target = "gateId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    @Mapping(source = "access.id", target = "accessId")
    GateControlDTO toDto(GateControl gateControl);

    @Mapping(source = "gateId", target = "gate")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitorBookId", target = "visitorBook")
    @Mapping(source = "accessId", target = "access")
    GateControl toEntity(GateControlDTO gateControlDTO);

    default GateControl fromId(Long id) {
        if (id == null) {
            return null;
        }
        GateControl gateControl = new GateControl();
        gateControl.setId(id);
        return gateControl;
    }
}
