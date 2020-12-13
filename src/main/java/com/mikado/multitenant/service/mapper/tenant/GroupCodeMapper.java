package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.GroupCodeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GroupCode} and its DTO {@link GroupCodeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GroupCodeMapper extends EntityMapper<GroupCodeDTO, GroupCode> {



    default GroupCode fromId(Long id) {
        if (id == null) {
            return null;
        }
        GroupCode groupCode = new GroupCode();
        groupCode.setId(id);
        return groupCode;
    }
}
