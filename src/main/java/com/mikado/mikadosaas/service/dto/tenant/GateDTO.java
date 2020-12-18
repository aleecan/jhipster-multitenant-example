package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Gate} entity.
 */
public class GateDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 6)
    private String code;

    @NotNull
    @Size(max = 80)
    private String description;

    private Integer accessStatus;

    private Boolean timekeeping;

    private Boolean useRdCompany;


    private Long companyFirmId;

    private Long companySubFirmId;

    private Long groupCodeId;

    private Long privateCodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isUseRdCompany() {
        return useRdCompany;
    }

    public void setUseRdCompany(Boolean useRdCompany) {
        this.useRdCompany = useRdCompany;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GateDTO)) {
            return false;
        }

        return id != null && id.equals(((GateDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GateDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", accessStatus=" + getAccessStatus() +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", useRdCompany='" + isUseRdCompany() + "'" +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            "}";
    }
}
