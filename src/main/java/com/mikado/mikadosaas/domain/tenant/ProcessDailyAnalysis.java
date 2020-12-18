package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ProcessDailyAnalysis.
 */
@Entity
@Table(name = "process_daily_analysis")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessDailyAnalysis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "run_for_all_employee")
    private Boolean runForAllEmployee;

    @Column(name = "apply_tolerances")
    private Boolean applyTolerances;

    @Column(name = "check_early_entry_late_exit")
    private Boolean checkEarlyEntryLateExit;

    @Column(name = "check_late_entry_early_exit")
    private Boolean checkLateEntryEarlyExit;

    @Column(name = "apply_tolerance_first_entry_last_exit")
    private Boolean applyToleranceFirstEntryLastExit;

    @Column(name = "check_prev_and_next_day_schedule")
    private Boolean checkPrevAndNextDaySchedule;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

    @Column(name = "use_first_entry_last_exit")
    private Boolean useFirstEntryLastExit;

    @Column(name = "complete_work_when_missing_entry_exit")
    private Boolean completeWorkWhenMissingEntryExit;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public ProcessDailyAnalysis description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRunForAllEmployee() {
        return runForAllEmployee;
    }

    public ProcessDailyAnalysis runForAllEmployee(Boolean runForAllEmployee) {
        this.runForAllEmployee = runForAllEmployee;
        return this;
    }

    public void setRunForAllEmployee(Boolean runForAllEmployee) {
        this.runForAllEmployee = runForAllEmployee;
    }

    public Boolean isApplyTolerances() {
        return applyTolerances;
    }

    public ProcessDailyAnalysis applyTolerances(Boolean applyTolerances) {
        this.applyTolerances = applyTolerances;
        return this;
    }

    public void setApplyTolerances(Boolean applyTolerances) {
        this.applyTolerances = applyTolerances;
    }

    public Boolean isCheckEarlyEntryLateExit() {
        return checkEarlyEntryLateExit;
    }

    public ProcessDailyAnalysis checkEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
        return this;
    }

    public void setCheckEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
    }

    public Boolean isCheckLateEntryEarlyExit() {
        return checkLateEntryEarlyExit;
    }

    public ProcessDailyAnalysis checkLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
        return this;
    }

    public void setCheckLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
    }

    public Boolean isApplyToleranceFirstEntryLastExit() {
        return applyToleranceFirstEntryLastExit;
    }

    public ProcessDailyAnalysis applyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
        return this;
    }

    public void setApplyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
    }

    public Boolean isCheckPrevAndNextDaySchedule() {
        return checkPrevAndNextDaySchedule;
    }

    public ProcessDailyAnalysis checkPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
        return this;
    }

    public void setCheckPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public ProcessDailyAnalysis usePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
        return this;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
    }

    public Boolean isUseFirstEntryLastExit() {
        return useFirstEntryLastExit;
    }

    public ProcessDailyAnalysis useFirstEntryLastExit(Boolean useFirstEntryLastExit) {
        this.useFirstEntryLastExit = useFirstEntryLastExit;
        return this;
    }

    public void setUseFirstEntryLastExit(Boolean useFirstEntryLastExit) {
        this.useFirstEntryLastExit = useFirstEntryLastExit;
    }

    public Boolean isCompleteWorkWhenMissingEntryExit() {
        return completeWorkWhenMissingEntryExit;
    }

    public ProcessDailyAnalysis completeWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
        return this;
    }

    public void setCompleteWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
    }

    public Instant getCreated() {
        return created;
    }

    public ProcessDailyAnalysis created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ProcessDailyAnalysis modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ProcessDailyAnalysis modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessDailyAnalysis)) {
            return false;
        }
        return id != null && id.equals(((ProcessDailyAnalysis) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessDailyAnalysis{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", runForAllEmployee='" + isRunForAllEmployee() + "'" +
            ", applyTolerances='" + isApplyTolerances() + "'" +
            ", checkEarlyEntryLateExit='" + isCheckEarlyEntryLateExit() + "'" +
            ", checkLateEntryEarlyExit='" + isCheckLateEntryEarlyExit() + "'" +
            ", applyToleranceFirstEntryLastExit='" + isApplyToleranceFirstEntryLastExit() + "'" +
            ", checkPrevAndNextDaySchedule='" + isCheckPrevAndNextDaySchedule() + "'" +
            ", usePrevDayShiftGroup='" + isUsePrevDayShiftGroup() + "'" +
            ", useFirstEntryLastExit='" + isUseFirstEntryLastExit() + "'" +
            ", completeWorkWhenMissingEntryExit='" + isCompleteWorkWhenMissingEntryExit() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
