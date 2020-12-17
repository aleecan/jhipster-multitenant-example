package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.AnnualLeaveGroupDetails} entity.
 */
public class AnnualLeaveGroupDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer workedYear;

    @NotNull
    private Integer earnedDay;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long annualLeaveGroupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkedYear() {
        return workedYear;
    }

    public void setWorkedYear(Integer workedYear) {
        this.workedYear = workedYear;
    }

    public Integer getEarnedDay() {
        return earnedDay;
    }

    public void setEarnedDay(Integer earnedDay) {
        this.earnedDay = earnedDay;
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

    public Long getAnnualLeaveGroupId() {
        return annualLeaveGroupId;
    }

    public void setAnnualLeaveGroupId(Long annualLeaveGroupId) {
        this.annualLeaveGroupId = annualLeaveGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveGroupDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((AnnualLeaveGroupDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveGroupDetailsDTO{" +
            "id=" + getId() +
            ", workedYear=" + getWorkedYear() +
            ", earnedDay=" + getEarnedDay() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", annualLeaveGroupId=" + getAnnualLeaveGroupId() +
            "}";
    }
}
