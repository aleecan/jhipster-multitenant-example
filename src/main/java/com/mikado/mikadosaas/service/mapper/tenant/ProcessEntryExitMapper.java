package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ProcessEntryExitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessEntryExit} and its DTO {@link ProcessEntryExitDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProcessEntryExitMapper extends EntityMapper<ProcessEntryExitDTO, ProcessEntryExit> {



    default ProcessEntryExit fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessEntryExit processEntryExit = new ProcessEntryExit();
        processEntryExit.setId(id);
        return processEntryExit;
    }
}
