package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TimecardMovementDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TimecardMovement} and its DTO {@link TimecardMovementDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CategoryMapper.class, TerminalMapper.class, AccessControlMapper.class})
public interface TimecardMovementMapper extends EntityMapper<TimecardMovementDTO, TimecardMovement> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "reason.id", target = "reasonId")
    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "accessControl.id", target = "accessControlId")
    TimecardMovementDTO toDto(TimecardMovement timecardMovement);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "reasonId", target = "reason")
    @Mapping(source = "terminalId", target = "terminal")
    @Mapping(source = "accessControlId", target = "accessControl")
    TimecardMovement toEntity(TimecardMovementDTO timecardMovementDTO);

    default TimecardMovement fromId(Long id) {
        if (id == null) {
            return null;
        }
        TimecardMovement timecardMovement = new TimecardMovement();
        timecardMovement.setId(id);
        return timecardMovement;
    }
}
