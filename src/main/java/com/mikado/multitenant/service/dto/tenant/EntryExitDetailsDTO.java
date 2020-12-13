package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.EntryExitDetails} entity.
 */
public class EntryExitDetailsDTO implements Serializable {

    private Long id;

    private Instant entryDatetime;

    private Integer entryType;

    private Boolean entryOvertimeApproved;

    private Boolean entryOvertimeApproved1;

    private Boolean entryOvertimeApproved2;

    private Boolean entryRealtime;

    private Instant termEntryDatetime;

    private Boolean entryExported;

    private Instant exitDatetime;

    private Integer exitType;

    private Boolean exitOvertimeApproved;

    private Boolean exitOvertimeApproved1;

    private Boolean exitOvertimeApproved2;

    private Boolean exitRealtime;

    private Instant termExitDatetime;

    private Boolean exitExported;

    private Boolean newEntryReasonApp1;

    private Boolean newEntryReasonApp2;

    private Boolean newEntryReasonApp3;

    private Boolean newExitReasonApp1;

    private Boolean newExitReasonApp2;

    private Boolean newExitReasonApp3;

    private Instant newEntryDatetime;

    private Boolean newEntryDatetimeApp1;

    private Boolean newEntryDatetimeApp2;

    private Boolean newEntryDatetimeApp3;

    private Instant newExitDatetime;

    private Boolean newExitDatetimeApp1;

    private Boolean newExitDatetimeApp2;

    private Boolean newExitDatetimeApp3;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long entryExitId;

    private Long entryReasonId;

    private Long entryTerminalId;

    private Long exitReasonId;

    private Long exitTerminalId;

    private Long newEntryReasonId;

    private Long newExitReasonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Instant entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public Boolean isEntryOvertimeApproved() {
        return entryOvertimeApproved;
    }

    public void setEntryOvertimeApproved(Boolean entryOvertimeApproved) {
        this.entryOvertimeApproved = entryOvertimeApproved;
    }

    public Boolean isEntryOvertimeApproved1() {
        return entryOvertimeApproved1;
    }

    public void setEntryOvertimeApproved1(Boolean entryOvertimeApproved1) {
        this.entryOvertimeApproved1 = entryOvertimeApproved1;
    }

    public Boolean isEntryOvertimeApproved2() {
        return entryOvertimeApproved2;
    }

    public void setEntryOvertimeApproved2(Boolean entryOvertimeApproved2) {
        this.entryOvertimeApproved2 = entryOvertimeApproved2;
    }

    public Boolean isEntryRealtime() {
        return entryRealtime;
    }

    public void setEntryRealtime(Boolean entryRealtime) {
        this.entryRealtime = entryRealtime;
    }

    public Instant getTermEntryDatetime() {
        return termEntryDatetime;
    }

    public void setTermEntryDatetime(Instant termEntryDatetime) {
        this.termEntryDatetime = termEntryDatetime;
    }

    public Boolean isEntryExported() {
        return entryExported;
    }

    public void setEntryExported(Boolean entryExported) {
        this.entryExported = entryExported;
    }

    public Instant getExitDatetime() {
        return exitDatetime;
    }

    public void setExitDatetime(Instant exitDatetime) {
        this.exitDatetime = exitDatetime;
    }

    public Integer getExitType() {
        return exitType;
    }

    public void setExitType(Integer exitType) {
        this.exitType = exitType;
    }

    public Boolean isExitOvertimeApproved() {
        return exitOvertimeApproved;
    }

    public void setExitOvertimeApproved(Boolean exitOvertimeApproved) {
        this.exitOvertimeApproved = exitOvertimeApproved;
    }

    public Boolean isExitOvertimeApproved1() {
        return exitOvertimeApproved1;
    }

    public void setExitOvertimeApproved1(Boolean exitOvertimeApproved1) {
        this.exitOvertimeApproved1 = exitOvertimeApproved1;
    }

    public Boolean isExitOvertimeApproved2() {
        return exitOvertimeApproved2;
    }

