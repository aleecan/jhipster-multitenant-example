package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.MailScheduler} entity.
 */
public class MailSchedulerDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String description;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String daytime;

    private Boolean isActive;

    @Size(max = 80)
    private String mailSubject;

    private Integer processType;

    @Lob
    private String mailBody;

    private Boolean allEmployee;

    private Boolean allManager;

    private Boolean isFirm;

    private Boolean isSubFirm;

    private Boolean isDepartment;

    private Boolean isSubDepartment;

    private Boolean isCostCenter;

    private Boolean isCustom;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public Boolean isAllEmployee() {
        return allEmployee;
    }

    public void setAllEmployee(Boolean allEmployee) {
        this.allEmployee = allEmployee;
    }

    public Boolean isAllManager() {
        return allManager;
    }

    public void setAllManager(Boolean allManager) {
        this.allManager = allManager;
    }

    public Boolean isIsFirm() {
        return isFirm;
    }

    public void setIsFirm(Boolean isFirm) {
        this.isFirm = isFirm;
    }

    public Boolean isIsSubFirm() {
        return isSubFirm;
    }

    public void setIsSubFirm(Boolean isSubFirm) {
        this.isSubFirm = isSubFirm;
    }

    public Boolean isIsDepartment() {
        return isDepartment;
    }

    public void setIsDepartment(Boolean isDepartment) {
        this.isDepartment = isDepartment;
    }

    public Boolean isIsSubDepartment() {
        return isSubDepartment;
    }

    public void setIsSubDepartment(Boolean isSubDepartment) {
        this.isSubDepartment = isSubDepartment;
    }

    public Boolean isIsCostCenter() {
        return isCostCenter;
    }

    public void setIsCostCenter(Boolean isCostCenter) {
        this.isCostCenter = isCostCenter;
    }

    public Boolean isIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MailSchedulerDTO)) {
            return false;
        }

        return id != null && id.equals(((MailSchedulerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MailSchedulerDTO{" +
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
