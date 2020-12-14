package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ProcessHolidayLeave.
 */
@Entity
@Table(name = "process_holiday_leave")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessHolidayLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "do_not_update_old_transaction")
    private Boolean doNotUpdateOldTransaction;

    @Column(name = "use_previous_day_schedule_group")
    private Boolean usePreviousDayScheduleGroup;

    @Column(name = "check_other_day_schedule")
    private Boolean checkOtherDaySchedule;

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

    public ProcessHolidayLeave description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public ProcessHolidayLeave startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProcessHolidayLeave endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isDoNotUpdateOldTransaction() {
        return doNotUpdateOldTransaction;
    }

    public ProcessHolidayLeave doNotUpdateOldTransaction(Boolean doNotUpdateOldTransaction) {
        this.doNotUpdateOldTransaction = doNotUpdateOldTransaction;
        return this;
    }

    public void setDoNotUpdateOldTransaction(Boolean doNotUpdateOldTransaction) {
        this.doNotUpdateOldTransaction = doNotUpdateOldTransaction;
    }

    public Boolean isUsePreviousDayScheduleGroup() {
        return usePreviousDayScheduleGroup;
    }

    public ProcessHolidayLeave usePreviousDayScheduleGroup(Boolean usePreviousDayScheduleGroup) {
        this.usePreviousDayScheduleGroup = usePreviousDayScheduleGroup;
        return this;
    }

    public void setUsePreviousDayScheduleGroup(Boolean usePreviousDayScheduleGroup) {
        this.usePreviousDayScheduleGroup = usePreviousDayScheduleGroup;
    }

    public Boolean isCheckOtherDaySchedule() {
        return checkOtherDaySchedule;
    }

    public ProcessHolidayLeave checkOtherDaySchedule(Boolean checkOtherDaySchedule) {
        this.checkOtherDaySchedule = checkOtherDaySchedule;
        return this;
    }

    public void setCheckOtherDaySchedule(Boolean checkOtherDaySchedule) {
        this.checkOtherDaySchedule = checkOtherDaySchedule;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessHolidayLeave)) {
            return false;
        }
        return id != null && id.equals(((ProcessHolidayLeave) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessHolidayLeave{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", doNotUpdateOldTransaction='" + isDoNotUpdateOldTransaction() + "'" +
            ", usePreviousDayScheduleGroup='" + isUsePreviousDayScheduleGroup() + "'" +
            ", checkOtherDaySchedule='" + isCheckOtherDaySchedule() + "'" +
            "}";
    }
}
