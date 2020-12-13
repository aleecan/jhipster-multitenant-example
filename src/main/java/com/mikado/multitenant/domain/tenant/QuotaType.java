package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A QuotaType.
 */
@Entity
@Table(name = "quota_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QuotaType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "code", length = 80, nullable = false)
    private String code;

    @NotNull
    @Column(name = "hour_control", nullable = false)
    private Boolean hourControl;

    @NotNull
    @Column(name = "control_min", nullable = false)
    private Double controlMin;

    @NotNull
    @Column(name = "control_max", nullable = false)
    private Double controlMax;

    @Column(name = "total_count")
    private Integer totalCount;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaTypes", allowSetters = true)
    private Category transferCategory;

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

    public QuotaType code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean isHourControl() {
        return hourControl;
    }

    public QuotaType hourControl(Boolean hourControl) {
        this.hourControl = hourControl;
        return this;
    }

    public void setHourControl(Boolean hourControl) {
        this.hourControl = hourControl;
    }

    public Double getControlMin() {
        return controlMin;
    }

    public QuotaType controlMin(Double controlMin) {
        this.controlMin = controlMin;
        return this;
    }

    public void setControlMin(Double controlMin) {
        this.controlMin = controlMin;
    }

    public Double getControlMax() {
        return controlMax;
    }

    public QuotaType controlMax(Double controlMax) {
        this.controlMax = controlMax;
        return this;
    }

    public void setControlMax(Double controlMax) {
        this.controlMax = controlMax;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public QuotaType totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Category getTransferCategory() {
        return transferCategory;
    }

    public QuotaType transferCategory(Category category) {
        this.transferCategory = category;
        return this;
    }

    public void setTransferCategory(Category category) {
        this.transferCategory = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuotaType)) {
            return false;
        }
        return id != null && id.equals(((QuotaType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaType{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", hourControl='" + isHourControl() + "'" +
            ", controlMin=" + getControlMin() +
            ", controlMax=" + getControlMax() +
            ", totalCount=" + getTotalCount() +
            "}";
    }
}
