package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Schedule.
 */
@Entity
@Table(name = "schedule")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Schedule implements Serializable {

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

    @NotNull
    @Column(name = "type", nullable = false)
    private Integer type;

    @Size(max = 10)
    @Column(name = "color", length = 10)
    private String color;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "na_start", length = 8)
    private String naStart;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "na_finish", length = 8)
    private String naFinish;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "na_length", length = 8)
    private String naLength;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "na_length_max", length = 8)
    private String naLengthMax;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "end_of_day", length = 8)
    private String endOfDay;

    @Column(name = "end_of_day_priority")
    private Boolean endOfDayPriority;

    @Column(name = "na_start_flex")
    private Boolean naStartFlex;

    @Column(name = "na_complete")
    private Boolean naComplete;

    @Column(name = "day_shift")
    private Boolean dayShift;

    @Column(name = "priority")
    private Boolean priority;

    @Column(name = "daily_excuse")
    private Boolean dailyExcuse;

    @Column(name = "cut_one_hour")
    private Boolean cutOneHour;

    @Column(name = "overtime_from_end")
    private Boolean overtimeFromEnd;

    @Column(name = "not_cut_meal_overtime")
    private Boolean notCutMealOvertime;

    @Column(name = "use_first_in_last_out")
    private Boolean useFirstInLastOut;

    @Size(max = 10)
    @Column(name = "summary_group", length = 10)
    private String summaryGroup;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private NormalGroup normalGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private ToleranceGroup toleranceGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private OvertimeGroup overtimeGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private MealGroup mealGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private AdditionalGroup additionalGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private Category absentCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedules", allowSetters = true)
    private Category excessOtCategory;

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

    public Schedule code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Schedule description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public Schedule type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public Schedule color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNaStart() {
        return naStart;
    }

    public Schedule naStart(String naStart) {
        this.naStart = naStart;
        return this;
    }

    public void setNaStart(String naStart) {
        this.naStart = naStart;
    }

    public String getNaFinish() {
        return naFinish;
    }

    public Schedule naFinish(String naFinish) {
        this.naFinish = naFinish;
        return this;
    }

    public void setNaFinish(String naFinish) {
        this.naFinish = naFinish;
    }

    public String getNaLength() {
        return naLength;
    }

    public Schedule naLength(String naLength) {
        this.naLength = naLength;
        return this;
    }

    public void setNaLength(String naLength) {
        this.naLength = naLength;
    }

    public String getNaLengthMax() {
        return naLengthMax;
    }

    public Schedule naLengthMax(String naLengthMax) {
        this.naLengthMax = naLengthMax;
        return this;
    }

    public void setNaLengthMax(String naLengthMax) {
        this.naLengthMax = naLengthMax;
    }

    public String getEndOfDay() {
        return endOfDay;
    }

    public Schedule endOfDay(String endOfDay) {
        this.endOfDay = endOfDay;
        return this;
    }

    public void setEndOfDay(String endOfDay) {
        this.endOfDay = endOfDay;
    }

    public Boolean isEndOfDayPriority() {
        return endOfDayPriority;
    }

    public Schedule endOfDayPriority(Boolean endOfDayPriority) {
        this.endOfDayPriority = endOfDayPriority;
        return this;
    }

    public void setEndOfDayPriority(Boolean endOfDayPriority) {
        this.endOfDayPriority = endOfDayPriority;
    }

    public Boolean isNaStartFlex() {
        return naStartFlex;
    }

    public Schedule naStartFlex(Boolean naStartFlex) {
        this.naStartFlex = naStartFlex;
        return this;
    }

    public void setNaStartFlex(Boolean naStartFlex) {
        this.naStartFlex = naStartFlex;
    }

    public Boolean isNaComplete() {
        return naComplete;
    }

    public Schedule naComplete(Boolean naComplete) {
        this.naComplete = naComplete;
        return this;
    }

    public void setNaComplete(Boolean naComplete) {
        this.naComplete = naComplete;
    }

    public Boolean isDayShift() {
        return dayShift;
    }

    public Schedule dayShift(Boolean dayShift) {
        this.dayShift = dayShift;
        return this;
    }

    public void setDayShift(Boolean dayShift) {
        this.dayShift = dayShift;
    }

    public Boolean isPriority() {
        return priority;
    }

    public Schedule priority(Boolean priority) {
        this.priority = priority;
        return this;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Boolean isDailyExcuse() {
        return dailyExcuse;
    }

    public Schedule dailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
        return this;
    }

    public void setDailyExcuse(Boolean dailyExcuse) {
        this.dailyExcuse = dailyExcuse;
    }

    public Boolean isCutOneHour() {
        return cutOneHour;
    }

    public Schedule cutOneHour(Boolean cutOneHour) {
        this.cutOneHour = cutOneHour;
        return this;
    }

    public void setCutOneHour(Boolean cutOneHour) {
        this.cutOneHour = cutOneHour;
    }

    public Boolean isOvertimeFromEnd() {
        return overtimeFromEnd;
    }

    public Schedule overtimeFromEnd(Boolean overtimeFromEnd) {
        this.overtimeFromEnd = overtimeFromEnd;
        return this;
    }

    public void setOvertimeFromEnd(Boolean overtimeFromEnd) {
        this.overtimeFromEnd = overtimeFromEnd;
    }

    public Boolean isNotCutMealOvertime() {
        return notCutMealOvertime;
    }

    public Schedule notCutMealOvertime(Boolean notCutMealOvertime) {
        this.notCutMealOvertime = notCutMealOvertime;
        return this;
    }

    public void setNotCutMealOvertime(Boolean notCutMealOvertime) {
        this.notCutMealOvertime = notCutMealOvertime;
    }

    public Boolean isUseFirstInLastOut() {
        return useFirstInLastOut;
    }

    public Schedule useFirstInLastOut(Boolean useFirstInLastOut) {
        this.useFirstInLastOut = useFirstInLastOut;
        return this;
    }

    public void setUseFirstInLastOut(Boolean useFirstInLastOut) {
        this.useFirstInLastOut = useFirstInLastOut;
    }

    public String getSummaryGroup() {
        return summaryGroup;
    }

    public Schedule summaryGroup(String summaryGroup) {
        this.summaryGroup = summaryGroup;
        return this;
    }

    public void setSummaryGroup(String summaryGroup) {
        this.summaryGroup = summaryGroup;
    }

    public Instant getCreated() {
        return created;
    }

    public Schedule created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Schedule modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Schedule modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public NormalGroup getNormalGroup() {
        return normalGroup;
    }

    public Schedule normalGroup(NormalGroup normalGroup) {
        this.normalGroup = normalGroup;
        return this;
    }

    public void setNormalGroup(NormalGroup normalGroup) {
        this.normalGroup = normalGroup;
    }

    public ToleranceGroup getToleranceGroup() {
        return toleranceGroup;
    }

    public Schedule toleranceGroup(ToleranceGroup toleranceGroup) {
        this.toleranceGroup = toleranceGroup;
        return this;
    }

    public void setToleranceGroup(ToleranceGroup toleranceGroup) {
        this.toleranceGroup = toleranceGroup;
    }

    public OvertimeGroup getOvertimeGroup() {
        return overtimeGroup;
    }

    public Schedule overtimeGroup(OvertimeGroup overtimeGroup) {
        this.overtimeGroup = overtimeGroup;
        return this;
    }

    public void setOvertimeGroup(OvertimeGroup overtimeGroup) {
        this.overtimeGroup = overtimeGroup;
    }

    public MealGroup getMealGroup() {
        return mealGroup;
    }

    public Schedule mealGroup(MealGroup mealGroup) {
        this.mealGroup = mealGroup;
        return this;
    }

    public void setMealGroup(MealGroup mealGroup) {
        this.mealGroup = mealGroup;
    }

    public AdditionalGroup getAdditionalGroup() {
        return additionalGroup;
    }

    public Schedule additionalGroup(AdditionalGroup additionalGroup) {
        this.additionalGroup = additionalGroup;
        return this;
    }

    public void setAdditionalGroup(AdditionalGroup additionalGroup) {
        this.additionalGroup = additionalGroup;
    }

    public Category getAbsentCategory() {
        return absentCategory;
    }

    public Schedule absentCategory(Category category) {
        this.absentCategory = category;
        return this;
    }

    public void setAbsentCategory(Category category) {
        this.absentCategory = category;
    }

    public Category getExcessOtCategory() {
        return excessOtCategory;
    }

    public Schedule excessOtCategory(Category category) {
        this.excessOtCategory = category;
        return this;
    }

    public void setExcessOtCategory(Category category) {
        this.excessOtCategory = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Schedule)) {
            return false;
        }
        return id != null && id.equals(((Schedule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Schedule{" +
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
            "}";
    }
}
