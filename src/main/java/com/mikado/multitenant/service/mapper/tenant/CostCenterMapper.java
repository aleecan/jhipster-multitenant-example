package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.CostCenterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CostCenter} and its DTO {@link CostCenterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CostCenterMapper extends EntityMapper<CostCenterDTO, CostCenter> {



    default CostCenter fromId(Long id) {
        if (id == null) {
            return null;
        }
        CostCenter costCenter = new CostCenter();
        costCenter.setId(id);
        return costCenter;
    }
}
