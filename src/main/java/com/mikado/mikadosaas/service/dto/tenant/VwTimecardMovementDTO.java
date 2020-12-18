package com.mikado.mikadosaas.service.dto.tenant;

import io.swagger.annotations.ApiModel;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.VwTimecardMovement} entity.
 */
@ApiModel(description = "VIEW")
public class VwTimecardMovementDTO implements Serializable {

    private Long id;

    @NotNull
    private Long employeeId;

    @NotNull
    private Instant daytime;

    @NotNull
    private Integer direction;

    private Long reasonId;

    private Long terminalId;

    private Boolean overtimeApproval;

    private Boolean overtimeApproval1;

    private Boolean overtimeApproval2;

    private Long overtimeReasonId;

    @Size(max = 80)
    private String overtimeNotes;

    private Boolean exported;

    private Boolean rcexported;

    private Boolean realtime;

    private Instant terminalTime;

    private Long accessControlId;


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

    public Instant getDaytime() {
        return daytime;
    }

    public void setDaytime(Instant daytime) {
        this.daytime = daytime;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Boolean isOvertimeApproval() {
        return overtimeApproval;
    }

    public void setOvertimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
    }

    public Boolean isOvertimeApproval1() {
        return overtimeApproval1;
    }

    public void setOvertimeApproval1(Boolean overtimeApproval1) {
        this.overtimeApproval1 = overtimeApproval1;
    }

    public Boolean isOvertimeApproval2() {
        return overtimeApproval2;
    }

    public void setOvertimeApproval2(Boolean overtimeApproval2) {
        this.overtimeApproval2 = overtimeApproval2;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    public String getOvertimeNotes() {
        return overtimeNotes;
    }

    public void setOvertimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
    }

    public Boolean isExported() {
        return exported;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Boolean isRcexported() {
        return rcexported;
    }

    public void setRcexported(Boolean rcexported) {
        this.rcexported = rcexported;
    }

    public Boolean isRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public Instant getTerminalTime() {
        return terminalTime;
    }

    public void setTerminalTime(Instant terminalTime) {
        this.terminalTime = terminalTime;
    }

    public Long getAccessControlId() {
        return accessControlId;
    }

    public void setAccessControlId(Long accessControlId) {
        this.accessControlId = accessControlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VwTimecardMovementDTO)) {
            return false;
        }

        return id != null && id.equals(((VwTimecardMovementDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VwTimecardMovementDTO{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", daytime='" + getDaytime() + "'" +
            ", direction=" + getDirection() +
            ", reasonId=" + getReasonId() +
            ", terminalId=" + getTerminalId() +
            ", overtimeApproval='" + isOvertimeApproval() + "'" +
            ", overtimeApproval1='" + isOvertimeApproval1() + "'" +
            ", overtimeApproval2='" + isOvertimeApproval2() + "'" +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            ", overtimeNotes='" + getOvertimeNotes() + "'" +
            ", exported='" + isExported() + "'" +
            ", rcexported='" + isRcexported() + "'" +
            ", realtime='" + isRealtime() + "'" +
            ", terminalTime='" + getTerminalTime() + "'" +
            ", accessControlId=" + getAccessControlId() +
            "}";
    }
}