    public void setExitOvertimeApproved2(Boolean exitOvertimeApproved2) {
        this.exitOvertimeApproved2 = exitOvertimeApproved2;
    }

    public Boolean isExitRealtime() {
        return exitRealtime;
    }

    public void setExitRealtime(Boolean exitRealtime) {
        this.exitRealtime = exitRealtime;
    }

    public Instant getTermExitDatetime() {
        return termExitDatetime;
    }

    public void setTermExitDatetime(Instant termExitDatetime) {
        this.termExitDatetime = termExitDatetime;
    }

    public Boolean isExitExported() {
        return exitExported;
    }

    public void setExitExported(Boolean exitExported) {
        this.exitExported = exitExported;
    }

    public Boolean isNewEntryReasonApp1() {
        return newEntryReasonApp1;
    }

    public void setNewEntryReasonApp1(Boolean newEntryReasonApp1) {
        this.newEntryReasonApp1 = newEntryReasonApp1;
    }

    public Boolean isNewEntryReasonApp2() {
        return newEntryReasonApp2;
    }

    public void setNewEntryReasonApp2(Boolean newEntryReasonApp2) {
        this.newEntryReasonApp2 = newEntryReasonApp2;
    }

    public Boolean isNewEntryReasonApp3() {
        return newEntryReasonApp3;
    }

    public void setNewEntryReasonApp3(Boolean newEntryReasonApp3) {
        this.newEntryReasonApp3 = newEntryReasonApp3;
    }

    public Boolean isNewExitReasonApp1() {
        return newExitReasonApp1;
    }

    public void setNewExitReasonApp1(Boolean newExitReasonApp1) {
        this.newExitReasonApp1 = newExitReasonApp1;
    }

    public Boolean isNewExitReasonApp2() {
        return newExitReasonApp2;
    }

    public void setNewExitReasonApp2(Boolean newExitReasonApp2) {
        this.newExitReasonApp2 = newExitReasonApp2;
    }

    public Boolean isNewExitReasonApp3() {
        return newExitReasonApp3;
    }

    public void setNewExitReasonApp3(Boolean newExitReasonApp3) {
        this.newExitReasonApp3 = newExitReasonApp3;
    }

    public Instant getNewEntryDatetime() {
        return newEntryDatetime;
    }

    public void setNewEntryDatetime(Instant newEntryDatetime) {
        this.newEntryDatetime = newEntryDatetime;
    }

    public Boolean isNewEntryDatetimeApp1() {
        return newEntryDatetimeApp1;
    }

    public void setNewEntryDatetimeApp1(Boolean newEntryDatetimeApp1) {
        this.newEntryDatetimeApp1 = newEntryDatetimeApp1;
    }

    public Boolean isNewEntryDatetimeApp2() {
        return newEntryDatetimeApp2;
    }

    public void setNewEntryDatetimeApp2(Boolean newEntryDatetimeApp2) {
        this.newEntryDatetimeApp2 = newEntryDatetimeApp2;
    }

    public Boolean isNewEntryDatetimeApp3() {
        return newEntryDatetimeApp3;
    }

    public void setNewEntryDatetimeApp3(Boolean newEntryDatetimeApp3) {
        this.newEntryDatetimeApp3 = newEntryDatetimeApp3;
    }

    public Instant getNewExitDatetime() {
        return newExitDatetime;
    }

    public void setNewExitDatetime(Instant newExitDatetime) {
        this.newExitDatetime = newExitDatetime;
    }

    public Boolean isNewExitDatetimeApp1() {
        return newExitDatetimeApp1;
    }

    public void setNewExitDatetimeApp1(Boolean newExitDatetimeApp1) {
        this.newExitDatetimeApp1 = newExitDatetimeApp1;
    }

    public Boolean isNewExitDatetimeApp2() {
        return newExitDatetimeApp2;
    }

    public void setNewExitDatetimeApp2(Boolean newExitDatetimeApp2) {
        this.newExitDatetimeApp2 = newExitDatetimeApp2;
    }

    public Boolean isNewExitDatetimeApp3() {
        return newExitDatetimeApp3;
    }

