package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A TimezoneRights.
 */
@Entity
@Table(name = "timezone_rights")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TimezoneRights implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 96)
    @Column(name = "timezone_right", length = 96)
    private String timezoneRight;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "timezoneRights", allowSetters = true)
    private Timezone timezone;

    @ManyToOne
    @JsonIgnoreProperties(value = "timezoneRights", allowSetters = true)
    private TimezoneDay timezoneDay;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimezoneRight() {
        return timezoneRight;
    }

    public TimezoneRights timezoneRight(String timezoneRight) {
        this.timezoneRight = timezoneRight;
        return this;
    }

    public void setTimezoneRight(String timezoneRight) {
        this.timezoneRight = timezoneRight;
    }

    public Instant getCreated() {
        return created;
    }

    public TimezoneRights created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public TimezoneRights modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public TimezoneRights modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public TimezoneRights timezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public TimezoneDay getTimezoneDay() {
        return timezoneDay;
    }

    public TimezoneRights timezoneDay(TimezoneDay timezoneDay) {
        this.timezoneDay = timezoneDay;
        return this;
    }

    public void setTimezoneDay(TimezoneDay timezoneDay) {
        this.timezoneDay = timezoneDay;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimezoneRights)) {
            return false;
        }
        return id != null && id.equals(((TimezoneRights) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TimezoneRights{" +
            "id=" + getId() +
            ", timezoneRight='" + getTimezoneRight() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
