package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ProcessDailyAnalysis} entity.
 */
public class ProcessDailyAnalysisDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    private Boolean runForAllEmployee;

    private Boolean applyTolerances;

    private Boolean checkEarlyEntryLateExit;

    private Boolean checkLateEntryEarlyExit;

    private Boolean applyToleranceFirstEntryLastExit;

    private Boolean checkPrevAndNextDaySchedule;

    private Boolean usePrevDayShiftGroup;

    private Boolean useFirstEntryLastExit;

    private Boolean completeWorkWhenMissingEntryExit;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRunForAllEmployee() {
        return runForAllEmployee;
    }

    public void setRunForAllEmployee(Boolean runForAllEmployee) {
        this.runForAllEmployee = runForAllEmployee;
    }

    public Boolean isApplyTolerances() {
        return applyTolerances;
    }

    public void setApplyTolerances(Boolean applyTolerances) {
        this.applyTolerances = applyTolerances;
    }

    public Boolean isCheckEarlyEntryLateExit() {
        return checkEarlyEntryLateExit;
    }

    public void setCheckEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
    }

    public Boolean isCheckLateEntryEarlyExit() {
        return checkLateEntryEarlyExit;
    }

    public void setCheckLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
    }

    public Boolean isApplyToleranceFirstEntryLastExit() {
        return applyToleranceFirstEntryLastExit;
    }

    public void setApplyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
    }

    public Boolean isCheckPrevAndNextDaySchedule() {
        return checkPrevAndNextDaySchedule;
    }

    public void setCheckPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
    }

    public Boolean isUseFirstEntryLastExit() {
        return useFirstEntryLastExit;
    }

    public void setUseFirstEntryLastExit(Boolean useFirstEntryLastExit) {
        this.useFirstEntryLastExit = useFirstEntryLastExit;
    }

    public Boolean isCompleteWorkWhenMissingEntryExit() {
        return completeWorkWhenMissingEntryExit;
    }

    public void setCompleteWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessDailyAnalysisDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessDailyAnalysisDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessDailyAnalysisDTO{" +
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
