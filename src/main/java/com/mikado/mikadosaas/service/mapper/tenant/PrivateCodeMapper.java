package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.PrivateCodeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PrivateCode} and its DTO {@link PrivateCodeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PrivateCodeMapper extends EntityMapper<PrivateCodeDTO, PrivateCode> {



    default PrivateCode fromId(Long id) {
        if (id == null) {
            return null;
        }
        PrivateCode privateCode = new PrivateCode();
        privateCode.setId(id);
        return privateCode;
    }
}
