package com.mikado.multitenant.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.TimezoneDay} entity.
 */
public class TimezoneDayDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    @Size(max = 15)
    private String color;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimezoneDayDTO)) {
            return false;
        }

        return id != null && id.equals(((TimezoneDayDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimezoneDayDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", color='" + getColor() + "'" +
            "}";
    }
}
