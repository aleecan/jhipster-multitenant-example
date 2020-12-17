package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.ScheduleChange} entity.
 */
public class ScheduleChangeDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    private Boolean approval;

    private Boolean approval2;

    private Boolean approval3;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long scheduleId;

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

    public Boolean isApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public Boolean isApproval2() {
        return approval2;
    }

    public void setApproval2(Boolean approval2) {
        this.approval2 = approval2;
    }

    public Boolean isApproval3() {
        return approval3;
    }

    public void setApproval3(Boolean approval3) {
        this.approval3 = approval3;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ScheduleChangeDTO)) {
            return false;
        }

        return id != null && id.equals(((ScheduleChangeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ScheduleChangeDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", approval='" + isApproval() + "'" +
            ", approval2='" + isApproval2() + "'" +
            ", approval3='" + isApproval3() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", scheduleId=" + getScheduleId() +
            "}";
    }
}
