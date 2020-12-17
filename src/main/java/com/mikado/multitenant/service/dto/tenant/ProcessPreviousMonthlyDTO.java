package com.mikado.multitenant.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.ProcessPreviousMonthly} entity.
 */
public class ProcessPreviousMonthlyDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    private Integer dateYear;

    private Integer dateMonth;

    private Boolean selectStartEndDateOfMonth;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean calcWagesSalaryTypeAsMonthly;

    private Boolean useDefaultValueForAbsence;

    private Boolean applyPercentageForRegularday;

    private Boolean checkMaxHour;

    private Double maxHour;

    private Boolean completeMinHourAfterBalance;


    private Long lineForDiffMaxId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean isSelectStartEndDateOfMonth() {
        return selectStartEndDateOfMonth;
    }

    public void setSelectStartEndDateOfMonth(Boolean selectStartEndDateOfMonth) {
        this.selectStartEndDateOfMonth = selectStartEndDateOfMonth;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isCalcWagesSalaryTypeAsMonthly() {
        return calcWagesSalaryTypeAsMonthly;
    }

    public void setCalcWagesSalaryTypeAsMonthly(Boolean calcWagesSalaryTypeAsMonthly) {
        this.calcWagesSalaryTypeAsMonthly = calcWagesSalaryTypeAsMonthly;
    }

    public Boolean isUseDefaultValueForAbsence() {
        return useDefaultValueForAbsence;
    }

    public void setUseDefaultValueForAbsence(Boolean useDefaultValueForAbsence) {
        this.useDefaultValueForAbsence = useDefaultValueForAbsence;
    }

    public Boolean isApplyPercentageForRegularday() {
        return applyPercentageForRegularday;
    }

    public void setApplyPercentageForRegularday(Boolean applyPercentageForRegularday) {
        this.applyPercentageForRegularday = applyPercentageForRegularday;
    }

    public Boolean isCheckMaxHour() {
        return checkMaxHour;
    }

    public void setCheckMaxHour(Boolean checkMaxHour) {
        this.checkMaxHour = checkMaxHour;
    }

    public Double getMaxHour() {
        return maxHour;
    }

    public void setMaxHour(Double maxHour) {
        this.maxHour = maxHour;
    }

    public Boolean isCompleteMinHourAfterBalance() {
        return completeMinHourAfterBalance;
    }

    public void setCompleteMinHourAfterBalance(Boolean completeMinHourAfterBalance) {
        this.completeMinHourAfterBalance = completeMinHourAfterBalance;
    }

    public Long getLineForDiffMaxId() {
        return lineForDiffMaxId;
    }

    public void setLineForDiffMaxId(Long monthlyLineId) {
        this.lineForDiffMaxId = monthlyLineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessPreviousMonthlyDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessPreviousMonthlyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessPreviousMonthlyDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", dateYear=" + getDateYear() +
            ", dateMonth=" + getDateMonth() +
            ", selectStartEndDateOfMonth='" + isSelectStartEndDateOfMonth() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", calcWagesSalaryTypeAsMonthly='" + isCalcWagesSalaryTypeAsMonthly() + "'" +
            ", useDefaultValueForAbsence='" + isUseDefaultValueForAbsence() + "'" +
            ", applyPercentageForRegularday='" + isApplyPercentageForRegularday() + "'" +
            ", checkMaxHour='" + isCheckMaxHour() + "'" +
            ", maxHour=" + getMaxHour() +
            ", completeMinHourAfterBalance='" + isCompleteMinHourAfterBalance() + "'" +
            ", lineForDiffMaxId=" + getLineForDiffMaxId() +
            "}";
    }
}
