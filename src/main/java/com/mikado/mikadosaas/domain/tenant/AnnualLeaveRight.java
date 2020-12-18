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
 * A AnnualLeaveRight.
 */
@Entity
@Table(name = "annual_leave_right")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnnualLeaveRight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "al_year")
    private Integer alYear;

    @Column(name = "service_year")
    private Integer serviceYear;

    @Column(name = "rights_date")
    private LocalDate rightsDate;

    @Column(name = "al_day")
    private Double alDay;

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
    @JsonIgnoreProperties(value = "annualLeaveRights", allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlYear() {
        return alYear;
    }

    public AnnualLeaveRight alYear(Integer alYear) {
        this.alYear = alYear;
        return this;
    }

    public void setAlYear(Integer alYear) {
        this.alYear = alYear;
    }

    public Integer getServiceYear() {
        return serviceYear;
    }

    public AnnualLeaveRight serviceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
        return this;
    }

    public void setServiceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
    }

    public LocalDate getRightsDate() {
        return rightsDate;
    }

    public AnnualLeaveRight rightsDate(LocalDate rightsDate) {
        this.rightsDate = rightsDate;
        return this;
    }

    public void setRightsDate(LocalDate rightsDate) {
        this.rightsDate = rightsDate;
    }

    public Double getAlDay() {
        return alDay;
    }

    public AnnualLeaveRight alDay(Double alDay) {
        this.alDay = alDay;
        return this;
    }

    public void setAlDay(Double alDay) {
        this.alDay = alDay;
    }

    public String getDescription() {
        return description;
    }

    public AnnualLeaveRight description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreated() {
        return created;
    }

    public AnnualLeaveRight created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public AnnualLeaveRight modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public AnnualLeaveRight modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AnnualLeaveRight employee(Employee employee) {
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
        if (!(o instanceof AnnualLeaveRight)) {
            return false;
        }
        return id != null && id.equals(((AnnualLeaveRight) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveRight{" +
            "id=" + getId() +
            ", alYear=" + getAlYear() +
            ", serviceYear=" + getServiceYear() +
            ", rightsDate='" + getRightsDate() + "'" +
            ", alDay=" + getAlDay() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
