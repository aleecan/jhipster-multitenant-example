package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Card.
 */
@Entity
@Table(name = "card")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "card_no", length = 20, nullable = false)
    private String cardNo;

    @Size(max = 1)
    @Column(name = "type", length = 1)
    private String type;

    @Column(name = "cancelled")
    private Boolean cancelled;

    @Column(name = "issue_datetime")
    private Instant issueDatetime;

    @Column(name = "expire_datetime")
    private Instant expireDatetime;

    @Size(max = 20)
    @Column(name = "card_code", length = 20)
    private String cardCode;

    @Size(max = 20)
    @Column(name = "pin_code", length = 20)
    private String pinCode;

    @Column(name = "timekeeping")
    private Boolean timekeeping;

    @Column(name = "biometric_enabled")
    private Boolean biometricEnabled;

    @Column(name = "rd_employee")
    private Boolean rdEmployee;

    @Size(max = 3200)
    @Column(name = "fingerprint", length = 3200)
    private String fingerprint;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private VisitorBook visitorBook;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "cards", allowSetters = true)
    private PrivateCode privateCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public Card cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public Card type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isCancelled() {
        return cancelled;
    }

    public Card cancelled(Boolean cancelled) {
        this.cancelled = cancelled;
        return this;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Instant getIssueDatetime() {
        return issueDatetime;
    }

    public Card issueDatetime(Instant issueDatetime) {
        this.issueDatetime = issueDatetime;
        return this;
    }

    public void setIssueDatetime(Instant issueDatetime) {
        this.issueDatetime = issueDatetime;
    }

    public Instant getExpireDatetime() {
        return expireDatetime;
    }

    public Card expireDatetime(Instant expireDatetime) {
        this.expireDatetime = expireDatetime;
        return this;
    }

    public void setExpireDatetime(Instant expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public String getCardCode() {
        return cardCode;
    }

    public Card cardCode(String cardCode) {
        this.cardCode = cardCode;
        return this;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Card pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public Card timekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public Boolean isBiometricEnabled() {
        return biometricEnabled;
    }

    public Card biometricEnabled(Boolean biometricEnabled) {
        this.biometricEnabled = biometricEnabled;
        return this;
    }

    public void setBiometricEnabled(Boolean biometricEnabled) {
        this.biometricEnabled = biometricEnabled;
    }

    public Boolean isRdEmployee() {
        return rdEmployee;
    }

    public Card rdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
        return this;
    }

    public void setRdEmployee(Boolean rdEmployee) {
        this.rdEmployee = rdEmployee;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public Card fingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Instant getCreated() {
        return created;
    }

    public Card created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Card modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Card modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Card employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public Card visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public Card companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public Card companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public Card groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public Card privateCode(PrivateCode privateCode) {
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
        if (!(o instanceof Card)) {
            return false;
        }
        return id != null && id.equals(((Card) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Card{" +
            "id=" + getId() +
            ", cardNo='" + getCardNo() + "'" +
            ", type='" + getType() + "'" +
            ", cancelled='" + isCancelled() + "'" +
            ", issueDatetime='" + getIssueDatetime() + "'" +
            ", expireDatetime='" + getExpireDatetime() + "'" +
            ", cardCode='" + getCardCode() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", biometricEnabled='" + isBiometricEnabled() + "'" +
            ", rdEmployee='" + isRdEmployee() + "'" +
            ", fingerprint='" + getFingerprint() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
