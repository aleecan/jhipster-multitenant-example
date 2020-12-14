package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A UserUser.
 */
@Entity
@Table(name = "user_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(name = "employee_id")
    private Long employeeId;

    @NotNull
    @Size(max = 80)
    @Column(name = "username", length = 80, nullable = false)
    private String username;

    @NotNull
    @Size(max = 255)
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "password_expiry")
    private Instant passwordExpiry;

    @NotNull
    @Size(max = 40)
    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "filter")
    private Boolean filter;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user_user", length = 80)
    private String modifiedUserUser;

    @OneToOne
    @JoinColumn(unique = true)
    private UserFilter userFilter;

    @OneToOne
    @JoinColumn(unique = true)
    private UserPermissionProfile profile;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private UserRole role;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public UserUser tenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public UserUser employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public UserUser username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public UserUser password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getPasswordExpiry() {
        return passwordExpiry;
    }

    public UserUser passwordExpiry(Instant passwordExpiry) {
        this.passwordExpiry = passwordExpiry;
        return this;
    }

    public void setPasswordExpiry(Instant passwordExpiry) {
        this.passwordExpiry = passwordExpiry;
    }

    public String getEmail() {
        return email;
    }

    public UserUser email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public UserUser isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isFilter() {
        return filter;
    }

    public UserUser filter(Boolean filter) {
        this.filter = filter;
        return this;
    }

    public void setFilter(Boolean filter) {
        this.filter = filter;
    }

    public Instant getCreated() {
        return created;
    }

    public UserUser created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public UserUser modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUserUser() {
        return modifiedUserUser;
    }

    public UserUser modifiedUserUser(String modifiedUserUser) {
        this.modifiedUserUser = modifiedUserUser;
        return this;
    }

    public void setModifiedUserUser(String modifiedUserUser) {
        this.modifiedUserUser = modifiedUserUser;
    }

    public UserPermissionProfile getProfile() {
        return profile;
    }

    public UserUser profile(UserPermissionProfile userPermissionProfile) {
        this.profile = userPermissionProfile;
        return this;
    }

    public void setProfile(UserPermissionProfile userPermissionProfile) {
        this.profile = userPermissionProfile;
    }

    public UserRole getRole() {
        return role;
    }

    public UserUser role(UserRole userRole) {
        this.role = userRole;
        return this;
    }

    public void setRole(UserRole userRole) {
        this.role = userRole;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserUser)) {
            return false;
        }
        return id != null && id.equals(((UserUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserUser{" +
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
            "}";
    }

    public UserFilter getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(UserFilter userFilter) {
        this.userFilter = userFilter;
    }
}
