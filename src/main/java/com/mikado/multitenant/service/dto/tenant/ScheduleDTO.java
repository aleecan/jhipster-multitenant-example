package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Schedule} entity.
 */
public class ScheduleDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 10)
    private String code;

    @Size(max = 80)
    private String description;

    @NotNull
    private Integer type;

    @Size(max = 10)
    private String color;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String naStart;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String naFinish;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String naLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String naLengthMax;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String endOfDay;

    private Boolean endOfDayPriority;

    private Boolean naStartFlex;

    private Boolean naComplete;

    private Boolean dayShift;

    private Boolean priority;

    private Boolean dailyExcuse;

    private Boolean cutOneHour;

    private Boolean overtimeFromEnd;

    private Boolean notCutMealOvertime;

    private Boolean useFirstInLastOut;

    @Size(max = 10)
    private String summaryGroup;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long normalGroupId;

    private Long toleranceGroupId;

    private Long overtimeGroupId;

    private Long mealGroupId;

    private Long additionalGroupId;

    private Long absentCategoryId;

    private Long excessOtCategoryId;

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

    public String getNaStart() {
        return naStart;
    }

    public void setNaStart(String naStart) {
        this.naStart = naStart;
    }

    public String getNaFinish() {
        return naFinish;
    }

    public void setNaFinish(String naFinish) {
        this.naFinish = naFinish;
    }

    public String getNaLength() {
        return naLength;
    }

    public void setNaLength(String naLength) {
        this.naLength = naLength;
    }

    public String getNaLengthMax() {
        return naLengthMax;
    }

    public void setNaLengthMax(String naLengthMax) {
        this.naLengthMax = naLengthMax;
    }

    public String getEndOfDay() {
        return endOfDay;
    }

    public void setEndOfDay(String endOfDay) {
        this.endOfDay = endOfDay;
    }

    public Boolean isEndOfDayPriority() {
        return endOfDayPriority;
    }

    public void setEndOfDayPriority(Boolean endOfDayPriority) {
        this.endOfDayPriority = endOfDayPriority;
    }

    public Boolean isNaStartFlex() {
        return naStartFlex;
    }

    public void setNaStartFlex(Boolean naStartFlex) {
        this.naStartFlex = naStartFlex;
    }

    public Boolean isNaComplete() {
        return naComplete;
    }

    public void setNaComplete(Boolean naComplete) {
        this.naComplete = naComplete;
    }

    public Boolean isDayShift() {
        return dayShift;
    }

    public void setDayShift(Boolean dayShift) {
        this.dayShift = dayShift;
    }

    public Boolean isPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Boolean isDailyExcuse() {
        return dailyExcuse;
    }

    public void setDailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
    }

    public Boolean isCutOneHour() {
        return cutOneHour;
    }

    public void setCutOneHour(Boolean cutOneHour) {
        this.cutOneHour = cutOneHour;
    }

    public Boolean isOvertimeFromEnd() {
        return overtimeFromEnd;
    }

    public void setOvertimeFromEnd(Boolean overtimeFromEnd) {
        this.overtimeFromEnd = overtimeFromEnd;
    }

    public Boolean isNotCutMealOvertime() {
        return notCutMealOvertime;
    }

    public void setNotCutMealOvertime(Boolean notCutMealOvertime) {
        this.notCutMealOvertime = notCutMealOvertime;
    }

    public Boolean isUseFirstInLastOut() {
        return useFirstInLastOut;
    }

    public void setUseFirstInLastOut(Boolean useFirstInLastOut) {
        this.useFirstInLastOut = useFirstInLastOut;
    }

    public String getSummaryGroup() {
        return summaryGroup;
    }

    public void setSummaryGroup(String summaryGroup) {
        this.summaryGroup = summaryGroup;
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

    public Long getNormalGroupId() {
        return normalGroupId;
    }

    public void setNormalGroupId(Long normalGroupId) {
        this.normalGroupId = normalGroupId;
    }

    public Long getToleranceGroupId() {
        return toleranceGroupId;
    }

    public void setToleranceGroupId(Long toleranceGroupId) {
        this.toleranceGroupId = toleranceGroupId;
    }

    public Long getOvertimeGroupId() {
        return overtimeGroupId;
    }

    public void setOvertimeGroupId(Long overtimeGroupId) {
        this.overtimeGroupId = overtimeGroupId;
    }

    public Long getMealGroupId() {
        return mealGroupId;
    }

    public void setMealGroupId(Long mealGroupId) {
        this.mealGroupId = mealGroupId;
    }

    public Long getAdditionalGroupId() {
        return additionalGroupId;
    }

    public void setAdditionalGroupId(Long additionalGroupId) {
        this.additionalGroupId = additionalGroupId;
    }

    public Long getAbsentCategoryId() {
        return absentCategoryId;
    }

    public void setAbsentCategoryId(Long categoryId) {
        this.absentCategoryId = categoryId;
    }

    public Long getExcessOtCategoryId() {
        return excessOtCategoryId;
    }

    public void setExcessOtCategoryId(Long categoryId) {
        this.excessOtCategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ScheduleDTO)) {
            return false;
        }

        return id != null && id.equals(((ScheduleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ScheduleDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", type=" + getType() +
            ", color='" + getColor() + "'" +
            ", naStart='" + getNaStart() + "'" +
            ", naFinish='" + getNaFinish() + "'" +
            ", naLength='" + getNaLength() + "'" +
            ", naLengthMax='" + getNaLengthMax() + "'" +
            ", endOfDay='" + getEndOfDay() + "'" +
            ", endOfDayPriority='" + isEndOfDayPriority() + "'" +
            ", naStartFlex='" + isNaStartFlex() + "'" +
            ", naComplete='" + isNaComplete() + "'" +
            ", dayShift='" + isDayShift() + "'" +
            ", priority='" + isPriority() + "'" +
            ", dailyExcuse='" + isDailyExcuse() + "'" +
            ", cutOneHour='" + isCutOneHour() + "'" +
            ", overtimeFromEnd='" + isOvertimeFromEnd() + "'" +
            ", notCutMealOvertime='" + isNotCutMealOvertime() + "'" +
            ", useFirstInLastOut='" + isUseFirstInLastOut() + "'" +
            ", summaryGroup='" + getSummaryGroup() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", normalGroupId=" + getNormalGroupId() +
            ", toleranceGroupId=" + getToleranceGroupId() +
            ", overtimeGroupId=" + getOvertimeGroupId() +
            ", mealGroupId=" + getMealGroupId() +
            ", additionalGroupId=" + getAdditionalGroupId() +
            ", absentCategoryId=" + getAbsentCategoryId() +
            ", excessOtCategoryId=" + getExcessOtCategoryId() +
            "}";
    }
}
