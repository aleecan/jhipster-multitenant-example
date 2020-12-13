package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A AuthorizationGroup.
 */
@Entity
@Table(name = "authorization_group")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AuthorizationGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "timekeeping")
    private Boolean timekeeping;

    @Column(name = "default_employee")
    private Boolean defaultEmployee;

    @Column(name = "default_external")
    private Boolean defaultExternal;

    @Column(name = "default_other")
    private Boolean defaultOther;

    @Column(name = "default_visitor")
    private Boolean defaultVisitor;

    @Column(name = "available_reception")
    private Boolean availableReception;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public AuthorizationGroup code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public AuthorizationGroup description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public AuthorizationGroup timekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isDefaultEmployee() {
        return defaultEmployee;
    }

    public AuthorizationGroup defaultEmployee(Boolean defaultEmployee) {
        this.defaultEmployee = defaultEmployee;
        return this;
    }

    public void setDefaultEmployee(Boolean defaultEmployee) {
        this.defaultEmployee = defaultEmployee;
    }

    public Boolean isDefaultExternal() {
        return defaultExternal;
    }

    public AuthorizationGroup defaultExternal(Boolean defaultExternal) {
        this.defaultExternal = defaultExternal;
        return this;
    }

    public void setDefaultExternal(Boolean defaultExternal) {
        this.defaultExternal = defaultExternal;
    }

    public Boolean isDefaultOther() {
        return defaultOther;
    }

    public AuthorizationGroup defaultOther(Boolean defaultOther) {
        this.defaultOther = defaultOther;
        return this;
    }

    public void setDefaultOther(Boolean defaultOther) {
        this.defaultOther = defaultOther;
    }

    public Boolean isDefaultVisitor() {
        return defaultVisitor;
    }

    public AuthorizationGroup defaultVisitor(Boolean defaultVisitor) {
        this.defaultVisitor = defaultVisitor;
        return this;
    }

    public void setDefaultVisitor(Boolean defaultVisitor) {
        this.defaultVisitor = defaultVisitor;
    }

    public Boolean isAvailableReception() {
        return availableReception;
    }

    public AuthorizationGroup availableReception(Boolean availableReception) {
        this.availableReception = availableReception;
        return this;
    }

    public void setAvailableReception(Boolean availableReception) {
        this.availableReception = availableReception;
    }

    public Instant getCreated() {
        return created;
    }

    public AuthorizationGroup created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public AuthorizationGroup modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public AuthorizationGroup modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthorizationGroup)) {
            return false;
        }
        return id != null && id.equals(((AuthorizationGroup) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthorizationGroup{" +
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
