package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ZoneControl} entity.
 */
public class ZoneControlDTO implements Serializable {

    private Long id;

    private Instant entryTime;

    @NotNull
    @Size(max = 20)
    private String cardNo;

    @NotNull
    @Size(max = 1)
    private String cardType;

    private Boolean accessAck;

    private Long exitAccessId;

    private Instant exitTime;

    private Boolean exitAccessAck;


    private Long zoneId;

    private Long accessCodeId;

    private Long employeeId;

    private Long visitorBookId;

    private Long accessId;

    private Long exitAccessCodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
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

    public Boolean isAccessAck() {
        return accessAck;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Long getExitAccessId() {
        return exitAccessId;
    }

    public void setExitAccessId(Long exitAccessId) {
        this.exitAccessId = exitAccessId;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public Boolean isExitAccessAck() {
        return exitAccessAck;
    }

    public void setExitAccessAck(Boolean exitAccessAck) {
        this.exitAccessAck = exitAccessAck;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
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

    public Long getExitAccessCodeId() {
        return exitAccessCodeId;
    }

    public void setExitAccessCodeId(Long accessCodeId) {
        this.exitAccessCodeId = accessCodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneControlDTO)) {
            return false;
        }

        return id != null && id.equals(((ZoneControlDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneControlDTO{" +
            "id=" + getId() +
            ", entryTime='" + getEntryTime() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", accessAck='" + isAccessAck() + "'" +
            ", exitAccessId=" + getExitAccessId() +
            ", exitTime='" + getExitTime() + "'" +
            ", exitAccessAck='" + isExitAccessAck() + "'" +
            ", zoneId=" + getZoneId() +
            ", accessCodeId=" + getAccessCodeId() +
            ", employeeId=" + getEmployeeId() +
            ", visitorBookId=" + getVisitorBookId() +
            ", accessId=" + getAccessId() +
            ", exitAccessCodeId=" + getExitAccessCodeId() +
            "}";
    }
}
