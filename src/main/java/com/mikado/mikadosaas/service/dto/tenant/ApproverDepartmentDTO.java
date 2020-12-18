package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ApproverDepartment} entity.
 */
public class ApproverDepartmentDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer approveLevel;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long departmentId;

    private Long subDepartmentId;

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getSubDepartmentId() {
        return subDepartmentId;
    }

    public void setSubDepartmentId(Long subDepartmentId) {
        this.subDepartmentId = subDepartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApproverDepartmentDTO)) {
            return false;
        }

        return id != null && id.equals(((ApproverDepartmentDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApproverDepartmentDTO{" +
            "id=" + getId() +
            ", approveLevel=" + getApproveLevel() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", departmentId=" + getDepartmentId() +
            ", subDepartmentId=" + getSubDepartmentId() +
            "}";
    }
}
