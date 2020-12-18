package com.mikado.mikadosaas.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.QuotaBalanceDetails} entity.
 */
public class QuotaBalanceDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    private Double dayCount;

    private Double dayLenthh;


    private Long quotaBalanceId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Double getDayCount() {
        return dayCount;
    }

    public void setDayCount(Double dayCount) {
        this.dayCount = dayCount;
    }

    public Double getDayLenthh() {
        return dayLenthh;
    }

    public void setDayLenthh(Double dayLenthh) {
        this.dayLenthh = dayLenthh;
    }

    public Long getQuotaBalanceId() {
        return quotaBalanceId;
    }

    public void setQuotaBalanceId(Long quotaBalanceId) {
        this.quotaBalanceId = quotaBalanceId;
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
        if (!(o instanceof QuotaBalanceDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((QuotaBalanceDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaBalanceDetailsDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", dayCount=" + getDayCount() +
            ", dayLenthh=" + getDayLenthh() +
            ", quotaBalanceId=" + getQuotaBalanceId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
