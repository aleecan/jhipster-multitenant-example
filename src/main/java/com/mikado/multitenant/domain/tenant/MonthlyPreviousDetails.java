package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A MonthlyPreviousDetails.
 */
@Entity
@Table(name = "monthly_previous_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlyPreviousDetails implements Serializable {

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
    @JsonIgnoreProperties(value = "monthlyPreviousDetails", allowSetters = true)
    private MonthlyPrevious monthlyPrevious;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyPreviousDetails", allowSetters = true)
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

    public MonthlyPreviousDetails numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public MonthlyPreviousDetails numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public MonthlyPrevious getMonthlyPrevious() {
        return monthlyPrevious;
    }

    public MonthlyPreviousDetails monthlyPrevious(MonthlyPrevious monthlyPrevious) {
        this.monthlyPrevious = monthlyPrevious;
        return this;
    }

    public void setMonthlyPrevious(MonthlyPrevious monthlyPrevious) {
        this.monthlyPrevious = monthlyPrevious;
    }

    public MonthlyLine getMonthlyLine() {
        return monthlyLine;
    }

    public MonthlyPreviousDetails monthlyLine(MonthlyLine monthlyLine) {
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
        if (!(o instanceof MonthlyPreviousDetails)) {
            return false;
        }
        return id != null && id.equals(((MonthlyPreviousDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyPreviousDetails{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
