package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.OvertimeGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OvertimeGroup} and its DTO {@link OvertimeGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OvertimeGroupMapper extends EntityMapper<OvertimeGroupDTO, OvertimeGroup> {



    default OvertimeGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        OvertimeGroup overtimeGroup = new OvertimeGroup();
        overtimeGroup.setId(id);
        return overtimeGroup;
    }
}
