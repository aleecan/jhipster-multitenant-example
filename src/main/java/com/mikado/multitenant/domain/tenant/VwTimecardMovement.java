package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * VIEW
 */
@Entity
@Table(name = "vw_timecard_movement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VwTimecardMovement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotNull
    @Column(name = "daytime", nullable = false)
    private Instant daytime;

    @NotNull
    @Column(name = "direction", nullable = false)
    private Integer direction;

    @Column(name = "reason_id")
    private Long reasonId;

    @Column(name = "terminal_id")
    private Long terminalId;

    @Column(name = "overtime_approval")
    private Boolean overtimeApproval;

    @Column(name = "overtime_approval_1")
    private Boolean overtimeApproval1;

    @Column(name = "overtime_approval_2")
    private Boolean overtimeApproval2;

    @Column(name = "overtime_reason_id")
    private Long overtimeReasonId;

    @Size(max = 80)
    @Column(name = "overtime_notes", length = 80)
    private String overtimeNotes;

    @Column(name = "exported")
    private Boolean exported;

    @Column(name = "rcexported")
    private Boolean rcexported;

    @Column(name = "realtime")
    private Boolean realtime;

    @Column(name = "terminal_time")
    private Instant terminalTime;

    @Column(name = "access_control_id")
    private Long accessControlId;

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

    public VwTimecardMovement employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Instant getDaytime() {
        return daytime;
    }

    public VwTimecardMovement daytime(Instant daytime) {
        this.daytime = daytime;
        return this;
    }

    public void setDaytime(Instant daytime) {
        this.daytime = daytime;
    }

    public Integer getDirection() {
        return direction;
    }

    public VwTimecardMovement direction(Integer direction) {
        this.direction = direction;
        return this;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Long getReasonId() {
        return reasonId;
    }

    public VwTimecardMovement reasonId(Long reasonId) {
        this.reasonId = reasonId;
        return this;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public VwTimecardMovement terminalId(Long terminalId) {
        this.terminalId = terminalId;
        return this;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Boolean isOvertimeApproval() {
        return overtimeApproval;
    }

    public VwTimecardMovement overtimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
        return this;
    }

    public void setOvertimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
    }

    public Boolean isOvertimeApproval1() {
        return overtimeApproval1;
    }

    public VwTimecardMovement overtimeApproval1(Boolean overtimeApproval1) {
        this.overtimeApproval1 = overtimeApproval1;
        return this;
    }

    public void setOvertimeApproval1(Boolean overtimeApproval1) {
        this.overtimeApproval1 = overtimeApproval1;
    }

    public Boolean isOvertimeApproval2() {
        return overtimeApproval2;
    }

    public VwTimecardMovement overtimeApproval2(Boolean overtimeApproval2) {
        this.overtimeApproval2 = overtimeApproval2;
        return this;
    }

    public void setOvertimeApproval2(Boolean overtimeApproval2) {
        this.overtimeApproval2 = overtimeApproval2;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public VwTimecardMovement overtimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
        return this;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    public String getOvertimeNotes() {
        return overtimeNotes;
    }

    public VwTimecardMovement overtimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
        return this;
    }

    public void setOvertimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
    }

    public Boolean isExported() {
        return exported;
    }

    public VwTimecardMovement exported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Boolean isRcexported() {
        return rcexported;
    }

    public VwTimecardMovement rcexported(Boolean rcexported) {
        this.rcexported = rcexported;
        return this;
    }

    public void setRcexported(Boolean rcexported) {
        this.rcexported = rcexported;
    }

    public Boolean isRealtime() {
        return realtime;
    }

    public VwTimecardMovement realtime(Boolean realtime) {
        this.realtime = realtime;
        return this;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public Instant getTerminalTime() {
        return terminalTime;
    }

    public VwTimecardMovement terminalTime(Instant terminalTime) {
        this.terminalTime = terminalTime;
        return this;
    }

    public void setTerminalTime(Instant terminalTime) {
        this.terminalTime = terminalTime;
    }

    public Long getAccessControlId() {
        return accessControlId;
    }

    public VwTimecardMovement accessControlId(Long accessControlId) {
        this.accessControlId = accessControlId;
        return this;
    }

    public void setAccessControlId(Long accessControlId) {
        this.accessControlId = accessControlId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VwTimecardMovement)) {
            return false;
        }
        return id != null && id.equals(((VwTimecardMovement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VwTimecardMovement{" +
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
