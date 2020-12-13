package com.mikado.multitenant.service.dto.tenant;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Daily} entity.
 */
public class DailyDTO implements Serializable {

    private Long id;

    private LocalDate daydate;

    private Integer status;

    private Double totalHour;

    private Double normalHour;

    private Double overtimeHour;

    private Double reasonHour;

    private Double absentHour;

    private Double weekOvertimeHour;

    private Boolean isDayOff;

    private Double weekDay;

    private Double weekHour;


    private Long employeeId;

    private Long scheduleId;

    private Long overtimeReasonId;

    private Long absentCategoryId;

    private Long weekOvertimeCategoryId;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Double getNormalHour() {
        return normalHour;
    }

    public void setNormalHour(Double normalHour) {
        this.normalHour = normalHour;
    }

    public Double getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(Double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public Double getReasonHour() {
        return reasonHour;
    }

    public void setReasonHour(Double reasonHour) {
        this.reasonHour = reasonHour;
    }

    public Double getAbsentHour() {
        return absentHour;
    }

    public void setAbsentHour(Double absentHour) {
        this.absentHour = absentHour;
    }

    public Double getWeekOvertimeHour() {
        return weekOvertimeHour;
    }

    public void setWeekOvertimeHour(Double weekOvertimeHour) {
        this.weekOvertimeHour = weekOvertimeHour;
    }

    public Boolean isIsDayOff() {
        return isDayOff;
    }

    public void setIsDayOff(Boolean isDayOff) {
        this.isDayOff = isDayOff;
    }

    public Double getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Double weekDay) {
        this.weekDay = weekDay;
    }

    public Double getWeekHour() {
        return weekHour;
    }

    public void setWeekHour(Double weekHour) {
        this.weekHour = weekHour;
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

    public Long getAbsentCategoryId() {
        return absentCategoryId;
    }

    public void setAbsentCategoryId(Long categoryId) {
        this.absentCategoryId = categoryId;
    }

    public Long getWeekOvertimeCategoryId() {
        return weekOvertimeCategoryId;
    }

    public void setWeekOvertimeCategoryId(Long categoryId) {
        this.weekOvertimeCategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DailyDTO)) {
            return false;
        }

        return id != null && id.equals(((DailyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", status=" + getStatus() +
            ", totalHour=" + getTotalHour() +
            ", normalHour=" + getNormalHour() +
            ", overtimeHour=" + getOvertimeHour() +
            ", reasonHour=" + getReasonHour() +
            ", absentHour=" + getAbsentHour() +
            ", weekOvertimeHour=" + getWeekOvertimeHour() +
            ", isDayOff='" + isIsDayOff() + "'" +
            ", weekDay=" + getWeekDay() +
            ", weekHour=" + getWeekHour() +
            ", employeeId=" + getEmployeeId() +
            ", scheduleId=" + getScheduleId() +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            ", absentCategoryId=" + getAbsentCategoryId() +
            ", weekOvertimeCategoryId=" + getWeekOvertimeCategoryId() +
            "}";
    }
}
