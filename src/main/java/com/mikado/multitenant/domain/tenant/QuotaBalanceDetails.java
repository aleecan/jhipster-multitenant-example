package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A QuotaBalanceDetails.
 */
@Entity
@Table(name = "quota_balance_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QuotaBalanceDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @Column(name = "day_count")
    private Double dayCount;

    @Column(name = "day_lenthh")
    private Double dayLenthh;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaBalanceDetails", allowSetters = true)
    private QuotaBalance quotaBalance;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaBalanceDetails", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public QuotaBalanceDetails daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public Double getDayCount() {
        return dayCount;
    }

    public QuotaBalanceDetails dayCount(Double dayCount) {
        this.dayCount = dayCount;
        return this;
    }

    public void setDayCount(Double dayCount) {
        this.dayCount = dayCount;
    }

    public Double getDayLenthh() {
        return dayLenthh;
    }

    public QuotaBalanceDetails dayLenthh(Double dayLenthh) {
        this.dayLenthh = dayLenthh;
        return this;
    }

    public void setDayLenthh(Double dayLenthh) {
        this.dayLenthh = dayLenthh;
    }

    public QuotaBalance getQuotaBalance() {
        return quotaBalance;
    }

    public QuotaBalanceDetails quotaBalance(QuotaBalance quotaBalance) {
        this.quotaBalance = quotaBalance;
        return this;
    }

    public void setQuotaBalance(QuotaBalance quotaBalance) {
        this.quotaBalance = quotaBalance;
    }

    public Category getCategory() {
        return category;
    }

    public QuotaBalanceDetails category(Category category) {
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
        if (!(o instanceof QuotaBalanceDetails)) {
            return false;
        }
        return id != null && id.equals(((QuotaBalanceDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaBalanceDetails{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", dayCount=" + getDayCount() +
            ", dayLenthh=" + getDayLenthh() +
            "}";
    }
}
