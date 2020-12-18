package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.AnnualLeaveRight} entity.
 */
public class AnnualLeaveRightDTO implements Serializable {

    private Long id;

    private Integer alYear;

    private Integer serviceYear;

    private LocalDate rightsDate;

    private Double alDay;

    @Size(max = 80)
    private String description;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlYear() {
        return alYear;
    }

    public void setAlYear(Integer alYear) {
        this.alYear = alYear;
    }

    public Integer getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
    }

    public LocalDate getRightsDate() {
        return rightsDate;
    }

    public void setRightsDate(LocalDate rightsDate) {
        this.rightsDate = rightsDate;
    }

    public Double getAlDay() {
        return alDay;
    }

    public void setAlDay(Double alDay) {
        this.alDay = alDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveRightDTO)) {
            return false;
        }

        return id != null && id.equals(((AnnualLeaveRightDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveRightDTO{" +
            "id=" + getId() +
            ", alYear=" + getAlYear() +
            ", serviceYear=" + getServiceYear() +
            ", rightsDate='" + getRightsDate() + "'" +
            ", alDay=" + getAlDay() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
