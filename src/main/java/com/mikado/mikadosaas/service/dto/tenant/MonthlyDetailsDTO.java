package com.mikado.mikadosaas.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.MonthlyDetails} entity.
 */
public class MonthlyDetailsDTO implements Serializable {

    private Long id;

    private Double numday;

    private Double numhour;


    private Long monthlyId;

    private Long monthlyLineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumday() {
        return numday;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Long monthlyId) {
        this.monthlyId = monthlyId;
    }

    public Long getMonthlyLineId() {
        return monthlyLineId;
    }

    public void setMonthlyLineId(Long monthlyLineId) {
        this.monthlyLineId = monthlyLineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyDetailsDTO{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            ", monthlyId=" + getMonthlyId() +
            ", monthlyLineId=" + getMonthlyLineId() +
            "}";
    }
}
