package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ApproverCostCenter} entity.
 */
public class ApproverCostCenterDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer approveLevel;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long costCenterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApproveLevel() {
        return approveLevel;
    }

    public void setApproveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
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

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApproverCostCenterDTO)) {
            return false;
        }

        return id != null && id.equals(((ApproverCostCenterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApproverCostCenterDTO{" +
            "id=" + getId() +
            ", approveLevel=" + getApproveLevel() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", costCenterId=" + getCostCenterId() +
            "}";
    }
}
