package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A MonthlyDetails.
 */
@Entity
@Table(name = "monthly_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlyDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numday")
    private Double numday;

    @Column(name = "numhour")
    private Double numhour;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyDetails", allowSetters = true)
    private Monthly monthly;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyDetails", allowSetters = true)
    private MonthlyLine monthlyLine;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumday() {
        return numday;
    }

    public MonthlyDetails numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public MonthlyDetails numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Monthly getMonthly() {
        return monthly;
    }

    public MonthlyDetails monthly(Monthly monthly) {
        this.monthly = monthly;
        return this;
    }

    public void setMonthly(Monthly monthly) {
        this.monthly = monthly;
    }

    public MonthlyLine getMonthlyLine() {
        return monthlyLine;
    }

    public MonthlyDetails monthlyLine(MonthlyLine monthlyLine) {
        this.monthlyLine = monthlyLine;
        return this;
    }

    public void setMonthlyLine(MonthlyLine monthlyLine) {
        this.monthlyLine = monthlyLine;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyDetails)) {
            return false;
        }
        return id != null && id.equals(((MonthlyDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyDetails{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
