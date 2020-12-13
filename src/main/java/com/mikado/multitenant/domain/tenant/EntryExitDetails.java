package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A EntryExitDetails.
 */
@Entity
@Table(name = "entry_exit_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EntryExitDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_datetime")
    private Instant entryDatetime;

    @Column(name = "entry_type")
    private Integer entryType;

    @Column(name = "entry_overtime_approved")
    private Boolean entryOvertimeApproved;

    @Column(name = "entry_overtime_approved_1")
    private Boolean entryOvertimeApproved1;

    @Column(name = "entry_overtime_approved_2")
    private Boolean entryOvertimeApproved2;

    @Column(name = "entry_realtime")
    private Boolean entryRealtime;

    @Column(name = "term_entry_datetime")
    private Instant termEntryDatetime;

    @Column(name = "entry_exported")
    private Boolean entryExported;

    @Column(name = "exit_datetime")
    private Instant exitDatetime;

    @Column(name = "exit_type")
    private Integer exitType;

    @Column(name = "exit_overtime_approved")
    private Boolean exitOvertimeApproved;

    @Column(name = "exit_overtime_approved_1")
    private Boolean exitOvertimeApproved1;

    @Column(name = "exit_overtime_approved_2")
    private Boolean exitOvertimeApproved2;

    @Column(name = "exit_realtime")
    private Boolean exitRealtime;

    @Column(name = "term_exit_datetime")
    private Instant termExitDatetime;

    @Column(name = "exit_exported")
    private Boolean exitExported;

    @Column(name = "new_entry_reason_app_1")
    private Boolean newEntryReasonApp1;

    @Column(name = "new_entry_reason_app_2")
    private Boolean newEntryReasonApp2;

    @Column(name = "new_entry_reason_app_3")
    private Boolean newEntryReasonApp3;

    @Column(name = "new_exit_reason_app_1")
    private Boolean newExitReasonApp1;

    @Column(name = "new_exit_reason_app_2")
    private Boolean newExitReasonApp2;

    @Column(name = "new_exit_reason_app_3")
    private Boolean newExitReasonApp3;

    @Column(name = "new_entry_datetime")
    private Instant newEntryDatetime;

    @Column(name = "new_entry_datetime_app_1")
    private Boolean newEntryDatetimeApp1;

    @Column(name = "new_entry_datetime_app_2")
    private Boolean newEntryDatetimeApp2;

    @Column(name = "new_entry_datetime_app_3")
    private Boolean newEntryDatetimeApp3;

    @Column(name = "new_exit_datetime")
    private Instant newExitDatetime;

    @Column(name = "new_exit_datetime_app_1")
    private Boolean newExitDatetimeApp1;

    @Column(name = "new_exit_datetime_app_2")
    private Boolean newExitDatetimeApp2;

    @Column(name = "new_exit_datetime_app_3")
    private Boolean newExitDatetimeApp3;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private EntryExit entryExit;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Category entryReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Terminal entryTerminal;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Category exitReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Terminal exitTerminal;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Category newEntryReason;

    @ManyToOne
    @JsonIgnoreProperties(value = "entryExitDetails", allowSetters = true)
    private Category newExitReason;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryDatetime() {
        return entryDatetime;
    }

    public EntryExitDetails entryDatetime(Instant entryDatetime) {
        this.entryDatetime = entryDatetime;
        return this;
    }

    public void setEntryDatetime(Instant entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public EntryExitDetails entryType(Integer entryType) {
        this.entryType = entryType;
        return this;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public Boolean isEntryOvertimeApproved() {
        return entryOvertimeApproved;
    }

    public EntryExitDetails entryOvertimeApproved(Boolean entryOvertimeApproved) {
        this.entryOvertimeApproved = entryOvertimeApproved;
        return this;
    }

    public void setEntryOvertimeApproved(Boolean entryOvertimeApproved) {
        this.entryOvertimeApproved = entryOvertimeApproved;
    }

    public Boolean isEntryOvertimeApproved1() {
        return entryOvertimeApproved1;
    }

    public EntryExitDetails entryOvertimeApproved1(Boolean entryOvertimeApproved1) {
        this.entryOvertimeApproved1 = entryOvertimeApproved1;
        return this;
    }

    public void setEntryOvertimeApproved1(Boolean entryOvertimeApproved1) {
        this.entryOvertimeApproved1 = entryOvertimeApproved1;
    }

    public Boolean isEntryOvertimeApproved2() {
        return entryOvertimeApproved2;
    }

    public EntryExitDetails entryOvertimeApproved2(Boolean entryOvertimeApproved2) {
        this.entryOvertimeApproved2 = entryOvertimeApproved2;
        return this;
    }

    public void setEntryOvertimeApproved2(Boolean entryOvertimeApproved2) {
        this.entryOvertimeApproved2 = entryOvertimeApproved2;
    }

    public Boolean isEntryRealtime() {
        return entryRealtime;
    }

    public EntryExitDetails entryRealtime(Boolean entryRealtime) {
        this.entryRealtime = entryRealtime;
        return this;
    }

    public void setEntryRealtime(Boolean entryRealtime) {
        this.entryRealtime = entryRealtime;
    }

    public Instant getTermEntryDatetime() {
        return termEntryDatetime;
    }

    public EntryExitDetails termEntryDatetime(Instant termEntryDatetime) {
        this.termEntryDatetime = termEntryDatetime;
        return this;
    }

    public void setTermEntryDatetime(Instant termEntryDatetime) {
        this.termEntryDatetime = termEntryDatetime;
    }

    public Boolean isEntryExported() {
        return entryExported;
    }

    public EntryExitDetails entryExported(Boolean entryExported) {
        this.entryExported = entryExported;
        return this;
    }

    public void setEntryExported(Boolean entryExported) {
        this.entryExported = entryExported;
    }

    public Instant getExitDatetime() {
        return exitDatetime;
    }

    public EntryExitDetails exitDatetime(Instant exitDatetime) {
        this.exitDatetime = exitDatetime;
        return this;
    }

    public void setExitDatetime(Instant exitDatetime) {
        this.exitDatetime = exitDatetime;
    }

    public Integer getExitType() {
        return exitType;
    }

    public EntryExitDetails exitType(Integer exitType) {
        this.exitType = exitType;
        return this;
    }

    public void setExitType(Integer exitType) {
        this.exitType = exitType;
    }

    public Boolean isExitOvertimeApproved() {
        return exitOvertimeApproved;
    }

    public EntryExitDetails exitOvertimeApproved(Boolean exitOvertimeApproved) {
        this.exitOvertimeApproved = exitOvertimeApproved;
        return this;
    }

    public void setExitOvertimeApproved(Boolean exitOvertimeApproved) {
        this.exitOvertimeApproved = exitOvertimeApproved;
    }

    public Boolean isExitOvertimeApproved1() {
        return exitOvertimeApproved1;
    }

    public EntryExitDetails exitOvertimeApproved1(Boolean exitOvertimeApproved1) {
        this.exitOvertimeApproved1 = exitOvertimeApproved1;
        return this;
    }

    public void setExitOvertimeApproved1(Boolean exitOvertimeApproved1) {
        this.exitOvertimeApproved1 = exitOvertimeApproved1;
    }

    public Boolean isExitOvertimeApproved2() {
        return exitOvertimeApproved2;
    }

    public EntryExitDetails exitOvertimeApproved2(Boolean exitOvertimeApproved2) {
        this.exitOvertimeApproved2 = exitOvertimeApproved2;
        return this;
    }

    public void setExitOvertimeApproved2(Boolean exitOvertimeApproved2) {
        this.exitOvertimeApproved2 = exitOvertimeApproved2;
    }

    public Boolean isExitRealtime() {
        return exitRealtime;
    }

    public EntryExitDetails exitRealtime(Boolean exitRealtime) {
        this.exitRealtime = exitRealtime;
        return this;
    }

    public void setExitRealtime(Boolean exitRealtime) {
        this.exitRealtime = exitRealtime;
    }

    public Instant getTermExitDatetime() {
        return termExitDatetime;
    }

    public EntryExitDetails termExitDatetime(Instant termExitDatetime) {
        this.termExitDatetime = termExitDatetime;
        return this;
    }

    public void setTermExitDatetime(Instant termExitDatetime) {
        this.termExitDatetime = termExitDatetime;
    }

    public Boolean isExitExported() {
        return exitExported;
    }

    public EntryExitDetails exitExported(Boolean exitExported) {
        this.exitExported = exitExported;
        return this;
    }

    public void setExitExported(Boolean exitExported) {
        this.exitExported = exitExported;
    }

    public Boolean isNewEntryReasonApp1() {
        return newEntryReasonApp1;
    }

    public EntryExitDetails newEntryReasonApp1(Boolean newEntryReasonApp1) {
        this.newEntryReasonApp1 = newEntryReasonApp1;
        return this;
    }

    public void setNewEntryReasonApp1(Boolean newEntryReasonApp1) {
        this.newEntryReasonApp1 = newEntryReasonApp1;
    }

    public Boolean isNewEntryReasonApp2() {
        return newEntryReasonApp2;
    }

    public EntryExitDetails newEntryReasonApp2(Boolean newEntryReasonApp2) {
        this.newEntryReasonApp2 = newEntryReasonApp2;
        return this;
    }

    public void setNewEntryReasonApp2(Boolean newEntryReasonApp2) {
        this.newEntryReasonApp2 = newEntryReasonApp2;
    }

    public Boolean isNewEntryReasonApp3() {
        return newEntryReasonApp3;
    }

    public EntryExitDetails newEntryReasonApp3(Boolean newEntryReasonApp3) {
        this.newEntryReasonApp3 = newEntryReasonApp3;
        return this;
    }

    public void setNewEntryReasonApp3(Boolean newEntryReasonApp3) {
        this.newEntryReasonApp3 = newEntryReasonApp3;
    }

    public Boolean isNewExitReasonApp1() {
        return newExitReasonApp1;
    }

    public EntryExitDetails newExitReasonApp1(Boolean newExitReasonApp1) {
        this.newExitReasonApp1 = newExitReasonApp1;
        return this;
    }

    public void setNewExitReasonApp1(Boolean newExitReasonApp1) {
        this.newExitReasonApp1 = newExitReasonApp1;
    }

    public Boolean isNewExitReasonApp2() {
        return newExitReasonApp2;
    }

    public EntryExitDetails newExitReasonApp2(Boolean newExitReasonApp2) {
        this.newExitReasonApp2 = newExitReasonApp2;
        return this;
    }

    public void setNewExitReasonApp2(Boolean newExitReasonApp2) {
        this.newExitReasonApp2 = newExitReasonApp2;
    }

    public Boolean isNewExitReasonApp3() {
        return newExitReasonApp3;
    }

    public EntryExitDetails newExitReasonApp3(Boolean newExitReasonApp3) {
        this.newExitReasonApp3 = newExitReasonApp3;
        return this;
    }

    public void setNewExitReasonApp3(Boolean newExitReasonApp3) {
        this.newExitReasonApp3 = newExitReasonApp3;
    }

    public Instant getNewEntryDatetime() {
        return newEntryDatetime;
    }

    public EntryExitDetails newEntryDatetime(Instant newEntryDatetime) {
        this.newEntryDatetime = newEntryDatetime;
        return this;
    }

    public void setNewEntryDatetime(Instant newEntryDatetime) {
        this.newEntryDatetime = newEntryDatetime;
    }

    public Boolean isNewEntryDatetimeApp1() {
        return newEntryDatetimeApp1;
    }

    public EntryExitDetails newEntryDatetimeApp1(Boolean newEntryDatetimeApp1) {
        this.newEntryDatetimeApp1 = newEntryDatetimeApp1;
        return this;
    }

    public void setNewEntryDatetimeApp1(Boolean newEntryDatetimeApp1) {
        this.newEntryDatetimeApp1 = newEntryDatetimeApp1;
    }

    public Boolean isNewEntryDatetimeApp2() {
        return newEntryDatetimeApp2;
    }

    public EntryExitDetails newEntryDatetimeApp2(Boolean newEntryDatetimeApp2) {
        this.newEntryDatetimeApp2 = newEntryDatetimeApp2;
        return this;
    }

    public void setNewEntryDatetimeApp2(Boolean newEntryDatetimeApp2) {
        this.newEntryDatetimeApp2 = newEntryDatetimeApp2;
    }

    public Boolean isNewEntryDatetimeApp3() {
        return newEntryDatetimeApp3;
    }

    public EntryExitDetails newEntryDatetimeApp3(Boolean newEntryDatetimeApp3) {
        this.newEntryDatetimeApp3 = newEntryDatetimeApp3;
        return this;
    }

    public void setNewEntryDatetimeApp3(Boolean newEntryDatetimeApp3) {
        this.newEntryDatetimeApp3 = newEntryDatetimeApp3;
    }

    public Instant getNewExitDatetime() {
        return newExitDatetime;
    }

    public EntryExitDetails newExitDatetime(Instant newExitDatetime) {
        this.newExitDatetime = newExitDatetime;
        return this;
    }

    public void setNewExitDatetime(Instant newExitDatetime) {
        this.newExitDatetime = newExitDatetime;
    }

    public Boolean isNewExitDatetimeApp1() {
        return newExitDatetimeApp1;
    }

    public EntryExitDetails newExitDatetimeApp1(Boolean newExitDatetimeApp1) {
        this.newExitDatetimeApp1 = newExitDatetimeApp1;
        return this;
    }

    public void setNewExitDatetimeApp1(Boolean newExitDatetimeApp1) {
        this.newExitDatetimeApp1 = newExitDatetimeApp1;
    }

    public Boolean isNewExitDatetimeApp2() {
        return newExitDatetimeApp2;
    }

    public EntryExitDetails newExitDatetimeApp2(Boolean newExitDatetimeApp2) {
        this.newExitDatetimeApp2 = newExitDatetimeApp2;
        return this;
    }

    public void setNewExitDatetimeApp2(Boolean newExitDatetimeApp2) {
        this.newExitDatetimeApp2 = newExitDatetimeApp2;
    }

    public Boolean isNewExitDatetimeApp3() {
        return newExitDatetimeApp3;
    }

    public EntryExitDetails newExitDatetimeApp3(Boolean newExitDatetimeApp3) {
        this.newExitDatetimeApp3 = newExitDatetimeApp3;
        return this;
    }

    public void setNewExitDatetimeApp3(Boolean newExitDatetimeApp3) {
        this.newExitDatetimeApp3 = newExitDatetimeApp3;
    }

    public Instant getCreated() {
        return created;
    }

    public EntryExitDetails created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public EntryExitDetails modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public EntryExitDetails modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public EntryExit getEntryExit() {
        return entryExit;
    }

    public EntryExitDetails entryExit(EntryExit entryExit) {
        this.entryExit = entryExit;
        return this;
    }

    public void setEntryExit(EntryExit entryExit) {
        this.entryExit = entryExit;
    }

    public Category getEntryReason() {
        return entryReason;
    }

    public EntryExitDetails entryReason(Category category) {
        this.entryReason = category;
        return this;
    }

    public void setEntryReason(Category category) {
        this.entryReason = category;
    }

    public Terminal getEntryTerminal() {
        return entryTerminal;
    }

    public EntryExitDetails entryTerminal(Terminal terminal) {
        this.entryTerminal = terminal;
        return this;
    }

    public void setEntryTerminal(Terminal terminal) {
        this.entryTerminal = terminal;
    }

    public Category getExitReason() {
        return exitReason;
    }

    public EntryExitDetails exitReason(Category category) {
        this.exitReason = category;
        return this;
    }

    public void setExitReason(Category category) {
        this.exitReason = category;
    }

    public Terminal getExitTerminal() {
        return exitTerminal;
    }

    public EntryExitDetails exitTerminal(Terminal terminal) {
        this.exitTerminal = terminal;
        return this;
    }

    public void setExitTerminal(Terminal terminal) {
        this.exitTerminal = terminal;
    }

    public Category getNewEntryReason() {
        return newEntryReason;
    }

    public EntryExitDetails newEntryReason(Category category) {
        this.newEntryReason = category;
        return this;
    }

    public void setNewEntryReason(Category category) {
        this.newEntryReason = category;
    }

    public Category getNewExitReason() {
        return newExitReason;
    }

    public EntryExitDetails newExitReason(Category category) {
        this.newExitReason = category;
        return this;
    }

    public void setNewExitReason(Category category) {
        this.newExitReason = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitDetails)) {
            return false;
        }
        return id != null && id.equals(((EntryExitDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitDetails{" +
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
            "}";
    }
}
