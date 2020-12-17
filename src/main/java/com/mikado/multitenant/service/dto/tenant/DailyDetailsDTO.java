package com.mikado.multitenant.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.DailyDetails} entity.
 */
public class DailyDetailsDTO implements Serializable {

    private Long id;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String dayLength;

    private Double dayCount;

    private Double dayLengthh;


    private Long dailyId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayLength() {
        return dayLength;
    }

    public void setDayLength(String dayLength) {
        this.dayLength = dayLength;
    }

    public Double getDayCount() {
        return dayCount;
    }

    public void setDayCount(Double dayCount) {
        this.dayCount = dayCount;
    }

    public Double getDayLengthh() {
        return dayLengthh;
    }

    public void setDayLengthh(Double dayLengthh) {
        this.dayLengthh = dayLengthh;
    }

    public Long getDailyId() {
        return dailyId;
    }

    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
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
        if (!(o instanceof DailyDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((DailyDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyDetailsDTO{" +
            "id=" + getId() +
            ", dayLength='" + getDayLength() + "'" +
            ", dayCount=" + getDayCount() +
            ", dayLengthh=" + getDayLengthh() +
            ", dailyId=" + getDailyId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
