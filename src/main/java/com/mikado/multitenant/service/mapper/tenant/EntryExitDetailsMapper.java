package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.EntryExitDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntryExitDetails} and its DTO {@link EntryExitDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntryExitMapper.class, CategoryMapper.class, TerminalMapper.class})
public interface EntryExitDetailsMapper extends EntityMapper<EntryExitDetailsDTO, EntryExitDetails> {

    @Mapping(source = "entryExit.id", target = "entryExitId")
    @Mapping(source = "entryReason.id", target = "entryReasonId")
    @Mapping(source = "entryTerminal.id", target = "entryTerminalId")
    @Mapping(source = "exitReason.id", target = "exitReasonId")
    @Mapping(source = "exitTerminal.id", target = "exitTerminalId")
    @Mapping(source = "newEntryReason.id", target = "newEntryReasonId")
    @Mapping(source = "newExitReason.id", target = "newExitReasonId")
    EntryExitDetailsDTO toDto(EntryExitDetails entryExitDetails);

    @Mapping(source = "entryExitId", target = "entryExit")
    @Mapping(source = "entryReasonId", target = "entryReason")
    @Mapping(source = "entryTerminalId", target = "entryTerminal")
    @Mapping(source = "exitReasonId", target = "exitReason")
    @Mapping(source = "exitTerminalId", target = "exitTerminal")
    @Mapping(source = "newEntryReasonId", target = "newEntryReason")
    @Mapping(source = "newExitReasonId", target = "newExitReason")
    EntryExitDetails toEntity(EntryExitDetailsDTO entryExitDetailsDTO);

    default EntryExitDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntryExitDetails entryExitDetails = new EntryExitDetails();
        entryExitDetails.setId(id);
        return entryExitDetails;
    }
}
