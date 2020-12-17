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
 * A EntryExitChange.
 */
@Entity
@Table(name = "entry_exit_change")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EntryExitChange implements Serializable {

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

    @Column(name = "new_entry_time")
    private Instant newEntryTime;

    @Column(name = "new_exit_time")
    private Instant newExitTime;

    @Column(name = "original_entry_time")
    private Instant originalEntryTime;

    @Column(name = "original_exit_time")
    private Instant originalExitTime;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExitChanges", allowSetters = true)
    private EntryExit entryExit;

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

    public EntryExitChange employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public EntryExitChange daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Instant getNewEntryTime() {
        return newEntryTime;
    }

    public EntryExitChange newEntryTime(Instant newEntryTime) {
        this.newEntryTime = newEntryTime;
        return this;
    }

    public void setNewEntryTime(Instant newEntryTime) {
        this.newEntryTime = newEntryTime;
    }

    public Instant getNewExitTime() {
        return newExitTime;
    }

    public EntryExitChange newExitTime(Instant newExitTime) {
        this.newExitTime = newExitTime;
        return this;
    }

    public void setNewExitTime(Instant newExitTime) {
        this.newExitTime = newExitTime;
    }

    public Instant getOriginalEntryTime() {
        return originalEntryTime;
    }

    public EntryExitChange originalEntryTime(Instant originalEntryTime) {
        this.originalEntryTime = originalEntryTime;
        return this;
    }

    public void setOriginalEntryTime(Instant originalEntryTime) {
        this.originalEntryTime = originalEntryTime;
    }

    public Instant getOriginalExitTime() {
        return originalExitTime;
    }

    public EntryExitChange originalExitTime(Instant originalExitTime) {
        this.originalExitTime = originalExitTime;
        return this;
    }

    public void setOriginalExitTime(Instant originalExitTime) {
        this.originalExitTime = originalExitTime;
    }

    public Instant getCreated() {
        return created;
    }

    public EntryExitChange created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public EntryExitChange modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public EntryExitChange modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public EntryExit getEntryExit() {
        return entryExit;
    }

    public EntryExitChange entryExit(EntryExit entryExit) {
        this.entryExit = entryExit;
        return this;
    }

    public void setEntryExit(EntryExit entryExit) {
        this.entryExit = entryExit;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitChange)) {
            return false;
        }
        return id != null && id.equals(((EntryExitChange) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitChange{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", daydate='" + getDaydate() + "'" +
            ", newEntryTime='" + getNewEntryTime() + "'" +
            ", newExitTime='" + getNewExitTime() + "'" +
            ", originalEntryTime='" + getOriginalEntryTime() + "'" +
            ", originalExitTime='" + getOriginalExitTime() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
