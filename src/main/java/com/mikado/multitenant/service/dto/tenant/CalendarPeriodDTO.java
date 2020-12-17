package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.CalendarPeriod} entity.
 */
public class CalendarPeriodDTO implements Serializable {

    private Long id;

    private LocalDate daydate;

    @Size(max = 80)
    private String description;

    private Integer turnCount;

    private Boolean turnDirection;

    @Lob
    private String shiftDef;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long calendarId;

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

    public Integer getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(Integer turnCount) {
        this.turnCount = turnCount;
    }

    public Boolean isTurnDirection() {
        return turnDirection;
    }

    public void setTurnDirection(Boolean turnDirection) {
        this.turnDirection = turnDirection;
    }

    public String getShiftDef() {
        return shiftDef;
    }

    public void setShiftDef(String shiftDef) {
        this.shiftDef = shiftDef;
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

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarPeriodDTO)) {
            return false;
        }

        return id != null && id.equals(((CalendarPeriodDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CalendarPeriodDTO{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", description='" + getDescription() + "'" +
            ", turnCount=" + getTurnCount() +
            ", turnDirection='" + isTurnDirection() + "'" +
            ", shiftDef='" + getShiftDef() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", calendarId=" + getCalendarId() +
            "}";
    }
}
