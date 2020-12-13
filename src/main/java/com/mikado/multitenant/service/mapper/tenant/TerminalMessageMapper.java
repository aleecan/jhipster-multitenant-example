package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TerminalMessageDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TerminalMessage} and its DTO {@link TerminalMessageDTO}.
 */
@Mapper(componentModel = "spring", uses = {TerminalMapper.class, AccessCodeMapper.class, AuthorizationGroupMapper.class})
public interface TerminalMessageMapper extends EntityMapper<TerminalMessageDTO, TerminalMessage> {

    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "authorizationGroup.id", target = "authorizationGroupId")
    TerminalMessageDTO toDto(TerminalMessage terminalMessage);

    @Mapping(source = "terminalId", target = "terminal")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "authorizationGroupId", target = "authorizationGroup")
    TerminalMessage toEntity(TerminalMessageDTO terminalMessageDTO);

    default TerminalMessage fromId(Long id) {
        if (id == null) {
            return null;
        }
        TerminalMessage terminalMessage = new TerminalMessage();
        terminalMessage.setId(id);
        return terminalMessage;
    }
}
