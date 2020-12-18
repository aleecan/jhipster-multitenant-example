package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ZoneGateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ZoneGate} and its DTO {@link ZoneGateDTO}.
 */
@Mapper(componentModel = "spring", uses = {ZoneMapper.class, GateMapper.class})
public interface ZoneGateMapper extends EntityMapper<ZoneGateDTO, ZoneGate> {

    @Mapping(source = "zone.id", target = "zoneId")
    @Mapping(source = "gate.id", target = "gateId")
    ZoneGateDTO toDto(ZoneGate zoneGate);

    @Mapping(source = "zoneId", target = "zone")
    @Mapping(source = "gateId", target = "gate")
    ZoneGate toEntity(ZoneGateDTO zoneGateDTO);

    default ZoneGate fromId(Long id) {
        if (id == null) {
            return null;
        }
        ZoneGate zoneGate = new ZoneGate();
        zoneGate.setId(id);
        return zoneGate;
    }
}
