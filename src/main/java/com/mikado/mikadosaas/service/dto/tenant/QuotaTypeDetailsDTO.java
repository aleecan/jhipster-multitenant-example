package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.QuotaTypeDetails} entity.
 */
public class QuotaTypeDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 1)
    private String addSub;


    private Long quotaId;

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

    public Long getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(Long quotaTypeId) {
        this.quotaId = quotaTypeId;
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
        if (!(o instanceof QuotaTypeDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((QuotaTypeDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaTypeDetailsDTO{" +
            "id=" + getId() +
            ", addSub='" + getAddSub() + "'" +
            ", quotaId=" + getQuotaId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
