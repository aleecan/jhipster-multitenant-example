package com.mikado.multitenant.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Monthly} entity.
 */
public class MonthlyDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer dateYear;

    @NotNull
    private Integer dateMonth;

    private LocalDate dateFirst;

    private LocalDate dateLast;

    private Integer balancing;

    private Double totalDay;

    private Double totalHour;

    private Integer ssDay;

    private Integer taxDay;

    private Double scheduledDay;

    private Double scheduledHour;

    @Size(max = 2)
    private String missingDayReason;

    private Double salaryHour;

    private Double salaryGross;

    private Double salarySsCompany;

    private Double salarySsDif;

    private Double salarySs;

    private Double salaryTotal;


    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public LocalDate getDateFirst() {
        return dateFirst;
    }

    public void setDateFirst(LocalDate dateFirst) {
        this.dateFirst = dateFirst;
    }

    public LocalDate getDateLast() {
        return dateLast;
    }

    public void setDateLast(LocalDate dateLast) {
        this.dateLast = dateLast;
    }

    public Integer getBalancing() {
        return balancing;
    }

    public void setBalancing(Integer balancing) {
        this.balancing = balancing;
    }

    public Double getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Double totalDay) {
        this.totalDay = totalDay;
    }

    public Double getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Double totalHour) {
        this.totalHour = totalHour;
    }

    public Integer getSsDay() {
        return ssDay;
    }

    public void setSsDay(Integer ssDay) {
        this.ssDay = ssDay;
    }

    public Integer getTaxDay() {
        return taxDay;
    }

    public void setTaxDay(Integer taxDay) {
        this.taxDay = taxDay;
    }

    public Double getScheduledDay() {
        return scheduledDay;
    }

    public void setScheduledDay(Double scheduledDay) {
        this.scheduledDay = scheduledDay;
    }

    public Double getScheduledHour() {
        return scheduledHour;
    }

    public void setScheduledHour(Double scheduledHour) {
        this.scheduledHour = scheduledHour;
    }

    public String getMissingDayReason() {
        return missingDayReason;
    }

    public void setMissingDayReason(String missingDayReason) {
        this.missingDayReason = missingDayReason;
    }

    public Double getSalaryHour() {
        return salaryHour;
    }

    public void setSalaryHour(Double salaryHour) {
        this.salaryHour = salaryHour;
    }

    public Double getSalaryGross() {
        return salaryGross;
    }

    public void setSalaryGross(Double salaryGross) {
        this.salaryGross = salaryGross;
    }

    public Double getSalarySsCompany() {
        return salarySsCompany;
    }

    public void setSalarySsCompany(Double salarySsCompany) {
        this.salarySsCompany = salarySsCompany;
    }

    public Double getSalarySsDif() {
        return salarySsDif;
    }

    public void setSalarySsDif(Double salarySsDif) {
        this.salarySsDif = salarySsDif;
    }

    public Double getSalarySs() {
        return salarySs;
    }

    public void setSalarySs(Double salarySs) {
        this.salarySs = salarySs;
    }

    public Double getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(Double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyDTO{" +
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
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
