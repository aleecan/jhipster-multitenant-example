package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A WeeklyBalanceDetails.
 */
@Entity
@Table(name = "weekly_balance_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WeeklyBalanceDetails implements Serializable {

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
    @JsonIgnoreProperties(value = "weeklyBalanceDetails", allowSetters = true)
    private WeeklyBalance weeklyBalance;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyBalanceDetails", allowSetters = true)
    private Category category;

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

    public WeeklyBalanceDetails numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public WeeklyBalanceDetails numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public WeeklyBalance getWeeklyBalance() {
        return weeklyBalance;
    }

    public WeeklyBalanceDetails weeklyBalance(WeeklyBalance weeklyBalance) {
        this.weeklyBalance = weeklyBalance;
        return this;
    }

    public void setWeeklyBalance(WeeklyBalance weeklyBalance) {
        this.weeklyBalance = weeklyBalance;
    }

    public Category getCategory() {
        return category;
    }

    public WeeklyBalanceDetails category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyBalanceDetails)) {
            return false;
        }
        return id != null && id.equals(((WeeklyBalanceDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyBalanceDetails{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
