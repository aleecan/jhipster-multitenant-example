package com.mikado.multitenant.domain.tenant.process;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import com.mikado.multitenant.domain.tenant.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "process_daily")
@Data
public class ProcessDaily extends TenantAbstractAuditingEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "close_month")
    private Boolean closeMonth;

    @Column(name = "check_early_entry_late_exit")
    private Boolean checkEarlyEntryLateExit;

    @Column(name = "check_late_entry_early_exit")
    private Boolean checkLateEntryEarlyExit;

    @Column(name = "apply_tolerance_first_entry_last_exit")
    private Boolean applyToleranceFirstEntryLastExit;

    @Column(name = "check_prev_and_next_day_schedule")
    private Boolean checkPrevAndNextDaySchedule;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

    @Column(name = "complete_work_when_missing_entry_exit")
    private Boolean completeWorkWhenMissingEntryExit;

    @Column(name = "check_weekly_work_hours")
    private Boolean checkWeeklyWorkHours;

    @Column(name = "calc_weekend_days_from_daily")
    private Boolean calcWeekendDaysFromDaily;

    @Column(name = "holiday_payment")
    private Boolean holidayPayment;

    @Column(name = "weekly_work_days_for_holiday_payment")
    private Integer weeklyWorkDaysForHolidayPayment;

    @Column(name = "min_weekly_work_hour_for_holiday_payment")
    private Double minWeeklyWorkHourForHolidayPayment;

    @Column(name = "check_only_last_consecutive_working_days")
    private Boolean checkOnlyLastConsecutiveWorkingDays;

    @Column(name = "apply_ratio")
    private Boolean applyRatio;

    @Column(name = "divide_the_no_of_worked_days")
    private Boolean divideTheNoOfWorkedDays;

    @Column(name = "no_holiday_payment_in_case_of_absence")
    private Boolean noHolidayPaymentInCaseOfAbsence;

    @Column(name = "at_least_one_day_absence")
    private Boolean atLeastOneDayAbsence;

    @Column(name = "transfer_extra_hours")
    private Boolean transferExtraHours;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "extra_hour_category_id", referencedColumnName = "id")
    private Category category;

}
