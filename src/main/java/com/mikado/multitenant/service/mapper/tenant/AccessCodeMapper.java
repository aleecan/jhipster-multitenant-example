package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AccessCodeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccessCode} and its DTO {@link AccessCodeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccessCodeMapper extends EntityMapper<AccessCodeDTO, AccessCode> {



    default AccessCode fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccessCode accessCode = new AccessCode();
        accessCode.setId(id);
        return accessCode;
    }
}
