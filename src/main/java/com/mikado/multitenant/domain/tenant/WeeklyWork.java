package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A WeeklyWork.
 */
@Entity
@Table(name = "weekly_work")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WeeklyWork implements Serializable {

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

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category normalCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category overtimeCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category overworkCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category overtimeUsedCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category leaveCreditCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category leaveNormalCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category leaveDebitCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category balanceLeftCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "weeklyWorks", allowSetters = true)
    private Category balanceOverCategory;

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

    public WeeklyWork code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public WeeklyWork description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDayHoursMin() {
        return dayHoursMin;
    }

    public WeeklyWork dayHoursMin(Double dayHoursMin) {
        this.dayHoursMin = dayHoursMin;
        return this;
    }

    public void setDayHoursMin(Double dayHoursMin) {
        this.dayHoursMin = dayHoursMin;
    }

    public Double getDayHours() {
        return dayHours;
    }

    public WeeklyWork dayHours(Double dayHours) {
        this.dayHours = dayHours;
        return this;
    }

    public void setDayHours(Double dayHours) {
        this.dayHours = dayHours;
    }

    public Double getDayHoursMax() {
        return dayHoursMax;
    }

    public WeeklyWork dayHoursMax(Double dayHoursMax) {
        this.dayHoursMax = dayHoursMax;
        return this;
    }

    public void setDayHoursMax(Double dayHoursMax) {
        this.dayHoursMax = dayHoursMax;
    }

    public Double getWeekHoursMin() {
        return weekHoursMin;
    }

    public WeeklyWork weekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
        return this;
    }

    public void setWeekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
    }

    public Double getWeekHours() {
        return weekHours;
    }

    public WeeklyWork weekHours(Double weekHours) {
        this.weekHours = weekHours;
        return this;
    }

    public void setWeekHours(Double weekHours) {
        this.weekHours = weekHours;
    }

    public Double getWeekHoursMax() {
        return weekHoursMax;
    }

    public WeeklyWork weekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
        return this;
    }

    public void setWeekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
    }

    public Boolean isDistBeforeMultiplier() {
        return distBeforeMultiplier;
    }

    public WeeklyWork distBeforeMultiplier(Boolean distBeforeMultiplier) {
        this.distBeforeMultiplier = distBeforeMultiplier;
        return this;
    }

    public void setDistBeforeMultiplier(Boolean distBeforeMultiplier) {
        this.distBeforeMultiplier = distBeforeMultiplier;
    }

    public Boolean isDistDailyDisabled() {
        return distDailyDisabled;
    }

    public WeeklyWork distDailyDisabled(Boolean distDailyDisabled) {
        this.distDailyDisabled = distDailyDisabled;
        return this;
    }

    public void setDistDailyDisabled(Boolean distDailyDisabled) {
        this.distDailyDisabled = distDailyDisabled;
    }

    public Boolean isDistWeeklyDisabled() {
        return distWeeklyDisabled;
    }

    public WeeklyWork distWeeklyDisabled(Boolean distWeeklyDisabled) {
        this.distWeeklyDisabled = distWeeklyDisabled;
        return this;
    }

    public void setDistWeeklyDisabled(Boolean distWeeklyDisabled) {
        this.distWeeklyDisabled = distWeeklyDisabled;
    }

    public Boolean isDistNoAfterFullna() {
        return distNoAfterFullna;
    }

    public WeeklyWork distNoAfterFullna(Boolean distNoAfterFullna) {
        this.distNoAfterFullna = distNoAfterFullna;
        return this;
    }

    public void setDistNoAfterFullna(Boolean distNoAfterFullna) {
        this.distNoAfterFullna = distNoAfterFullna;
    }

    public Boolean isLeaveWhenAbsent() {
        return leaveWhenAbsent;
    }

    public WeeklyWork leaveWhenAbsent(Boolean leaveWhenAbsent) {
        this.leaveWhenAbsent = leaveWhenAbsent;
        return this;
    }

    public void setLeaveWhenAbsent(Boolean leaveWhenAbsent) {
        this.leaveWhenAbsent = leaveWhenAbsent;
    }

    public Boolean isLeaveDebitAlways() {
        return leaveDebitAlways;
    }

    public WeeklyWork leaveDebitAlways(Boolean leaveDebitAlways) {
        this.leaveDebitAlways = leaveDebitAlways;
        return this;
    }

    public void setLeaveDebitAlways(Boolean leaveDebitAlways) {
        this.leaveDebitAlways = leaveDebitAlways;
    }

    public Double getOvertimeUseLeaveRatio() {
        return overtimeUseLeaveRatio;
    }

    public WeeklyWork overtimeUseLeaveRatio(Double overtimeUseLeaveRatio) {
        this.overtimeUseLeaveRatio = overtimeUseLeaveRatio;
        return this;
    }

    public void setOvertimeUseLeaveRatio(Double overtimeUseLeaveRatio) {
        this.overtimeUseLeaveRatio = overtimeUseLeaveRatio;
    }

    public Boolean isUseOverworkForLeaves() {
        return useOverworkForLeaves;
    }

    public WeeklyWork useOverworkForLeaves(Boolean useOverworkForLeaves) {
        this.useOverworkForLeaves = useOverworkForLeaves;
        return this;
    }

    public void setUseOverworkForLeaves(Boolean useOverworkForLeaves) {
        this.useOverworkForLeaves = useOverworkForLeaves;
    }

    public Boolean isDayHoursComparative() {
        return dayHoursComparative;
    }

    public WeeklyWork dayHoursComparative(Boolean dayHoursComparative) {
        this.dayHoursComparative = dayHoursComparative;
        return this;
    }

    public void setDayHoursComparative(Boolean dayHoursComparative) {
        this.dayHoursComparative = dayHoursComparative;
    }

    public Boolean isAlwaysCalcHoliday() {
        return alwaysCalcHoliday;
    }

    public WeeklyWork alwaysCalcHoliday(Boolean alwaysCalcHoliday) {
        this.alwaysCalcHoliday = alwaysCalcHoliday;
        return this;
    }

    public void setAlwaysCalcHoliday(Boolean alwaysCalcHoliday) {
        this.alwaysCalcHoliday = alwaysCalcHoliday;
    }

    public Boolean isNoHolidayWhenAbsent() {
        return noHolidayWhenAbsent;
    }

    public WeeklyWork noHolidayWhenAbsent(Boolean noHolidayWhenAbsent) {
        this.noHolidayWhenAbsent = noHolidayWhenAbsent;
        return this;
    }

    public void setNoHolidayWhenAbsent(Boolean noHolidayWhenAbsent) {
        this.noHolidayWhenAbsent = noHolidayWhenAbsent;
    }

    public Integer getMinNormalDayForHoliday() {
        return minNormalDayForHoliday;
    }

    public WeeklyWork minNormalDayForHoliday(Integer minNormalDayForHoliday) {
        this.minNormalDayForHoliday = minNormalDayForHoliday;
        return this;
    }

    public void setMinNormalDayForHoliday(Integer minNormalDayForHoliday) {
        this.minNormalDayForHoliday = minNormalDayForHoliday;
    }

    public Category getNormalCategory() {
        return normalCategory;
    }

    public WeeklyWork normalCategory(Category category) {
        this.normalCategory = category;
        return this;
    }

    public void setNormalCategory(Category category) {
        this.normalCategory = category;
    }

    public Category getOvertimeCategory() {
        return overtimeCategory;
    }

    public WeeklyWork overtimeCategory(Category category) {
        this.overtimeCategory = category;
        return this;
    }

    public void setOvertimeCategory(Category category) {
        this.overtimeCategory = category;
    }

    public Category getOverworkCategory() {
        return overworkCategory;
    }

    public WeeklyWork overworkCategory(Category category) {
        this.overworkCategory = category;
        return this;
    }

    public void setOverworkCategory(Category category) {
        this.overworkCategory = category;
    }

    public Category getOvertimeUsedCategory() {
        return overtimeUsedCategory;
    }

    public WeeklyWork overtimeUsedCategory(Category category) {
        this.overtimeUsedCategory = category;
        return this;
    }

    public void setOvertimeUsedCategory(Category category) {
        this.overtimeUsedCategory = category;
    }

    public Category getLeaveCreditCategory() {
        return leaveCreditCategory;
    }

    public WeeklyWork leaveCreditCategory(Category category) {
        this.leaveCreditCategory = category;
        return this;
    }

    public void setLeaveCreditCategory(Category category) {
        this.leaveCreditCategory = category;
    }

    public Category getLeaveNormalCategory() {
        return leaveNormalCategory;
    }

    public WeeklyWork leaveNormalCategory(Category category) {
        this.leaveNormalCategory = category;
        return this;
    }

    public void setLeaveNormalCategory(Category category) {
        this.leaveNormalCategory = category;
    }

    public Category getLeaveDebitCategory() {
        return leaveDebitCategory;
    }

    public WeeklyWork leaveDebitCategory(Category category) {
        this.leaveDebitCategory = category;
        return this;
    }

    public void setLeaveDebitCategory(Category category) {
        this.leaveDebitCategory = category;
    }

    public Category getBalanceLeftCategory() {
        return balanceLeftCategory;
    }

    public WeeklyWork balanceLeftCategory(Category category) {
        this.balanceLeftCategory = category;
        return this;
    }

    public void setBalanceLeftCategory(Category category) {
        this.balanceLeftCategory = category;
    }

    public Category getBalanceOverCategory() {
        return balanceOverCategory;
    }

    public WeeklyWork balanceOverCategory(Category category) {
        this.balanceOverCategory = category;
        return this;
    }

    public void setBalanceOverCategory(Category category) {
        this.balanceOverCategory = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyWork)) {
            return false;
        }
        return id != null && id.equals(((WeeklyWork) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyWork{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", dayHoursMin=" + getDayHoursMin() +
            ", dayHours=" + getDayHours() +
            ", dayHoursMax=" + getDayHoursMax() +
            ", weekHoursMin=" + getWeekHoursMin() +
            ", weekHours=" + getWeekHours() +
            ", weekHoursMax=" + getWeekHoursMax() +
            ", distBeforeMultiplier='" + isDistBeforeMultiplier() + "'" +
            ", distDailyDisabled='" + isDistDailyDisabled() + "'" +
            ", distWeeklyDisabled='" + isDistWeeklyDisabled() + "'" +
            ", distNoAfterFullna='" + isDistNoAfterFullna() + "'" +
            ", leaveWhenAbsent='" + isLeaveWhenAbsent() + "'" +
            ", leaveDebitAlways='" + isLeaveDebitAlways() + "'" +
            ", overtimeUseLeaveRatio=" + getOvertimeUseLeaveRatio() +
            ", useOverworkForLeaves='" + isUseOverworkForLeaves() + "'" +
            ", dayHoursComparative='" + isDayHoursComparative() + "'" +
            ", alwaysCalcHoliday='" + isAlwaysCalcHoliday() + "'" +
            ", noHolidayWhenAbsent='" + isNoHolidayWhenAbsent() + "'" +
            ", minNormalDayForHoliday=" + getMinNormalDayForHoliday() +
            "}";
    }
}
