package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.QuotaBalance} entity.
 */
public class QuotaBalanceDTO implements Serializable {

    private Long id;

    private Double totalCount;

    private Double totalHour;


    private Long employeeId;

    private Long quotaTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getQuotaTypeId() {
        return quotaTypeId;
    }

    public void setQuotaTypeId(Long quotaTypeId) {
        this.quotaTypeId = quotaTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuotaBalanceDTO)) {
            return false;
        }

        return id != null && id.equals(((QuotaBalanceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaBalanceDTO{" +
            "id=" + getId() +
            ", totalCount=" + getTotalCount() +
            ", totalHour=" + getTotalHour() +
            ", employeeId=" + getEmployeeId() +
            ", quotaTypeId=" + getQuotaTypeId() +
            "}";
    }
}
