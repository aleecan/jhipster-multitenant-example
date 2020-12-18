package com.mikado.mikadosaas.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ProcessHolidayLeave} entity.
 */
public class ProcessHolidayLeaveDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean doNotUpdateOldTransaction;

    private Boolean usePreviousDayScheduleGroup;

    private Boolean checkOtherDaySchedule;


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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isDoNotUpdateOldTransaction() {
        return doNotUpdateOldTransaction;
    }

    public void setDoNotUpdateOldTransaction(Boolean doNotUpdateOldTransaction) {
        this.doNotUpdateOldTransaction = doNotUpdateOldTransaction;
    }

    public Boolean isUsePreviousDayScheduleGroup() {
        return usePreviousDayScheduleGroup;
    }

    public void setUsePreviousDayScheduleGroup(Boolean usePreviousDayScheduleGroup) {
        this.usePreviousDayScheduleGroup = usePreviousDayScheduleGroup;
    }

    public Boolean isCheckOtherDaySchedule() {
        return checkOtherDaySchedule;
    }

    public void setCheckOtherDaySchedule(Boolean checkOtherDaySchedule) {
        this.checkOtherDaySchedule = checkOtherDaySchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessHolidayLeaveDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessHolidayLeaveDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessHolidayLeaveDTO{" +
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
