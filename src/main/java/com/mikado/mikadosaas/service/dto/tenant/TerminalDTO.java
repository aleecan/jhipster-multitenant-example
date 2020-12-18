package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Terminal} entity.
 */
public class TerminalDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 4)
    private String code;

    @Size(max = 80)
    private String description;

    private Integer accessStatus;

    private Boolean active;

    private Boolean useTerminalTime;

    private Boolean useTerminalGateNo;

    @NotNull
    private Integer brandid;

    @Size(max = 25)
    private String macAddress;

    @Size(max = 20)
    private String tcpIp;

    private Integer tcpPort;

    @Size(max = 20)
    private String gateway;

    @Size(max = 20)
    private String netmask;

    @Size(max = 20)
    private String monitoringIp;

    private Integer monitoringPort;


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

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isUseTerminalTime() {
        return useTerminalTime;
    }

    public void setUseTerminalTime(Boolean useTerminalTime) {
        this.useTerminalTime = useTerminalTime;
    }

    public Boolean isUseTerminalGateNo() {
        return useTerminalGateNo;
    }

    public void setUseTerminalGateNo(Boolean useTerminalGateNo) {
        this.useTerminalGateNo = useTerminalGateNo;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getTcpIp() {
        return tcpIp;
    }

    public void setTcpIp(String tcpIp) {
        this.tcpIp = tcpIp;
    }

    public Integer getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getMonitoringIp() {
        return monitoringIp;
    }

    public void setMonitoringIp(String monitoringIp) {
        this.monitoringIp = monitoringIp;
    }

    public Integer getMonitoringPort() {
        return monitoringPort;
    }

    public void setMonitoringPort(Integer monitoringPort) {
        this.monitoringPort = monitoringPort;
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
        if (!(o instanceof TerminalDTO)) {
            return false;
        }

        return id != null && id.equals(((TerminalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", accessStatus=" + getAccessStatus() +
            ", active='" + isActive() + "'" +
            ", useTerminalTime='" + isUseTerminalTime() + "'" +
            ", useTerminalGateNo='" + isUseTerminalGateNo() + "'" +
            ", brandid=" + getBrandid() +
            ", macAddress='" + getMacAddress() + "'" +
            ", tcpIp='" + getTcpIp() + "'" +
            ", tcpPort=" + getTcpPort() +
            ", gateway='" + getGateway() + "'" +
            ", netmask='" + getNetmask() + "'" +
            ", monitoringIp='" + getMonitoringIp() + "'" +
            ", monitoringPort=" + getMonitoringPort() +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            "}";
    }
}
