package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.VisitorBook} entity.
 */
public class VisitorBookDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String description;

    @Size(max = 15)
    private String idCard;

    private Instant entryTime;

    private Instant exitTime;

    @Size(max = 15)
    private String billNo;

    @Size(max = 15)
    private String orderNo;

    private Instant parkingTime;

    @Size(max = 15)
    private String plateNo;

    @Size(max = 15)
    private String trailerNo;

    private Boolean exported;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long visitorId;

    private Long employeeId;

    private Long visitReasonId;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Instant getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getTrailerNo() {
        return trailerNo;
    }

    public void setTrailerNo(String trailerNo) {
        this.trailerNo = trailerNo;
    }

    public Boolean isExported() {
        return exported;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
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

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getVisitReasonId() {
        return visitReasonId;
    }

    public void setVisitReasonId(Long visitReasonId) {
        this.visitReasonId = visitReasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitorBookDTO)) {
            return false;
        }

        return id != null && id.equals(((VisitorBookDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitorBookDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", idCard='" + getIdCard() + "'" +
            ", entryTime='" + getEntryTime() + "'" +
            ", exitTime='" + getExitTime() + "'" +
            ", billNo='" + getBillNo() + "'" +
            ", orderNo='" + getOrderNo() + "'" +
            ", parkingTime='" + getParkingTime() + "'" +
            ", plateNo='" + getPlateNo() + "'" +
            ", trailerNo='" + getTrailerNo() + "'" +
            ", exported='" + isExported() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", visitorId=" + getVisitorId() +
            ", employeeId=" + getEmployeeId() +
            ", visitReasonId=" + getVisitReasonId() +
            "}";
    }
}
