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
import java.time.LocalDate;

/**
 * A EntryExit.
 */
@Entity
@Table(name = "entry_exit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EntryExit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @Column(name = "day_type")
    private Integer dayType;

    @Column(name = "day_approved")
    private Boolean dayApproved;

    @Size(max = 80)
    @Column(name = "overtime_explanation", length = 80)
    private String overtimeExplanation;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_approved_pay_time", length = 8)
    private String overtimeApprovedPayTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "reason_approved_pay_time", length = 8)
    private String reasonApprovedPayTime;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExits", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExits", allowSetters = true)
    private Schedule schedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExits", allowSetters = true)
    private Schedule defaultSchedule;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExits", allowSetters = true)
    private OvertimeReason overtimeReason;

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

    public EntryExit daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Integer getDayType() {
        return dayType;
    }

    public EntryExit dayType(Integer dayType) {
        this.dayType = dayType;
        return this;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public Boolean isDayApproved() {
        return dayApproved;
    }

    public EntryExit dayApproved(Boolean dayApproved) {
        this.dayApproved = dayApproved;
        return this;
    }

    public void setDayApproved(Boolean dayApproved) {
        this.dayApproved = dayApproved;
    }

    public String getOvertimeExplanation() {
        return overtimeExplanation;
    }

    public EntryExit overtimeExplanation(String overtimeExplanation) {
        this.overtimeExplanation = overtimeExplanation;
        return this;
    }

    public void setOvertimeExplanation(String overtimeExplanation) {
        this.overtimeExplanation = overtimeExplanation;
    }

    public String getOvertimeApprovedPayTime() {
        return overtimeApprovedPayTime;
    }

    public EntryExit overtimeApprovedPayTime(String overtimeApprovedPayTime) {
        this.overtimeApprovedPayTime = overtimeApprovedPayTime;
        return this;
    }

    public void setOvertimeApprovedPayTime(String overtimeApprovedPayTime) {
        this.overtimeApprovedPayTime = overtimeApprovedPayTime;
    }

    public String getReasonApprovedPayTime() {
        return reasonApprovedPayTime;
    }

    public EntryExit reasonApprovedPayTime(String reasonApprovedPayTime) {
        this.reasonApprovedPayTime = reasonApprovedPayTime;
        return this;
    }

    public void setReasonApprovedPayTime(String reasonApprovedPayTime) {
        this.reasonApprovedPayTime = reasonApprovedPayTime;
    }

    public Instant getCreated() {
        return created;
    }

    public EntryExit created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public EntryExit modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public EntryExit modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EntryExit employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public EntryExit schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getDefaultSchedule() {
        return defaultSchedule;
    }

    public EntryExit defaultSchedule(Schedule schedule) {
        this.defaultSchedule = schedule;
        return this;
    }

    public void setDefaultSchedule(Schedule schedule) {
        this.defaultSchedule = schedule;
    }

    public OvertimeReason getOvertimeReason() {
        return overtimeReason;
    }

    public EntryExit overtimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
        return this;
    }

    public void setOvertimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExit)) {
            return false;
        }
        return id != null && id.equals(((EntryExit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExit{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", dayType=" + getDayType() +
            ", dayApproved='" + isDayApproved() + "'" +
            ", overtimeExplanation='" + getOvertimeExplanation() + "'" +
            ", overtimeApprovedPayTime='" + getOvertimeApprovedPayTime() + "'" +
            ", reasonApprovedPayTime='" + getReasonApprovedPayTime() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
