package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A GateControl.
 */
@Entity
@Table(name = "gate_control")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GateControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daytime", nullable = false)
    private Instant daytime;

    @NotNull
    @Size(max = 20)
    @Column(name = "card_no", length = 20, nullable = false)
    private String cardNo;

    @NotNull
    @Size(max = 1)
    @Column(name = "card_type", length = 1, nullable = false)
    private String cardType;

    @NotNull
    @Column(name = "direction", nullable = false)
    private Integer direction;

    @Column(name = "access_ack")
    private Boolean accessAck;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "gateControls", allowSetters = true)
    private Gate gate;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "gateControls", allowSetters = true)
    private AccessCode accessCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "gateControls", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "gateControls", allowSetters = true)
    private VisitorBook visitorBook;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "gateControls", allowSetters = true)
    private AccessControl access;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDaytime() {
        return daytime;
    }

    public GateControl daytime(Instant daytime) {
        this.daytime = daytime;
        return this;
    }

    public void setDaytime(Instant daytime) {
        this.daytime = daytime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public GateControl cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public GateControl cardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getDirection() {
        return direction;
    }

    public GateControl direction(Integer direction) {
        this.direction = direction;
        return this;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Boolean isAccessAck() {
        return accessAck;
    }

    public GateControl accessAck(Boolean accessAck) {
        this.accessAck = accessAck;
        return this;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Gate getGate() {
        return gate;
    }

    public GateControl gate(Gate gate) {
        this.gate = gate;
        return this;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public GateControl accessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public GateControl employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public GateControl visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }

    public AccessControl getAccess() {
        return access;
    }

    public GateControl access(AccessControl accessControl) {
        this.access = accessControl;
        return this;
    }

    public void setAccess(AccessControl accessControl) {
        this.access = accessControl;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GateControl)) {
            return false;
        }
        return id != null && id.equals(((GateControl) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GateControl{" +
            "id=" + getId() +
            ", daytime='" + getDaytime() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", direction=" + getDirection() +
            ", accessAck='" + isAccessAck() + "'" +
            "}";
    }
}
