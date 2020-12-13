package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TerminalActivityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TerminalActivity} and its DTO {@link TerminalActivityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TerminalActivityMapper extends EntityMapper<TerminalActivityDTO, TerminalActivity> {



    default TerminalActivity fromId(Long id) {
        if (id == null) {
            return null;
        }
        TerminalActivity terminalActivity = new TerminalActivity();
        terminalActivity.setId(id);
        return terminalActivity;
    }
}
