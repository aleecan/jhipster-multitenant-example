package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.TimezoneRights} entity.
 */
public class TimezoneRightsDTO implements Serializable {

    private Long id;

    @Size(max = 96)
    private String timezoneRight;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long timezoneId;

    private Long timezoneDayId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimezoneRight() {
        return timezoneRight;
    }

    public void setTimezoneRight(String timezoneRight) {
        this.timezoneRight = timezoneRight;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Long timezoneId) {
        this.timezoneId = timezoneId;
    }

    public Long getTimezoneDayId() {
        return timezoneDayId;
    }

    public void setTimezoneDayId(Long timezoneDayId) {
        this.timezoneDayId = timezoneDayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimezoneRightsDTO)) {
            return false;
        }

        return id != null && id.equals(((TimezoneRightsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimezoneRightsDTO{" +
            "id=" + getId() +
            ", timezoneRight='" + getTimezoneRight() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", timezoneId=" + getTimezoneId() +
            ", timezoneDayId=" + getTimezoneDayId() +
            "}";
    }
}
