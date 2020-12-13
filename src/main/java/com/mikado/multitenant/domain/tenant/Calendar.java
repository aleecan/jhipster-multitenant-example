package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "calendar")
@Data
public class Calendar extends TenantAbstractAuditingEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "assign_shift_day")
    private Boolean assignShiftDay;

    @Column(name = "shift_assign_method")
    private Boolean assignShiftMethod;

    @Column(name = "day_start_time")
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

    @Column(name = "own_flexna_start")
    private Boolean ownFlexnaStart;

    @Column(name = "own_schedules")
    private Boolean ownSchedules;

    @Column(name = "own_week_hours")
    private Boolean ownWeekHours;

    @Column(name = "own_monthly_balance")
    private Boolean ownMonthlyBalance;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_entry_exit_id", referencedColumnName = "id")
    private ProcessEntryExit processEntryExit;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_holiday_leave_id", referencedColumnName = "id")
    private ProcessHolidayLeave processHolidayLeave;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_daily_analysis_id", referencedColumnName = "id")
    private ProcessDailyAnalysis processDailyAnalysis;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_daily_id", referencedColumnName = "id")
    private ProcessDaily processDaily;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_monthly_id", referencedColumnName = "id")
    private ProcessMonthly processMonthly;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "process_previous_monthly_id", referencedColumnName = "id")
    private ProcessPreviousMonthly processPreviousMonthly;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "weekly_id", referencedColumnName = "id")
    private WeeklyWork weeklyWork;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "standard_schedule_id", referencedColumnName = "id")
    private Schedule standardSchedule;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "saturday_schedule_id", referencedColumnName = "id")
    private Schedule saturdaySchedule;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "weekend_schedule_id", referencedColumnName = "id")
    private Schedule weekendSchedule;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "absent_schedule_id", referencedColumnName = "id")
    private Schedule absentSchedule;
}
