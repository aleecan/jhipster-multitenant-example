package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.VisitorCompany} entity.
 */
public class VisitorCompanyDTO implements Serializable {

    private Long id;

    @Size(max = 10)
    private String code;

    @Size(max = 255)
    private String name;

    @Size(max = 40)
    private String managingPerson;

    @Size(max = 15)
    private String fax;

    @Size(max = 15)
    private String phone;

    @Size(max = 15)
    private String taxNo;

    @Size(max = 40)
    private String taxOffice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagingPerson() {
        return managingPerson;
    }

    public void setManagingPerson(String managingPerson) {
        this.managingPerson = managingPerson;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitorCompanyDTO)) {
            return false;
        }

        return id != null && id.equals(((VisitorCompanyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitorCompanyDTO{" +
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
