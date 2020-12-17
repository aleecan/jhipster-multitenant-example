package com.mikado.multitenant.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.MonthlyPrevious} entity.
 */
public class MonthlyPreviousDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer dateYear;

    @NotNull
    private Integer dateMonth;

    private LocalDate dateFirst;

    private LocalDate dateLast;

    private Double totalDay;

    private Double totalHour;

    private Integer ssDay;

    private Integer taxDay;


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
        if (!(o instanceof MonthlyPreviousDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyPreviousDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyPreviousDTO{" +
            "id=" + getId() +
            ", dateYear=" + getDateYear() +
            ", dateMonth=" + getDateMonth() +
            ", dateFirst='" + getDateFirst() + "'" +
            ", dateLast='" + getDateLast() + "'" +
            ", totalDay=" + getTotalDay() +
            ", totalHour=" + getTotalHour() +
            ", ssDay=" + getSsDay() +
            ", taxDay=" + getTaxDay() +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
