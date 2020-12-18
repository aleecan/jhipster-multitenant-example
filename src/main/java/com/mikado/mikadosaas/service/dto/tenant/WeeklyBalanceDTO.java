package com.mikado.mikadosaas.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.WeeklyBalance} entity.
 */
public class WeeklyBalanceDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer dateYear;

    @NotNull
    private Integer dateWeek;

    private LocalDate weekDate;

    private Integer weekCount;

    private LocalDate weekFirstDate;

    private LocalDate weekLastDate;

    private Double weekHourMin;

    private Double weekHour;

    private Double weekHourMax;

    private Double weekNormalHourMax;

    private Double weekOvertimeHourMax;

    private Double totalHour;

    private Double totalNaHour;

    private Double totalWorkHour;

    private Double naHour;

    private Double noHour;

    private Double otHour;

    private Double overHour;

    private Double otUsedHour;

    private Double leaveHour;

    private Double balanceLeftHour;

    private Double balanceOverHour;

    private Double workDay;

    private Double leaveDay;

    private Integer workWeek;

    private Integer leaveWeek;


    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateWeek() {
        return dateWeek;
    }

    public void setDateWeek(Integer dateWeek) {
        this.dateWeek = dateWeek;
    }

    public LocalDate getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(LocalDate weekDate) {
        this.weekDate = weekDate;
    }

    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public LocalDate getWeekFirstDate() {
        return weekFirstDate;
    }

    public void setWeekFirstDate(LocalDate weekFirstDate) {
        this.weekFirstDate = weekFirstDate;
    }

    public LocalDate getWeekLastDate() {
        return weekLastDate;
    }

    public void setWeekLastDate(LocalDate weekLastDate) {
        this.weekLastDate = weekLastDate;
    }

    public Double getWeekHourMin() {
        return weekHourMin;
    }

    public void setWeekHourMin(Double weekHourMin) {
        this.weekHourMin = weekHourMin;
    }

    public Double getWeekHour() {
        return weekHour;
    }

    public void setWeekHour(Double weekHour) {
        this.weekHour = weekHour;
    }

    public Double getWeekHourMax() {
        return weekHourMax;
    }

    public void setWeekHourMax(Double weekHourMax) {
        this.weekHourMax = weekHourMax;
    }

    public Double getWeekNormalHourMax() {
        return weekNormalHourMax;
    }

    public void setWeekNormalHourMax(Double weekNormalHourMax) {
        this.weekNormalHourMax = weekNormalHourMax;
    }

    public Double getWeekOvertimeHourMax() {
        return weekOvertimeHourMax;
    }

    public void setWeekOvertimeHourMax(Double weekOvertimeHourMax) {
        this.weekOvertimeHourMax = weekOvertimeHourMax;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Double getTotalNaHour() {
        return totalNaHour;
    }

    public void setTotalNaHour(Double totalNaHour) {
        this.totalNaHour = totalNaHour;
    }

    public Double getTotalWorkHour() {
        return totalWorkHour;
    }

    public void setTotalWorkHour(Double totalWorkHour) {
        this.totalWorkHour = totalWorkHour;
    }

    public Double getNaHour() {
        return naHour;
    }

    public void setNaHour(Double naHour) {
        this.naHour = naHour;
    }

    public Double getNoHour() {
        return noHour;
    }

    public void setNoHour(Double noHour) {
        this.noHour = noHour;
    }

    public Double getOtHour() {
        return otHour;
    }

    public void setOtHour(Double otHour) {
        this.otHour = otHour;
    }

    public Double getOverHour() {
        return overHour;
    }

    public void setOverHour(Double overHour) {
        this.overHour = overHour;
    }

    public Double getOtUsedHour() {
        return otUsedHour;
    }

    public void setOtUsedHour(Double otUsedHour) {
        this.otUsedHour = otUsedHour;
    }

    public Double getLeaveHour() {
        return leaveHour;
    }

    public void setLeaveHour(Double leaveHour) {
        this.leaveHour = leaveHour;
    }

    public Double getBalanceLeftHour() {
        return balanceLeftHour;
    }

    public void setBalanceLeftHour(Double balanceLeftHour) {
        this.balanceLeftHour = balanceLeftHour;
    }

    public Double getBalanceOverHour() {
        return balanceOverHour;
    }

    public void setBalanceOverHour(Double balanceOverHour) {
        this.balanceOverHour = balanceOverHour;
    }

    public Double getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Double workDay) {
        this.workDay = workDay;
    }

    public Double getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(Double leaveDay) {
        this.leaveDay = leaveDay;
    }

    public Integer getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(Integer workWeek) {
        this.workWeek = workWeek;
    }

    public Integer getLeaveWeek() {
        return leaveWeek;
    }

    public void setLeaveWeek(Integer leaveWeek) {
        this.leaveWeek = leaveWeek;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyBalanceDTO)) {
            return false;
        }

        return id != null && id.equals(((WeeklyBalanceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyBalanceDTO{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", dateWeek=" + getDateWeek() +
            ", weekDate='" + getWeekDate() + "'" +
            ", weekCount=" + getWeekCount() +
            ", weekFirstDate='" + getWeekFirstDate() + "'" +
            ", weekLastDate='" + getWeekLastDate() + "'" +
            ", weekHourMin=" + getWeekHourMin() +
            ", weekHour=" + getWeekHour() +
            ", weekHourMax=" + getWeekHourMax() +
            ", weekNormalHourMax=" + getWeekNormalHourMax() +
            ", weekOvertimeHourMax=" + getWeekOvertimeHourMax() +
            ", totalHour=" + getTotalHour() +
            ", totalNaHour=" + getTotalNaHour() +
            ", totalWorkHour=" + getTotalWorkHour() +
            ", naHour=" + getNaHour() +
            ", noHour=" + getNoHour() +
            ", otHour=" + getOtHour() +
            ", overHour=" + getOverHour() +
            ", otUsedHour=" + getOtUsedHour() +
            ", leaveHour=" + getLeaveHour() +
            ", balanceLeftHour=" + getBalanceLeftHour() +
            ", balanceOverHour=" + getBalanceOverHour() +
            ", workDay=" + getWorkDay() +
            ", leaveDay=" + getLeaveDay() +
            ", workWeek=" + getWorkWeek() +
            ", leaveWeek=" + getLeaveWeek() +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
