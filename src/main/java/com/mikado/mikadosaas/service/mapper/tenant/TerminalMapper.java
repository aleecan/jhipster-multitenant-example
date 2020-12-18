package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TerminalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Terminal} and its DTO {@link TerminalDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyFirmMapper.class, CompanySubFirmMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class})
public interface TerminalMapper extends EntityMapper<TerminalDTO, Terminal> {

    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    TerminalDTO toDto(Terminal terminal);

    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    Terminal toEntity(TerminalDTO terminalDTO);

    default Terminal fromId(Long id) {
        if (id == null) {
            return null;
        }
        Terminal terminal = new Terminal();
        terminal.setId(id);
        return terminal;
    }
}
