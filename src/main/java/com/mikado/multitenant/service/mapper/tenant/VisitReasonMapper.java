package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.VisitReasonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VisitReason} and its DTO {@link VisitReasonDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VisitReasonMapper extends EntityMapper<VisitReasonDTO, VisitReason> {



    default VisitReason fromId(Long id) {
        if (id == null) {
            return null;
        }
        VisitReason visitReason = new VisitReason();
        visitReason.setId(id);
        return visitReason;
    }
}
