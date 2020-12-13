package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Category} entity.
 */
public class CategoryDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 5)
    private String code;

    @Size(max = 80)
    private String description;

    private Integer type;

    @Size(max = 15)
    private String color;

    @Size(max = 10)
    private String abbr;

    private Boolean hourlyExcuse;

    private Boolean dailyExcuse;

    private Boolean overtimeApproval;

    private Boolean normalGroup;

    private Boolean notChangeWeekly;

    private Boolean overtimeGroup;

    private Double dayShiftMultiplier;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String dayShiftDayLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String dayShiftLimitLow;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String dayShiftLimitUp;

    private Double shiftMultiplier;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String shiftDayLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String shiftLimitLow;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String shiftLimitUp;

    private Boolean rounding;

    private Integer roundStep;

    private Integer roundTime;

    private Integer roundDay;

    private Integer roundDayMonthly;

    private Boolean includeTask;

    private Boolean includeSpecialTask;

    private Boolean reserved;

    @Size(max = 1)
    private String addSubAnnualLeave;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Boolean isHourlyExcuse() {
        return hourlyExcuse;
    }

    public void setHourlyExcuse(Boolean hourlyExcuse) {
        this.hourlyExcuse = hourlyExcuse;
    }

    public Boolean isDailyExcuse() {
        return dailyExcuse;
    }

    public void setDailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
    }

    public Boolean isOvertimeApproval() {
        return overtimeApproval;
    }

    public void setOvertimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
    }

    public Boolean isNormalGroup() {
        return normalGroup;
    }

    public void setNormalGroup(Boolean normalGroup) {
        this.normalGroup = normalGroup;
    }

    public Boolean isNotChangeWeekly() {
        return notChangeWeekly;
    }

    public void setNotChangeWeekly(Boolean notChangeWeekly) {
        this.notChangeWeekly = notChangeWeekly;
    }

    public Boolean isOvertimeGroup() {
        return overtimeGroup;
    }

    public void setOvertimeGroup(Boolean overtimeGroup) {
        this.overtimeGroup = overtimeGroup;
    }

    public Double getDayShiftMultiplier() {
        return dayShiftMultiplier;
    }

    public void setDayShiftMultiplier(Double dayShiftMultiplier) {
        this.dayShiftMultiplier = dayShiftMultiplier;
    }

    public String getDayShiftDayLength() {
        return dayShiftDayLength;
    }

    public void setDayShiftDayLength(String dayShiftDayLength) {
        this.dayShiftDayLength = dayShiftDayLength;
    }

    public String getDayShiftLimitLow() {
        return dayShiftLimitLow;
    }

    public void setDayShiftLimitLow(String dayShiftLimitLow) {
        this.dayShiftLimitLow = dayShiftLimitLow;
    }

    public String getDayShiftLimitUp() {
        return dayShiftLimitUp;
    }

    public void setDayShiftLimitUp(String dayShiftLimitUp) {
        this.dayShiftLimitUp = dayShiftLimitUp;
    }

    public Double getShiftMultiplier() {
        return shiftMultiplier;
    }

    public void setShiftMultiplier(Double shiftMultiplier) {
        this.shiftMultiplier = shiftMultiplier;
    }

    public String getShiftDayLength() {
        return shiftDayLength;
    }

    public void setShiftDayLength(String shiftDayLength) {
        this.shiftDayLength = shiftDayLength;
    }

    public String getShiftLimitLow() {
        return shiftLimitLow;
    }

    public void setShiftLimitLow(String shiftLimitLow) {
        this.shiftLimitLow = shiftLimitLow;
    }

    public String getShiftLimitUp() {
        return shiftLimitUp;
    }

    public void setShiftLimitUp(String shiftLimitUp) {
        this.shiftLimitUp = shiftLimitUp;
    }

    public Boolean isRounding() {
        return rounding;
    }

    public void setRounding(Boolean rounding) {
        this.rounding = rounding;
    }

    public Integer getRoundStep() {
        return roundStep;
    }

    public void setRoundStep(Integer roundStep) {
        this.roundStep = roundStep;
    }

    public Integer getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(Integer roundTime) {
        this.roundTime = roundTime;
    }

    public Integer getRoundDay() {
        return roundDay;
    }

    public void setRoundDay(Integer roundDay) {
        this.roundDay = roundDay;
    }

    public Integer getRoundDayMonthly() {
        return roundDayMonthly;
    }

    public void setRoundDayMonthly(Integer roundDayMonthly) {
        this.roundDayMonthly = roundDayMonthly;
    }

    public Boolean isIncludeTask() {
        return includeTask;
    }

    public void setIncludeTask(Boolean includeTask) {
        this.includeTask = includeTask;
    }

    public Boolean isIncludeSpecialTask() {
        return includeSpecialTask;
    }

    public void setIncludeSpecialTask(Boolean includeSpecialTask) {
        this.includeSpecialTask = includeSpecialTask;
    }

    public Boolean isReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public String getAddSubAnnualLeave() {
        return addSubAnnualLeave;
    }

    public void setAddSubAnnualLeave(String addSubAnnualLeave) {
        this.addSubAnnualLeave = addSubAnnualLeave;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoryDTO)) {
            return false;
        }

        return id != null && id.equals(((CategoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CategoryDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", type=" + getType() +
            ", color='" + getColor() + "'" +
            ", abbr='" + getAbbr() + "'" +
            ", hourlyExcuse='" + isHourlyExcuse() + "'" +
            ", dailyExcuse='" + isDailyExcuse() + "'" +
            ", overtimeApproval='" + isOvertimeApproval() + "'" +
            ", normalGroup='" + isNormalGroup() + "'" +
            ", notChangeWeekly='" + isNotChangeWeekly() + "'" +
            ", overtimeGroup='" + isOvertimeGroup() + "'" +
            ", dayShiftMultiplier=" + getDayShiftMultiplier() +
            ", dayShiftDayLength='" + getDayShiftDayLength() + "'" +
            ", dayShiftLimitLow='" + getDayShiftLimitLow() + "'" +
            ", dayShiftLimitUp='" + getDayShiftLimitUp() + "'" +
            ", shiftMultiplier=" + getShiftMultiplier() +
            ", shiftDayLength='" + getShiftDayLength() + "'" +
            ", shiftLimitLow='" + getShiftLimitLow() + "'" +
            ", shiftLimitUp='" + getShiftLimitUp() + "'" +
            ", rounding='" + isRounding() + "'" +
            ", roundStep=" + getRoundStep() +
            ", roundTime=" + getRoundTime() +
            ", roundDay=" + getRoundDay() +
            ", roundDayMonthly=" + getRoundDayMonthly() +
            ", includeTask='" + isIncludeTask() + "'" +
            ", includeSpecialTask='" + isIncludeSpecialTask() + "'" +
            ", reserved='" + isReserved() + "'" +
            ", addSubAnnualLeave='" + getAddSubAnnualLeave() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
