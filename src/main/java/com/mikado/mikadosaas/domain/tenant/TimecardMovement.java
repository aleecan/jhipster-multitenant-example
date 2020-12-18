package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A TimecardMovement.
 */
@Entity
@Table(name = "timecard_movement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TimecardMovement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daytime", nullable = false)
    private Instant daytime;

    @NotNull
    @Column(name = "direction", nullable = false)
    private Integer direction;

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

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "timecardMovements", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "timecardMovements", allowSetters = true)
    private Category reason;

    @ManyToOne
    @JsonIgnoreProperties(value = "timecardMovements", allowSetters = true)
    private Terminal terminal;

    @ManyToOne
    @JsonIgnoreProperties(value = "timecardMovements", allowSetters = true)
    private AccessControl accessControl;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDaytime() {
        return daytime;
    }

    public TimecardMovement daytime(Instant daytime) {
        this.daytime = daytime;
        return this;
    }

    public void setDaytime(Instant daytime) {
        this.daytime = daytime;
    }

    public Integer getDirection() {
        return direction;
    }

    public TimecardMovement direction(Integer direction) {
        this.direction = direction;
        return this;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Boolean isOvertimeApproval() {
        return overtimeApproval;
    }

    public TimecardMovement overtimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
        return this;
    }

    public void setOvertimeApproval(Boolean overtimeApproval) {
        this.overtimeApproval = overtimeApproval;
    }

    public Boolean isOvertimeApproval1() {
        return overtimeApproval1;
    }

    public TimecardMovement overtimeApproval1(Boolean overtimeApproval1) {
        this.overtimeApproval1 = overtimeApproval1;
        return this;
    }

    public void setOvertimeApproval1(Boolean overtimeApproval1) {
        this.overtimeApproval1 = overtimeApproval1;
    }

    public Boolean isOvertimeApproval2() {
        return overtimeApproval2;
    }

    public TimecardMovement overtimeApproval2(Boolean overtimeApproval2) {
        this.overtimeApproval2 = overtimeApproval2;
        return this;
    }

    public void setOvertimeApproval2(Boolean overtimeApproval2) {
        this.overtimeApproval2 = overtimeApproval2;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public TimecardMovement overtimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
        return this;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    public String getOvertimeNotes() {
        return overtimeNotes;
    }

    public TimecardMovement overtimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
        return this;
    }

    public void setOvertimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
    }

    public Boolean isExported() {
        return exported;
    }

    public TimecardMovement exported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Boolean isRcexported() {
        return rcexported;
    }

    public TimecardMovement rcexported(Boolean rcexported) {
        this.rcexported = rcexported;
        return this;
    }

    public void setRcexported(Boolean rcexported) {
        this.rcexported = rcexported;
    }

    public Boolean isRealtime() {
        return realtime;
    }

    public TimecardMovement realtime(Boolean realtime) {
        this.realtime = realtime;
        return this;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public Instant getTerminalTime() {
        return terminalTime;
    }

    public TimecardMovement terminalTime(Instant terminalTime) {
        this.terminalTime = terminalTime;
        return this;
    }

    public void setTerminalTime(Instant terminalTime) {
        this.terminalTime = terminalTime;
    }

    public Instant getCreated() {
        return created;
    }

    public TimecardMovement created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public TimecardMovement modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public TimecardMovement modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public TimecardMovement employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Category getReason() {
        return reason;
    }

    public TimecardMovement reason(Category category) {
        this.reason = category;
        return this;
    }

    public void setReason(Category category) {
        this.reason = category;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public TimecardMovement terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public TimecardMovement accessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
        return this;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimecardMovement)) {
            return false;
        }
        return id != null && id.equals(((TimecardMovement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimecardMovement{" +
            "id=" + getId() +
            ", daytime='" + getDaytime() + "'" +
            ", direction=" + getDirection() +
            ", overtimeApproval='" + isOvertimeApproval() + "'" +
            ", overtimeApproval1='" + isOvertimeApproval1() + "'" +
            ", overtimeApproval2='" + isOvertimeApproval2() + "'" +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            ", overtimeNotes='" + getOvertimeNotes() + "'" +
            ", exported='" + isExported() + "'" +
            ", rcexported='" + isRcexported() + "'" +
            ", realtime='" + isRealtime() + "'" +
            ", terminalTime='" + getTerminalTime() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
