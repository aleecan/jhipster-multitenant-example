package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Daily.
 */
@Entity
@Table(name = "daily")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Daily implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "daydate")
    private LocalDate daydate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_hour")
    private Double totalHour;

    @Column(name = "normal_hour")
    private Double normalHour;

    @Column(name = "overtime_hour")
    private Double overtimeHour;

    @Column(name = "reason_hour")
    private Double reasonHour;

    @Column(name = "absent_hour")
    private Double absentHour;

    @Column(name = "week_overtime_hour")
    private Double weekOvertimeHour;

    @Column(name = "is_day_off")
    private Boolean isDayOff;

    @Column(name = "week_day")
    private Double weekDay;

    @Column(name = "week_hour")
    private Double weekHour;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailies", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailies", allowSetters = true)
    private Schedule schedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailies", allowSetters = true)
    private OvertimeReason overtimeReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailies", allowSetters = true)
    private Category absentCategory;

    @ManyToOne
    @JsonIgnoreProperties(value = "dailies", allowSetters = true)
    private Category weekOvertimeCategory;

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

    public Daily daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Integer getStatus() {
        return status;
    }

    public Daily status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public Daily totalHour(Double totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Double getNormalHour() {
        return normalHour;
    }

    public Daily normalHour(Double normalHour) {
        this.normalHour = normalHour;
        return this;
    }

    public void setNormalHour(Double normalHour) {
        this.normalHour = normalHour;
    }

    public Double getOvertimeHour() {
        return overtimeHour;
    }

    public Daily overtimeHour(Double overtimeHour) {
        this.overtimeHour = overtimeHour;
        return this;
    }

    public void setOvertimeHour(Double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public Double getReasonHour() {
        return reasonHour;
    }

    public Daily reasonHour(Double reasonHour) {
        this.reasonHour = reasonHour;
        return this;
    }

    public void setReasonHour(Double reasonHour) {
        this.reasonHour = reasonHour;
    }

    public Double getAbsentHour() {
        return absentHour;
    }

    public Daily absentHour(Double absentHour) {
        this.absentHour = absentHour;
        return this;
    }

    public void setAbsentHour(Double absentHour) {
        this.absentHour = absentHour;
    }

    public Double getWeekOvertimeHour() {
        return weekOvertimeHour;
    }

    public Daily weekOvertimeHour(Double weekOvertimeHour) {
        this.weekOvertimeHour = weekOvertimeHour;
        return this;
    }

    public void setWeekOvertimeHour(Double weekOvertimeHour) {
        this.weekOvertimeHour = weekOvertimeHour;
    }

    public Boolean isIsDayOff() {
        return isDayOff;
    }

    public Daily isDayOff(Boolean isDayOff) {
        this.isDayOff = isDayOff;
        return this;
    }

    public void setIsDayOff(Boolean isDayOff) {
        this.isDayOff = isDayOff;
    }

    public Double getWeekDay() {
        return weekDay;
    }

    public Daily weekDay(Double weekDay) {
        this.weekDay = weekDay;
        return this;
    }

    public void setWeekDay(Double weekDay) {
        this.weekDay = weekDay;
    }

    public Double getWeekHour() {
        return weekHour;
    }

    public Daily weekHour(Double weekHour) {
        this.weekHour = weekHour;
        return this;
    }

    public void setWeekHour(Double weekHour) {
        this.weekHour = weekHour;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Daily employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Daily schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public OvertimeReason getOvertimeReason() {
        return overtimeReason;
    }

    public Daily overtimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
        return this;
    }

    public void setOvertimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
    }

    public Category getAbsentCategory() {
        return absentCategory;
    }

    public Daily absentCategory(Category category) {
        this.absentCategory = category;
        return this;
    }

    public void setAbsentCategory(Category category) {
        this.absentCategory = category;
    }

    public Category getWeekOvertimeCategory() {
        return weekOvertimeCategory;
    }

    public Daily weekOvertimeCategory(Category category) {
        this.weekOvertimeCategory = category;
        return this;
    }

    public void setWeekOvertimeCategory(Category category) {
        this.weekOvertimeCategory = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Daily)) {
            return false;
        }
        return id != null && id.equals(((Daily) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Daily{" +
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
            "}";
    }
}
