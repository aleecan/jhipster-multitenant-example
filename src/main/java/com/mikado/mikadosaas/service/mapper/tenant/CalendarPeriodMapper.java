package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CalendarPeriodDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CalendarPeriod} and its DTO {@link CalendarPeriodDTO}.
 */
@Mapper(componentModel = "spring", uses = {CalendarMapper.class})
public interface CalendarPeriodMapper extends EntityMapper<CalendarPeriodDTO, CalendarPeriod> {

    @Mapping(source = "calendar.id", target = "calendarId")
    CalendarPeriodDTO toDto(CalendarPeriod calendarPeriod);

    @Mapping(source = "calendarId", target = "calendar")
    CalendarPeriod toEntity(CalendarPeriodDTO calendarPeriodDTO);

    default CalendarPeriod fromId(Long id) {
        if (id == null) {
            return null;
        }
        CalendarPeriod calendarPeriod = new CalendarPeriod();
        calendarPeriod.setId(id);
        return calendarPeriod;
    }
}
