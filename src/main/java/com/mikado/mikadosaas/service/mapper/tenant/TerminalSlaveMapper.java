package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TerminalSlaveDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TerminalSlave} and its DTO {@link TerminalSlaveDTO}.
 */
@Mapper(componentModel = "spring", uses = {TerminalMapper.class})
public interface TerminalSlaveMapper extends EntityMapper<TerminalSlaveDTO, TerminalSlave> {

    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "slaveTerminal.id", target = "slaveTerminalId")
    TerminalSlaveDTO toDto(TerminalSlave terminalSlave);

    @Mapping(source = "terminalId", target = "terminal")
    @Mapping(source = "slaveTerminalId", target = "slaveTerminal")
    TerminalSlave toEntity(TerminalSlaveDTO terminalSlaveDTO);

    default TerminalSlave fromId(Long id) {
        if (id == null) {
            return null;
        }
        TerminalSlave terminalSlave = new TerminalSlave();
        terminalSlave.setId(id);
        return terminalSlave;
    }
}
