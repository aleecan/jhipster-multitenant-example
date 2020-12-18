package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CalendarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Calendar} and its DTO {@link CalendarDTO}.
 */
@Mapper(componentModel = "spring", uses = {WeeklyWorkMapper.class, ScheduleMapper.class, ProcessEntryExitMapper.class, ProcessHolidayLeaveMapper.class, ProcessDailyAnalysisMapper.class, ProcessDailyMapper.class, ProcessMonthlyMapper.class, ProcessPreviousMonthlyMapper.class})
public interface CalendarMapper extends EntityMapper<CalendarDTO, Calendar> {

    @Mapping(source = "weekly.id", target = "weeklyId")
    @Mapping(source = "standardSchedule.id", target = "standardScheduleId")
    @Mapping(source = "saturdaySchedule.id", target = "saturdayScheduleId")
    @Mapping(source = "weekendSchedule.id", target = "weekendScheduleId")
    @Mapping(source = "absentSchedule.id", target = "absentScheduleId")
    @Mapping(source = "processEntryExit.id", target = "processEntryExitId")
    @Mapping(source = "processHolidayLeave.id", target = "processHolidayLeaveId")
    @Mapping(source = "processDailyAnalysis.id", target = "processDailyAnalysisId")
    @Mapping(source = "processDaily.id", target = "processDailyId")
    @Mapping(source = "processMonthly.id", target = "processMonthlyId")
    @Mapping(source = "processPreviousMonthly.id", target = "processPreviousMonthlyId")
    CalendarDTO toDto(Calendar calendar);

    @Mapping(source = "weeklyId", target = "weekly")
    @Mapping(source = "standardScheduleId", target = "standardSchedule")
    @Mapping(source = "saturdayScheduleId", target = "saturdaySchedule")
    @Mapping(source = "weekendScheduleId", target = "weekendSchedule")
    @Mapping(source = "absentScheduleId", target = "absentSchedule")
    @Mapping(source = "processEntryExitId", target = "processEntryExit")
    @Mapping(source = "processHolidayLeaveId", target = "processHolidayLeave")
    @Mapping(source = "processDailyAnalysisId", target = "processDailyAnalysis")
    @Mapping(source = "processDailyId", target = "processDaily")
    @Mapping(source = "processMonthlyId", target = "processMonthly")
    @Mapping(source = "processPreviousMonthlyId", target = "processPreviousMonthly")
    Calendar toEntity(CalendarDTO calendarDTO);

    default Calendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        Calendar calendar = new Calendar();
        calendar.setId(id);
        return calendar;
    }
}
