package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.EmployeeHistory} entity.
 */
public class EmployeeHistoryDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private Boolean useWorkContract;

    private Double salary;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long companyFirmId;

    private Long companySubFirmId;

    private Long departmentId;

    private Long subDepartmentId;

    private Long costCenterId;

    private Long groupCodeId;

    private Long privateCodeId;

    private Long titleId;

    private Long staffId;

    private Long workContractId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean isUseWorkContract() {
        return useWorkContract;
    }

    public void setUseWorkContract(Boolean useWorkContract) {
        this.useWorkContract = useWorkContract;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Long getCompanyFirmId() {
        return companyFirmId;
    }

    public void setCompanyFirmId(Long companyFirmId) {
        this.companyFirmId = companyFirmId;
    }

    public Long getCompanySubFirmId() {
        return companySubFirmId;
    }

    public void setCompanySubFirmId(Long companySubFirmId) {
        this.companySubFirmId = companySubFirmId;
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

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public Long getGroupCodeId() {
        return groupCodeId;
    }

    public void setGroupCodeId(Long groupCodeId) {
        this.groupCodeId = groupCodeId;
    }

    public Long getPrivateCodeId() {
        return privateCodeId;
    }

    public void setPrivateCodeId(Long privateCodeId) {
        this.privateCodeId = privateCodeId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getWorkContractId() {
        return workContractId;
    }

    public void setWorkContractId(Long workContractId) {
        this.workContractId = workContractId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeHistoryDTO)) {
            return false;
        }

        return id != null && id.equals(((EmployeeHistoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeHistoryDTO{" +
            "id=" + getId() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", useWorkContract='" + isUseWorkContract() + "'" +
            ", salary=" + getSalary() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", departmentId=" + getDepartmentId() +
            ", subDepartmentId=" + getSubDepartmentId() +
            ", costCenterId=" + getCostCenterId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            ", titleId=" + getTitleId() +
            ", staffId=" + getStaffId() +
            ", workContractId=" + getWorkContractId() +
            "}";
    }
}
