package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ProcessEntryExit} entity.
 */
public class ProcessEntryExitDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    private Boolean notProcessPrevDay;

    private Boolean processMissingEntryExit;

    private Boolean processUnworkedDay;

    private Boolean findBestMatchingSchedule;

    private Boolean assignMatchingScheduleAsWaiting;

    private Boolean flexibleWeekend;

    private Boolean checkOnlyOnWeekendDay;

    private Boolean usePrevDayShiftGroup;

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

    public Boolean isNotProcessPrevDay() {
        return notProcessPrevDay;
    }

    public void setNotProcessPrevDay(Boolean notProcessPrevDay) {
        this.notProcessPrevDay = notProcessPrevDay;
    }

    public Boolean isProcessMissingEntryExit() {
        return processMissingEntryExit;
    }

    public void setProcessMissingEntryExit(Boolean processMissingEntryExit) {
        this.processMissingEntryExit = processMissingEntryExit;
    }

    public Boolean isProcessUnworkedDay() {
        return processUnworkedDay;
    }

    public void setProcessUnworkedDay(Boolean processUnworkedDay) {
        this.processUnworkedDay = processUnworkedDay;
    }

    public Boolean isFindBestMatchingSchedule() {
        return findBestMatchingSchedule;
    }

    public void setFindBestMatchingSchedule(Boolean findBestMatchingSchedule) {
        this.findBestMatchingSchedule = findBestMatchingSchedule;
    }

    public Boolean isAssignMatchingScheduleAsWaiting() {
        return assignMatchingScheduleAsWaiting;
    }

    public void setAssignMatchingScheduleAsWaiting(Boolean assignMatchingScheduleAsWaiting) {
        this.assignMatchingScheduleAsWaiting = assignMatchingScheduleAsWaiting;
    }

    public Boolean isFlexibleWeekend() {
        return flexibleWeekend;
    }

    public void setFlexibleWeekend(Boolean flexibleWeekend) {
        this.flexibleWeekend = flexibleWeekend;
    }

    public Boolean isCheckOnlyOnWeekendDay() {
        return checkOnlyOnWeekendDay;
    }

    public void setCheckOnlyOnWeekendDay(Boolean checkOnlyOnWeekendDay) {
        this.checkOnlyOnWeekendDay = checkOnlyOnWeekendDay;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
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
        if (!(o instanceof ProcessEntryExitDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessEntryExitDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessEntryExitDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", notProcessPrevDay='" + isNotProcessPrevDay() + "'" +
            ", processMissingEntryExit='" + isProcessMissingEntryExit() + "'" +
            ", processUnworkedDay='" + isProcessUnworkedDay() + "'" +
            ", findBestMatchingSchedule='" + isFindBestMatchingSchedule() + "'" +
            ", assignMatchingScheduleAsWaiting='" + isAssignMatchingScheduleAsWaiting() + "'" +
            ", flexibleWeekend='" + isFlexibleWeekend() + "'" +
            ", checkOnlyOnWeekendDay='" + isCheckOnlyOnWeekendDay() + "'" +
            ", usePrevDayShiftGroup='" + isUsePrevDayShiftGroup() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
