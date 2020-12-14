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
 * A AnnualLeaveGroupDetails.
 */
@Entity
@Table(name = "annual_leave_group_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnnualLeaveGroupDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "worked_year", nullable = false)
    private Integer workedYear;

    @NotNull
    @Column(name = "earned_day", nullable = false)
    private Integer earnedDay;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "annualLeaveGroupDetails", allowSetters = true)
    private AnnualLeaveGroup annualLeaveGroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkedYear() {
        return workedYear;
    }

    public AnnualLeaveGroupDetails workedYear(Integer workedYear) {
        this.workedYear = workedYear;
        return this;
    }

    public void setWorkedYear(Integer workedYear) {
        this.workedYear = workedYear;
    }

    public Integer getEarnedDay() {
        return earnedDay;
    }

    public AnnualLeaveGroupDetails earnedDay(Integer earnedDay) {
        this.earnedDay = earnedDay;
        return this;
    }

    public void setEarnedDay(Integer earnedDay) {
        this.earnedDay = earnedDay;
    }

    public Instant getCreated() {
        return created;
    }

    public AnnualLeaveGroupDetails created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public AnnualLeaveGroupDetails modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public AnnualLeaveGroupDetails modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public AnnualLeaveGroup getAnnualLeaveGroup() {
        return annualLeaveGroup;
    }

    public AnnualLeaveGroupDetails annualLeaveGroup(AnnualLeaveGroup annualLeaveGroup) {
        this.annualLeaveGroup = annualLeaveGroup;
        return this;
    }

    public void setAnnualLeaveGroup(AnnualLeaveGroup annualLeaveGroup) {
        this.annualLeaveGroup = annualLeaveGroup;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveGroupDetails)) {
            return false;
        }
        return id != null && id.equals(((AnnualLeaveGroupDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveGroupDetails{" +
            "id=" + getId() +
            ", workedYear=" + getWorkedYear() +
            ", earnedDay=" + getEarnedDay() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
