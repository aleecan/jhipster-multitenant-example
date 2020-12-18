package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeaveGroup} and its DTO {@link AnnualLeaveGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AnnualLeaveGroupMapper extends EntityMapper<AnnualLeaveGroupDTO, AnnualLeaveGroup> {



    default AnnualLeaveGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeaveGroup annualLeaveGroup = new AnnualLeaveGroup();
        annualLeaveGroup.setId(id);
        return annualLeaveGroup;
    }
}
