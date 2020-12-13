package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A QuotaBalance.
 */
@Entity
@Table(name = "quota_balance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QuotaBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_count")
    private Double totalCount;

    @Column(name = "total_hour")
    private Double totalHour;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaBalances", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaBalances", allowSetters = true)
    private QuotaType quotaType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalCount() {
        return totalCount;
    }

    public QuotaBalance totalCount(Double totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public void setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public QuotaBalance totalHour(Double totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Employee getEmployee() {
        return employee;
    }

    public QuotaBalance employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public QuotaType getQuotaType() {
        return quotaType;
    }

    public QuotaBalance quotaType(QuotaType quotaType) {
        this.quotaType = quotaType;
        return this;
    }

    public void setQuotaType(QuotaType quotaType) {
        this.quotaType = quotaType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuotaBalance)) {
            return false;
        }
        return id != null && id.equals(((QuotaBalance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaBalance{" +
            "id=" + getId() +
            ", totalCount=" + getTotalCount() +
            ", totalHour=" + getTotalHour() +
            "}";
    }
}
