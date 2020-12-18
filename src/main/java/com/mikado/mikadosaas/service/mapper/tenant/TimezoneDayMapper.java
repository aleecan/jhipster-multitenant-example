package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneDayDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TimezoneDay} and its DTO {@link TimezoneDayDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TimezoneDayMapper extends EntityMapper<TimezoneDayDTO, TimezoneDay> {



    default TimezoneDay fromId(Long id) {
        if (id == null) {
            return null;
        }
        TimezoneDay timezoneDay = new TimezoneDay();
        timezoneDay.setId(id);
        return timezoneDay;
    }
}
