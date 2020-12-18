package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.AuthorizationGroup} entity.
 */
public class AuthorizationGroupDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 10)
    private String code;

    @Size(max = 80)
    private String description;

    private Boolean timekeeping;

    private Boolean defaultEmployee;

    private Boolean defaultExternal;

    private Boolean defaultOther;

    private Boolean defaultVisitor;

    private Boolean availableReception;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


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

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isDefaultEmployee() {
        return defaultEmployee;
    }

    public void setDefaultEmployee(Boolean defaultEmployee) {
        this.defaultEmployee = defaultEmployee;
    }

    public Boolean isDefaultExternal() {
        return defaultExternal;
    }

    public void setDefaultExternal(Boolean defaultExternal) {
        this.defaultExternal = defaultExternal;
    }

    public Boolean isDefaultOther() {
        return defaultOther;
    }

    public void setDefaultOther(Boolean defaultOther) {
        this.defaultOther = defaultOther;
    }

    public Boolean isDefaultVisitor() {
        return defaultVisitor;
    }

    public void setDefaultVisitor(Boolean defaultVisitor) {
        this.defaultVisitor = defaultVisitor;
    }

    public Boolean isAvailableReception() {
        return availableReception;
    }

    public void setAvailableReception(Boolean availableReception) {
        this.availableReception = availableReception;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthorizationGroupDTO)) {
            return false;
        }

        return id != null && id.equals(((AuthorizationGroupDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthorizationGroupDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", defaultEmployee='" + isDefaultEmployee() + "'" +
            ", defaultExternal='" + isDefaultExternal() + "'" +
            ", defaultOther='" + isDefaultOther() + "'" +
            ", defaultVisitor='" + isDefaultVisitor() + "'" +
            ", availableReception='" + isAvailableReception() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
