package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AccessLogDTO;

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
