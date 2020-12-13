package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.VisitorCompanyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VisitorCompany} and its DTO {@link VisitorCompanyDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VisitorCompanyMapper extends EntityMapper<VisitorCompanyDTO, VisitorCompany> {



    default VisitorCompany fromId(Long id) {
        if (id == null) {
            return null;
        }
        VisitorCompany visitorCompany = new VisitorCompany();
        visitorCompany.setId(id);
        return visitorCompany;
    }
}
