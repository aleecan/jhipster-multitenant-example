package com.mikado.mikadosaas.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.WeeklyDetails} entity.
 */
public class WeeklyDetailsDTO implements Serializable {

    private Long id;

    private Double numday;

    private Double numhour;


    private Long weeklyId;

    private Long categoryId;

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

    public Long getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Long weeklyId) {
        this.weeklyId = weeklyId;
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
        if (!(o instanceof WeeklyDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((WeeklyDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyDetailsDTO{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            ", weeklyId=" + getWeeklyId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
