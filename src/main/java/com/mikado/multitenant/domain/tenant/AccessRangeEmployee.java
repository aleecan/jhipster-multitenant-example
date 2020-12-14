package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A AccessRangeEmployee.
 */
@Entity
@Table(name = "access_range_employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessRangeEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_time")
    private Instant firstTime;

    @Column(name = "last_time")
    private Instant lastTime;

    @Column(name = "last_in_time")
    private Instant lastInTime;

    @Column(name = "last_out_time")
    private Instant lastOutTime;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "accessRangeEmployees", allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFirstTime() {
        return firstTime;
    }

    public AccessRangeEmployee firstTime(Instant firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public void setFirstTime(Instant firstTime) {
        this.firstTime = firstTime;
    }

    public Instant getLastTime() {
        return lastTime;
    }

    public AccessRangeEmployee lastTime(Instant lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public void setLastTime(Instant lastTime) {
        this.lastTime = lastTime;
    }

    public Instant getLastInTime() {
        return lastInTime;
    }

    public AccessRangeEmployee lastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
        return this;
    }

    public void setLastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
    }

    public Instant getLastOutTime() {
        return lastOutTime;
    }

    public AccessRangeEmployee lastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
        return this;
    }

    public void setLastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AccessRangeEmployee employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessRangeEmployee)) {
            return false;
        }
        return id != null && id.equals(((AccessRangeEmployee) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessRangeEmployee{" +
            "id=" + getId() +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", lastInTime='" + getLastInTime() + "'" +
            ", lastOutTime='" + getLastOutTime() + "'" +
            "}";
    }
}
