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
 * A DailyAnalysis.
 */
@Entity
@Table(name = "daily_analysis")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DailyAnalysis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "daydate")
    private LocalDate daydate;

    @Column(name = "day_type")
    private Integer dayType;

    @Size(max = 80)
    @Column(name = "schedule_desc", length = 80)
    private String scheduleDesc;

    @Size(max = 80)
    @Column(name = "default_schedule_desc", length = 80)
    private String defaultScheduleDesc;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "na_length", length = 8)
    private String naLength;

    @Column(name = "na_start")
    private Instant naStart;

    @Column(name = "na_finish")
    private Instant naFinish;

    @Column(name = "ee_count")
    private Integer eeCount;

    @Size(max = 1024)
    @Column(name = "ee_info", length = 1024)
    private String eeInfo;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "finish_time")
    private Instant finishTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "start_time_dif", length = 8)
    private String startTimeDif;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "finish_time_dif", length = 8)
    private String finishTimeDif;

    @Column(name = "start_late")
    private Boolean startLate;

    @Column(name = "finish_early")
    private Boolean finishEarly;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "total_hour", length = 8)
    private String totalHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "normal_hour", length = 8)
    private String normalHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_hour", length = 8)
    private String overtimeHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "reason_hour", length = 8)
    private String reasonHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "absent_hour", length = 8)
    private String absentHour;

    @Size(max = 10)
    @Column(name = "cweekly", length = 10)
    private String cweekly;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "weekly_hour", length = 8)
    private String weeklyHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_total", length = 8)
    private String overtimeTotal;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_total_approved", length = 8)
    private String overtimeTotalApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_total_not_approved", length = 8)
    private String overtimeTotalNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_before", length = 8)
    private String overtimeBefore;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_before_approved", length = 8)
    private String overtimeBeforeApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_before_not_approved", length = 8)
    private String overtimeBeforeNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_after", length = 8)
    private String overtimeAfter;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_after_approved", length = 8)
    private String overtimeAfterApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_after_not_approved", length = 8)
    private String overtimeAfterNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_add", length = 8)
    private String overtimeAdd;

    @Column(name = "mee_count")
    private Integer meeCount;

    @Size(max = 1024)
    @Column(name = "mee_info", length = 1024)
    private String meeInfo;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private Schedule schedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private OvertimeReason overtimeReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private Schedule defaultSchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private Category startReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailyAnalyses", allowSetters = true)
    private Category finishReason;

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

    public DailyAnalysis daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Integer getDayType() {
        return dayType;
    }

    public DailyAnalysis dayType(Integer dayType) {
        this.dayType = dayType;
        return this;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public String getScheduleDesc() {
        return scheduleDesc;
    }

    public DailyAnalysis scheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc;
        return this;
    }

    public void setScheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc;
    }

    public String getDefaultScheduleDesc() {
        return defaultScheduleDesc;
    }

    public DailyAnalysis defaultScheduleDesc(String defaultScheduleDesc) {
        this.defaultScheduleDesc = defaultScheduleDesc;
        return this;
    }

    public void setDefaultScheduleDesc(String defaultScheduleDesc) {
        this.defaultScheduleDesc = defaultScheduleDesc;
    }

    public String getNaLength() {
        return naLength;
    }

    public DailyAnalysis naLength(String naLength) {
        this.naLength = naLength;
        return this;
    }

    public void setNaLength(String naLength) {
        this.naLength = naLength;
    }

    public Instant getNaStart() {
        return naStart;
    }

    public DailyAnalysis naStart(Instant naStart) {
        this.naStart = naStart;
        return this;
    }

    public void setNaStart(Instant naStart) {
        this.naStart = naStart;
    }

    public Instant getNaFinish() {
        return naFinish;
    }

    public DailyAnalysis naFinish(Instant naFinish) {
        this.naFinish = naFinish;
        return this;
    }

    public void setNaFinish(Instant naFinish) {
        this.naFinish = naFinish;
    }

    public Integer getEeCount() {
        return eeCount;
    }

    public DailyAnalysis eeCount(Integer eeCount) {
        this.eeCount = eeCount;
        return this;
    }

    public void setEeCount(Integer eeCount) {
        this.eeCount = eeCount;
    }

    public String getEeInfo() {
        return eeInfo;
    }

    public DailyAnalysis eeInfo(String eeInfo) {
        this.eeInfo = eeInfo;
        return this;
    }

    public void setEeInfo(String eeInfo) {
        this.eeInfo = eeInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public DailyAnalysis status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public DailyAnalysis startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getFinishTime() {
        return finishTime;
    }

    public DailyAnalysis finishTime(Instant finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public void setFinishTime(Instant finishTime) {
        this.finishTime = finishTime;
    }

    public String getStartTimeDif() {
        return startTimeDif;
    }

    public DailyAnalysis startTimeDif(String startTimeDif) {
        this.startTimeDif = startTimeDif;
        return this;
    }

    public void setStartTimeDif(String startTimeDif) {
        this.startTimeDif = startTimeDif;
    }

    public String getFinishTimeDif() {
        return finishTimeDif;
    }

    public DailyAnalysis finishTimeDif(String finishTimeDif) {
        this.finishTimeDif = finishTimeDif;
        return this;
    }

    public void setFinishTimeDif(String finishTimeDif) {
        this.finishTimeDif = finishTimeDif;
    }

    public Boolean isStartLate() {
        return startLate;
    }

    public DailyAnalysis startLate(Boolean startLate) {
        this.startLate = startLate;
        return this;
    }

    public void setStartLate(Boolean startLate) {
        this.startLate = startLate;
    }

    public Boolean isFinishEarly() {
        return finishEarly;
    }

    public DailyAnalysis finishEarly(Boolean finishEarly) {
        this.finishEarly = finishEarly;
        return this;
    }

    public void setFinishEarly(Boolean finishEarly) {
        this.finishEarly = finishEarly;
    }

    public String getTotalHour() {
        return totalHour;
    }

    public DailyAnalysis totalHour(String totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(String totalHour) {
        this.totalHour = totalHour;
    }

    public String getNormalHour() {
        return normalHour;
    }

    public DailyAnalysis normalHour(String normalHour) {
        this.normalHour = normalHour;
        return this;
    }

    public void setNormalHour(String normalHour) {
        this.normalHour = normalHour;
    }

    public String getOvertimeHour() {
        return overtimeHour;
    }

    public DailyAnalysis overtimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
        return this;
    }

    public void setOvertimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public String getReasonHour() {
        return reasonHour;
    }

    public DailyAnalysis reasonHour(String reasonHour) {
        this.reasonHour = reasonHour;
        return this;
    }

    public void setReasonHour(String reasonHour) {
        this.reasonHour = reasonHour;
    }

    public String getAbsentHour() {
        return absentHour;
    }

    public DailyAnalysis absentHour(String absentHour) {
        this.absentHour = absentHour;
        return this;
    }

    public void setAbsentHour(String absentHour) {
        this.absentHour = absentHour;
    }

    public String getCweekly() {
        return cweekly;
    }

    public DailyAnalysis cweekly(String cweekly) {
        this.cweekly = cweekly;
        return this;
    }

    public void setCweekly(String cweekly) {
        this.cweekly = cweekly;
    }

    public String getWeeklyHour() {
        return weeklyHour;
    }

    public DailyAnalysis weeklyHour(String weeklyHour) {
        this.weeklyHour = weeklyHour;
        return this;
    }

    public void setWeeklyHour(String weeklyHour) {
        this.weeklyHour = weeklyHour;
    }

    public String getOvertimeTotal() {
        return overtimeTotal;
    }

    public DailyAnalysis overtimeTotal(String overtimeTotal) {
        this.overtimeTotal = overtimeTotal;
        return this;
    }

    public void setOvertimeTotal(String overtimeTotal) {
        this.overtimeTotal = overtimeTotal;
    }

    public String getOvertimeTotalApproved() {
        return overtimeTotalApproved;
    }

    public DailyAnalysis overtimeTotalApproved(String overtimeTotalApproved) {
        this.overtimeTotalApproved = overtimeTotalApproved;
        return this;
    }

    public void setOvertimeTotalApproved(String overtimeTotalApproved) {
        this.overtimeTotalApproved = overtimeTotalApproved;
    }

    public String getOvertimeTotalNotApproved() {
        return overtimeTotalNotApproved;
    }

    public DailyAnalysis overtimeTotalNotApproved(String overtimeTotalNotApproved) {
        this.overtimeTotalNotApproved = overtimeTotalNotApproved;
        return this;
    }

    public void setOvertimeTotalNotApproved(String overtimeTotalNotApproved) {
        this.overtimeTotalNotApproved = overtimeTotalNotApproved;
    }

    public String getOvertimeBefore() {
        return overtimeBefore;
    }

    public DailyAnalysis overtimeBefore(String overtimeBefore) {
        this.overtimeBefore = overtimeBefore;
        return this;
    }

    public void setOvertimeBefore(String overtimeBefore) {
        this.overtimeBefore = overtimeBefore;
    }

    public String getOvertimeBeforeApproved() {
        return overtimeBeforeApproved;
    }

    public DailyAnalysis overtimeBeforeApproved(String overtimeBeforeApproved) {
        this.overtimeBeforeApproved = overtimeBeforeApproved;
        return this;
    }

    public void setOvertimeBeforeApproved(String overtimeBeforeApproved) {
        this.overtimeBeforeApproved = overtimeBeforeApproved;
    }

    public String getOvertimeBeforeNotApproved() {
        return overtimeBeforeNotApproved;
    }

    public DailyAnalysis overtimeBeforeNotApproved(String overtimeBeforeNotApproved) {
        this.overtimeBeforeNotApproved = overtimeBeforeNotApproved;
        return this;
    }

    public void setOvertimeBeforeNotApproved(String overtimeBeforeNotApproved) {
        this.overtimeBeforeNotApproved = overtimeBeforeNotApproved;
    }

    public String getOvertimeAfter() {
        return overtimeAfter;
    }

    public DailyAnalysis overtimeAfter(String overtimeAfter) {
        this.overtimeAfter = overtimeAfter;
        return this;
    }

    public void setOvertimeAfter(String overtimeAfter) {
        this.overtimeAfter = overtimeAfter;
    }

    public String getOvertimeAfterApproved() {
        return overtimeAfterApproved;
    }

    public DailyAnalysis overtimeAfterApproved(String overtimeAfterApproved) {
        this.overtimeAfterApproved = overtimeAfterApproved;
        return this;
    }

    public void setOvertimeAfterApproved(String overtimeAfterApproved) {
        this.overtimeAfterApproved = overtimeAfterApproved;
    }

    public String getOvertimeAfterNotApproved() {
        return overtimeAfterNotApproved;
    }

    public DailyAnalysis overtimeAfterNotApproved(String overtimeAfterNotApproved) {
        this.overtimeAfterNotApproved = overtimeAfterNotApproved;
        return this;
    }

    public void setOvertimeAfterNotApproved(String overtimeAfterNotApproved) {
        this.overtimeAfterNotApproved = overtimeAfterNotApproved;
    }

    public String getOvertimeAdd() {
        return overtimeAdd;
    }

    public DailyAnalysis overtimeAdd(String overtimeAdd) {
        this.overtimeAdd = overtimeAdd;
        return this;
    }

    public void setOvertimeAdd(String overtimeAdd) {
        this.overtimeAdd = overtimeAdd;
    }

    public Integer getMeeCount() {
        return meeCount;
    }

    public DailyAnalysis meeCount(Integer meeCount) {
        this.meeCount = meeCount;
        return this;
    }

    public void setMeeCount(Integer meeCount) {
        this.meeCount = meeCount;
    }

    public String getMeeInfo() {
        return meeInfo;
    }

    public DailyAnalysis meeInfo(String meeInfo) {
        this.meeInfo = meeInfo;
        return this;
    }

    public void setMeeInfo(String meeInfo) {
        this.meeInfo = meeInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public DailyAnalysis employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public DailyAnalysis schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public OvertimeReason getOvertimeReason() {
        return overtimeReason;
    }

    public DailyAnalysis overtimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
        return this;
    }

    public void setOvertimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
    }

    public Schedule getDefaultSchedule() {
        return defaultSchedule;
    }

    public DailyAnalysis defaultSchedule(Schedule schedule) {
        this.defaultSchedule = schedule;
        return this;
    }

    public void setDefaultSchedule(Schedule schedule) {
        this.defaultSchedule = schedule;
    }

    public Category getStartReason() {
        return startReason;
    }

    public DailyAnalysis startReason(Category category) {
        this.startReason = category;
        return this;
    }

    public void setStartReason(Category category) {
        this.startReason = category;
    }

    public Category getFinishReason() {
        return finishReason;
    }

    public DailyAnalysis finishReason(Category category) {
        this.finishReason = category;
        return this;
    }

    public void setFinishReason(Category category) {
        this.finishReason = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DailyAnalysis)) {
            return false;
        }
        return id != null && id.equals(((DailyAnalysis) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyAnalysis{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", dayType=" + getDayType() +
            ", scheduleDesc='" + getScheduleDesc() + "'" +
            ", defaultScheduleDesc='" + getDefaultScheduleDesc() + "'" +
            ", naLength='" + getNaLength() + "'" +
            ", naStart='" + getNaStart() + "'" +
            ", naFinish='" + getNaFinish() + "'" +
            ", eeCount=" + getEeCount() +
            ", eeInfo='" + getEeInfo() + "'" +
            ", status=" + getStatus() +
            ", startTime='" + getStartTime() + "'" +
            ", finishTime='" + getFinishTime() + "'" +
            ", startTimeDif='" + getStartTimeDif() + "'" +
            ", finishTimeDif='" + getFinishTimeDif() + "'" +
            ", startLate='" + isStartLate() + "'" +
            ", finishEarly='" + isFinishEarly() + "'" +
            ", totalHour='" + getTotalHour() + "'" +
            ", normalHour='" + getNormalHour() + "'" +
            ", overtimeHour='" + getOvertimeHour() + "'" +
            ", reasonHour='" + getReasonHour() + "'" +
            ", absentHour='" + getAbsentHour() + "'" +
            ", cweekly='" + getCweekly() + "'" +
            ", weeklyHour='" + getWeeklyHour() + "'" +
            ", overtimeTotal='" + getOvertimeTotal() + "'" +
            ", overtimeTotalApproved='" + getOvertimeTotalApproved() + "'" +
            ", overtimeTotalNotApproved='" + getOvertimeTotalNotApproved() + "'" +
            ", overtimeBefore='" + getOvertimeBefore() + "'" +
            ", overtimeBeforeApproved='" + getOvertimeBeforeApproved() + "'" +
            ", overtimeBeforeNotApproved='" + getOvertimeBeforeNotApproved() + "'" +
            ", overtimeAfter='" + getOvertimeAfter() + "'" +
            ", overtimeAfterApproved='" + getOvertimeAfterApproved() + "'" +
            ", overtimeAfterNotApproved='" + getOvertimeAfterNotApproved() + "'" +
            ", overtimeAdd='" + getOvertimeAdd() + "'" +
            ", meeCount=" + getMeeCount() +
            ", meeInfo='" + getMeeInfo() + "'" +
            "}";
    }
}
