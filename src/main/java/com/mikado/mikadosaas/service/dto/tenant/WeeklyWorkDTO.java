package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.WeeklyWork} entity.
 */
public class WeeklyWorkDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 10)
    private String code;

    @Size(max = 80)
    private String description;

    private Double dayHoursMin;

    private Double dayHours;

    private Double dayHoursMax;

    private Double weekHoursMin;

    private Double weekHours;

    private Double weekHoursMax;

    private Boolean distBeforeMultiplier;

    private Boolean distDailyDisabled;

    private Boolean distWeeklyDisabled;

    private Boolean distNoAfterFullna;

    private Boolean leaveWhenAbsent;

    private Boolean leaveDebitAlways;

    private Double overtimeUseLeaveRatio;

    private Boolean useOverworkForLeaves;

    private Boolean dayHoursComparative;

    private Boolean alwaysCalcHoliday;

    private Boolean noHolidayWhenAbsent;

    private Integer minNormalDayForHoliday;


    private Long normalCategoryId;

    private Long overtimeCategoryId;

    private Long overworkCategoryId;

    private Long overtimeUsedCategoryId;

    private Long leaveCreditCategoryId;

    private Long leaveNormalCategoryId;

    private Long leaveDebitCategoryId;

    private Long balanceLeftCategoryId;

    private Long balanceOverCategoryId;

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

    public Double getDayHoursMin() {
        return dayHoursMin;
    }

    public void setDayHoursMin(Double dayHoursMin) {
        this.dayHoursMin = dayHoursMin;
    }

    public Double getDayHours() {
        return dayHours;
    }

    public void setDayHours(Double dayHours) {
        this.dayHours = dayHours;
    }

    public Double getDayHoursMax() {
        return dayHoursMax;
    }

    public void setDayHoursMax(Double dayHoursMax) {
        this.dayHoursMax = dayHoursMax;
    }

    public Double getWeekHoursMin() {
        return weekHoursMin;
    }

    public void setWeekHoursMin(Double weekHoursMin) {
        this.weekHoursMin = weekHoursMin;
    }

    public Double getWeekHours() {
        return weekHours;
    }

    public void setWeekHours(Double weekHours) {
        this.weekHours = weekHours;
    }

    public Double getWeekHoursMax() {
        return weekHoursMax;
    }

    public void setWeekHoursMax(Double weekHoursMax) {
        this.weekHoursMax = weekHoursMax;
    }

    public Boolean isDistBeforeMultiplier() {
        return distBeforeMultiplier;
    }

    public void setDistBeforeMultiplier(Boolean distBeforeMultiplier) {
        this.distBeforeMultiplier = distBeforeMultiplier;
    }

    public Boolean isDistDailyDisabled() {
        return distDailyDisabled;
    }

    public void setDistDailyDisabled(Boolean distDailyDisabled) {
        this.distDailyDisabled = distDailyDisabled;
    }

    public Boolean isDistWeeklyDisabled() {
        return distWeeklyDisabled;
    }

    public void setDistWeeklyDisabled(Boolean distWeeklyDisabled) {
        this.distWeeklyDisabled = distWeeklyDisabled;
    }

    public Boolean isDistNoAfterFullna() {
        return distNoAfterFullna;
    }

    public void setDistNoAfterFullna(Boolean distNoAfterFullna) {
        this.distNoAfterFullna = distNoAfterFullna;
    }

    public Boolean isLeaveWhenAbsent() {
        return leaveWhenAbsent;
    }

    public void setLeaveWhenAbsent(Boolean leaveWhenAbsent) {
        this.leaveWhenAbsent = leaveWhenAbsent;
    }

    public Boolean isLeaveDebitAlways() {
        return leaveDebitAlways;
    }

    public void setLeaveDebitAlways(Boolean leaveDebitAlways) {
        this.leaveDebitAlways = leaveDebitAlways;
    }

    public Double getOvertimeUseLeaveRatio() {
        return overtimeUseLeaveRatio;
    }

    public void setOvertimeUseLeaveRatio(Double overtimeUseLeaveRatio) {
        this.overtimeUseLeaveRatio = overtimeUseLeaveRatio;
    }

    public Boolean isUseOverworkForLeaves() {
        return useOverworkForLeaves;
    }

    public void setUseOverworkForLeaves(Boolean useOverworkForLeaves) {
        this.useOverworkForLeaves = useOverworkForLeaves;
    }

    public Boolean isDayHoursComparative() {
        return dayHoursComparative;
    }

    public void setDayHoursComparative(Boolean dayHoursComparative) {
        this.dayHoursComparative = dayHoursComparative;
    }

    public Boolean isAlwaysCalcHoliday() {
        return alwaysCalcHoliday;
    }

    public void setAlwaysCalcHoliday(Boolean alwaysCalcHoliday) {
        this.alwaysCalcHoliday = alwaysCalcHoliday;
    }

    public Boolean isNoHolidayWhenAbsent() {
        return noHolidayWhenAbsent;
    }

    public void setNoHolidayWhenAbsent(Boolean noHolidayWhenAbsent) {
        this.noHolidayWhenAbsent = noHolidayWhenAbsent;
    }

    public Integer getMinNormalDayForHoliday() {
        return minNormalDayForHoliday;
    }

    public void setMinNormalDayForHoliday(Integer minNormalDayForHoliday) {
        this.minNormalDayForHoliday = minNormalDayForHoliday;
    }

    public Long getNormalCategoryId() {
        return normalCategoryId;
    }

    public void setNormalCategoryId(Long categoryId) {
        this.normalCategoryId = categoryId;
    }

    public Long getOvertimeCategoryId() {
        return overtimeCategoryId;
    }

    public void setOvertimeCategoryId(Long categoryId) {
        this.overtimeCategoryId = categoryId;
    }

    public Long getOverworkCategoryId() {
        return overworkCategoryId;
    }

    public void setOverworkCategoryId(Long categoryId) {
        this.overworkCategoryId = categoryId;
    }

    public Long getOvertimeUsedCategoryId() {
        return overtimeUsedCategoryId;
    }

    public void setOvertimeUsedCategoryId(Long categoryId) {
        this.overtimeUsedCategoryId = categoryId;
    }

    public Long getLeaveCreditCategoryId() {
        return leaveCreditCategoryId;
    }

    public void setLeaveCreditCategoryId(Long categoryId) {
        this.leaveCreditCategoryId = categoryId;
    }

    public Long getLeaveNormalCategoryId() {
        return leaveNormalCategoryId;
    }

    public void setLeaveNormalCategoryId(Long categoryId) {
        this.leaveNormalCategoryId = categoryId;
    }

    public Long getLeaveDebitCategoryId() {
        return leaveDebitCategoryId;
    }

    public void setLeaveDebitCategoryId(Long categoryId) {
        this.leaveDebitCategoryId = categoryId;
    }

    public Long getBalanceLeftCategoryId() {
        return balanceLeftCategoryId;
    }

    public void setBalanceLeftCategoryId(Long categoryId) {
        this.balanceLeftCategoryId = categoryId;
    }

    public Long getBalanceOverCategoryId() {
        return balanceOverCategoryId;
    }

    public void setBalanceOverCategoryId(Long categoryId) {
        this.balanceOverCategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyWorkDTO)) {
            return false;
        }

        return id != null && id.equals(((WeeklyWorkDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyWorkDTO{" +
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
            ", normalCategoryId=" + getNormalCategoryId() +
            ", overtimeCategoryId=" + getOvertimeCategoryId() +
            ", overworkCategoryId=" + getOverworkCategoryId() +
            ", overtimeUsedCategoryId=" + getOvertimeUsedCategoryId() +
            ", leaveCreditCategoryId=" + getLeaveCreditCategoryId() +
            ", leaveNormalCategoryId=" + getLeaveNormalCategoryId() +
            ", leaveDebitCategoryId=" + getLeaveDebitCategoryId() +
            ", balanceLeftCategoryId=" + getBalanceLeftCategoryId() +
            ", balanceOverCategoryId=" + getBalanceOverCategoryId() +
            "}";
    }
}
