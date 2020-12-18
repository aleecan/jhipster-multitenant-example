package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AdditionalGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AdditionalGroup} and its DTO {@link AdditionalGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AdditionalGroupMapper extends EntityMapper<AdditionalGroupDTO, AdditionalGroup> {



    default AdditionalGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        AdditionalGroup additionalGroup = new AdditionalGroup();
        additionalGroup.setId(id);
        return additionalGroup;
    }
}
