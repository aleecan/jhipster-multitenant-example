package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.CalendarHolidayDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CalendarHoliday} and its DTO {@link CalendarHolidayDTO}.
 */
@Mapper(componentModel = "spring", uses = {ScheduleMapper.class})
public interface CalendarHolidayMapper extends EntityMapper<CalendarHolidayDTO, CalendarHoliday> {

    @Mapping(source = "calendarSchedule.id", target = "calendarScheduleId")
    @Mapping(source = "holidaySchedule.id", target = "holidayScheduleId")
    CalendarHolidayDTO toDto(CalendarHoliday calendarHoliday);

    @Mapping(source = "calendarScheduleId", target = "calendarSchedule")
    @Mapping(source = "holidayScheduleId", target = "holidaySchedule")
    CalendarHoliday toEntity(CalendarHolidayDTO calendarHolidayDTO);

    default CalendarHoliday fromId(Long id) {
        if (id == null) {
            return null;
        }
        CalendarHoliday calendarHoliday = new CalendarHoliday();
        calendarHoliday.setId(id);
        return calendarHoliday;
    }
}
