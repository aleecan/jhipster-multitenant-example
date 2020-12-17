package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ToleranceGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ToleranceGroup} and its DTO {@link ToleranceGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ToleranceGroupMapper extends EntityMapper<ToleranceGroupDTO, ToleranceGroup> {



    default ToleranceGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        ToleranceGroup toleranceGroup = new ToleranceGroup();
        toleranceGroup.setId(id);
        return toleranceGroup;
    }
}
