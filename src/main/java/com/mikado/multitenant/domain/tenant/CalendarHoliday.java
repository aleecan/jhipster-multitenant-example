package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A CalendarHoliday.
 */
@Entity
@Table(name = "calendar_holiday")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CalendarHoliday implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "calendarHolidays", allowSetters = true)
    private Schedule calendarSchedule;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "calendarHolidays", allowSetters = true)
    private Schedule holidaySchedule;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public CalendarHoliday daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getDescription() {
        return description;
    }

    public CalendarHoliday description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreated() {
        return created;
    }

    public CalendarHoliday created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public CalendarHoliday modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public CalendarHoliday modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Schedule getCalendarSchedule() {
        return calendarSchedule;
    }

    public CalendarHoliday calendarSchedule(Schedule schedule) {
        this.calendarSchedule = schedule;
        return this;
    }

    public void setCalendarSchedule(Schedule schedule) {
        this.calendarSchedule = schedule;
    }

    public Schedule getHolidaySchedule() {
        return holidaySchedule;
    }

    public CalendarHoliday holidaySchedule(Schedule schedule) {
        this.holidaySchedule = schedule;
        return this;
    }

    public void setHolidaySchedule(Schedule schedule) {
        this.holidaySchedule = schedule;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarHoliday)) {
            return false;
        }
        return id != null && id.equals(((CalendarHoliday) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CalendarHoliday{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
