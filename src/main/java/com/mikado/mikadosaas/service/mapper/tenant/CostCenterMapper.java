package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CostCenterDTO;

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
