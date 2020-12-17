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
 * A ScheduleChange.
 */
@Entity
@Table(name = "schedule_change")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ScheduleChange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @Column(name = "approval")
    private Boolean approval;

    @Column(name = "approval_2")
    private Boolean approval2;

    @Column(name = "approval_3")
    private Boolean approval3;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "scheduleChanges", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "scheduleChanges", allowSetters = true)
    private Schedule schedule;

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

    public ScheduleChange daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Boolean isApproval() {
        return approval;
    }

    public ScheduleChange approval(Boolean approval) {
        this.approval = approval;
        return this;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public Boolean isApproval2() {
        return approval2;
    }

    public ScheduleChange approval2(Boolean approval2) {
        this.approval2 = approval2;
        return this;
    }

    public void setApproval2(Boolean approval2) {
        this.approval2 = approval2;
    }

    public Boolean isApproval3() {
        return approval3;
    }

    public ScheduleChange approval3(Boolean approval3) {
        this.approval3 = approval3;
        return this;
    }

    public void setApproval3(Boolean approval3) {
        this.approval3 = approval3;
    }

    public Instant getCreated() {
        return created;
    }

    public ScheduleChange created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ScheduleChange modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ScheduleChange modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ScheduleChange employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public ScheduleChange schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ScheduleChange)) {
            return false;
        }
        return id != null && id.equals(((ScheduleChange) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ScheduleChange{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", approval='" + isApproval() + "'" +
            ", approval2='" + isApproval2() + "'" +
            ", approval3='" + isApproval3() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
