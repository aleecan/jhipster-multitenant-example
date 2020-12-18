package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.QuotaType} entity.
 */
public class QuotaTypeDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String code;

    @NotNull
    private Boolean hourControl;

    @NotNull
    private Double controlMin;

    @NotNull
    private Double controlMax;

    private Integer totalCount;


    private Long transferCategoryId;

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

    public Boolean isHourControl() {
        return hourControl;
    }

    public void setHourControl(Boolean hourControl) {
        this.hourControl = hourControl;
    }

    public Double getControlMin() {
        return controlMin;
    }

    public void setControlMin(Double controlMin) {
        this.controlMin = controlMin;
    }

    public Double getControlMax() {
        return controlMax;
    }

    public void setControlMax(Double controlMax) {
        this.controlMax = controlMax;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTransferCategoryId() {
        return transferCategoryId;
    }

    public void setTransferCategoryId(Long categoryId) {
        this.transferCategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuotaTypeDTO)) {
            return false;
        }

        return id != null && id.equals(((QuotaTypeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaTypeDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", hourControl='" + isHourControl() + "'" +
            ", controlMin=" + getControlMin() +
            ", controlMax=" + getControlMax() +
            ", totalCount=" + getTotalCount() +
            ", transferCategoryId=" + getTransferCategoryId() +
            "}";
    }
}
