package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A AccessRangeVisitor.
 */
@Entity
@Table(name = "access_range_visitor")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessRangeVisitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_time")
    private Instant firstTime;

    @Column(name = "last_time")
    private Instant lastTime;

    @Column(name = "last_in_time")
    private Instant lastInTime;

    @Column(name = "last_out_time")
    private Instant lastOutTime;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "accessRangeVisitors", allowSetters = true)
    private VisitorBook visitorBook;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFirstTime() {
        return firstTime;
    }

    public AccessRangeVisitor firstTime(Instant firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public void setFirstTime(Instant firstTime) {
        this.firstTime = firstTime;
    }

    public Instant getLastTime() {
        return lastTime;
    }

    public AccessRangeVisitor lastTime(Instant lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public void setLastTime(Instant lastTime) {
        this.lastTime = lastTime;
    }

    public Instant getLastInTime() {
        return lastInTime;
    }

    public AccessRangeVisitor lastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
        return this;
    }

    public void setLastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
    }

    public Instant getLastOutTime() {
        return lastOutTime;
    }

    public AccessRangeVisitor lastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
        return this;
    }

    public void setLastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
    }

    public VisitorBook getVisitorBook() {
        return visitorBook;
    }

    public AccessRangeVisitor visitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
        return this;
    }

    public void setVisitorBook(VisitorBook visitorBook) {
        this.visitorBook = visitorBook;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessRangeVisitor)) {
            return false;
        }
        return id != null && id.equals(((AccessRangeVisitor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessRangeVisitor{" +
            "id=" + getId() +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", lastInTime='" + getLastInTime() + "'" +
            ", lastOutTime='" + getLastOutTime() + "'" +
            "}";
    }
}
