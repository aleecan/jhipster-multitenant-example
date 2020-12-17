package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.EntryExitChangeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntryExitChange} and its DTO {@link EntryExitChangeDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntryExitMapper.class})
public interface EntryExitChangeMapper extends EntityMapper<EntryExitChangeDTO, EntryExitChange> {

    @Mapping(source = "entryExit.id", target = "entryExitId")
    EntryExitChangeDTO toDto(EntryExitChange entryExitChange);

    @Mapping(source = "entryExitId", target = "entryExit")
    EntryExitChange toEntity(EntryExitChangeDTO entryExitChangeDTO);

    default EntryExitChange fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntryExitChange entryExitChange = new EntryExitChange();
        entryExitChange.setId(id);
        return entryExitChange;
    }
}
