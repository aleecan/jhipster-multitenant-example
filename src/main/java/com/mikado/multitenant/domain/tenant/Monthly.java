package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Monthly.
 */
@Entity
@Table(name = "monthly")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Monthly implements Serializable {

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

    @Column(name = "balancing")
    private Integer balancing;

    @Column(name = "total_day")
    private Double totalDay;

    @Column(name = "total_hour")
    private Double totalHour;

    @Column(name = "ss_day")
    private Integer ssDay;

    @Column(name = "tax_day")
    private Integer taxDay;

    @Column(name = "scheduled_day")
    private Double scheduledDay;

    @Column(name = "scheduled_hour")
    private Double scheduledHour;

    @Size(max = 2)
    @Column(name = "missing_day_reason", length = 2)
    private String missingDayReason;

    @Column(name = "salary_hour")
    private Double salaryHour;

    @Column(name = "salary_gross")
    private Double salaryGross;

    @Column(name = "salary_ss_company")
    private Double salarySsCompany;

    @Column(name = "salary_ss_dif")
    private Double salarySsDif;

    @Column(name = "salary_ss")
    private Double salarySs;

    @Column(name = "salary_total")
    private Double salaryTotal;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlies", allowSetters = true)
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

    public Monthly dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public Monthly dateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
        return this;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public LocalDate getDateFirst() {
        return dateFirst;
    }

    public Monthly dateFirst(LocalDate dateFirst) {
        this.dateFirst = dateFirst;
        return this;
    }

    public void setDateFirst(LocalDate dateFirst) {
        this.dateFirst = dateFirst;
    }

    public LocalDate getDateLast() {
        return dateLast;
    }

    public Monthly dateLast(LocalDate dateLast) {
        this.dateLast = dateLast;
        return this;
    }

    public void setDateLast(LocalDate dateLast) {
        this.dateLast = dateLast;
    }

    public Integer getBalancing() {
        return balancing;
    }

    public Monthly balancing(Integer balancing) {
        this.balancing = balancing;
        return this;
    }

    public void setBalancing(Integer balancing) {
        this.balancing = balancing;
    }

    public Double getTotalDay() {
        return totalDay;
    }

    public Monthly totalDay(Double totalDay) {
        this.totalDay = totalDay;
        return this;
    }

    public void setTotalDay(Double totalDay) {
        this.totalDay = totalDay;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public Monthly totalHour(Double totalHour) {
        this.totalHour = totalHour;
        return this;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Integer getSsDay() {
        return ssDay;
    }

    public Monthly ssDay(Integer ssDay) {
        this.ssDay = ssDay;
        return this;
    }

    public void setSsDay(Integer ssDay) {
        this.ssDay = ssDay;
    }

    public Integer getTaxDay() {
        return taxDay;
    }

    public Monthly taxDay(Integer taxDay) {
        this.taxDay = taxDay;
        return this;
    }

    public void setTaxDay(Integer taxDay) {
        this.taxDay = taxDay;
    }

    public Double getScheduledDay() {
        return scheduledDay;
    }

    public Monthly scheduledDay(Double scheduledDay) {
        this.scheduledDay = scheduledDay;
        return this;
    }

    public void setScheduledDay(Double scheduledDay) {
        this.scheduledDay = scheduledDay;
    }

    public Double getScheduledHour() {
        return scheduledHour;
    }

    public Monthly scheduledHour(Double scheduledHour) {
        this.scheduledHour = scheduledHour;
        return this;
    }

    public void setScheduledHour(Double scheduledHour) {
        this.scheduledHour = scheduledHour;
    }

    public String getMissingDayReason() {
        return missingDayReason;
    }

    public Monthly missingDayReason(String missingDayReason) {
        this.missingDayReason = missingDayReason;
        return this;
    }

    public void setMissingDayReason(String missingDayReason) {
        this.missingDayReason = missingDayReason;
    }

    public Double getSalaryHour() {
        return salaryHour;
    }

    public Monthly salaryHour(Double salaryHour) {
        this.salaryHour = salaryHour;
        return this;
    }

    public void setSalaryHour(Double salaryHour) {
        this.salaryHour = salaryHour;
    }

    public Double getSalaryGross() {
        return salaryGross;
    }

    public Monthly salaryGross(Double salaryGross) {
        this.salaryGross = salaryGross;
        return this;
    }

    public void setSalaryGross(Double salaryGross) {
        this.salaryGross = salaryGross;
    }

    public Double getSalarySsCompany() {
        return salarySsCompany;
    }

    public Monthly salarySsCompany(Double salarySsCompany) {
        this.salarySsCompany = salarySsCompany;
        return this;
    }

    public void setSalarySsCompany(Double salarySsCompany) {
        this.salarySsCompany = salarySsCompany;
    }

    public Double getSalarySsDif() {
        return salarySsDif;
    }

    public Monthly salarySsDif(Double salarySsDif) {
        this.salarySsDif = salarySsDif;
        return this;
    }

    public void setSalarySsDif(Double salarySsDif) {
        this.salarySsDif = salarySsDif;
    }

    public Double getSalarySs() {
        return salarySs;
    }

    public Monthly salarySs(Double salarySs) {
        this.salarySs = salarySs;
        return this;
    }

    public void setSalarySs(Double salarySs) {
        this.salarySs = salarySs;
    }

    public Double getSalaryTotal() {
        return salaryTotal;
    }

    public Monthly salaryTotal(Double salaryTotal) {
        this.salaryTotal = salaryTotal;
        return this;
    }

    public void setSalaryTotal(Double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Monthly employee(Employee employee) {
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
        if (!(o instanceof Monthly)) {
            return false;
        }
        return id != null && id.equals(((Monthly) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Monthly{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", dateMonth=" + getDateMonth() +
            ", dateFirst='" + getDateFirst() + "'" +
            ", dateLast='" + getDateLast() + "'" +
            ", balancing=" + getBalancing() +
            ", totalDay=" + getTotalDay() +
            ", totalHour=" + getTotalHour() +
            ", ssDay=" + getSsDay() +
            ", taxDay=" + getTaxDay() +
            ", scheduledDay=" + getScheduledDay() +
            ", scheduledHour=" + getScheduledHour() +
            ", missingDayReason='" + getMissingDayReason() + "'" +
            ", salaryHour=" + getSalaryHour() +
            ", salaryGross=" + getSalaryGross() +
            ", salarySsCompany=" + getSalarySsCompany() +
            ", salarySsDif=" + getSalarySsDif() +
            ", salarySs=" + getSalarySs() +
            ", salaryTotal=" + getSalaryTotal() +
            "}";
    }
}
