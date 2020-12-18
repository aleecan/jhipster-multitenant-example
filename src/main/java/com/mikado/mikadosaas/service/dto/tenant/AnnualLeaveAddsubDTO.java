package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.AnnualLeaveAddsub} entity.
 */
public class AnnualLeaveAddsubDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate firstDate;

    private LocalDate lastDate;

    @NotNull
    private Integer numday;

    @NotNull
    private Integer alYear;

    @NotNull
    @Size(max = 1)
    private String addSub;

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

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getNumday() {
        return numday;
    }

    public void setNumday(Integer numday) {
        this.numday = numday;
    }

    public Integer getAlYear() {
        return alYear;
    }

    public void setAlYear(Integer alYear) {
        this.alYear = alYear;
    }

    public String getAddSub() {
        return addSub;
    }

    public void setAddSub(String addSub) {
        this.addSub = addSub;
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
        if (!(o instanceof AnnualLeaveAddsubDTO)) {
            return false;
        }

        return id != null && id.equals(((AnnualLeaveAddsubDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveAddsubDTO{" +
            "id=" + getId() +
            ", firstDate='" + getFirstDate() + "'" +
            ", lastDate='" + getLastDate() + "'" +
            ", numday=" + getNumday() +
            ", alYear=" + getAlYear() +
            ", addSub='" + getAddSub() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
