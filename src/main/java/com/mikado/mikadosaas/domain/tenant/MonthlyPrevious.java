package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A MonthlyPrevious.
 */
@Entity
@Table(name = "monthly_previous")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlyPrevious implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_year", nullable = false)
    private Integer dateYear;

    @NotNull
    @Column(name = "date_month", nullable = false)
    private Integer dateMonth;

    @Column(name = "date_first")
    private LocalDate dateFirst;

    @Column(name = "date_last")
    private LocalDate dateLast;

    @Column(name = "total_day")
    private Double totalDay;

    @Column(name = "total_hour")
    private Double totalHour;

    @Column(name = "ss_day")
    private Integer ssDay;

    @Column(name = "tax_day")
    private Integer taxDay;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyPrevious", allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public MonthlyPrevious dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public MonthlyPrevious dateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
        return this;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public LocalDate getDateFirst() {
        return dateFirst;
    }

    public MonthlyPrevious dateFirst(LocalDate dateFirst) {
        this.dateFirst = dateFirst;
        return this;
    }

    public void setDateFirst(LocalDate dateFirst) {
        this.dateFirst = dateFirst;
    }

    public LocalDate getDateLast() {
        return dateLast;
    }

    public MonthlyPrevious dateLast(LocalDate dateLast) {
        this.dateLast = dateLast;
        return this;
    }

    public void setDateLast(LocalDate dateLast) {
        this.dateLast = dateLast;
    }

    public Double getTotalDay() {
        return totalDay;
    }

    public MonthlyPrevious totalDay(Double totalDay) {
        this.totalDay = totalDay;
        return this;
    }

    public void setTotalDay(Double totalDay) {
        this.totalDay = totalDay;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public MonthlyPrevious totalHour(Double totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Integer getSsDay() {
        return ssDay;
    }

    public MonthlyPrevious ssDay(Integer ssDay) {
        this.ssDay = ssDay;
        return this;
    }

    public void setSsDay(Integer ssDay) {
        this.ssDay = ssDay;
    }

    public Integer getTaxDay() {
        return taxDay;
    }

    public MonthlyPrevious taxDay(Integer taxDay) {
        this.taxDay = taxDay;
        return this;
    }

    public void setTaxDay(Integer taxDay) {
        this.taxDay = taxDay;
    }

    public Employee getEmployee() {
        return employee;
    }

    public MonthlyPrevious employee(Employee employee) {
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
        if (!(o instanceof MonthlyPrevious)) {
            return false;
        }
        return id != null && id.equals(((MonthlyPrevious) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyPrevious{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", dateMonth=" + getDateMonth() +
            ", dateFirst='" + getDateFirst() + "'" +
            ", dateLast='" + getDateLast() + "'" +
            ", totalDay=" + getTotalDay() +
            ", totalHour=" + getTotalHour() +
            ", ssDay=" + getSsDay() +
            ", taxDay=" + getTaxDay() +
            "}";
    }
}
