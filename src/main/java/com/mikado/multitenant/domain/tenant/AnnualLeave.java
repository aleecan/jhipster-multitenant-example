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
 * A AnnualLeave.
 */
@Entity
@Table(name = "annual_leave")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnnualLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "leave_date", nullable = false)
    private LocalDate leaveDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "paid")
    private Double paid;

    @Column(name = "day_off")
    private Double dayOff;

    @Column(name = "holiday")
    private Double holiday;

    @Column(name = "travel")
    private Double travel;

    @Column(name = "military")
    private Double military;

    @Column(name = "is_used")
    private Boolean isUsed;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "annualLeaves", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "annualLeaves", allowSetters = true)
    private Schedule schedule;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public AnnualLeave leaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
        return this;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public AnnualLeave returnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getPaid() {
        return paid;
    }

    public AnnualLeave paid(Double paid) {
        this.paid = paid;
        return this;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getDayOff() {
        return dayOff;
    }

    public AnnualLeave dayOff(Double dayOff) {
        this.dayOff = dayOff;
        return this;
    }

    public void setDayOff(Double dayOff) {
        this.dayOff = dayOff;
    }

    public Double getHoliday() {
        return holiday;
    }

    public AnnualLeave holiday(Double holiday) {
        this.holiday = holiday;
        return this;
    }

    public void setHoliday(Double holiday) {
        this.holiday = holiday;
    }

    public Double getTravel() {
        return travel;
    }

    public AnnualLeave travel(Double travel) {
        this.travel = travel;
        return this;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public Double getMilitary() {
        return military;
    }

    public AnnualLeave military(Double military) {
        this.military = military;
        return this;
    }

    public void setMilitary(Double military) {
        this.military = military;
    }

    public Boolean isIsUsed() {
        return isUsed;
    }

    public AnnualLeave isUsed(Boolean isUsed) {
        this.isUsed = isUsed;
        return this;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Instant getCreated() {
        return created;
    }

    public AnnualLeave created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public AnnualLeave modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public AnnualLeave modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AnnualLeave employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public AnnualLeave schedule(Schedule schedule) {
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
        if (!(o instanceof AnnualLeave)) {
            return false;
        }
        return id != null && id.equals(((AnnualLeave) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeave{" +
            "id=" + getId() +
            ", leaveDate='" + getLeaveDate() + "'" +
            ", returnDate='" + getReturnDate() + "'" +
            ", paid=" + getPaid() +
            ", dayOff=" + getDayOff() +
            ", holiday=" + getHoliday() +
            ", travel=" + getTravel() +
            ", military=" + getMilitary() +
            ", isUsed='" + isIsUsed() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
