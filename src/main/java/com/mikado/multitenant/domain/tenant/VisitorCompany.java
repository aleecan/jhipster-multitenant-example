package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A VisitorCompany.
 */
@Entity
@Table(name = "visitor_company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VisitorCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 10)
    @Column(name = "code", length = 10)
    private String code;

    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;

    @Size(max = 40)
    @Column(name = "managing_person", length = 40)
    private String managingPerson;

    @Size(max = 15)
    @Column(name = "fax", length = 15)
    private String fax;

    @Size(max = 15)
    @Column(name = "phone", length = 15)
    private String phone;

    @Size(max = 15)
    @Column(name = "tax_no", length = 15)
    private String taxNo;

    @Size(max = 40)
    @Column(name = "tax_office", length = 40)
    private String taxOffice;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public VisitorCompany code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public VisitorCompany name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagingPerson() {
        return managingPerson;
    }

    public VisitorCompany managingPerson(String managingPerson) {
        this.managingPerson = managingPerson;
        return this;
    }

    public void setManagingPerson(String managingPerson) {
        this.managingPerson = managingPerson;
    }

    public String getFax() {
        return fax;
    }

    public VisitorCompany fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public VisitorCompany phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public VisitorCompany taxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public VisitorCompany taxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
        return this;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitorCompany)) {
            return false;
        }
        return id != null && id.equals(((VisitorCompany) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitorCompany{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", managingPerson='" + getManagingPerson() + "'" +
            ", fax='" + getFax() + "'" +
            ", phone='" + getPhone() + "'" +
            ", taxNo='" + getTaxNo() + "'" +
            ", taxOffice='" + getTaxOffice() + "'" +
            "}";
    }
}
