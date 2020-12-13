package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Calendar.
 */
@Entity
@Table(name = "calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "assign_shift_day")
    private Integer assignShiftDay;

    @Column(name = "shift_assign_method")
    private Integer shiftAssignMethod;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "day_start_time", length = 8)
    private String dayStartTime;

    @Column(name = "apply_weekly_balance")
    private Boolean applyWeeklyBalance;

    @Column(name = "balance_weeks_in_month")
    private Boolean balanceWeeksInMonth;

    @Column(name = "weekend_day")
    private Boolean weekendDay;

    @Column(name = "flexible_working_time")
    private Boolean flexibleWorkingTime;

    @Column(name = "day_off")
    private Integer dayOff;

    @Column(name = "flexible_shift")
    private Boolean flexibleShift;

    @Column(name = "week_hours")
    private Double weekHours;

    @Column(name = "week_hours_min")
    private Double weekHoursMin;

    @Column(name = "week_hours_max")
    private Double weekHoursMax;

    @Column(name = "monthly_balance_01")
    private Integer monthlyBalance01;

    @Column(name = "monthly_balance_02")
    private Integer monthlyBalance02;

    @Column(name = "monthly_balance_03")
    private Integer monthlyBalance03;

    @Column(name = "monthly_balance_04")
    private Integer monthlyBalance04;

    @Column(name = "monthly_balance_05")
    private Integer monthlyBalance05;

    @Column(name = "monthly_balance_06")
    private Integer monthlyBalance06;

    @Column(name = "monthly_balance_07")
    private Integer monthlyBalance07;

    @Column(name = "monthly_balance_08")
    private Integer monthlyBalance08;

    @Column(name = "monthly_balance_09")
    private Integer monthlyBalance09;

    @Column(name = "monthly_balance_10")
    private Integer monthlyBalance10;

    @Column(name = "monthly_balance_11")
    private Integer monthlyBalance11;

    @Column(name = "monthly_balance_12")
    private Integer monthlyBalance12;

    @Column(name = "own_calendar")
    private Boolean ownCalendar;

    @Column(name = "own_weekly_work")
    private Boolean ownWeeklyWork;

    @Column(name = "own_day_off")
    private Boolean ownDayOff;

    @Column(name = "own_na_start_flex")
    private Boolean ownNaStartFlex;

    @Column(name = "own_schedules")
    private Boolean ownSchedules;

    @Column(name = "own_week_hours")
    private Boolean ownWeekHours;

    @Column(name = "own_monthly_balance")
    private Boolean ownMonthlyBalance;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private WeeklyWork weekly;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private Schedule standardSchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private Schedule saturdaySchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private Schedule weekendSchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private Schedule absentSchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessEntryExit processEntryExit;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessHolidayLeave processHolidayLeave;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessDailyAnalysis processDailyAnalysis;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessDaily processDaily;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessMonthly processMonthly;

    @ManyToOne
    @JsonIgnoreProperties(value = "calendars", allowSetters = true)
    private ProcessPreviousMonthly processPreviousMonthly;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Calendar code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Calendar description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAssignShiftDay() {
        return assignShiftDay;
    }

    public Calendar assignShiftDay(Integer assignShiftDay) {
        this.assignShiftDay = assignShiftDay;
        return this;
    }

    public void setAssignShiftDay(Integer assignShiftDay) {
        this.assignShiftDay = assignShiftDay;
    }

    public Integer getShiftAssignMethod() {
        return shiftAssignMethod;
    }

    public Calendar shiftAssignMethod(Integer shiftAssignMethod) {
        this.shiftAssignMethod = shiftAssignMethod;
        return this;
    }

    public void setShiftAssignMethod(Integer shiftAssignMethod) {
        this.shiftAssignMethod = shiftAssignMethod;
    }

    public String getDayStartTime() {
        return dayStartTime;
    }

    public Calendar dayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
        return this;
    }

    public void setDayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public Boolean isApplyWeeklyBalance() {
        return applyWeeklyBalance;
    }

    public Calendar applyWeeklyBalance(Boolean applyWeeklyBalance) {
        this.applyWeeklyBalance = applyWeeklyBalance;
        return this;
    }

    public void setApplyWeeklyBalance(Boolean applyWeeklyBalance) {
        this.applyWeeklyBalance = applyWeeklyBalance;
    }

    public Boolean isBalanceWeeksInMonth() {
        return balanceWeeksInMonth;
    }

    public Calendar balanceWeeksInMonth(Boolean balanceWeeksInMonth) {
        this.balanceWeeksInMonth = balanceWeeksInMonth;
        return this;
    }

    public void setBalanceWeeksInMonth(Boolean balanceWeeksInMonth) {
        this.balanceWeeksInMonth = balanceWeeksInMonth;
    }

    public Boolean isWeekendDay() {
        return weekendDay;
    }

    public Calendar weekendDay(Boolean weekendDay) {
        this.weekendDay = weekendDay;
        return this;
    }

    public void setWeekendDay(Boolean weekendDay) {
        this.weekendDay = weekendDay;
    }

    public Boolean isFlexibleWorkingTime() {
        return flexibleWorkingTime;
    }

    public Calendar flexibleWorkingTime(Boolean flexibleWorkingTime) {
        this.flexibleWorkingTime = flexibleWorkingTime;
        return this;
    }

    public void setFlexibleWorkingTime(Boolean flexibleWorkingTime) {
        this.flexibleWorkingTime = flexibleWorkingTime;
    }

    public Integer getDayOff() {
        return dayOff;
    }

    public Calendar dayOff(Integer dayOff) {
        this.dayOff = dayOff;
        return this;
    }

    public void setDayOff(Integer dayOff) {
        this.dayOff = dayOff;
    }

    public Boolean isFlexibleShift() {
        return flexibleShift;
    }

    public Calendar flexibleShift(Boolean flexibleShift) {
        this.flexibleShift = flexibleShift;
        return this;
    }

    public void setFlexibleShift(Boolean flexibleShift) {
        this.flexibleShift = flexibleShift;
    }

    public Double getWeekHours() {
        return weekHours;
    }

    public Calendar weekHours(Double weekHours) {
        this.weekHours = weekHours;
        return this;
    }

    public void setWeekHours(Double weekHours) {
        this.weekHours = weekHours;
    }

    public Double getWeekHoursMin() {
        return weekHoursMin;
    }

    public Calendar weekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
        return this;
    }

    public void setWeekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
    }

    public Double getWeekHoursMax() {
        return weekHoursMax;
    }

    public Calendar weekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
        return this;
    }

    public void setWeekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
    }

    public Integer getMonthlyBalance01() {
        return monthlyBalance01;
    }

    public Calendar monthlyBalance01(Integer monthlyBalance01) {
        this.monthlyBalance01 = monthlyBalance01;
        return this;
    }

    public void setMonthlyBalance01(Integer monthlyBalance01) {
        this.monthlyBalance01 = monthlyBalance01;
    }

    public Integer getMonthlyBalance02() {
        return monthlyBalance02;
    }

    public Calendar monthlyBalance02(Integer monthlyBalance02) {
        this.monthlyBalance02 = monthlyBalance02;
        return this;
    }

    public void setMonthlyBalance02(Integer monthlyBalance02) {
        this.monthlyBalance02 = monthlyBalance02;
    }

    public Integer getMonthlyBalance03() {
        return monthlyBalance03;
    }

    public Calendar monthlyBalance03(Integer monthlyBalance03) {
        this.monthlyBalance03 = monthlyBalance03;
        return this;
    }

    public void setMonthlyBalance03(Integer monthlyBalance03) {
        this.monthlyBalance03 = monthlyBalance03;
    }

    public Integer getMonthlyBalance04() {
        return monthlyBalance04;
    }

    public Calendar monthlyBalance04(Integer monthlyBalance04) {
        this.monthlyBalance04 = monthlyBalance04;
        return this;
    }

    public void setMonthlyBalance04(Integer monthlyBalance04) {
        this.monthlyBalance04 = monthlyBalance04;
    }

    public Integer getMonthlyBalance05() {
        return monthlyBalance05;
    }

    public Calendar monthlyBalance05(Integer monthlyBalance05) {
        this.monthlyBalance05 = monthlyBalance05;
        return this;
    }

    public void setMonthlyBalance05(Integer monthlyBalance05) {
        this.monthlyBalance05 = monthlyBalance05;
    }

    public Integer getMonthlyBalance06() {
        return monthlyBalance06;
    }

    public Calendar monthlyBalance06(Integer monthlyBalance06) {
        this.monthlyBalance06 = monthlyBalance06;
        return this;
    }

    public void setMonthlyBalance06(Integer monthlyBalance06) {
        this.monthlyBalance06 = monthlyBalance06;
    }

    public Integer getMonthlyBalance07() {
        return monthlyBalance07;
    }

    public Calendar monthlyBalance07(Integer monthlyBalance07) {
        this.monthlyBalance07 = monthlyBalance07;
        return this;
    }

    public void setMonthlyBalance07(Integer monthlyBalance07) {
        this.monthlyBalance07 = monthlyBalance07;
    }

    public Integer getMonthlyBalance08() {
        return monthlyBalance08;
    }

    public Calendar monthlyBalance08(Integer monthlyBalance08) {
        this.monthlyBalance08 = monthlyBalance08;
        return this;
    }

    public void setMonthlyBalance08(Integer monthlyBalance08) {
        this.monthlyBalance08 = monthlyBalance08;
    }

    public Integer getMonthlyBalance09() {
        return monthlyBalance09;
    }

    public Calendar monthlyBalance09(Integer monthlyBalance09) {
        this.monthlyBalance09 = monthlyBalance09;
        return this;
    }

    public void setMonthlyBalance09(Integer monthlyBalance09) {
        this.monthlyBalance09 = monthlyBalance09;
    }

    public Integer getMonthlyBalance10() {
        return monthlyBalance10;
    }

    public Calendar monthlyBalance10(Integer monthlyBalance10) {
        this.monthlyBalance10 = monthlyBalance10;
        return this;
    }

    public void setMonthlyBalance10(Integer monthlyBalance10) {
        this.monthlyBalance10 = monthlyBalance10;
    }

    public Integer getMonthlyBalance11() {
        return monthlyBalance11;
    }

    public Calendar monthlyBalance11(Integer monthlyBalance11) {
        this.monthlyBalance11 = monthlyBalance11;
        return this;
    }

    public void setMonthlyBalance11(Integer monthlyBalance11) {
        this.monthlyBalance11 = monthlyBalance11;
    }

    public Integer getMonthlyBalance12() {
        return monthlyBalance12;
    }

    public Calendar monthlyBalance12(Integer monthlyBalance12) {
        this.monthlyBalance12 = monthlyBalance12;
        return this;
    }

    public void setMonthlyBalance12(Integer monthlyBalance12) {
        this.monthlyBalance12 = monthlyBalance12;
    }

    public Boolean isOwnCalendar() {
        return ownCalendar;
    }

    public Calendar ownCalendar(Boolean ownCalendar) {
        this.ownCalendar = ownCalendar;
        return this;
    }

    public void setOwnCalendar(Boolean ownCalendar) {
        this.ownCalendar = ownCalendar;
    }

    public Boolean isOwnWeeklyWork() {
        return ownWeeklyWork;
    }

    public Calendar ownWeeklyWork(Boolean ownWeeklyWork) {
        this.ownWeeklyWork = ownWeeklyWork;
        return this;
    }

    public void setOwnWeeklyWork(Boolean ownWeeklyWork) {
        this.ownWeeklyWork = ownWeeklyWork;
    }

    public Boolean isOwnDayOff() {
        return ownDayOff;
    }

    public Calendar ownDayOff(Boolean ownDayOff) {
        this.ownDayOff = ownDayOff;
        return this;
    }

    public void setOwnDayOff(Boolean ownDayOff) {
        this.ownDayOff = ownDayOff;
    }

    public Boolean isOwnNaStartFlex() {
        return ownNaStartFlex;
    }

    public Calendar ownNaStartFlex(Boolean ownNaStartFlex) {
        this.ownNaStartFlex = ownNaStartFlex;
        return this;
    }

    public void setOwnNaStartFlex(Boolean ownNaStartFlex) {
        this.ownNaStartFlex = ownNaStartFlex;
    }

    public Boolean isOwnSchedules() {
        return ownSchedules;
    }

    public Calendar ownSchedules(Boolean ownSchedules) {
        this.ownSchedules = ownSchedules;
        return this;
    }

    public void setOwnSchedules(Boolean ownSchedules) {
        this.ownSchedules = ownSchedules;
    }

    public Boolean isOwnWeekHours() {
        return ownWeekHours;
    }

    public Calendar ownWeekHours(Boolean ownWeekHours) {
        this.ownWeekHours = ownWeekHours;
        return this;
    }

    public void setOwnWeekHours(Boolean ownWeekHours) {
        this.ownWeekHours = ownWeekHours;
    }

    public Boolean isOwnMonthlyBalance() {
        return ownMonthlyBalance;
    }

    public Calendar ownMonthlyBalance(Boolean ownMonthlyBalance) {
        this.ownMonthlyBalance = ownMonthlyBalance;
        return this;
    }

    public void setOwnMonthlyBalance(Boolean ownMonthlyBalance) {
        this.ownMonthlyBalance = ownMonthlyBalance;
    }

    public Instant getCreated() {
        return created;
    }

    public Calendar created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Calendar modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Calendar modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public WeeklyWork getWeekly() {
        return weekly;
    }

    public Calendar weekly(WeeklyWork weeklyWork) {
        this.weekly = weeklyWork;
        return this;
    }

    public void setWeekly(WeeklyWork weeklyWork) {
        this.weekly = weeklyWork;
    }

    public Schedule getStandardSchedule() {
        return standardSchedule;
    }

    public Calendar standardSchedule(Schedule schedule) {
        this.standardSchedule = schedule;
        return this;
    }

    public void setStandardSchedule(Schedule schedule) {
        this.standardSchedule = schedule;
    }

    public Schedule getSaturdaySchedule() {
        return saturdaySchedule;
    }

    public Calendar saturdaySchedule(Schedule schedule) {
        this.saturdaySchedule = schedule;
        return this;
    }

    public void setSaturdaySchedule(Schedule schedule) {
        this.saturdaySchedule = schedule;
    }

    public Schedule getWeekendSchedule() {
        return weekendSchedule;
    }

    public Calendar weekendSchedule(Schedule schedule) {
        this.weekendSchedule = schedule;
        return this;
    }

    public void setWeekendSchedule(Schedule schedule) {
        this.weekendSchedule = schedule;
    }

    public Schedule getAbsentSchedule() {
        return absentSchedule;
    }

    public Calendar absentSchedule(Schedule schedule) {
        this.absentSchedule = schedule;
        return this;
    }

    public void setAbsentSchedule(Schedule schedule) {
        this.absentSchedule = schedule;
    }

    public ProcessEntryExit getProcessEntryExit() {
        return processEntryExit;
    }

    public Calendar processEntryExit(ProcessEntryExit processEntryExit) {
        this.processEntryExit = processEntryExit;
        return this;
    }

    public void setProcessEntryExit(ProcessEntryExit processEntryExit) {
        this.processEntryExit = processEntryExit;
    }

    public ProcessHolidayLeave getProcessHolidayLeave() {
        return processHolidayLeave;
    }

    public Calendar processHolidayLeave(ProcessHolidayLeave processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
        return this;
    }

    public void setProcessHolidayLeave(ProcessHolidayLeave processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
    }

    public ProcessDailyAnalysis getProcessDailyAnalysis() {
        return processDailyAnalysis;
    }

    public Calendar processDailyAnalysis(ProcessDailyAnalysis processDailyAnalysis) {
        this.processDailyAnalysis = processDailyAnalysis;
        return this;
    }

    public void setProcessDailyAnalysis(ProcessDailyAnalysis processDailyAnalysis) {
        this.processDailyAnalysis = processDailyAnalysis;
    }

    public ProcessDaily getProcessDaily() {
        return processDaily;
    }

    public Calendar processDaily(ProcessDaily processDaily) {
        this.processDaily = processDaily;
        return this;
    }

    public void setProcessDaily(ProcessDaily processDaily) {
        this.processDaily = processDaily;
    }

    public ProcessMonthly getProcessMonthly() {
        return processMonthly;
    }

    public Calendar processMonthly(ProcessMonthly processMonthly) {
        this.processMonthly = processMonthly;
        return this;
    }

    public void setProcessMonthly(ProcessMonthly processMonthly) {
        this.processMonthly = processMonthly;
    }

    public ProcessPreviousMonthly getProcessPreviousMonthly() {
        return processPreviousMonthly;
    }

    public Calendar processPreviousMonthly(ProcessPreviousMonthly processPreviousMonthly) {
        this.processPreviousMonthly = processPreviousMonthly;
        return this;
    }

    public void setProcessPreviousMonthly(ProcessPreviousMonthly processPreviousMonthly) {
        this.processPreviousMonthly = processPreviousMonthly;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Calendar)) {
            return false;
        }
        return id != null && id.equals(((Calendar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Calendar{" +
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
            "}";
    }
}
