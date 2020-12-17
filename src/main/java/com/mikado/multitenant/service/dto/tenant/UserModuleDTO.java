package com.mikado.multitenant.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.UserModule} entity.
 */
public class UserModuleDTO implements Serializable {

    private Long id;

    private Long masterModuleId;

    @Size(max = 80)
    private String name;

    @NotNull
    private Boolean active;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterModuleId() {
        return masterModuleId;
    }

    public void setMasterModuleId(Long masterModuleId) {
        this.masterModuleId = masterModuleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserModuleDTO)) {
            return false;
        }

        return id != null && id.equals(((UserModuleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserModuleDTO{" +
            "id=" + getId() +
            ", masterModuleId=" + getMasterModuleId() +
            ", name='" + getName() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }
}
