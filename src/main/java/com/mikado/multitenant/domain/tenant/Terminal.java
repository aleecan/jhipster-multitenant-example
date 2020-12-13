package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Terminal.
 */
@Entity
@Table(name = "terminal")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 4)
    @Column(name = "code", length = 4, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "access_status")
    private Integer accessStatus;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "use_terminal_time")
    private Boolean useTerminalTime;

    @Column(name = "use_terminal_gate_no")
    private Boolean useTerminalGateNo;

    @NotNull
    @Column(name = "brandid", nullable = false)
    private Integer brandid;

    @Size(max = 25)
    @Column(name = "mac_address", length = 25)
    private String macAddress;

    @Size(max = 20)
    @Column(name = "tcp_ip", length = 20)
    private String tcpIp;

    @Column(name = "tcp_port")
    private Integer tcpPort;

    @Size(max = 20)
    @Column(name = "gateway", length = 20)
    private String gateway;

    @Size(max = 20)
    @Column(name = "netmask", length = 20)
    private String netmask;

    @Size(max = 20)
    @Column(name = "monitoring_ip", length = 20)
    private String monitoringIp;

    @Column(name = "monitoring_port")
    private Integer monitoringPort;

    @ManyToOne
    @JsonIgnoreProperties(value = "terminals", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "terminals", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "terminals", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "terminals", allowSetters = true)
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

    public Terminal code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Terminal description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public Terminal accessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
        return this;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isActive() {
        return active;
    }

    public Terminal active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isUseTerminalTime() {
        return useTerminalTime;
    }

    public Terminal useTerminalTime(Boolean useTerminalTime) {
        this.useTerminalTime = useTerminalTime;
        return this;
    }

    public void setUseTerminalTime(Boolean useTerminalTime) {
        this.useTerminalTime = useTerminalTime;
    }

    public Boolean isUseTerminalGateNo() {
        return useTerminalGateNo;
    }

    public Terminal useTerminalGateNo(Boolean useTerminalGateNo) {
        this.useTerminalGateNo = useTerminalGateNo;
        return this;
    }

    public void setUseTerminalGateNo(Boolean useTerminalGateNo) {
        this.useTerminalGateNo = useTerminalGateNo;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public Terminal brandid(Integer brandid) {
        this.brandid = brandid;
        return this;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Terminal macAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getTcpIp() {
        return tcpIp;
    }

    public Terminal tcpIp(String tcpIp) {
        this.tcpIp = tcpIp;
        return this;
    }

    public void setTcpIp(String tcpIp) {
        this.tcpIp = tcpIp;
    }

    public Integer getTcpPort() {
        return tcpPort;
    }

    public Terminal tcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
        return this;
    }

    public void setTcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
    }

    public String getGateway() {
        return gateway;
    }

    public Terminal gateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getNetmask() {
        return netmask;
    }

    public Terminal netmask(String netmask) {
        this.netmask = netmask;
        return this;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getMonitoringIp() {
        return monitoringIp;
    }

    public Terminal monitoringIp(String monitoringIp) {
        this.monitoringIp = monitoringIp;
        return this;
    }

    public void setMonitoringIp(String monitoringIp) {
        this.monitoringIp = monitoringIp;
    }

    public Integer getMonitoringPort() {
        return monitoringPort;
    }

    public Terminal monitoringPort(Integer monitoringPort) {
        this.monitoringPort = monitoringPort;
        return this;
    }

    public void setMonitoringPort(Integer monitoringPort) {
        this.monitoringPort = monitoringPort;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public Terminal companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public Terminal companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public Terminal groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public Terminal privateCode(PrivateCode privateCode) {
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
        if (!(o instanceof Terminal)) {
            return false;
        }
        return id != null && id.equals(((Terminal) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Terminal{" +
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
            "}";
    }
}
