package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A AccessControl.
 */
@Entity
@Table(name = "access_control")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_time")
    private Instant dayTime;

    @Size(max = 20)
    @Column(name = "card_no", length = 20)
    private String cardNo;

    @Size(max = 1)
    @Column(name = "card_type", length = 1)
    private String cardType;

    @NotNull
    @Column(name = "direction", nullable = false)
    private Integer direction;

    @Column(name = "accepted")
    private Boolean accepted;

    @Column(name = "access_ack")
    private Boolean accessAck;

    @Column(name = "module_type")
    private Integer moduleType;

    @Column(name = "rd_employee")
    private Boolean rdEmployee;

    @Column(name = "real_time")
    private Boolean realTime;

    @Column(name = "exported")
    private Boolean exported;

    @ManyToOne
    @JsonIgnoreProperties(value = "accessControls", allowSetters = true)
    private Terminal terminal;

    @ManyToOne
    @JsonIgnoreProperties(value = "accessControls", allowSetters = true)
    private AccessCode accessCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "accessControls", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "accessControls", allowSetters = true)
    private VisitorBook visitorBook;

    @ManyToOne
    @JsonIgnoreProperties(value = "accessControls", allowSetters = true)
    private Category reason;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDayTime() {
        return dayTime;
    }

    public AccessControl dayTime(Instant dayTime) {
        this.dayTime = dayTime;
        return this;
    }

    public void setDayTime(Instant dayTime) {
        this.dayTime = dayTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public AccessControl cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public AccessControl cardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getDirection() {
        return direction;
    }

    public AccessControl direction(Integer direction) {
        this.direction = direction;
        return this;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public AccessControl accepted(Boolean accepted) {
        this.accepted = accepted;
        return this;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean isAccessAck() {
        return accessAck;
    }

    public AccessControl accessAck(Boolean accessAck) {
        this.accessAck = accessAck;
        return this;
    }

    public void setAccessAck(Boolean accessAck) {
        this.accessAck = accessAck;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public AccessControl moduleType(Integer moduleType) {
        this.moduleType = moduleType;
        return this;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public Boolean isRdEmployee() {
        return rdEmployee;
    }

    public AccessControl rdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
        return this;
    }

    public void setRdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
    }

    public Boolean isRealTime() {
        return realTime;
    }

    public AccessControl realTime(Boolean realTime) {
        this.realTime = realTime;
        return this;
    }

    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    public Boolean isExported() {
        return exported;
    }

    public AccessControl exported(Boolean exported) {
        this.exported = exported;
        return this;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public AccessControl terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public AccessControl accessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AccessControl employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public AccessControl visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }

    public Category getReason() {
        return reason;
    }

    public AccessControl reason(Category category) {
        this.reason = category;
        return this;
    }

    public void setReason(Category category) {
        this.reason = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessControl)) {
            return false;
        }
        return id != null && id.equals(((AccessControl) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessControl{" +
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
            "}";
    }
}
