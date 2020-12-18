package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A WeeklyBalance.
 */
@Entity
@Table(name = "weekly_balance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WeeklyBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_year", nullable = false)
    private Integer dateYear;

    @NotNull
    @Column(name = "date_week", nullable = false)
    private Integer dateWeek;

    @Column(name = "week_date")
    private LocalDate weekDate;

    @Column(name = "week_count")
    private Integer weekCount;

    @Column(name = "week_first_date")
    private LocalDate weekFirstDate;

    @Column(name = "week_last_date")
    private LocalDate weekLastDate;

    @Column(name = "week_hour_min")
    private Double weekHourMin;

    @Column(name = "week_hour")
    private Double weekHour;

    @Column(name = "week_hour_max")
    private Double weekHourMax;

    @Column(name = "week_normal_hour_max")
    private Double weekNormalHourMax;

    @Column(name = "week_overtime_hour_max")
    private Double weekOvertimeHourMax;

    @Column(name = "total_hour")
    private Double totalHour;

    @Column(name = "total_na_hour")
    private Double totalNaHour;

    @Column(name = "total_work_hour")
    private Double totalWorkHour;

    @Column(name = "na_hour")
    private Double naHour;

    @Column(name = "no_hour")
    private Double noHour;

    @Column(name = "ot_hour")
    private Double otHour;

    @Column(name = "over_hour")
    private Double overHour;

    @Column(name = "ot_used_hour")
    private Double otUsedHour;

    @Column(name = "leave_hour")
    private Double leaveHour;

    @Column(name = "balance_left_hour")
    private Double balanceLeftHour;

    @Column(name = "balance_over_hour")
    private Double balanceOverHour;

    @Column(name = "work_day")
    private Double workDay;

    @Column(name = "leave_day")
    private Double leaveDay;

    @Column(name = "work_week")
    private Integer workWeek;

    @Column(name = "leave_week")
    private Integer leaveWeek;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyBalances", allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public WeeklyBalance dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateWeek() {
        return dateWeek;
    }

    public WeeklyBalance dateWeek(Integer dateWeek) {
        this.dateWeek = dateWeek;
        return this;
    }

    public void setDateWeek(Integer dateWeek) {
        this.dateWeek = dateWeek;
    }

    public LocalDate getWeekDate() {
        return weekDate;
    }

    public WeeklyBalance weekDate(LocalDate weekDate) {
        this.weekDate = weekDate;
        return this;
    }

    public void setWeekDate(LocalDate weekDate) {
        this.weekDate = weekDate;
    }

    public Integer getWeekCount() {
        return weekCount;
    }

    public WeeklyBalance weekCount(Integer weekCount) {
        this.weekCount = weekCount;
        return this;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public LocalDate getWeekFirstDate() {
        return weekFirstDate;
    }

    public WeeklyBalance weekFirstDate(LocalDate weekFirstDate) {
        this.weekFirstDate = weekFirstDate;
        return this;
    }

    public void setWeekFirstDate(LocalDate weekFirstDate) {
        this.weekFirstDate = weekFirstDate;
    }

    public LocalDate getWeekLastDate() {
        return weekLastDate;
    }

    public WeeklyBalance weekLastDate(LocalDate weekLastDate) {
        this.weekLastDate = weekLastDate;
        return this;
    }

    public void setWeekLastDate(LocalDate weekLastDate) {
        this.weekLastDate = weekLastDate;
    }

    public Double getWeekHourMin() {
        return weekHourMin;
    }

    public WeeklyBalance weekHourMin(Double weekHourMin) {
        this.weekHourMin = weekHourMin;
        return this;
    }

    public void setWeekHourMin(Double weekHourMin) {
        this.weekHourMin = weekHourMin;
    }

    public Double getWeekHour() {
        return weekHour;
    }

    public WeeklyBalance weekHour(Double weekHour) {
        this.weekHour = weekHour;
        return this;
    }

    public void setWeekHour(Double weekHour) {
        this.weekHour = weekHour;
    }

    public Double getWeekHourMax() {
        return weekHourMax;
    }

    public WeeklyBalance weekHourMax(Double weekHourMax) {
        this.weekHourMax = weekHourMax;
        return this;
    }

    public void setWeekHourMax(Double weekHourMax) {
        this.weekHourMax = weekHourMax;
    }

    public Double getWeekNormalHourMax() {
        return weekNormalHourMax;
    }

    public WeeklyBalance weekNormalHourMax(Double weekNormalHourMax) {
        this.weekNormalHourMax = weekNormalHourMax;
        return this;
    }

    public void setWeekNormalHourMax(Double weekNormalHourMax) {
        this.weekNormalHourMax = weekNormalHourMax;
    }

    public Double getWeekOvertimeHourMax() {
        return weekOvertimeHourMax;
    }

    public WeeklyBalance weekOvertimeHourMax(Double weekOvertimeHourMax) {
        this.weekOvertimeHourMax = weekOvertimeHourMax;
        return this;
    }

    public void setWeekOvertimeHourMax(Double weekOvertimeHourMax) {
        this.weekOvertimeHourMax = weekOvertimeHourMax;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public WeeklyBalance totalHour(Double totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Double getTotalNaHour() {
        return totalNaHour;
    }

    public WeeklyBalance totalNaHour(Double totalNaHour) {
        this.totalNaHour = totalNaHour;
        return this;
    }

    public void setTotalNaHour(Double totalNaHour) {
        this.totalNaHour = totalNaHour;
    }

    public Double getTotalWorkHour() {
        return totalWorkHour;
    }

    public WeeklyBalance totalWorkHour(Double totalWorkHour) {
        this.totalWorkHour = totalWorkHour;
        return this;
    }

    public void setTotalWorkHour(Double totalWorkHour) {
        this.totalWorkHour = totalWorkHour;
    }

    public Double getNaHour() {
        return naHour;
    }

    public WeeklyBalance naHour(Double naHour) {
        this.naHour = naHour;
        return this;
    }

    public void setNaHour(Double naHour) {
        this.naHour = naHour;
    }

    public Double getNoHour() {
        return noHour;
    }

    public WeeklyBalance noHour(Double noHour) {
        this.noHour = noHour;
        return this;
    }

    public void setNoHour(Double noHour) {
        this.noHour = noHour;
    }

    public Double getOtHour() {
        return otHour;
    }

    public WeeklyBalance otHour(Double otHour) {
        this.otHour = otHour;
        return this;
    }

    public void setOtHour(Double otHour) {
        this.otHour = otHour;
    }

    public Double getOverHour() {
        return overHour;
    }

    public WeeklyBalance overHour(Double overHour) {
        this.overHour = overHour;
        return this;
    }

    public void setOverHour(Double overHour) {
        this.overHour = overHour;
    }

    public Double getOtUsedHour() {
        return otUsedHour;
    }

    public WeeklyBalance otUsedHour(Double otUsedHour) {
        this.otUsedHour = otUsedHour;
        return this;
    }

    public void setOtUsedHour(Double otUsedHour) {
        this.otUsedHour = otUsedHour;
    }

    public Double getLeaveHour() {
        return leaveHour;
    }

    public WeeklyBalance leaveHour(Double leaveHour) {
        this.leaveHour = leaveHour;
        return this;
    }

    public void setLeaveHour(Double leaveHour) {
        this.leaveHour = leaveHour;
    }

    public Double getBalanceLeftHour() {
        return balanceLeftHour;
    }

    public WeeklyBalance balanceLeftHour(Double balanceLeftHour) {
        this.balanceLeftHour = balanceLeftHour;
        return this;
    }

    public void setBalanceLeftHour(Double balanceLeftHour) {
        this.balanceLeftHour = balanceLeftHour;
    }

    public Double getBalanceOverHour() {
        return balanceOverHour;
    }

    public WeeklyBalance balanceOverHour(Double balanceOverHour) {
        this.balanceOverHour = balanceOverHour;
        return this;
    }

    public void setBalanceOverHour(Double balanceOverHour) {
        this.balanceOverHour = balanceOverHour;
    }

    public Double getWorkDay() {
        return workDay;
    }

    public WeeklyBalance workDay(Double workDay) {
        this.workDay = workDay;
        return this;
    }

    public void setWorkDay(Double workDay) {
        this.workDay = workDay;
    }

    public Double getLeaveDay() {
        return leaveDay;
    }

    public WeeklyBalance leaveDay(Double leaveDay) {
        this.leaveDay = leaveDay;
        return this;
    }

    public void setLeaveDay(Double leaveDay) {
        this.leaveDay = leaveDay;
    }

    public Integer getWorkWeek() {
        return workWeek;
    }

    public WeeklyBalance workWeek(Integer workWeek) {
        this.workWeek = workWeek;
        return this;
    }

    public void setWorkWeek(Integer workWeek) {
        this.workWeek = workWeek;
    }

    public Integer getLeaveWeek() {
        return leaveWeek;
    }

    public WeeklyBalance leaveWeek(Integer leaveWeek) {
        this.leaveWeek = leaveWeek;
        return this;
    }

    public void setLeaveWeek(Integer leaveWeek) {
        this.leaveWeek = leaveWeek;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WeeklyBalance employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyBalance)) {
            return false;
        }
        return id != null && id.equals(((WeeklyBalance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyBalance{" +
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
            "}";
    }
}
