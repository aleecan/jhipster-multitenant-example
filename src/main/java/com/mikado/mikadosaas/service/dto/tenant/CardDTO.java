package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Card} entity.
 */
public class CardDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String cardNo;

    @Size(max = 1)
    private String type;

    private Boolean cancelled;

    private Instant issueDatetime;

    private Instant expireDatetime;

    @Size(max = 20)
    private String cardCode;

    @Size(max = 20)
    private String pinCode;

    private Boolean timekeeping;

    private Boolean biometricEnabled;

    private Boolean rdEmployee;

    @Size(max = 3200)
    private String fingerprint;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long visitorBookId;

    private Long companyFirmId;

    private Long companySubFirmId;

    private Long groupCodeId;

    private Long privateCodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Instant getIssueDatetime() {
        return issueDatetime;
    }

    public void setIssueDatetime(Instant issueDatetime) {
        this.issueDatetime = issueDatetime;
    }

    public Instant getExpireDatetime() {
        return expireDatetime;
    }

    public void setExpireDatetime(Instant expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isBiometricEnabled() {
        return biometricEnabled;
    }

    public void setBiometricEnabled(Boolean biometricEnabled) {
        this.biometricEnabled = biometricEnabled;
    }

    public Boolean isRdEmployee() {
        return rdEmployee;
    }

    public void setRdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getVisitorBookId() {
        return visitorBookId;
    }

    public void setVisitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
    }

    public Long getCompanyFirmId() {
        return companyFirmId;
    }

    public void setCompanyFirmId(Long companyFirmId) {
        this.companyFirmId = companyFirmId;
    }

    public Long getCompanySubFirmId() {
        return companySubFirmId;
    }

    public void setCompanySubFirmId(Long companySubFirmId) {
        this.companySubFirmId = companySubFirmId;
    }

    public Long getGroupCodeId() {
        return groupCodeId;
    }

    public void setGroupCodeId(Long groupCodeId) {
        this.groupCodeId = groupCodeId;
    }

    public Long getPrivateCodeId() {
        return privateCodeId;
    }

    public void setPrivateCodeId(Long privateCodeId) {
        this.privateCodeId = privateCodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CardDTO)) {
            return false;
        }

        return id != null && id.equals(((CardDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CardDTO{" +
            "id=" + getId() +
            ", cardNo='" + getCardNo() + "'" +
            ", type='" + getType() + "'" +
            ", cancelled='" + isCancelled() + "'" +
            ", issueDatetime='" + getIssueDatetime() + "'" +
            ", expireDatetime='" + getExpireDatetime() + "'" +
            ", cardCode='" + getCardCode() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", biometricEnabled='" + isBiometricEnabled() + "'" +
            ", rdEmployee='" + isRdEmployee() + "'" +
            ", fingerprint='" + getFingerprint() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", visitorBookId=" + getVisitorBookId() +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            "}";
    }
}
