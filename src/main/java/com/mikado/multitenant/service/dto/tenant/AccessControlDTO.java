package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.AccessControl} entity.
 */
public class AccessControlDTO implements Serializable {

    private Long id;

    private Instant dayTime;

    @Size(max = 20)
    private String cardNo;

    @Size(max = 1)
    private String cardType;

    @NotNull
    private Integer direction;

    private Boolean accepted;

    private Boolean accessAck;

    private Integer moduleType;

    private Boolean rdEmployee;

    private Boolean realTime;

    private Boolean exported;


    private Long terminalId;

    private Long accessCodeId;

    private Long employeeId;

    private Long visitorBookId;

    private Long reasonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDayTime() {
        return dayTime;
    }

    public void setDayTime(Instant dayTime) {
        this.dayTime = dayTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean isAccessAck() {
        return accessAck;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public Boolean isRdEmployee() {
        return rdEmployee;
    }

    public void setRdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
    }

    public Boolean isRealTime() {
        return realTime;
    }

    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    public Boolean isExported() {
        return exported;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getAccessCodeId() {
        return accessCodeId;
    }

    public void setAccessCodeId(Long accessCodeId) {
        this.accessCodeId = accessCodeId;
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

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long categoryId) {
        this.reasonId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessControlDTO)) {
            return false;
        }

        return id != null && id.equals(((AccessControlDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessControlDTO{" +
            "id=" + getId() +
            ", dayTime='" + getDayTime() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", direction=" + getDirection() +
            ", accepted='" + isAccepted() + "'" +
            ", accessAck='" + isAccessAck() + "'" +
            ", moduleType=" + getModuleType() +
            ", rdEmployee='" + isRdEmployee() + "'" +
            ", realTime='" + isRealTime() + "'" +
            ", exported='" + isExported() + "'" +
            ", terminalId=" + getTerminalId() +
            ", accessCodeId=" + getAccessCodeId() +
            ", employeeId=" + getEmployeeId() +
            ", visitorBookId=" + getVisitorBookId() +
            ", reasonId=" + getReasonId() +
            "}";
    }
}
