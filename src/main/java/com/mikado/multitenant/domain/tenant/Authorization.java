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
 * A Authorization.
 */
@Entity
@Table(name = "authorization")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Authorization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "authorization_group_id", nullable = false)
    private Long authorizationGroupId;

    @Column(name = "validity_start")
    private Instant validityStart;

    @Column(name = "validity_end")
    private Instant validityEnd;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "authorizations", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "authorizations", allowSetters = true)
    private VisitorBook visitorBook;

    @ManyToOne
    @JsonIgnoreProperties(value = "authorizations", allowSetters = true)
    private Card card;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorizationGroupId() {
        return authorizationGroupId;
    }

    public Authorization authorizationGroupId(Long authorizationGroupId) {
        this.authorizationGroupId = authorizationGroupId;
        return this;
    }

    public void setAuthorizationGroupId(Long authorizationGroupId) {
        this.authorizationGroupId = authorizationGroupId;
    }

    public Instant getValidityStart() {
        return validityStart;
    }

    public Authorization validityStart(Instant validityStart) {
        this.validityStart = validityStart;
        return this;
    }

    public void setValidityStart(Instant validityStart) {
        this.validityStart = validityStart;
    }

    public Instant getValidityEnd() {
        return validityEnd;
    }

    public Authorization validityEnd(Instant validityEnd) {
        this.validityEnd = validityEnd;
        return this;
    }

    public void setValidityEnd(Instant validityEnd) {
        this.validityEnd = validityEnd;
    }

    public Instant getCreated() {
        return created;
    }

    public Authorization created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Authorization modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Authorization modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Authorization employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public Authorization visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }

    public Card getCard() {
        return card;
    }

    public Authorization card(Card card) {
        this.card = card;
        return this;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Authorization)) {
            return false;
        }
        return id != null && id.equals(((Authorization) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Authorization{" +
            "id=" + getId() +
            ", authorizationGroupId=" + getAuthorizationGroupId() +
            ", validityStart='" + getValidityStart() + "'" +
            ", validityEnd='" + getValidityEnd() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
