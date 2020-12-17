package com.mikado.multitenant.service.dto.tenant;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.VwScheduleChange} entity.
 */
@ApiModel(description = "VIEW")
public class VwScheduleChangeDTO implements Serializable {

    private Long id;

    @NotNull
    private Long employeeId;

    @NotNull
    private LocalDate daydate;

    @NotNull
    private Long scheduleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
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
        if (!(o instanceof VwScheduleChangeDTO)) {
            return false;
        }

        return id != null && id.equals(((VwScheduleChangeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VwScheduleChangeDTO{" +
            "id=" + getId() +
            ", employeeId=" + getEmployeeId() +
            ", daydate='" + getDaydate() + "'" +
            ", scheduleId=" + getScheduleId() +
            "}";
    }
}
