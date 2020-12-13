package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A WorkContractPeriod.
 */
@Entity
@Table(name = "work_contract_period")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkContractPeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(max = 1)
    @Column(name = "payment_type", length = 1)
    private String paymentType;

    @Column(name = "use_calendar")
    private Boolean useCalendar;

    @Column(name = "calendar_id")
    private Long calendarId;

    @Column(name = "apply_weekly_balance")
    private Boolean applyWeeklyBalance;

    @Column(name = "weekly_id")
    private Long weeklyId;

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

    @Column(name = "standard_schedule_id")
    private Long standardScheduleId;

    @Column(name = "saturday_schedule_id")
    private Long saturdayScheduleId;

    @Column(name = "weekend_schedule_id")
    private Long weekendScheduleId;

    @Column(name = "absent_schedule_id")
    private Long absentScheduleId;

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

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private WorkContract workContract;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessEntryExit processEntryExit;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessHolidayLeave processHolidayLeave;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessDailyAnalysis processDailyAnalysis;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessDaily processDaily;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessMonthly processMonthly;

    @ManyToOne
    @JsonIgnoreProperties(value = "workContractPeriods", allowSetters = true)
    private ProcessPreviousMonthly processPreviousMonthly;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public WorkContractPeriod daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getDescription() {
        return description;
    }

    public WorkContractPeriod description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public WorkContractPeriod paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean isUseCalendar() {
        return useCalendar;
    }

    public WorkContractPeriod useCalendar(Boolean useCalendar) {
        this.useCalendar = useCalendar;
        return this;
    }

    public void setUseCalendar(Boolean useCalendar) {
        this.useCalendar = useCalendar;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public WorkContractPeriod calendarId(Long calendarId) {
        this.calendarId = calendarId;
        return this;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public Boolean isApplyWeeklyBalance() {
        return applyWeeklyBalance;
    }

    public WorkContractPeriod applyWeeklyBalance(Boolean applyWeeklyBalance) {
        this.applyWeeklyBalance = applyWeeklyBalance;
        return this;
    }

    public void setApplyWeeklyBalance(Boolean applyWeeklyBalance) {
        this.applyWeeklyBalance = applyWeeklyBalance;
    }

    public Long getWeeklyId() {
        return weeklyId;
    }

    public WorkContractPeriod weeklyId(Long weeklyId) {
        this.weeklyId = weeklyId;
        return this;
    }

    public void setWeeklyId(Long weeklyId) {
        this.weeklyId = weeklyId;
    }

    public Boolean isBalanceWeeksInMonth() {
        return balanceWeeksInMonth;
    }

    public WorkContractPeriod balanceWeeksInMonth(Boolean balanceWeeksInMonth) {
        this.balanceWeeksInMonth = balanceWeeksInMonth;
        return this;
    }

    public void setBalanceWeeksInMonth(Boolean balanceWeeksInMonth) {
        this.balanceWeeksInMonth = balanceWeeksInMonth;
    }

    public Boolean isWeekendDay() {
        return weekendDay;
    }

    public WorkContractPeriod weekendDay(Boolean weekendDay) {
        this.weekendDay = weekendDay;
        return this;
    }

    public void setWeekendDay(Boolean weekendDay) {
        this.weekendDay = weekendDay;
    }

    public Boolean isFlexibleWorkingTime() {
        return flexibleWorkingTime;
    }

    public WorkContractPeriod flexibleWorkingTime(Boolean flexibleWorkingTime) {
        this.flexibleWorkingTime = flexibleWorkingTime;
        return this;
    }

    public void setFlexibleWorkingTime(Boolean flexibleWorkingTime) {
        this.flexibleWorkingTime = flexibleWorkingTime;
    }

    public Integer getDayOff() {
        return dayOff;
    }

    public WorkContractPeriod dayOff(Integer dayOff) {
        this.dayOff = dayOff;
        return this;
    }

    public void setDayOff(Integer dayOff) {
        this.dayOff = dayOff;
    }

    public Boolean isFlexibleShift() {
        return flexibleShift;
    }

    public WorkContractPeriod flexibleShift(Boolean flexibleShift) {
        this.flexibleShift = flexibleShift;
        return this;
    }

    public void setFlexibleShift(Boolean flexibleShift) {
        this.flexibleShift = flexibleShift;
    }

    public Long getStandardScheduleId() {
        return standardScheduleId;
    }

    public WorkContractPeriod standardScheduleId(Long standardScheduleId) {
        this.standardScheduleId = standardScheduleId;
        return this;
    }

    public void setStandardScheduleId(Long standardScheduleId) {
        this.standardScheduleId = standardScheduleId;
    }

    public Long getSaturdayScheduleId() {
        return saturdayScheduleId;
    }

    public WorkContractPeriod saturdayScheduleId(Long saturdayScheduleId) {
        this.saturdayScheduleId = saturdayScheduleId;
        return this;
    }

    public void setSaturdayScheduleId(Long saturdayScheduleId) {
        this.saturdayScheduleId = saturdayScheduleId;
    }

    public Long getWeekendScheduleId() {
        return weekendScheduleId;
    }

    public WorkContractPeriod weekendScheduleId(Long weekendScheduleId) {
        this.weekendScheduleId = weekendScheduleId;
        return this;
    }

    public void setWeekendScheduleId(Long weekendScheduleId) {
        this.weekendScheduleId = weekendScheduleId;
    }

    public Long getAbsentScheduleId() {
        return absentScheduleId;
    }

    public WorkContractPeriod absentScheduleId(Long absentScheduleId) {
        this.absentScheduleId = absentScheduleId;
        return this;
    }

    public void setAbsentScheduleId(Long absentScheduleId) {
        this.absentScheduleId = absentScheduleId;
    }

    public Double getWeekHours() {
        return weekHours;
    }

    public WorkContractPeriod weekHours(Double weekHours) {
        this.weekHours = weekHours;
        return this;
    }

    public void setWeekHours(Double weekHours) {
        this.weekHours = weekHours;
    }

    public Double getWeekHoursMin() {
        return weekHoursMin;
    }

    public WorkContractPeriod weekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
        return this;
    }

    public void setWeekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
    }

    public Double getWeekHoursMax() {
        return weekHoursMax;
    }

    public WorkContractPeriod weekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
        return this;
    }

    public void setWeekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
    }

    public Integer getMonthlyBalance01() {
        return monthlyBalance01;
    }

    public WorkContractPeriod monthlyBalance01(Integer monthlyBalance01) {
        this.monthlyBalance01 = monthlyBalance01;
        return this;
    }

    public void setMonthlyBalance01(Integer monthlyBalance01) {
        this.monthlyBalance01 = monthlyBalance01;
    }

    public Integer getMonthlyBalance02() {
        return monthlyBalance02;
    }

    public WorkContractPeriod monthlyBalance02(Integer monthlyBalance02) {
        this.monthlyBalance02 = monthlyBalance02;
        return this;
    }

    public void setMonthlyBalance02(Integer monthlyBalance02) {
        this.monthlyBalance02 = monthlyBalance02;
    }

    public Integer getMonthlyBalance03() {
        return monthlyBalance03;
    }

    public WorkContractPeriod monthlyBalance03(Integer monthlyBalance03) {
        this.monthlyBalance03 = monthlyBalance03;
        return this;
    }

    public void setMonthlyBalance03(Integer monthlyBalance03) {
        this.monthlyBalance03 = monthlyBalance03;
    }

    public Integer getMonthlyBalance04() {
        return monthlyBalance04;
    }

    public WorkContractPeriod monthlyBalance04(Integer monthlyBalance04) {
        this.monthlyBalance04 = monthlyBalance04;
        return this;
    }

    public void setMonthlyBalance04(Integer monthlyBalance04) {
        this.monthlyBalance04 = monthlyBalance04;
    }

    public Integer getMonthlyBalance05() {
        return monthlyBalance05;
    }

    public WorkContractPeriod monthlyBalance05(Integer monthlyBalance05) {
        this.monthlyBalance05 = monthlyBalance05;
        return this;
    }

    public void setMonthlyBalance05(Integer monthlyBalance05) {
        this.monthlyBalance05 = monthlyBalance05;
    }

    public Integer getMonthlyBalance06() {
        return monthlyBalance06;
    }

    public WorkContractPeriod monthlyBalance06(Integer monthlyBalance06) {
        this.monthlyBalance06 = monthlyBalance06;
        return this;
    }

    public void setMonthlyBalance06(Integer monthlyBalance06) {
        this.monthlyBalance06 = monthlyBalance06;
    }

    public Integer getMonthlyBalance07() {
        return monthlyBalance07;
    }

    public WorkContractPeriod monthlyBalance07(Integer monthlyBalance07) {
        this.monthlyBalance07 = monthlyBalance07;
        return this;
    }

    public void setMonthlyBalance07(Integer monthlyBalance07) {
        this.monthlyBalance07 = monthlyBalance07;
    }

    public Integer getMonthlyBalance08() {
        return monthlyBalance08;
    }

    public WorkContractPeriod monthlyBalance08(Integer monthlyBalance08) {
        this.monthlyBalance08 = monthlyBalance08;
        return this;
    }

    public void setMonthlyBalance08(Integer monthlyBalance08) {
        this.monthlyBalance08 = monthlyBalance08;
    }

    public Integer getMonthlyBalance09() {
        return monthlyBalance09;
    }

    public WorkContractPeriod monthlyBalance09(Integer monthlyBalance09) {
        this.monthlyBalance09 = monthlyBalance09;
        return this;
    }

    public void setMonthlyBalance09(Integer monthlyBalance09) {
        this.monthlyBalance09 = monthlyBalance09;
    }

    public Integer getMonthlyBalance10() {
        return monthlyBalance10;
    }

    public WorkContractPeriod monthlyBalance10(Integer monthlyBalance10) {
        this.monthlyBalance10 = monthlyBalance10;
        return this;
    }

    public void setMonthlyBalance10(Integer monthlyBalance10) {
        this.monthlyBalance10 = monthlyBalance10;
    }

    public Integer getMonthlyBalance11() {
        return monthlyBalance11;
    }

    public WorkContractPeriod monthlyBalance11(Integer monthlyBalance11) {
        this.monthlyBalance11 = monthlyBalance11;
        return this;
    }

    public void setMonthlyBalance11(Integer monthlyBalance11) {
        this.monthlyBalance11 = monthlyBalance11;
    }

    public Integer getMonthlyBalance12() {
        return monthlyBalance12;
    }

    public WorkContractPeriod monthlyBalance12(Integer monthlyBalance12) {
        this.monthlyBalance12 = monthlyBalance12;
        return this;
    }

    public void setMonthlyBalance12(Integer monthlyBalance12) {
        this.monthlyBalance12 = monthlyBalance12;
    }

    public Boolean isOwnCalendar() {
        return ownCalendar;
    }

    public WorkContractPeriod ownCalendar(Boolean ownCalendar) {
        this.ownCalendar = ownCalendar;
        return this;
    }

    public void setOwnCalendar(Boolean ownCalendar) {
        this.ownCalendar = ownCalendar;
    }

    public Boolean isOwnWeeklyWork() {
        return ownWeeklyWork;
    }

    public WorkContractPeriod ownWeeklyWork(Boolean ownWeeklyWork) {
        this.ownWeeklyWork = ownWeeklyWork;
        return this;
    }

    public void setOwnWeeklyWork(Boolean ownWeeklyWork) {
        this.ownWeeklyWork = ownWeeklyWork;
    }

    public Boolean isOwnDayOff() {
        return ownDayOff;
    }

    public WorkContractPeriod ownDayOff(Boolean ownDayOff) {
        this.ownDayOff = ownDayOff;
        return this;
    }

    public void setOwnDayOff(Boolean ownDayOff) {
        this.ownDayOff = ownDayOff;
    }

    public Boolean isOwnNaStartFlex() {
        return ownNaStartFlex;
    }

    public WorkContractPeriod ownNaStartFlex(Boolean ownNaStartFlex) {
        this.ownNaStartFlex = ownNaStartFlex;
        return this;
    }

    public void setOwnNaStartFlex(Boolean ownNaStartFlex) {
        this.ownNaStartFlex = ownNaStartFlex;
    }

    public Boolean isOwnSchedules() {
        return ownSchedules;
    }

    public WorkContractPeriod ownSchedules(Boolean ownSchedules) {
        this.ownSchedules = ownSchedules;
        return this;
    }

    public void setOwnSchedules(Boolean ownSchedules) {
        this.ownSchedules = ownSchedules;
    }

    public Boolean isOwnWeekHours() {
        return ownWeekHours;
    }

    public WorkContractPeriod ownWeekHours(Boolean ownWeekHours) {
        this.ownWeekHours = ownWeekHours;
        return this;
    }

    public void setOwnWeekHours(Boolean ownWeekHours) {
        this.ownWeekHours = ownWeekHours;
    }

    public Boolean isOwnMonthlyBalance() {
        return ownMonthlyBalance;
    }

    public WorkContractPeriod ownMonthlyBalance(Boolean ownMonthlyBalance) {
        this.ownMonthlyBalance = ownMonthlyBalance;
        return this;
    }

    public void setOwnMonthlyBalance(Boolean ownMonthlyBalance) {
        this.ownMonthlyBalance = ownMonthlyBalance;
    }

    public Instant getCreated() {
        return created;
    }

    public WorkContractPeriod created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public WorkContractPeriod modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public WorkContractPeriod modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public WorkContract getWorkContract() {
        return workContract;
    }

    public WorkContractPeriod workContract(WorkContract workContract) {
        this.workContract = workContract;
        return this;
    }

    public void setWorkContract(WorkContract workContract) {
        this.workContract = workContract;
    }

    public ProcessEntryExit getProcessEntryExit() {
        return processEntryExit;
    }

    public WorkContractPeriod processEntryExit(ProcessEntryExit processEntryExit) {
        this.processEntryExit = processEntryExit;
        return this;
    }

    public void setProcessEntryExit(ProcessEntryExit processEntryExit) {
        this.processEntryExit = processEntryExit;
    }

    public ProcessHolidayLeave getProcessHolidayLeave() {
        return processHolidayLeave;
    }

    public WorkContractPeriod processHolidayLeave(ProcessHolidayLeave processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
        return this;
    }

    public void setProcessHolidayLeave(ProcessHolidayLeave processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
    }

    public ProcessDailyAnalysis getProcessDailyAnalysis() {
        return processDailyAnalysis;
    }

    public WorkContractPeriod processDailyAnalysis(ProcessDailyAnalysis processDailyAnalysis) {
        this.processDailyAnalysis = processDailyAnalysis;
        return this;
    }

    public void setProcessDailyAnalysis(ProcessDailyAnalysis processDailyAnalysis) {
        this.processDailyAnalysis = processDailyAnalysis;
    }

    public ProcessDaily getProcessDaily() {
        return processDaily;
    }

    public WorkContractPeriod processDaily(ProcessDaily processDaily) {
        this.processDaily = processDaily;
        return this;
    }

    public void setProcessDaily(ProcessDaily processDaily) {
        this.processDaily = processDaily;
    }

    public ProcessMonthly getProcessMonthly() {
        return processMonthly;
    }

    public WorkContractPeriod processMonthly(ProcessMonthly processMonthly) {
        this.processMonthly = processMonthly;
        return this;
    }

    public void setProcessMonthly(ProcessMonthly processMonthly) {
        this.processMonthly = processMonthly;
    }

    public ProcessPreviousMonthly getProcessPreviousMonthly() {
        return processPreviousMonthly;
    }

    public WorkContractPeriod processPreviousMonthly(ProcessPreviousMonthly processPreviousMonthly) {
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
        if (!(o instanceof WorkContractPeriod)) {
            return false;
        }
        return id != null && id.equals(((WorkContractPeriod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WorkContractPeriod{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", description='" + getDescription() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", useCalendar='" + isUseCalendar() + "'" +
            ", calendarId=" + getCalendarId() +
            ", applyWeeklyBalance='" + isApplyWeeklyBalance() + "'" +
            ", weeklyId=" + getWeeklyId() +
            ", balanceWeeksInMonth='" + isBalanceWeeksInMonth() + "'" +
            ", weekendDay='" + isWeekendDay() + "'" +
            ", flexibleWorkingTime='" + isFlexibleWorkingTime() + "'" +
            ", dayOff=" + getDayOff() +
            ", flexibleShift='" + isFlexibleShift() + "'" +
            ", standardScheduleId=" + getStandardScheduleId() +
            ", saturdayScheduleId=" + getSaturdayScheduleId() +
            ", weekendScheduleId=" + getWeekendScheduleId() +
            ", absentScheduleId=" + getAbsentScheduleId() +
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
