package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.EntryExitChange} entity.
 */
public class EntryExitChangeDTO implements Serializable {

    private Long id;

    @NotNull
    private Long employeeId;

    @NotNull
    private LocalDate daydate;

    private Instant newEntryTime;

    private Instant newExitTime;

    private Instant originalEntryTime;

    private Instant originalExitTime;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long entryExitId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Instant getNewEntryTime() {
        return newEntryTime;
    }

    public void setNewEntryTime(Instant newEntryTime) {
        this.newEntryTime = newEntryTime;
    }

    public Instant getNewExitTime() {
        return newExitTime;
    }

    public void setNewExitTime(Instant newExitTime) {
        this.newExitTime = newExitTime;
    }

    public Instant getOriginalEntryTime() {
        return originalEntryTime;
    }

    public void setOriginalEntryTime(Instant originalEntryTime) {
        this.originalEntryTime = originalEntryTime;
    }

    public Instant getOriginalExitTime() {
        return originalExitTime;
    }

    public void setOriginalExitTime(Instant originalExitTime) {
        this.originalExitTime = originalExitTime;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getEntryExitId() {
        return entryExitId;
    }

    public void setEntryExitId(Long entryExitId) {
        this.entryExitId = entryExitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitChangeDTO)) {
            return false;
        }

        return id != null && id.equals(((EntryExitChangeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitChangeDTO{" +
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
            ", entryExitId=" + getEntryExitId() +
            "}";
    }
}
