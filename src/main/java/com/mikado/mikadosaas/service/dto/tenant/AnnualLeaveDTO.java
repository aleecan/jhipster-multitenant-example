package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.AnnualLeave} entity.
 */
public class AnnualLeaveDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate leaveDate;

    private LocalDate returnDate;

    private Double paid;

    private Double dayOff;

    private Double holiday;

    private Double travel;

    private Double military;

    private Boolean isUsed;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long scheduleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getDayOff() {
        return dayOff;
    }

    public void setDayOff(Double dayOff) {
        this.dayOff = dayOff;
    }

    public Double getHoliday() {
        return holiday;
    }

    public void setHoliday(Double holiday) {
        this.holiday = holiday;
    }

    public Double getTravel() {
        return travel;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public Double getMilitary() {
        return military;
    }

    public void setMilitary(Double military) {
        this.military = military;
    }

    public Boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveDTO)) {
            return false;
        }

        return id != null && id.equals(((AnnualLeaveDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveDTO{" +
            "id=" + getId() +
            ", leaveDate='" + getLeaveDate() + "'" +
            ", returnDate='" + getReturnDate() + "'" +
            ", paid=" + getPaid() +
            ", dayOff=" + getDayOff() +
            ", holiday=" + getHoliday() +
            ", travel=" + getTravel() +
            ", military=" + getMilitary() +
            ", isUsed='" + isIsUsed() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", scheduleId=" + getScheduleId() +
            "}";
    }
}
