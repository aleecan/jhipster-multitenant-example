package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AccessLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccessLog} and its DTO {@link AccessLogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccessLogMapper extends EntityMapper<AccessLogDTO, AccessLog> {



    default AccessLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccessLog accessLog = new AccessLog();
        accessLog.setId(id);
        return accessLog;
    }
}
