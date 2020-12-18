package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ZoneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Zone} and its DTO {@link ZoneDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyFirmMapper.class, CompanySubFirmMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class})
public interface ZoneMapper extends EntityMapper<ZoneDTO, Zone> {

    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    ZoneDTO toDto(Zone zone);

    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    Zone toEntity(ZoneDTO zoneDTO);

    default Zone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Zone zone = new Zone();
        zone.setId(id);
        return zone;
    }
}
