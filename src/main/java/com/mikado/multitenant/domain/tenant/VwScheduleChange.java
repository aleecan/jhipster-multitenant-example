package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * VIEW
 */
@Entity
@Table(name = "vw_schedule_change")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VwScheduleChange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @NotNull
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public VwScheduleChange employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public VwScheduleChange daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public VwScheduleChange scheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
        return this;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VwScheduleChange)) {
            return false;
        }
        return id != null && id.equals(((VwScheduleChange) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VwScheduleChange{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", daydate='" + getDaydate() + "'" +
            ", scheduleId=" + getScheduleId() +
            "}";
    }
}
