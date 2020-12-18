package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.TimezoneCalendar} entity.
 */
public class TimezoneCalendarDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer dateYear;


    @Lob
    private String days;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimezoneCalendarDTO)) {
            return false;
        }

        return id != null && id.equals(((TimezoneCalendarDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimezoneCalendarDTO{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", days='" + getDays() + "'" +
            "}";
    }
}
