package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.CompanySubFirm} entity.
 */
public class CompanySubFirmDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 10)
    private String code;

    @Size(max = 80)
    private String description;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long companyFirmId;

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

    public Long getCompanyFirmId() {
        return companyFirmId;
    }

    public void setCompanyFirmId(Long companyFirmId) {
        this.companyFirmId = companyFirmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompanySubFirmDTO)) {
            return false;
        }

        return id != null && id.equals(((CompanySubFirmDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompanySubFirmDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", companyFirmId=" + getCompanyFirmId() +
            "}";
    }
}
