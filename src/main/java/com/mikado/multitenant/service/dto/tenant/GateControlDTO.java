package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.GateControl} entity.
 */
public class GateControlDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant daytime;

    @NotNull
    @Size(max = 20)
    private String cardNo;

    @NotNull
    @Size(max = 1)
    private String cardType;

    @NotNull
    private Integer direction;

    private Boolean accessAck;


    private Long gateId;

    private Long accessCodeId;

    private Long employeeId;

    private Long visitorBookId;

    private Long accessId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDaytime() {
        return daytime;
    }

    public void setDaytime(Instant daytime) {
        this.daytime = daytime;
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

    public Boolean isAccessAck() {
        return accessAck;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
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

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessControlId) {
        this.accessId = accessControlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GateControlDTO)) {
            return false;
        }

        return id != null && id.equals(((GateControlDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GateControlDTO{" +
            "id=" + getId() +
            ", daytime='" + getDaytime() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", direction=" + getDirection() +
            ", accessAck='" + isAccessAck() + "'" +
            ", gateId=" + getGateId() +
            ", accessCodeId=" + getAccessCodeId() +
            ", employeeId=" + getEmployeeId() +
            ", visitorBookId=" + getVisitorBookId() +
            ", accessId=" + getAccessId() +
            "}";
    }
}
