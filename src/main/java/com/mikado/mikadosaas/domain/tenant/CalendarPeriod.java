package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A CalendarPeriod.
 */
@Entity
@Table(name = "calendar_period")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CalendarPeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "daydate")
    private LocalDate daydate;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "turn_count")
    private Integer turnCount;

    @Column(name = "turn_direction")
    private Boolean turnDirection;

    @Lob
    @Column(name = "shift_def")
    private String shiftDef;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "calendarPeriods", allowSetters = true)
    private Calendar calendar;

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

    public CalendarPeriod daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getDescription() {
        return description;
    }

    public CalendarPeriod description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTurnCount() {
        return turnCount;
    }

    public CalendarPeriod turnCount(Integer turnCount) {
        this.turnCount = turnCount;
        return this;
    }

    public void setTurnCount(Integer turnCount) {
        this.turnCount = turnCount;
    }

    public Boolean isTurnDirection() {
        return turnDirection;
    }

    public CalendarPeriod turnDirection(Boolean turnDirection) {
        this.turnDirection = turnDirection;
        return this;
    }

    public void setTurnDirection(Boolean turnDirection) {
        this.turnDirection = turnDirection;
    }

    public String getShiftDef() {
        return shiftDef;
    }

    public CalendarPeriod shiftDef(String shiftDef) {
        this.shiftDef = shiftDef;
        return this;
    }

    public void setShiftDef(String shiftDef) {
        this.shiftDef = shiftDef;
    }

    public Instant getCreated() {
        return created;
    }

    public CalendarPeriod created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public CalendarPeriod modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public CalendarPeriod modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public CalendarPeriod calendar(Calendar calendar) {
        this.calendar = calendar;
        return this;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarPeriod)) {
            return false;
        }
        return id != null && id.equals(((CalendarPeriod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CalendarPeriod{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", description='" + getDescription() + "'" +
            ", turnCount=" + getTurnCount() +
            ", turnDirection='" + isTurnDirection() + "'" +
            ", shiftDef='" + getShiftDef() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
