package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A VisitorBook.
 */
@Entity
@Table(name = "visitor_book")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VisitorBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(max = 15)
    @Column(name = "id_card", length = 15)
    private String idCard;

    @Column(name = "entry_time")
    private Instant entryTime;

    @Column(name = "exit_time")
    private Instant exitTime;

    @Size(max = 15)
    @Column(name = "bill_no", length = 15)
    private String billNo;

    @Size(max = 15)
    @Column(name = "order_no", length = 15)
    private String orderNo;

    @Column(name = "parking_time")
    private Instant parkingTime;

    @Size(max = 15)
    @Column(name = "plate_no", length = 15)
    private String plateNo;

    @Size(max = 15)
    @Column(name = "trailer_no", length = 15)
    private String trailerNo;

    @Column(name = "exported")
    private Boolean exported;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "visitorBooks", allowSetters = true)
    private Visitor visitor;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "visitorBooks", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "visitorBooks", allowSetters = true)
    private VisitReason visitReason;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public VisitorBook description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdCard() {
        return idCard;
    }

    public VisitorBook idCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public VisitorBook entryTime(Instant entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public VisitorBook exitTime(Instant exitTime) {
        this.exitTime = exitTime;
        return this;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public String getBillNo() {
        return billNo;
    }

    public VisitorBook billNo(String billNo) {
        this.billNo = billNo;
        return this;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public VisitorBook orderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Instant getParkingTime() {
        return parkingTime;
    }

    public VisitorBook parkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
        return this;
    }

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public VisitorBook plateNo(String plateNo) {
        this.plateNo = plateNo;
        return this;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getTrailerNo() {
        return trailerNo;
    }

    public VisitorBook trailerNo(String trailerNo) {
        this.trailerNo = trailerNo;
        return this;
    }

    public void setTrailerNo(String trailerNo) {
        this.trailerNo = trailerNo;
    }

    public Boolean isExported() {
        return exported;
    }

    public VisitorBook exported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Instant getCreated() {
        return created;
    }

    public VisitorBook created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public VisitorBook modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public VisitorBook modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public VisitorBook visitor(Visitor visitor) {
        this.visitor = visitor;
        return this;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public VisitorBook employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitReason getVisitReason() {
        return visitReason;
    }

    public VisitorBook visitReason(VisitReason visitReason) {
        this.visitReason = visitReason;
        return this;
    }

    public void setVisitReason(VisitReason visitReason) {
        this.visitReason = visitReason;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitorBook)) {
            return false;
        }
        return id != null && id.equals(((VisitorBook) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitorBook{" +
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
            "}";
    }
}
