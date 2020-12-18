package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneCalendarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TimezoneCalendar} and its DTO {@link TimezoneCalendarDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TimezoneCalendarMapper extends EntityMapper<TimezoneCalendarDTO, TimezoneCalendar> {



    default TimezoneCalendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        TimezoneCalendar timezoneCalendar = new TimezoneCalendar();
        timezoneCalendar.setId(id);
        return timezoneCalendar;
    }
}
