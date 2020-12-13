package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.OvertimeReasonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OvertimeReason} and its DTO {@link OvertimeReasonDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OvertimeReasonMapper extends EntityMapper<OvertimeReasonDTO, OvertimeReason> {



    default OvertimeReason fromId(Long id) {
        if (id == null) {
            return null;
        }
        OvertimeReason overtimeReason = new OvertimeReason();
        overtimeReason.setId(id);
        return overtimeReason;
    }
}
