package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Gate.
 */
@Entity
@Table(name = "gate")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Gate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 6)
    @Column(name = "code", length = 6, nullable = false)
    private String code;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "access_status")
    private Integer accessStatus;

    @Column(name = "timekeeping")
    private Boolean timekeeping;

    @Column(name = "use_rd_company")
    private Boolean useRdCompany;

    @ManyToOne
    @JsonIgnoreProperties(value = "gates", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "gates", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "gates", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "gates", allowSetters = true)
    private PrivateCode privateCode;

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

    public Gate code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Gate description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public Gate accessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
        return this;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public Gate timekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isUseRdCompany() {
        return useRdCompany;
    }

    public Gate useRdCompany(Boolean useRdCompany) {
        this.useRdCompany = useRdCompany;
        return this;
    }

    public void setUseRdCompany(Boolean useRdCompany) {
        this.useRdCompany = useRdCompany;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public Gate companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public Gate companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public Gate groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public Gate privateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
        return this;
    }

    public void setPrivateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gate)) {
            return false;
        }
        return id != null && id.equals(((Gate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Gate{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", accessStatus=" + getAccessStatus() +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", useRdCompany='" + isUseRdCompany() + "'" +
            "}";
    }
}
