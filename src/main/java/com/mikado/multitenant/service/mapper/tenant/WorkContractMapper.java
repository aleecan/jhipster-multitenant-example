package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.WorkContractDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkContract} and its DTO {@link WorkContractDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WorkContractMapper extends EntityMapper<WorkContractDTO, WorkContract> {



    default WorkContract fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkContract workContract = new WorkContract();
        workContract.setId(id);
        return workContract;
    }
}
