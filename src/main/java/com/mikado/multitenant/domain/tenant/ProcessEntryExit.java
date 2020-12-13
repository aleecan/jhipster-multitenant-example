package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ProcessEntryExit.
 */
@Entity
@Table(name = "process_entry_exit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessEntryExit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "not_process_prev_day")
    private Boolean notProcessPrevDay;

    @Column(name = "process_missing_entry_exit")
    private Boolean processMissingEntryExit;

    @Column(name = "process_unworked_day")
    private Boolean processUnworkedDay;

    @Column(name = "find_best_matching_schedule")
    private Boolean findBestMatchingSchedule;

    @Column(name = "assign_matching_schedule_as_waiting")
    private Boolean assignMatchingScheduleAsWaiting;

    @Column(name = "flexible_weekend")
    private Boolean flexibleWeekend;

    @Column(name = "check_only_on_weekend_day")
    private Boolean checkOnlyOnWeekendDay;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

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

    public ProcessEntryExit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isNotProcessPrevDay() {
        return notProcessPrevDay;
    }

    public ProcessEntryExit notProcessPrevDay(Boolean notProcessPrevDay) {
        this.notProcessPrevDay = notProcessPrevDay;
        return this;
    }

    public void setNotProcessPrevDay(Boolean notProcessPrevDay) {
        this.notProcessPrevDay = notProcessPrevDay;
    }

    public Boolean isProcessMissingEntryExit() {
        return processMissingEntryExit;
    }

    public ProcessEntryExit processMissingEntryExit(Boolean processMissingEntryExit) {
        this.processMissingEntryExit = processMissingEntryExit;
        return this;
    }

    public void setProcessMissingEntryExit(Boolean processMissingEntryExit) {
        this.processMissingEntryExit = processMissingEntryExit;
    }

    public Boolean isProcessUnworkedDay() {
        return processUnworkedDay;
    }

    public ProcessEntryExit processUnworkedDay(Boolean processUnworkedDay) {
        this.processUnworkedDay = processUnworkedDay;
        return this;
    }

    public void setProcessUnworkedDay(Boolean processUnworkedDay) {
        this.processUnworkedDay = processUnworkedDay;
    }

    public Boolean isFindBestMatchingSchedule() {
        return findBestMatchingSchedule;
    }

    public ProcessEntryExit findBestMatchingSchedule(Boolean findBestMatchingSchedule) {
        this.findBestMatchingSchedule = findBestMatchingSchedule;
        return this;
    }

    public void setFindBestMatchingSchedule(Boolean findBestMatchingSchedule) {
        this.findBestMatchingSchedule = findBestMatchingSchedule;
    }

    public Boolean isAssignMatchingScheduleAsWaiting() {
        return assignMatchingScheduleAsWaiting;
    }

    public ProcessEntryExit assignMatchingScheduleAsWaiting(Boolean assignMatchingScheduleAsWaiting) {
        this.assignMatchingScheduleAsWaiting = assignMatchingScheduleAsWaiting;
        return this;
    }

    public void setAssignMatchingScheduleAsWaiting(Boolean assignMatchingScheduleAsWaiting) {
        this.assignMatchingScheduleAsWaiting = assignMatchingScheduleAsWaiting;
    }

    public Boolean isFlexibleWeekend() {
        return flexibleWeekend;
    }

    public ProcessEntryExit flexibleWeekend(Boolean flexibleWeekend) {
        this.flexibleWeekend = flexibleWeekend;
        return this;
    }

    public void setFlexibleWeekend(Boolean flexibleWeekend) {
        this.flexibleWeekend = flexibleWeekend;
    }

    public Boolean isCheckOnlyOnWeekendDay() {
        return checkOnlyOnWeekendDay;
    }

    public ProcessEntryExit checkOnlyOnWeekendDay(Boolean checkOnlyOnWeekendDay) {
        this.checkOnlyOnWeekendDay = checkOnlyOnWeekendDay;
        return this;
    }

    public void setCheckOnlyOnWeekendDay(Boolean checkOnlyOnWeekendDay) {
        this.checkOnlyOnWeekendDay = checkOnlyOnWeekendDay;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public ProcessEntryExit usePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
        return this;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
    }

    public Instant getCreated() {
        return created;
    }

    public ProcessEntryExit created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ProcessEntryExit modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ProcessEntryExit modifiedUser(String modifiedUser) {
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
        if (!(o instanceof ProcessEntryExit)) {
            return false;
        }
        return id != null && id.equals(((ProcessEntryExit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessEntryExit{" +
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
