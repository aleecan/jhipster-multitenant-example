package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CompanyFirmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CompanyFirm} and its DTO {@link CompanyFirmDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CompanyFirmMapper extends EntityMapper<CompanyFirmDTO, CompanyFirm> {



    default CompanyFirm fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompanyFirm companyFirm = new CompanyFirm();
        companyFirm.setId(id);
        return companyFirm;
    }
}
