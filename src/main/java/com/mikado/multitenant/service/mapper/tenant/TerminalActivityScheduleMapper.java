package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TerminalActivityScheduleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TerminalActivitySchedule} and its DTO {@link TerminalActivityScheduleDTO}.
 */
@Mapper(componentModel = "spring", uses = {TerminalMapper.class, TerminalActivityMapper.class})
public interface TerminalActivityScheduleMapper extends EntityMapper<TerminalActivityScheduleDTO, TerminalActivitySchedule> {

    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "activity.id", target = "activityId")
    TerminalActivityScheduleDTO toDto(TerminalActivitySchedule terminalActivitySchedule);

    @Mapping(source = "terminalId", target = "terminal")
    @Mapping(source = "activityId", target = "activity")
    TerminalActivitySchedule toEntity(TerminalActivityScheduleDTO terminalActivityScheduleDTO);

    default TerminalActivitySchedule fromId(Long id) {
        if (id == null) {
            return null;
        }
        TerminalActivitySchedule terminalActivitySchedule = new TerminalActivitySchedule();
        terminalActivitySchedule.setId(id);
        return terminalActivitySchedule;
    }
}
