package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CompanySubFirmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CompanySubFirm} and its DTO {@link CompanySubFirmDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyFirmMapper.class})
public interface CompanySubFirmMapper extends EntityMapper<CompanySubFirmDTO, CompanySubFirm> {

    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    CompanySubFirmDTO toDto(CompanySubFirm companySubFirm);

    @Mapping(source = "companyFirmId", target = "companyFirm")
    CompanySubFirm toEntity(CompanySubFirmDTO companySubFirmDTO);

    default CompanySubFirm fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompanySubFirm companySubFirm = new CompanySubFirm();
        companySubFirm.setId(id);
        return companySubFirm;
    }
}
