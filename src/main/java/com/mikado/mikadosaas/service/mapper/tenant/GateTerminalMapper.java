package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.GateTerminalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GateTerminal} and its DTO {@link GateTerminalDTO}.
 */
@Mapper(componentModel = "spring", uses = {GateMapper.class, TerminalMapper.class})
public interface GateTerminalMapper extends EntityMapper<GateTerminalDTO, GateTerminal> {

    @Mapping(source = "gate.id", target = "gateId")
    @Mapping(source = "terminal.id", target = "terminalId")
    GateTerminalDTO toDto(GateTerminal gateTerminal);

    @Mapping(source = "gateId", target = "gate")
    @Mapping(source = "terminalId", target = "terminal")
    GateTerminal toEntity(GateTerminalDTO gateTerminalDTO);

    default GateTerminal fromId(Long id) {
        if (id == null) {
            return null;
        }
        GateTerminal gateTerminal = new GateTerminal();
        gateTerminal.setId(id);
        return gateTerminal;
    }
}
