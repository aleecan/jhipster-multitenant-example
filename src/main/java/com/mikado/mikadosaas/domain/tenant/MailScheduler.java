package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A MailScheduler.
 */
@Entity
@Table(name = "mail_scheduler")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MailScheduler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "daytime", length = 8)
    private String daytime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Size(max = 80)
    @Column(name = "mail_subject", length = 80)
    private String mailSubject;

    @Column(name = "process_type")
    private Integer processType;

    @Lob
    @Column(name = "mail_body")
    private String mailBody;

    @Column(name = "all_employee")
    private Boolean allEmployee;

    @Column(name = "all_manager")
    private Boolean allManager;

    @Column(name = "is_firm")
    private Boolean isFirm;

    @Column(name = "is_sub_firm")
    private Boolean isSubFirm;

    @Column(name = "is_department")
    private Boolean isDepartment;

    @Column(name = "is_sub_department")
    private Boolean isSubDepartment;

    @Column(name = "is_cost_center")
    private Boolean isCostCenter;

    @Column(name = "is_custom")
    private Boolean isCustom;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public MailScheduler description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDaytime() {
        return daytime;
    }

    public MailScheduler daytime(String daytime) {
        this.daytime = daytime;
        return this;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public MailScheduler isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public MailScheduler mailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
        return this;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public Integer getProcessType() {
        return processType;
    }

    public MailScheduler processType(Integer processType) {
        this.processType = processType;
        return this;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getMailBody() {
        return mailBody;
    }

    public MailScheduler mailBody(String mailBody) {
        this.mailBody = mailBody;
        return this;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public Boolean isAllEmployee() {
        return allEmployee;
    }

    public MailScheduler allEmployee(Boolean allEmployee) {
        this.allEmployee = allEmployee;
        return this;
    }

    public void setAllEmployee(Boolean allEmployee) {
        this.allEmployee = allEmployee;
    }

    public Boolean isAllManager() {
        return allManager;
    }

    public MailScheduler allManager(Boolean allManager) {
        this.allManager = allManager;
        return this;
    }

    public void setAllManager(Boolean allManager) {
        this.allManager = allManager;
    }

    public Boolean isIsFirm() {
        return isFirm;
    }

    public MailScheduler isFirm(Boolean isFirm) {
        this.isFirm = isFirm;
        return this;
    }

    public void setIsFirm(Boolean isFirm) {
        this.isFirm = isFirm;
    }

    public Boolean isIsSubFirm() {
        return isSubFirm;
    }

    public MailScheduler isSubFirm(Boolean isSubFirm) {
        this.isSubFirm = isSubFirm;
        return this;
    }

    public void setIsSubFirm(Boolean isSubFirm) {
        this.isSubFirm = isSubFirm;
    }

    public Boolean isIsDepartment() {
        return isDepartment;
    }

    public MailScheduler isDepartment(Boolean isDepartment) {
        this.isDepartment = isDepartment;
        return this;
    }

    public void setIsDepartment(Boolean isDepartment) {
        this.isDepartment = isDepartment;
    }

    public Boolean isIsSubDepartment() {
        return isSubDepartment;
    }

    public MailScheduler isSubDepartment(Boolean isSubDepartment) {
        this.isSubDepartment = isSubDepartment;
        return this;
    }

    public void setIsSubDepartment(Boolean isSubDepartment) {
        this.isSubDepartment = isSubDepartment;
    }

    public Boolean isIsCostCenter() {
        return isCostCenter;
    }

    public MailScheduler isCostCenter(Boolean isCostCenter) {
        this.isCostCenter = isCostCenter;
        return this;
    }

    public void setIsCostCenter(Boolean isCostCenter) {
        this.isCostCenter = isCostCenter;
    }

    public Boolean isIsCustom() {
        return isCustom;
    }

    public MailScheduler isCustom(Boolean isCustom) {
        this.isCustom = isCustom;
        return this;
    }

    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MailScheduler)) {
            return false;
        }
        return id != null && id.equals(((MailScheduler) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MailScheduler{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", daytime='" + getDaytime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", mailSubject='" + getMailSubject() + "'" +
            ", processType=" + getProcessType() +
            ", mailBody='" + getMailBody() + "'" +
            ", allEmployee='" + isAllEmployee() + "'" +
            ", allManager='" + isAllManager() + "'" +
            ", isFirm='" + isIsFirm() + "'" +
            ", isSubFirm='" + isIsSubFirm() + "'" +
            ", isDepartment='" + isIsDepartment() + "'" +
            ", isSubDepartment='" + isIsSubDepartment() + "'" +
            ", isCostCenter='" + isIsCostCenter() + "'" +
            ", isCustom='" + isIsCustom() + "'" +
            "}";
    }
}
