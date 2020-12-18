package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 5)
    @Column(name = "code", length = 5, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "type")
    private Integer type;

    @Size(max = 15)
    @Column(name = "color", length = 15)
    private String color;

    @Size(max = 10)
    @Column(name = "abbr", length = 10)
    private String abbr;

    @Column(name = "hourly_excuse")
    private Boolean hourlyExcuse;

    @Column(name = "daily_excuse")
    private Boolean dailyExcuse;

    @Column(name = "overtime_approval")
    private Boolean overtimeApproval;

    @Column(name = "normal_group")
    private Boolean normalGroup;

    @Column(name = "not_change_weekly")
    private Boolean notChangeWeekly;

    @Column(name = "overtime_group")
    private Boolean overtimeGroup;

    @Column(name = "day_shift_multiplier")
    private Double dayShiftMultiplier;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "day_shift_day_length", length = 8)
    private String dayShiftDayLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "day_shift_limit_low", length = 8)
    private String dayShiftLimitLow;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "day_shift_limit_up", length = 8)
    private String dayShiftLimitUp;

    @Column(name = "shift_multiplier")
    private Double shiftMultiplier;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "shift_day_length", length = 8)
    private String shiftDayLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "shift_limit_low", length = 8)
    private String shiftLimitLow;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "shift_limit_up", length = 8)
    private String shiftLimitUp;

    @Column(name = "rounding")
    private Boolean rounding;

    @Column(name = "round_step")
    private Integer roundStep;

    @Column(name = "round_time")
    private Integer roundTime;

    @Column(name = "round_day")
    private Integer roundDay;

    @Column(name = "round_day_monthly")
    private Integer roundDayMonthly;

    @Column(name = "include_task")
    private Boolean includeTask;

    @Column(name = "include_special_task")
    private Boolean includeSpecialTask;

    @Column(name = "reserved")
    private Boolean reserved;

    @Size(max = 1)
    @Column(name = "add_sub_annual_leave", length = 1)
    private String addSubAnnualLeave;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

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

    public Category code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Category description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public Category type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public Category color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAbbr() {
        return abbr;
    }

    public Category abbr(String abbr) {
        this.abbr = abbr;
        return this;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Boolean isHourlyExcuse() {
        return hourlyExcuse;
    }

    public Category hourlyExcuse(Boolean hourlyExcuse) {
        this.hourlyExcuse = hourlyExcuse;
        return this;
    }

    public void setHourlyExcuse(Boolean hourlyExcuse) {
        this.hourlyExcuse = hourlyExcuse;
    }

    public Boolean isDailyExcuse() {
        return dailyExcuse;
    }

    public Category dailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
        return this;
    }

    public void setDailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
    }

    public Boolean isOvertimeApproval() {
        return overtimeApproval;
    }

    public Category overtimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
        return this;
    }

    public void setOvertimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
    }

    public Boolean isNormalGroup() {
        return normalGroup;
    }

    public Category normalGroup(Boolean normalGroup) {
        this.normalGroup = normalGroup;
        return this;
    }

    public void setNormalGroup(Boolean normalGroup) {
        this.normalGroup = normalGroup;
    }

    public Boolean isNotChangeWeekly() {
        return notChangeWeekly;
    }

    public Category notChangeWeekly(Boolean notChangeWeekly) {
        this.notChangeWeekly = notChangeWeekly;
        return this;
    }

    public void setNotChangeWeekly(Boolean notChangeWeekly) {
        this.notChangeWeekly = notChangeWeekly;
    }

    public Boolean isOvertimeGroup() {
        return overtimeGroup;
    }

    public Category overtimeGroup(Boolean overtimeGroup) {
        this.overtimeGroup = overtimeGroup;
        return this;
    }

    public void setOvertimeGroup(Boolean overtimeGroup) {
        this.overtimeGroup = overtimeGroup;
    }

    public Double getDayShiftMultiplier() {
        return dayShiftMultiplier;
    }

    public Category dayShiftMultiplier(Double dayShiftMultiplier) {
        this.dayShiftMultiplier = dayShiftMultiplier;
        return this;
    }

    public void setDayShiftMultiplier(Double dayShiftMultiplier) {
        this.dayShiftMultiplier = dayShiftMultiplier;
    }

    public String getDayShiftDayLength() {
        return dayShiftDayLength;
    }

    public Category dayShiftDayLength(String dayShiftDayLength) {
        this.dayShiftDayLength = dayShiftDayLength;
        return this;
    }

    public void setDayShiftDayLength(String dayShiftDayLength) {
        this.dayShiftDayLength = dayShiftDayLength;
    }

    public String getDayShiftLimitLow() {
        return dayShiftLimitLow;
    }

    public Category dayShiftLimitLow(String dayShiftLimitLow) {
        this.dayShiftLimitLow = dayShiftLimitLow;
        return this;
    }

    public void setDayShiftLimitLow(String dayShiftLimitLow) {
        this.dayShiftLimitLow = dayShiftLimitLow;
    }

    public String getDayShiftLimitUp() {
        return dayShiftLimitUp;
    }

    public Category dayShiftLimitUp(String dayShiftLimitUp) {
        this.dayShiftLimitUp = dayShiftLimitUp;
        return this;
    }

    public void setDayShiftLimitUp(String dayShiftLimitUp) {
        this.dayShiftLimitUp = dayShiftLimitUp;
    }

    public Double getShiftMultiplier() {
        return shiftMultiplier;
    }

    public Category shiftMultiplier(Double shiftMultiplier) {
        this.shiftMultiplier = shiftMultiplier;
        return this;
    }

    public void setShiftMultiplier(Double shiftMultiplier) {
        this.shiftMultiplier = shiftMultiplier;
    }

    public String getShiftDayLength() {
        return shiftDayLength;
    }

    public Category shiftDayLength(String shiftDayLength) {
        this.shiftDayLength = shiftDayLength;
        return this;
    }

    public void setShiftDayLength(String shiftDayLength) {
        this.shiftDayLength = shiftDayLength;
    }

    public String getShiftLimitLow() {
        return shiftLimitLow;
    }

    public Category shiftLimitLow(String shiftLimitLow) {
        this.shiftLimitLow = shiftLimitLow;
        return this;
    }

    public void setShiftLimitLow(String shiftLimitLow) {
        this.shiftLimitLow = shiftLimitLow;
    }

    public String getShiftLimitUp() {
        return shiftLimitUp;
    }

    public Category shiftLimitUp(String shiftLimitUp) {
        this.shiftLimitUp = shiftLimitUp;
        return this;
    }

    public void setShiftLimitUp(String shiftLimitUp) {
        this.shiftLimitUp = shiftLimitUp;
    }

    public Boolean isRounding() {
        return rounding;
    }

    public Category rounding(Boolean rounding) {
        this.rounding = rounding;
        return this;
    }

    public void setRounding(Boolean rounding) {
        this.rounding = rounding;
    }

    public Integer getRoundStep() {
        return roundStep;
    }

    public Category roundStep(Integer roundStep) {
        this.roundStep = roundStep;
        return this;
    }

    public void setRoundStep(Integer roundStep) {
        this.roundStep = roundStep;
    }

    public Integer getRoundTime() {
        return roundTime;
    }

    public Category roundTime(Integer roundTime) {
        this.roundTime = roundTime;
        return this;
    }

    public void setRoundTime(Integer roundTime) {
        this.roundTime = roundTime;
    }

    public Integer getRoundDay() {
        return roundDay;
    }

    public Category roundDay(Integer roundDay) {
        this.roundDay = roundDay;
        return this;
    }

    public void setRoundDay(Integer roundDay) {
        this.roundDay = roundDay;
    }

    public Integer getRoundDayMonthly() {
        return roundDayMonthly;
    }

    public Category roundDayMonthly(Integer roundDayMonthly) {
        this.roundDayMonthly = roundDayMonthly;
        return this;
    }

    public void setRoundDayMonthly(Integer roundDayMonthly) {
        this.roundDayMonthly = roundDayMonthly;
    }

    public Boolean isIncludeTask() {
        return includeTask;
    }

    public Category includeTask(Boolean includeTask) {
        this.includeTask = includeTask;
        return this;
    }

    public void setIncludeTask(Boolean includeTask) {
        this.includeTask = includeTask;
    }

    public Boolean isIncludeSpecialTask() {
        return includeSpecialTask;
    }

    public Category includeSpecialTask(Boolean includeSpecialTask) {
        this.includeSpecialTask = includeSpecialTask;
        return this;
    }

    public void setIncludeSpecialTask(Boolean includeSpecialTask) {
        this.includeSpecialTask = includeSpecialTask;
    }

    public Boolean isReserved() {
        return reserved;
    }

    public Category reserved(Boolean reserved) {
        this.reserved = reserved;
        return this;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public String getAddSubAnnualLeave() {
        return addSubAnnualLeave;
    }

    public Category addSubAnnualLeave(String addSubAnnualLeave) {
        this.addSubAnnualLeave = addSubAnnualLeave;
        return this;
    }

    public void setAddSubAnnualLeave(String addSubAnnualLeave) {
        this.addSubAnnualLeave = addSubAnnualLeave;
    }

    public Instant getCreated() {
        return created;
    }

    public Category created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Category modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Category modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Category{" +
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
