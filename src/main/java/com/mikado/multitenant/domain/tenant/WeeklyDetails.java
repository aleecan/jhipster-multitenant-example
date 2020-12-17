package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A WeeklyDetails.
 */
@Entity
@Table(name = "weekly_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WeeklyDetails implements Serializable {

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
    @JsonIgnoreProperties(value = "weeklyDetails", allowSetters = true)
    private Weekly weekly;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyDetails", allowSetters = true)
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

    public WeeklyDetails numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public WeeklyDetails numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Weekly getWeekly() {
        return weekly;
    }

    public WeeklyDetails weekly(Weekly weekly) {
        this.weekly = weekly;
        return this;
    }

    public void setWeekly(Weekly weekly) {
        this.weekly = weekly;
    }

    public Category getCategory() {
        return category;
    }

    public WeeklyDetails category(Category category) {
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
        if (!(o instanceof WeeklyDetails)) {
            return false;
        }
        return id != null && id.equals(((WeeklyDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyDetails{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
