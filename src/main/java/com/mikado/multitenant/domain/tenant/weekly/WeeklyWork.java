package com.mikado.multitenant.domain.tenant.weekly;

import com.mikado.multitenant.domain.base.EntityBase;
import com.mikado.multitenant.domain.tenant.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "weekly_work")
@Data
public class WeeklyWork extends EntityBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "day_hours_min")
    private Double dayHoursMin;

    @Column(name = "day_hours")
    private Double dayHours;

    @Column(name = "day_hours_max")
    private Double dayHoursMax;

    @Column(name = "week_hours_min")
    private Double weekHoursMin;

    @Column(name = "week_hours")
    private Double weekHours;

    @Column(name = "week_hours_max")
    private Double weekHoursMax;

    @Column(name = "dist_before_multiplier")
    private Boolean distBeforeMultiplier;

    @Column(name = "dist_daily_disabled")
    private Boolean distDailyDisabled;

    @Column(name = "dist_weekly_disabled")
    private Boolean distWeeklyDisabled;

    @Column(name = "dist_no_after_fullna")
    private Boolean distNoAfterFullna;

    @Column(name = "leave_when_absent")
    private Boolean leaveWhenAbsent;

    @Column(name = "leave_debit_always")
    private Boolean leaveDebitAlways;

    @Column(name = "overtime_use_leave_ratio")
    private Double overtimeUseLeaveRatio;

    @Column(name = "use_overwork_for_leaves")
    private Boolean useOverworkForLeaves;

    @Column(name = "day_hours_comparative")
    private Boolean dayHoursComparative;

    @Column(name = "always_calc_holiday")
    private Boolean alwaysCalcHoliday;

    @Column(name = "no_holiday_when_absent")
    private Boolean noHolidayWhenAbsent;

    @Column(name = "min_normal_day_for_holiday")
    private Integer minNormalDayForHoliday;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "normal_category_id", referencedColumnName = "id")
    private Category normalCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "overtime_category_id", referencedColumnName = "id")
    private Category overtimeCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "overwork_category_id", referencedColumnName = "id")
    private Category overworkCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "overtime_used_category_id", referencedColumnName = "id")
    private Category overtimeUsedCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "leave_credit_category_id", referencedColumnName = "id")
    private Category leaveCreditCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "leave_normal_category_id", referencedColumnName = "id")
    private Category leaveNormalCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "leave_debit_category_id", referencedColumnName = "id")
    private Category leaveDebitCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "balance_left_category_id", referencedColumnName = "id")
    private Category balanceLeftCategory;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "balance_over_category_id", referencedColumnName = "id")
    private Category balanceOverCategory;

}
