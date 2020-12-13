package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Calendar} entity.
 */
public class CalendarDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 10)
    private String code;

    @Size(max = 80)
    private String description;

    private Integer assignShiftDay;

    private Integer shiftAssignMethod;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String dayStartTime;

    private Boolean applyWeeklyBalance;

    private Boolean balanceWeeksInMonth;

    private Boolean weekendDay;

    private Boolean flexibleWorkingTime;

    private Integer dayOff;

    private Boolean flexibleShift;

    private Double weekHours;

    private Double weekHoursMin;

    private Double weekHoursMax;

    private Integer monthlyBalance01;

    private Integer monthlyBalance02;

    private Integer monthlyBalance03;

    private Integer monthlyBalance04;

    private Integer monthlyBalance05;

    private Integer monthlyBalance06;

    private Integer monthlyBalance07;

    private Integer monthlyBalance08;

    private Integer monthlyBalance09;

    private Integer monthlyBalance10;

    private Integer monthlyBalance11;

    private Integer monthlyBalance12;

    private Boolean ownCalendar;

    private Boolean ownWeeklyWork;

    private Boolean ownDayOff;

    private Boolean ownNaStartFlex;

    private Boolean ownSchedules;

    private Boolean ownWeekHours;

    private Boolean ownMonthlyBalance;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long weeklyId;

    private Long standardScheduleId;

    private Long saturdayScheduleId;

    private Long weekendScheduleId;

    private Long absentScheduleId;

    private Long processEntryExitId;

    private Long processHolidayLeaveId;

    private Long processDailyAnalysisId;

    private Long processDailyId;

    private Long processMonthlyId;

    private Long processPreviousMonthlyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAssignShiftDay() {
        return assignShiftDay;
    }

    public void setAssignShiftDay(Integer assignShiftDay) {
        this.assignShiftDay = assignShiftDay;
    }

    public Integer getShiftAssignMethod() {
        return shiftAssignMethod;
    }

    public void setShiftAssignMethod(Integer shiftAssignMethod) {
        this.shiftAssignMethod = shiftAssignMethod;
    }

    public String getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public Boolean isApplyWeeklyBalance() {
        return applyWeeklyBalance;
    }

    public void setApplyWeeklyBalance(Boolean applyWeeklyBalance) {
        this.applyWeeklyBalance = applyWeeklyBalance;
    }

    public Boolean isBalanceWeeksInMonth() {
        return balanceWeeksInMonth;
    }

    public void setBalanceWeeksInMonth(Boolean balanceWeeksInMonth) {
        this.balanceWeeksInMonth = balanceWeeksInMonth;
    }

    public Boolean isWeekendDay() {
        return weekendDay;
    }

    public void setWeekendDay(Boolean weekendDay) {
        this.weekendDay = weekendDay;
    }

    public Boolean isFlexibleWorkingTime() {
        return flexibleWorkingTime;
    }

    public void setFlexibleWorkingTime(Boolean flexibleWorkingTime) {
        this.flexibleWorkingTime = flexibleWorkingTime;
    }

    public Integer getDayOff() {
        return dayOff;
    }

    public void setDayOff(Integer dayOff) {
        this.dayOff = dayOff;
    }

    public Boolean isFlexibleShift() {
        return flexibleShift;
    }

    public void setFlexibleShift(Boolean flexibleShift) {
        this.flexibleShift = flexibleShift;
    }

    public Double getWeekHours() {
        return weekHours;
    }

    public void setWeekHours(Double weekHours) {
        this.weekHours = weekHours;
    }

    public Double getWeekHoursMin() {
        return weekHoursMin;
    }

    public void setWeekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
    }

    public Double getWeekHoursMax() {
        return weekHoursMax;
    }

    public void setWeekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
    }

    public Integer getMonthlyBalance01() {
        return monthlyBalance01;
    }

    public void setMonthlyBalance01(Integer monthlyBalance01) {
        this.monthlyBalance01 = monthlyBalance01;
    }

    public Integer getMonthlyBalance02() {
        return monthlyBalance02;
    }

    public void setMonthlyBalance02(Integer monthlyBalance02) {
        this.monthlyBalance02 = monthlyBalance02;
    }

    public Integer getMonthlyBalance03() {
        return monthlyBalance03;
    }

    public void setMonthlyBalance03(Integer monthlyBalance03) {
        this.monthlyBalance03 = monthlyBalance03;
    }

    public Integer getMonthlyBalance04() {
        return monthlyBalance04;
    }

    public void setMonthlyBalance04(Integer monthlyBalance04) {
        this.monthlyBalance04 = monthlyBalance04;
    }

    public Integer getMonthlyBalance05() {
        return monthlyBalance05;
    }

    public void setMonthlyBalance05(Integer monthlyBalance05) {
        this.monthlyBalance05 = monthlyBalance05;
    }

    public Integer getMonthlyBalance06() {
        return monthlyBalance06;
    }

    public void setMonthlyBalance06(Integer monthlyBalance06) {
        this.monthlyBalance06 = monthlyBalance06;
    }

    public Integer getMonthlyBalance07() {
        return monthlyBalance07;
    }

    public void setMonthlyBalance07(Integer monthlyBalance07) {
        this.monthlyBalance07 = monthlyBalance07;
    }

    public Integer getMonthlyBalance08() {
        return monthlyBalance08;
    }

    public void setMonthlyBalance08(Integer monthlyBalance08) {
        this.monthlyBalance08 = monthlyBalance08;
    }

    public Integer getMonthlyBalance09() {
        return monthlyBalance09;
    }

    public void setMonthlyBalance09(Integer monthlyBalance09) {
        this.monthlyBalance09 = monthlyBalance09;
    }

    public Integer getMonthlyBalance10() {
        return monthlyBalance10;
    }

    public void setMonthlyBalance10(Integer monthlyBalance10) {
        this.monthlyBalance10 = monthlyBalance10;
    }

    public Integer getMonthlyBalance11() {
        return monthlyBalance11;
    }

    public void setMonthlyBalance11(Integer monthlyBalance11) {
        this.monthlyBalance11 = monthlyBalance11;
    }

    public Integer getMonthlyBalance12() {
        return monthlyBalance12;
    }

    public void setMonthlyBalance12(Integer monthlyBalance12) {
        this.monthlyBalance12 = monthlyBalance12;
    }

    public Boolean isOwnCalendar() {
        return ownCalendar;
    }

    public void setOwnCalendar(Boolean ownCalendar) {
        this.ownCalendar = ownCalendar;
    }

    public Boolean isOwnWeeklyWork() {
        return ownWeeklyWork;
    }

    public void setOwnWeeklyWork(Boolean ownWeeklyWork) {
        this.ownWeeklyWork = ownWeeklyWork;
    }

    public Boolean isOwnDayOff() {
        return ownDayOff;
    }

    public void setOwnDayOff(Boolean ownDayOff) {
        this.ownDayOff = ownDayOff;
    }

    public Boolean isOwnNaStartFlex() {
        return ownNaStartFlex;
    }

    public void setOwnNaStartFlex(Boolean ownNaStartFlex) {
        this.ownNaStartFlex = ownNaStartFlex;
    }

    public Boolean isOwnSchedules() {
        return ownSchedules;
    }

    public void setOwnSchedules(Boolean ownSchedules) {
        this.ownSchedules = ownSchedules;
    }

    public Boolean isOwnWeekHours() {
        return ownWeekHours;
    }

    public void setOwnWeekHours(Boolean ownWeekHours) {
        this.ownWeekHours = ownWeekHours;
    }

    public Boolean isOwnMonthlyBalance() {
        return ownMonthlyBalance;
    }

    public void setOwnMonthlyBalance(Boolean ownMonthlyBalance) {
        this.ownMonthlyBalance = ownMonthlyBalance;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Long weeklyWorkId) {
        this.weeklyId = weeklyWorkId;
    }

    public Long getStandardScheduleId() {
        return standardScheduleId;
    }

    public void setStandardScheduleId(Long scheduleId) {
        this.standardScheduleId = scheduleId;
    }

    public Long getSaturdayScheduleId() {
        return saturdayScheduleId;
    }

    public void setSaturdayScheduleId(Long scheduleId) {
        this.saturdayScheduleId = scheduleId;
    }

    public Long getWeekendScheduleId() {
        return weekendScheduleId;
    }

    public void setWeekendScheduleId(Long scheduleId) {
        this.weekendScheduleId = scheduleId;
    }

    public Long getAbsentScheduleId() {
        return absentScheduleId;
    }

    public void setAbsentScheduleId(Long scheduleId) {
        this.absentScheduleId = scheduleId;
    }

    public Long getProcessEntryExitId() {
        return processEntryExitId;
    }

    public void setProcessEntryExitId(Long processEntryExitId) {
        this.processEntryExitId = processEntryExitId;
    }

    public Long getProcessHolidayLeaveId() {
        return processHolidayLeaveId;
    }

    public void setProcessHolidayLeaveId(Long processHolidayLeaveId) {
        this.processHolidayLeaveId = processHolidayLeaveId;
    }

    public Long getProcessDailyAnalysisId() {
        return processDailyAnalysisId;
    }

    public void setProcessDailyAnalysisId(Long processDailyAnalysisId) {
        this.processDailyAnalysisId = processDailyAnalysisId;
    }

    public Long getProcessDailyId() {
        return processDailyId;
    }

    public void setProcessDailyId(Long processDailyId) {
        this.processDailyId = processDailyId;
    }

    public Long getProcessMonthlyId() {
        return processMonthlyId;
    }

    public void setProcessMonthlyId(Long processMonthlyId) {
        this.processMonthlyId = processMonthlyId;
    }

    public Long getProcessPreviousMonthlyId() {
        return processPreviousMonthlyId;
    }

    public void setProcessPreviousMonthlyId(Long processPreviousMonthlyId) {
        this.processPreviousMonthlyId = processPreviousMonthlyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarDTO)) {
            return false;
        }

        return id != null && id.equals(((CalendarDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CalendarDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", assignShiftDay=" + getAssignShiftDay() +
            ", shiftAssignMethod=" + getShiftAssignMethod() +
            ", dayStartTime='" + getDayStartTime() + "'" +
            ", applyWeeklyBalance='" + isApplyWeeklyBalance() + "'" +
            ", balanceWeeksInMonth='" + isBalanceWeeksInMonth() + "'" +
            ", weekendDay='" + isWeekendDay() + "'" +
            ", flexibleWorkingTime='" + isFlexibleWorkingTime() + "'" +
            ", dayOff=" + getDayOff() +
            ", flexibleShift='" + isFlexibleShift() + "'" +
            ", weekHours=" + getWeekHours() +
            ", weekHoursMin=" + getWeekHoursMin() +
            ", weekHoursMax=" + getWeekHoursMax() +
            ", monthlyBalance01=" + getMonthlyBalance01() +
            ", monthlyBalance02=" + getMonthlyBalance02() +
            ", monthlyBalance03=" + getMonthlyBalance03() +
            ", monthlyBalance04=" + getMonthlyBalance04() +
            ", monthlyBalance05=" + getMonthlyBalance05() +
            ", monthlyBalance06=" + getMonthlyBalance06() +
            ", monthlyBalance07=" + getMonthlyBalance07() +
            ", monthlyBalance08=" + getMonthlyBalance08() +
            ", monthlyBalance09=" + getMonthlyBalance09() +
            ", monthlyBalance10=" + getMonthlyBalance10() +
            ", monthlyBalance11=" + getMonthlyBalance11() +
            ", monthlyBalance12=" + getMonthlyBalance12() +
            ", ownCalendar='" + isOwnCalendar() + "'" +
            ", ownWeeklyWork='" + isOwnWeeklyWork() + "'" +
            ", ownDayOff='" + isOwnDayOff() + "'" +
            ", ownNaStartFlex='" + isOwnNaStartFlex() + "'" +
            ", ownSchedules='" + isOwnSchedules() + "'" +
            ", ownWeekHours='" + isOwnWeekHours() + "'" +
            ", ownMonthlyBalance='" + isOwnMonthlyBalance() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", weeklyId=" + getWeeklyId() +
            ", standardScheduleId=" + getStandardScheduleId() +
            ", saturdayScheduleId=" + getSaturdayScheduleId() +
            ", weekendScheduleId=" + getWeekendScheduleId() +
            ", absentScheduleId=" + getAbsentScheduleId() +
            ", processEntryExitId=" + getProcessEntryExitId() +
            ", processHolidayLeaveId=" + getProcessHolidayLeaveId() +
            ", processDailyAnalysisId=" + getProcessDailyAnalysisId() +
            ", processDailyId=" + getProcessDailyId() +
            ", processMonthlyId=" + getProcessMonthlyId() +
            ", processPreviousMonthlyId=" + getProcessPreviousMonthlyId() +
            "}";
    }
}
