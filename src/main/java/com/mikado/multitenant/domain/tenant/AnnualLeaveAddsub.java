package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A AnnualLeaveAddsub.
 */
@Entity
@Table(name = "annual_leave_addsub")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnnualLeaveAddsub implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_date", nullable = false)
    private LocalDate firstDate;

    @Column(name = "last_date")
    private LocalDate lastDate;

    @NotNull
    @Column(name = "numday", nullable = false)
    private Integer numday;

    @NotNull
    @Column(name = "al_year", nullable = false)
    private Integer alYear;

    @NotNull
    @Size(max = 1)
    @Column(name = "add_sub", length = 1, nullable = false)
    private String addSub;

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
    @JsonIgnoreProperties(value = "annualLeaveAddsubs", allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public AnnualLeaveAddsub firstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
        return this;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public AnnualLeaveAddsub lastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
        return this;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getNumday() {
        return numday;
    }

    public AnnualLeaveAddsub numday(Integer numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Integer numday) {
        this.numday = numday;
    }

    public Integer getAlYear() {
        return alYear;
    }

    public AnnualLeaveAddsub alYear(Integer alYear) {
        this.alYear = alYear;
        return this;
    }

    public void setAlYear(Integer alYear) {
        this.alYear = alYear;
    }

    public String getAddSub() {
        return addSub;
    }

    public AnnualLeaveAddsub addSub(String addSub) {
        this.addSub = addSub;
        return this;
    }

    public void setAddSub(String addSub) {
        this.addSub = addSub;
    }

    public String getDescription() {
        return description;
    }

    public AnnualLeaveAddsub description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreated() {
        return created;
    }

    public AnnualLeaveAddsub created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public AnnualLeaveAddsub modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public AnnualLeaveAddsub modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AnnualLeaveAddsub employee(Employee employee) {
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
        if (!(o instanceof AnnualLeaveAddsub)) {
            return false;
        }
        return id != null && id.equals(((AnnualLeaveAddsub) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveAddsub{" +
            "id=" + getId() +
            ", firstDate='" + getFirstDate() + "'" +
            ", lastDate='" + getLastDate() + "'" +
            ", numday=" + getNumday() +
            ", alYear=" + getAlYear() +
            ", addSub='" + getAddSub() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
