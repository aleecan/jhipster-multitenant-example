package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A TimezoneCalendar.
 */
@Entity
@Table(name = "timezone_calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TimezoneCalendar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_year", nullable = false)
    private Integer dateYear;


    @Lob
    @Column(name = "days", nullable = false)
    private String days;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public TimezoneCalendar dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public String getDays() {
        return days;
    }

    public TimezoneCalendar days(String days) {
        this.days = days;
        return this;
    }

    public void setDays(String days) {
        this.days = days;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimezoneCalendar)) {
            return false;
        }
        return id != null && id.equals(((TimezoneCalendar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimezoneCalendar{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", days='" + getDays() + "'" +
            "}";
    }
}
