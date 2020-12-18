package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.UserUser} entity.
 */
public class UserUserDTO implements Serializable {

    private Long id;

    @NotNull
    private Long tenantId;

    private Long employeeId;

    @NotNull
    @Size(max = 80)
    private String username;

    @NotNull
    @Size(max = 255)
    private String password;

    private Instant passwordExpiry;

    @NotNull
    @Size(max = 40)
    private String email;

    private Boolean isActive;

    private Boolean filter;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUserUser;


    private Long filterId;

    private Long profileId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getPasswordExpiry() {
        return passwordExpiry;
    }

    public void setPasswordExpiry(Instant passwordExpiry) {
        this.passwordExpiry = passwordExpiry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isFilter() {
        return filter;
    }

    public void setFilter(Boolean filter) {
        this.filter = filter;
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

    public String getModifiedUserUser() {
        return modifiedUserUser;
    }

    public void setModifiedUserUser(String modifiedUserUser) {
        this.modifiedUserUser = modifiedUserUser;
    }

    public Long getFilterId() {
        return filterId;
    }

    public void setFilterId(Long userFilterId) {
        this.filterId = userFilterId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long userPermissionProfileId) {
        this.profileId = userPermissionProfileId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long userRoleId) {
        this.roleId = userRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserUserDTO)) {
            return false;
        }

        return id != null && id.equals(((UserUserDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserUserDTO{" +
            "id=" + getId() +
            ", tenantId=" + getTenantId() +
            ", employeeId=" + getEmployeeId() +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", passwordExpiry='" + getPasswordExpiry() + "'" +
            ", email='" + getEmail() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", filter='" + isFilter() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUserUser='" + getModifiedUserUser() + "'" +
            ", filterId=" + getFilterId() +
            ", profileId=" + getProfileId() +
            ", roleId=" + getRoleId() +
            "}";
    }
}
