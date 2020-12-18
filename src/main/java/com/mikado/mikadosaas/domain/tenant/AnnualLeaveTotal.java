package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A AnnualLeaveTotal.
 */
@Entity
@Table(name = "annual_leave_total")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnnualLeaveTotal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "al_left")
    private Double alLeft;

    @Column(name = "al_right")
    private Double alRight;

    @Column(name = "al_used")
    private Double alUsed;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAlLeft() {
        return alLeft;
    }

    public AnnualLeaveTotal alLeft(Double alLeft) {
        this.alLeft = alLeft;
        return this;
    }

    public void setAlLeft(Double alLeft) {
        this.alLeft = alLeft;
    }

    public Double getAlRight() {
        return alRight;
    }

    public AnnualLeaveTotal alRight(Double alRight) {
        this.alRight = alRight;
        return this;
    }

    public void setAlRight(Double alRight) {
        this.alRight = alRight;
    }

    public Double getAlUsed() {
        return alUsed;
    }

    public AnnualLeaveTotal alUsed(Double alUsed) {
        this.alUsed = alUsed;
        return this;
    }

    public void setAlUsed(Double alUsed) {
        this.alUsed = alUsed;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AnnualLeaveTotal employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveTotal)) {
            return false;
        }
        return id != null && id.equals(((AnnualLeaveTotal) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveTotal{" +
            "id=" + getId() +
            ", alLeft=" + getAlLeft() +
            ", alRight=" + getAlRight() +
            ", alUsed=" + getAlUsed() +
            "}";
    }
}
