package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A DailyDetails.
 */
@Entity
@Table(name = "daily_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DailyDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "day_length", length = 8)
    private String dayLength;

    @Column(name = "day_count")
    private Double dayCount;

    @Column(name = "day_lengthh")
    private Double dayLengthh;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "dailyDetails", allowSetters = true)
    private Daily daily;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "dailyDetails", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayLength() {
        return dayLength;
    }

    public DailyDetails dayLength(String dayLength) {
        this.dayLength = dayLength;
        return this;
    }

    public void setDayLength(String dayLength) {
        this.dayLength = dayLength;
    }

    public Double getDayCount() {
        return dayCount;
    }

    public DailyDetails dayCount(Double dayCount) {
        this.dayCount = dayCount;
        return this;
    }

    public void setDayCount(Double dayCount) {
        this.dayCount = dayCount;
    }

    public Double getDayLengthh() {
        return dayLengthh;
    }

    public DailyDetails dayLengthh(Double dayLengthh) {
        this.dayLengthh = dayLengthh;
        return this;
    }

    public void setDayLengthh(Double dayLengthh) {
        this.dayLengthh = dayLengthh;
    }

    public Daily getDaily() {
        return daily;
    }

    public DailyDetails daily(Daily daily) {
        this.daily = daily;
        return this;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Category getCategory() {
        return category;
    }

    public DailyDetails category(Category category) {
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
        if (!(o instanceof DailyDetails)) {
            return false;
        }
        return id != null && id.equals(((DailyDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyDetails{" +
            "id=" + getId() +
            ", dayLength='" + getDayLength() + "'" +
            ", dayCount=" + getDayCount() +
            ", dayLengthh=" + getDayLengthh() +
            "}";
    }
}
