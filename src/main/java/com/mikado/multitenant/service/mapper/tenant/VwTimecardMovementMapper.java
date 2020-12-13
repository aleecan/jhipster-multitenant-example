package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.VwTimecardMovementDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VwTimecardMovement} and its DTO {@link VwTimecardMovementDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VwTimecardMovementMapper extends EntityMapper<VwTimecardMovementDTO, VwTimecardMovement> {



    default VwTimecardMovement fromId(Long id) {
        if (id == null) {
            return null;
        }
        VwTimecardMovement vwTimecardMovement = new VwTimecardMovement();
        vwTimecardMovement.setId(id);
        return vwTimecardMovement;
    }
}
