package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Additional} entity.
 */
public class AdditionalDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String addTime;

    private Boolean addDay;

    private Boolean addNaHour;

    private Integer addingStatus;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long additionalGroupId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean isAddDay() {
        return addDay;
    }

    public void setAddDay(Boolean addDay) {
        this.addDay = addDay;
    }

    public Boolean isAddNaHour() {
        return addNaHour;
    }

    public void setAddNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
    }

    public Integer getAddingStatus() {
        return addingStatus;
    }

    public void setAddingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
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

    public Long getAdditionalGroupId() {
        return additionalGroupId;
    }

    public void setAdditionalGroupId(Long additionalGroupId) {
        this.additionalGroupId = additionalGroupId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdditionalDTO)) {
            return false;
        }

        return id != null && id.equals(((AdditionalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AdditionalDTO{" +
            "id=" + getId() +
            ", addTime='" + getAddTime() + "'" +
            ", addDay='" + isAddDay() + "'" +
            ", addNaHour='" + isAddNaHour() + "'" +
            ", addingStatus=" + getAddingStatus() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", additionalGroupId=" + getAdditionalGroupId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
