package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ZoneControl.
 */
@Entity
@Table(name = "zone_control")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ZoneControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_time")
    private Instant entryTime;

    @NotNull
    @Size(max = 20)
    @Column(name = "card_no", length = 20, nullable = false)
    private String cardNo;

    @NotNull
    @Size(max = 1)
    @Column(name = "card_type", length = 1, nullable = false)
    private String cardType;

    @Column(name = "access_ack")
    private Boolean accessAck;

    @Column(name = "exit_access_id")
    private Long exitAccessId;

    @Column(name = "exit_time")
    private Instant exitTime;

    @Column(name = "exit_access_ack")
    private Boolean exitAccessAck;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private Zone zone;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private AccessCode accessCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private VisitorBook visitorBook;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private AccessControl access;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneControls", allowSetters = true)
    private AccessCode exitAccessCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public ZoneControl entryTime(Instant entryTime) {
        this.entryTime = entryTime;
        return this;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public ZoneControl cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public ZoneControl cardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Boolean isAccessAck() {
        return accessAck;
    }

    public ZoneControl accessAck(Boolean accessAck) {
        this.accessAck = accessAck;
        return this;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Long getExitAccessId() {
        return exitAccessId;
    }

    public ZoneControl exitAccessId(Long exitAccessId) {
        this.exitAccessId = exitAccessId;
        return this;
    }

    public void setExitAccessId(Long exitAccessId) {
        this.exitAccessId = exitAccessId;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public ZoneControl exitTime(Instant exitTime) {
        this.exitTime = exitTime;
        return this;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public Boolean isExitAccessAck() {
        return exitAccessAck;
    }

    public ZoneControl exitAccessAck(Boolean exitAccessAck) {
        this.exitAccessAck = exitAccessAck;
        return this;
    }

    public void setExitAccessAck(Boolean exitAccessAck) {
        this.exitAccessAck = exitAccessAck;
    }

    public Zone getZone() {
        return zone;
    }

    public ZoneControl zone(Zone zone) {
        this.zone = zone;
        return this;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public ZoneControl accessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ZoneControl employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public ZoneControl visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }

    public AccessControl getAccess() {
        return access;
    }

    public ZoneControl access(AccessControl accessControl) {
        this.access = accessControl;
        return this;
    }

    public void setAccess(AccessControl accessControl) {
        this.access = accessControl;
    }

    public AccessCode getExitAccessCode() {
        return exitAccessCode;
    }

    public ZoneControl exitAccessCode(AccessCode accessCode) {
        this.exitAccessCode = accessCode;
        return this;
    }

    public void setExitAccessCode(AccessCode accessCode) {
        this.exitAccessCode = accessCode;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneControl)) {
            return false;
        }
        return id != null && id.equals(((ZoneControl) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneControl{" +
            "id=" + getId() +
            ", entryTime='" + getEntryTime() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", accessAck='" + isAccessAck() + "'" +
            ", exitAccessId=" + getExitAccessId() +
            ", exitTime='" + getExitTime() + "'" +
            ", exitAccessAck='" + isExitAccessAck() + "'" +
            "}";
    }
}
