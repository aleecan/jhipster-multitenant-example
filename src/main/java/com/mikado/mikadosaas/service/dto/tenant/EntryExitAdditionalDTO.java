package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.EntryExitAdditional} entity.
 */
public class EntryExitAdditionalDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String addTime;

    private Boolean addDay;

    private Boolean addNaHour;

    private Integer addingStatus;

    @NotNull
    private Long taskId;

    private Boolean manual;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean isAddDay() {
        return addDay;
    }

    public void setAddDay(Boolean addDay) {
        this.addDay = addDay;
    }

    public Boolean isAddNaHour() {
        return addNaHour;
    }

    public void setAddNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
    }

    public Integer getAddingStatus() {
        return addingStatus;
    }

    public void setAddingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Boolean isManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitAdditionalDTO)) {
            return false;
        }

        return id != null && id.equals(((EntryExitAdditionalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitAdditionalDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", addTime='" + getAddTime() + "'" +
            ", addDay='" + isAddDay() + "'" +
            ", addNaHour='" + isAddNaHour() + "'" +
            ", addingStatus=" + getAddingStatus() +
            ", taskId=" + getTaskId() +
            ", manual='" + isManual() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
