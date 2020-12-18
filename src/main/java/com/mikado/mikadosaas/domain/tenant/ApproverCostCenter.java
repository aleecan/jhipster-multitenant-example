package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ApproverCostCenter.
 */
@Entity
@Table(name = "approver_cost_center")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ApproverCostCenter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "approve_level", nullable = false)
    private Integer approveLevel;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "approverCostCenters", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "approverCostCenters", allowSetters = true)
    private CostCenter costCenter;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApproveLevel() {
        return approveLevel;
    }

    public ApproverCostCenter approveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
        return this;
    }

    public void setApproveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
    }

    public Instant getCreated() {
        return created;
    }

    public ApproverCostCenter created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ApproverCostCenter modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ApproverCostCenter modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ApproverCostCenter employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public ApproverCostCenter costCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApproverCostCenter)) {
            return false;
        }
        return id != null && id.equals(((ApproverCostCenter) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApproverCostCenter{" +
            "id=" + getId() +
            ", approveLevel=" + getApproveLevel() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
