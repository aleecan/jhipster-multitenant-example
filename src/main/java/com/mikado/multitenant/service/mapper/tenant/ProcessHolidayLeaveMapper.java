package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ProcessHolidayLeaveDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessHolidayLeave} and its DTO {@link ProcessHolidayLeaveDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProcessHolidayLeaveMapper extends EntityMapper<ProcessHolidayLeaveDTO, ProcessHolidayLeave> {



    default ProcessHolidayLeave fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessHolidayLeave processHolidayLeave = new ProcessHolidayLeave();
        processHolidayLeave.setId(id);
        return processHolidayLeave;
    }
}
