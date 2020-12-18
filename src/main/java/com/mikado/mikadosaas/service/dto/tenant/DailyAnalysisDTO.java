package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.DailyAnalysis} entity.
 */
public class DailyAnalysisDTO implements Serializable {

    private Long id;

    private LocalDate daydate;

    private Integer dayType;

    @Size(max = 80)
    private String scheduleDesc;

    @Size(max = 80)
    private String defaultScheduleDesc;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String naLength;

    private Instant naStart;

    private Instant naFinish;

    private Integer eeCount;

    @Size(max = 1024)
    private String eeInfo;

    private Integer status;

    private Instant startTime;

    private Instant finishTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String startTimeDif;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String finishTimeDif;

    private Boolean startLate;

    private Boolean finishEarly;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String totalHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String normalHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String reasonHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String absentHour;

    @Size(max = 10)
    private String cweekly;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String weeklyHour;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeTotal;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeTotalApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeTotalNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeBefore;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeBeforeApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeBeforeNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeAfter;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeAfterApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeAfterNotApproved;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeAdd;

    private Integer meeCount;

    @Size(max = 1024)
    private String meeInfo;


    private Long employeeId;

    private Long scheduleId;

    private Long overtimeReasonId;

    private Long defaultScheduleId;

    private Long startReasonId;

    private Long finishReasonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public String getScheduleDesc() {
        return scheduleDesc;
    }

    public void setScheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc;
    }

    public String getDefaultScheduleDesc() {
        return defaultScheduleDesc;
    }

    public void setDefaultScheduleDesc(String defaultScheduleDesc) {
        this.defaultScheduleDesc = defaultScheduleDesc;
    }

    public String getNaLength() {
        return naLength;
    }

    public void setNaLength(String naLength) {
        this.naLength = naLength;
    }

    public Instant getNaStart() {
        return naStart;
    }

    public void setNaStart(Instant naStart) {
        this.naStart = naStart;
    }

    public Instant getNaFinish() {
        return naFinish;
    }

    public void setNaFinish(Instant naFinish) {
        this.naFinish = naFinish;
    }

    public Integer getEeCount() {
        return eeCount;
    }

    public void setEeCount(Integer eeCount) {
        this.eeCount = eeCount;
    }

    public String getEeInfo() {
        return eeInfo;
    }

    public void setEeInfo(String eeInfo) {
        this.eeInfo = eeInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Instant finishTime) {
        this.finishTime = finishTime;
    }

    public String getStartTimeDif() {
        return startTimeDif;
    }

    public void setStartTimeDif(String startTimeDif) {
        this.startTimeDif = startTimeDif;
    }

    public String getFinishTimeDif() {
        return finishTimeDif;
    }

    public void setFinishTimeDif(String finishTimeDif) {
        this.finishTimeDif = finishTimeDif;
    }

    public Boolean isStartLate() {
        return startLate;
    }

    public void setStartLate(Boolean startLate) {
        this.startLate = startLate;
    }

    public Boolean isFinishEarly() {
        return finishEarly;
    }

    public void setFinishEarly(Boolean finishEarly) {
        this.finishEarly = finishEarly;
    }

    public String getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(String totalHour) {
        this.totalHour = totalHour;
    }

    public String getNormalHour() {
        return normalHour;
    }

    public void setNormalHour(String normalHour) {
        this.normalHour = normalHour;
    }

    public String getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public String getReasonHour() {
        return reasonHour;
    }

    public void setReasonHour(String reasonHour) {
        this.reasonHour = reasonHour;
    }

    public String getAbsentHour() {
        return absentHour;
    }

    public void setAbsentHour(String absentHour) {
        this.absentHour = absentHour;
    }

    public String getCweekly() {
        return cweekly;
    }

    public void setCweekly(String cweekly) {
        this.cweekly = cweekly;
    }

    public String getWeeklyHour() {
        return weeklyHour;
    }

    public void setWeeklyHour(String weeklyHour) {
        this.weeklyHour = weeklyHour;
    }

    public String getOvertimeTotal() {
        return overtimeTotal;
    }

    public void setOvertimeTotal(String overtimeTotal) {
        this.overtimeTotal = overtimeTotal;
    }

    public String getOvertimeTotalApproved() {
        return overtimeTotalApproved;
    }

    public void setOvertimeTotalApproved(String overtimeTotalApproved) {
        this.overtimeTotalApproved = overtimeTotalApproved;
    }

    public String getOvertimeTotalNotApproved() {
        return overtimeTotalNotApproved;
    }

    public void setOvertimeTotalNotApproved(String overtimeTotalNotApproved) {
        this.overtimeTotalNotApproved = overtimeTotalNotApproved;
    }

    public String getOvertimeBefore() {
        return overtimeBefore;
    }

    public void setOvertimeBefore(String overtimeBefore) {
        this.overtimeBefore = overtimeBefore;
    }

    public String getOvertimeBeforeApproved() {
        return overtimeBeforeApproved;
    }

    public void setOvertimeBeforeApproved(String overtimeBeforeApproved) {
        this.overtimeBeforeApproved = overtimeBeforeApproved;
    }

    public String getOvertimeBeforeNotApproved() {
        return overtimeBeforeNotApproved;
    }

    public void setOvertimeBeforeNotApproved(String overtimeBeforeNotApproved) {
        this.overtimeBeforeNotApproved = overtimeBeforeNotApproved;
    }

    public String getOvertimeAfter() {
        return overtimeAfter;
    }

    public void setOvertimeAfter(String overtimeAfter) {
        this.overtimeAfter = overtimeAfter;
    }

    public String getOvertimeAfterApproved() {
        return overtimeAfterApproved;
    }

    public void setOvertimeAfterApproved(String overtimeAfterApproved) {
        this.overtimeAfterApproved = overtimeAfterApproved;
    }

    public String getOvertimeAfterNotApproved() {
        return overtimeAfterNotApproved;
    }

    public void setOvertimeAfterNotApproved(String overtimeAfterNotApproved) {
        this.overtimeAfterNotApproved = overtimeAfterNotApproved;
    }

    public String getOvertimeAdd() {
        return overtimeAdd;
    }

    public void setOvertimeAdd(String overtimeAdd) {
        this.overtimeAdd = overtimeAdd;
    }

    public Integer getMeeCount() {
        return meeCount;
    }

    public void setMeeCount(Integer meeCount) {
        this.meeCount = meeCount;
    }

    public String getMeeInfo() {
        return meeInfo;
    }

    public void setMeeInfo(String meeInfo) {
        this.meeInfo = meeInfo;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    public Long getDefaultScheduleId() {
        return defaultScheduleId;
    }

    public void setDefaultScheduleId(Long scheduleId) {
        this.defaultScheduleId = scheduleId;
    }

    public Long getStartReasonId() {
        return startReasonId;
    }

    public void setStartReasonId(Long categoryId) {
        this.startReasonId = categoryId;
    }

    public Long getFinishReasonId() {
        return finishReasonId;
    }

    public void setFinishReasonId(Long categoryId) {
        this.finishReasonId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DailyAnalysisDTO)) {
            return false;
        }

        return id != null && id.equals(((DailyAnalysisDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyAnalysisDTO{" +
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
            ", employeeId=" + getEmployeeId() +
            ", scheduleId=" + getScheduleId() +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            ", defaultScheduleId=" + getDefaultScheduleId() +
            ", startReasonId=" + getStartReasonId() +
            ", finishReasonId=" + getFinishReasonId() +
            "}";
    }
}
