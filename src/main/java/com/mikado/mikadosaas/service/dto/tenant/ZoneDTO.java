package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Zone} entity.
 */
public class ZoneDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 6)
    private String code;

    @Size(max = 80)
    private String description;

    private Boolean active;

    private Boolean timekeeping;

    private Integer accessStatus;

    private Boolean externalZone;

    private Boolean checkApb;

    private Integer resetTimeApb;

    private Boolean employeeCounter;

    private Boolean externalCounter;

    private Boolean othersCounter;

    private Boolean vehicleCounter;

    private Boolean visitorCounter;

    private Boolean participantCounter;

    private Boolean sendCounterChange;

    private Integer maxStayTimeInZone;

    private Integer maxUserInZone;

    private Integer minUserInZone;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isExternalZone() {
        return externalZone;
    }

    public void setExternalZone(Boolean externalZone) {
        this.externalZone = externalZone;
    }

    public Boolean isCheckApb() {
        return checkApb;
    }

    public void setCheckApb(Boolean checkApb) {
        this.checkApb = checkApb;
    }

    public Integer getResetTimeApb() {
        return resetTimeApb;
    }

    public void setResetTimeApb(Integer resetTimeApb) {
        this.resetTimeApb = resetTimeApb;
    }

    public Boolean isEmployeeCounter() {
        return employeeCounter;
    }

    public void setEmployeeCounter(Boolean employeeCounter) {
        this.employeeCounter = employeeCounter;
    }

    public Boolean isExternalCounter() {
        return externalCounter;
    }

    public void setExternalCounter(Boolean externalCounter) {
        this.externalCounter = externalCounter;
    }

    public Boolean isOthersCounter() {
        return othersCounter;
    }

    public void setOthersCounter(Boolean othersCounter) {
        this.othersCounter = othersCounter;
    }

    public Boolean isVehicleCounter() {
        return vehicleCounter;
    }

    public void setVehicleCounter(Boolean vehicleCounter) {
        this.vehicleCounter = vehicleCounter;
    }

    public Boolean isVisitorCounter() {
        return visitorCounter;
    }

    public void setVisitorCounter(Boolean visitorCounter) {
        this.visitorCounter = visitorCounter;
    }

    public Boolean isParticipantCounter() {
        return participantCounter;
    }

    public void setParticipantCounter(Boolean participantCounter) {
        this.participantCounter = participantCounter;
    }

    public Boolean isSendCounterChange() {
        return sendCounterChange;
    }

    public void setSendCounterChange(Boolean sendCounterChange) {
        this.sendCounterChange = sendCounterChange;
    }

    public Integer getMaxStayTimeInZone() {
        return maxStayTimeInZone;
    }

    public void setMaxStayTimeInZone(Integer maxStayTimeInZone) {
        this.maxStayTimeInZone = maxStayTimeInZone;
    }

    public Integer getMaxUserInZone() {
        return maxUserInZone;
    }

    public void setMaxUserInZone(Integer maxUserInZone) {
        this.maxUserInZone = maxUserInZone;
    }

    public Integer getMinUserInZone() {
        return minUserInZone;
    }

    public void setMinUserInZone(Integer minUserInZone) {
        this.minUserInZone = minUserInZone;
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
        if (!(o instanceof ZoneDTO)) {
            return false;
        }

        return id != null && id.equals(((ZoneDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", active='" + isActive() + "'" +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", accessStatus=" + getAccessStatus() +
            ", externalZone='" + isExternalZone() + "'" +
            ", checkApb='" + isCheckApb() + "'" +
            ", resetTimeApb=" + getResetTimeApb() +
            ", employeeCounter='" + isEmployeeCounter() + "'" +
            ", externalCounter='" + isExternalCounter() + "'" +
            ", othersCounter='" + isOthersCounter() + "'" +
            ", vehicleCounter='" + isVehicleCounter() + "'" +
            ", visitorCounter='" + isVisitorCounter() + "'" +
            ", participantCounter='" + isParticipantCounter() + "'" +
            ", sendCounterChange='" + isSendCounterChange() + "'" +
            ", maxStayTimeInZone=" + getMaxStayTimeInZone() +
            ", maxUserInZone=" + getMaxUserInZone() +
            ", minUserInZone=" + getMinUserInZone() +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            "}";
    }
}
