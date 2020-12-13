package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.CalendarHoliday} entity.
 */
public class CalendarHolidayDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    @Size(max = 80)
    private String description;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long calendarScheduleId;

    private Long holidayScheduleId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getCalendarScheduleId() {
        return calendarScheduleId;
    }

    public void setCalendarScheduleId(Long scheduleId) {
        this.calendarScheduleId = scheduleId;
    }

    public Long getHolidayScheduleId() {
        return holidayScheduleId;
    }

    public void setHolidayScheduleId(Long scheduleId) {
        this.holidayScheduleId = scheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarHolidayDTO)) {
            return false;
        }

        return id != null && id.equals(((CalendarHolidayDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CalendarHolidayDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", calendarScheduleId=" + getCalendarScheduleId() +
            ", holidayScheduleId=" + getHolidayScheduleId() +
            "}";
    }
}