    public void setNewExitDatetimeApp3(Boolean newExitDatetimeApp3) {
        this.newExitDatetimeApp3 = newExitDatetimeApp3;
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

    public Long getEntryReasonId() {
        return entryReasonId;
    }

    public void setEntryReasonId(Long categoryId) {
        this.entryReasonId = categoryId;
    }

    public Long getEntryTerminalId() {
        return entryTerminalId;
    }

    public void setEntryTerminalId(Long terminalId) {
        this.entryTerminalId = terminalId;
    }

    public Long getExitReasonId() {
        return exitReasonId;
    }

    public void setExitReasonId(Long categoryId) {
        this.exitReasonId = categoryId;
    }

    public Long getExitTerminalId() {
        return exitTerminalId;
    }

    public void setExitTerminalId(Long terminalId) {
        this.exitTerminalId = terminalId;
    }

    public Long getNewEntryReasonId() {
        return newEntryReasonId;
    }

    public void setNewEntryReasonId(Long categoryId) {
        this.newEntryReasonId = categoryId;
    }

    public Long getNewExitReasonId() {
        return newExitReasonId;
    }

    public void setNewExitReasonId(Long categoryId) {
        this.newExitReasonId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((EntryExitDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitDetailsDTO{" +
            "id=" + getId() +
            ", entryDatetime='" + getEntryDatetime() + "'" +
            ", entryType=" + getEntryType() +
            ", entryOvertimeApproved='" + isEntryOvertimeApproved() + "'" +
            ", entryOvertimeApproved1='" + isEntryOvertimeApproved1() + "'" +
            ", entryOvertimeApproved2='" + isEntryOvertimeApproved2() + "'" +
            ", entryRealtime='" + isEntryRealtime() + "'" +
            ", termEntryDatetime='" + getTermEntryDatetime() + "'" +
            ", entryExported='" + isEntryExported() + "'" +
            ", exitDatetime='" + getExitDatetime() + "'" +
            ", exitType=" + getExitType() +
            ", exitOvertimeApproved='" + isExitOvertimeApproved() + "'" +
            ", exitOvertimeApproved1='" + isExitOvertimeApproved1() + "'" +
            ", exitOvertimeApproved2='" + isExitOvertimeApproved2() + "'" +
            ", exitRealtime='" + isExitRealtime() + "'" +
            ", termExitDatetime='" + getTermExitDatetime() + "'" +
            ", exitExported='" + isExitExported() + "'" +
            ", newEntryReasonApp1='" + isNewEntryReasonApp1() + "'" +
            ", newEntryReasonApp2='" + isNewEntryReasonApp2() + "'" +
            ", newEntryReasonApp3='" + isNewEntryReasonApp3() + "'" +
            ", newExitReasonApp1='" + isNewExitReasonApp1() + "'" +
            ", newExitReasonApp2='" + isNewExitReasonApp2() + "'" +
            ", newExitReasonApp3='" + isNewExitReasonApp3() + "'" +
            ", newEntryDatetime='" + getNewEntryDatetime() + "'" +
            ", newEntryDatetimeApp1='" + isNewEntryDatetimeApp1() + "'" +
            ", newEntryDatetimeApp2='" + isNewEntryDatetimeApp2() + "'" +
            ", newEntryDatetimeApp3='" + isNewEntryDatetimeApp3() + "'" +
            ", newExitDatetime='" + getNewExitDatetime() + "'" +
            ", newExitDatetimeApp1='" + isNewExitDatetimeApp1() + "'" +
            ", newExitDatetimeApp2='" + isNewExitDatetimeApp2() + "'" +
            ", newExitDatetimeApp3='" + isNewExitDatetimeApp3() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", entryExitId=" + getEntryExitId() +
            ", entryReasonId=" + getEntryReasonId() +
            ", entryTerminalId=" + getEntryTerminalId() +
            ", exitReasonId=" + getExitReasonId() +
            ", exitTerminalId=" + getExitTerminalId() +
            ", newEntryReasonId=" + getNewEntryReasonId() +
            ", newExitReasonId=" + getNewExitReasonId() +
            "}";
    }
}
