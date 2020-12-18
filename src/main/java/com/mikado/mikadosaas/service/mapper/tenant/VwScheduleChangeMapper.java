package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.VwScheduleChangeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VwScheduleChange} and its DTO {@link VwScheduleChangeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VwScheduleChangeMapper extends EntityMapper<VwScheduleChangeDTO, VwScheduleChange> {



    default VwScheduleChange fromId(Long id) {
        if (id == null) {
            return null;
        }
        VwScheduleChange vwScheduleChange = new VwScheduleChange();
        vwScheduleChange.setId(id);
        return vwScheduleChange;
    }
}
