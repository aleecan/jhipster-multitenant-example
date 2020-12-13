package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.EntryExit} entity.
 */
public class EntryExitDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    private Integer dayType;

    private Boolean dayApproved;

    @Size(max = 80)
    private String overtimeExplanation;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeApprovedPayTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String reasonApprovedPayTime;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long scheduleId;

    private Long defaultScheduleId;

    private Long overtimeReasonId;

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

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public Boolean isDayApproved() {
        return dayApproved;
    }

    public void setDayApproved(Boolean dayApproved) {
        this.dayApproved = dayApproved;
    }

    public String getOvertimeExplanation() {
        return overtimeExplanation;
    }

    public void setOvertimeExplanation(String overtimeExplanation) {
        this.overtimeExplanation = overtimeExplanation;
    }

    public String getOvertimeApprovedPayTime() {
        return overtimeApprovedPayTime;
    }

    public void setOvertimeApprovedPayTime(String overtimeApprovedPayTime) {
        this.overtimeApprovedPayTime = overtimeApprovedPayTime;
    }

    public String getReasonApprovedPayTime() {
        return reasonApprovedPayTime;
    }

    public void setReasonApprovedPayTime(String reasonApprovedPayTime) {
        this.reasonApprovedPayTime = reasonApprovedPayTime;
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

    public Long getDefaultScheduleId() {
        return defaultScheduleId;
    }

    public void setDefaultScheduleId(Long scheduleId) {
        this.defaultScheduleId = scheduleId;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitDTO)) {
            return false;
        }

        return id != null && id.equals(((EntryExitDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitDTO{" +
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
            ", employeeId=" + getEmployeeId() +
            ", scheduleId=" + getScheduleId() +
            ", defaultScheduleId=" + getDefaultScheduleId() +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            "}";
    }
}
