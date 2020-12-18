package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ApproverCompanyFirm.
 */
@Entity
@Table(name = "approver_company_firm")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ApproverCompanyFirm implements Serializable {

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
    @JsonIgnoreProperties(value = "approverCompanyFirms", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "approverCompanyFirms", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "approverCompanyFirms", allowSetters = true)
    private CompanySubFirm companySubFirm;

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

    public ApproverCompanyFirm approveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
        return this;
    }

    public void setApproveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
    }

    public Instant getCreated() {
        return created;
    }

    public ApproverCompanyFirm created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ApproverCompanyFirm modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ApproverCompanyFirm modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ApproverCompanyFirm employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public ApproverCompanyFirm companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public ApproverCompanyFirm companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApproverCompanyFirm)) {
            return false;
        }
        return id != null && id.equals(((ApproverCompanyFirm) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApproverCompanyFirm{" +
            "id=" + getId() +
            ", approveLevel=" + getApproveLevel() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
