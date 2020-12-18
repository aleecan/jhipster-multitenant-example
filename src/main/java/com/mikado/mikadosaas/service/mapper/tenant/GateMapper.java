package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.GateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Gate} and its DTO {@link GateDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyFirmMapper.class, CompanySubFirmMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class})
public interface GateMapper extends EntityMapper<GateDTO, Gate> {

    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    GateDTO toDto(Gate gate);

    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    Gate toEntity(GateDTO gateDTO);

    default Gate fromId(Long id) {
        if (id == null) {
            return null;
        }
        Gate gate = new Gate();
        gate.setId(id);
        return gate;
    }
}
