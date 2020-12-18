package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.MonthlyLineDetails} entity.
 */
public class MonthlyLineDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 1)
    private String addSub;

    @NotNull
    private Integer source;

    @NotNull
    private Boolean oninit;

    @NotNull
    private Boolean onnormal;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long monthlyLineId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddSub() {
        return addSub;
    }

    public void setAddSub(String addSub) {
        this.addSub = addSub;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Boolean isOninit() {
        return oninit;
    }

    public void setOninit(Boolean oninit) {
        this.oninit = oninit;
    }

    public Boolean isOnnormal() {
        return onnormal;
    }

    public void setOnnormal(Boolean onnormal) {
        this.onnormal = onnormal;
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

    public Long getMonthlyLineId() {
        return monthlyLineId;
    }

    public void setMonthlyLineId(Long monthlyLineId) {
        this.monthlyLineId = monthlyLineId;
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
        if (!(o instanceof MonthlyLineDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyLineDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyLineDetailsDTO{" +
            "id=" + getId() +
            ", addSub='" + getAddSub() + "'" +
            ", source=" + getSource() +
            ", oninit='" + isOninit() + "'" +
            ", onnormal='" + isOnnormal() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", monthlyLineId=" + getMonthlyLineId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
