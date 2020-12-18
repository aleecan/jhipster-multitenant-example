package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A UserModule.
 */
@Entity
@Table(name = "user_module")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "master_module_id")
    private Long masterModuleId;

    @Size(max = 80)
    @Column(name = "name", length = 80)
    private String name;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterModuleId() {
        return masterModuleId;
    }

    public UserModule masterModuleId(Long masterModuleId) {
        this.masterModuleId = masterModuleId;
        return this;
    }

    public void setMasterModuleId(Long masterModuleId) {
        this.masterModuleId = masterModuleId;
    }

    public String getName() {
        return name;
    }

    public UserModule name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isActive() {
        return active;
    }

    public UserModule active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserModule)) {
            return false;
        }
        return id != null && id.equals(((UserModule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserModule{" +
            "id=" + getId() +
            ", masterModuleId=" + getMasterModuleId() +
            ", name='" + getName() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }
}
