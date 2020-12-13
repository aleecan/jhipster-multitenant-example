package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Zone.
 */
@Entity
@Table(name = "zone")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Zone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 6)
    @Column(name = "code", length = 6, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "timekeeping")
    private Boolean timekeeping;

    @Column(name = "access_status")
    private Integer accessStatus;

    @Column(name = "external_zone")
    private Boolean externalZone;

    @Column(name = "check_apb")
    private Boolean checkApb;

    @Column(name = "reset_time_apb")
    private Integer resetTimeApb;

    @Column(name = "employee_counter")
    private Boolean employeeCounter;

    @Column(name = "external_counter")
    private Boolean externalCounter;

    @Column(name = "others_counter")
    private Boolean othersCounter;

    @Column(name = "vehicle_counter")
    private Boolean vehicleCounter;

    @Column(name = "visitor_counter")
    private Boolean visitorCounter;

    @Column(name = "participant_counter")
    private Boolean participantCounter;

    @Column(name = "send_counter_change")
    private Boolean sendCounterChange;

    @Column(name = "max_stay_time_in_zone")
    private Integer maxStayTimeInZone;

    @Column(name = "max_user_in_zone")
    private Integer maxUserInZone;

    @Column(name = "min_user_in_zone")
    private Integer minUserInZone;

    @ManyToOne
    @JsonIgnoreProperties(value = "zones", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "zones", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "zones", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "zones", allowSetters = true)
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

    public Zone code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Zone description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public Zone active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public Zone timekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public Zone accessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
        return this;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Boolean isExternalZone() {
        return externalZone;
    }

    public Zone externalZone(Boolean externalZone) {
        this.externalZone = externalZone;
        return this;
    }

    public void setExternalZone(Boolean externalZone) {
        this.externalZone = externalZone;
    }

    public Boolean isCheckApb() {
        return checkApb;
    }

    public Zone checkApb(Boolean checkApb) {
        this.checkApb = checkApb;
        return this;
    }

    public void setCheckApb(Boolean checkApb) {
        this.checkApb = checkApb;
    }

    public Integer getResetTimeApb() {
        return resetTimeApb;
    }

    public Zone resetTimeApb(Integer resetTimeApb) {
        this.resetTimeApb = resetTimeApb;
        return this;
    }

    public void setResetTimeApb(Integer resetTimeApb) {
        this.resetTimeApb = resetTimeApb;
    }

    public Boolean isEmployeeCounter() {
        return employeeCounter;
    }

    public Zone employeeCounter(Boolean employeeCounter) {
        this.employeeCounter = employeeCounter;
        return this;
    }

    public void setEmployeeCounter(Boolean employeeCounter) {
        this.employeeCounter = employeeCounter;
    }

    public Boolean isExternalCounter() {
        return externalCounter;
    }

    public Zone externalCounter(Boolean externalCounter) {
        this.externalCounter = externalCounter;
        return this;
    }

    public void setExternalCounter(Boolean externalCounter) {
        this.externalCounter = externalCounter;
    }

    public Boolean isOthersCounter() {
        return othersCounter;
    }

    public Zone othersCounter(Boolean othersCounter) {
        this.othersCounter = othersCounter;
        return this;
    }

    public void setOthersCounter(Boolean othersCounter) {
        this.othersCounter = othersCounter;
    }

    public Boolean isVehicleCounter() {
        return vehicleCounter;
    }

    public Zone vehicleCounter(Boolean vehicleCounter) {
        this.vehicleCounter = vehicleCounter;
        return this;
    }

    public void setVehicleCounter(Boolean vehicleCounter) {
        this.vehicleCounter = vehicleCounter;
    }

    public Boolean isVisitorCounter() {
        return visitorCounter;
    }

    public Zone visitorCounter(Boolean visitorCounter) {
        this.visitorCounter = visitorCounter;
        return this;
    }

    public void setVisitorCounter(Boolean visitorCounter) {
        this.visitorCounter = visitorCounter;
    }

    public Boolean isParticipantCounter() {
        return participantCounter;
    }

    public Zone participantCounter(Boolean participantCounter) {
        this.participantCounter = participantCounter;
        return this;
    }

    public void setParticipantCounter(Boolean participantCounter) {
        this.participantCounter = participantCounter;
    }

    public Boolean isSendCounterChange() {
        return sendCounterChange;
    }

    public Zone sendCounterChange(Boolean sendCounterChange) {
        this.sendCounterChange = sendCounterChange;
        return this;
    }

    public void setSendCounterChange(Boolean sendCounterChange) {
        this.sendCounterChange = sendCounterChange;
    }

    public Integer getMaxStayTimeInZone() {
        return maxStayTimeInZone;
    }

    public Zone maxStayTimeInZone(Integer maxStayTimeInZone) {
        this.maxStayTimeInZone = maxStayTimeInZone;
        return this;
    }

    public void setMaxStayTimeInZone(Integer maxStayTimeInZone) {
        this.maxStayTimeInZone = maxStayTimeInZone;
    }

    public Integer getMaxUserInZone() {
        return maxUserInZone;
    }

    public Zone maxUserInZone(Integer maxUserInZone) {
        this.maxUserInZone = maxUserInZone;
        return this;
    }

    public void setMaxUserInZone(Integer maxUserInZone) {
        this.maxUserInZone = maxUserInZone;
    }

    public Integer getMinUserInZone() {
        return minUserInZone;
    }

    public Zone minUserInZone(Integer minUserInZone) {
        this.minUserInZone = minUserInZone;
        return this;
    }

    public void setMinUserInZone(Integer minUserInZone) {
        this.minUserInZone = minUserInZone;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public Zone companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public Zone companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public Zone groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public Zone privateCode(PrivateCode privateCode) {
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
        if (!(o instanceof Zone)) {
            return false;
        }
        return id != null && id.equals(((Zone) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Zone{" +
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
            "}";
    }
}
