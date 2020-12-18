package com.mikado.mikadosaas.service.dto.tenant;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ProcessMonthly} entity.
 */
public class ProcessMonthlyDTO implements Serializable {

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

    private Boolean applyPercentageForTotalday;

    private Boolean addHourFromPreviousMonth;

    private Boolean calcSalary;

    private Boolean findNoOfDayOffFromDaily;

    private Integer missingDayType;

    private Boolean checkMaxHour;

    private Double maxHour;

    private Boolean completeMinHourAfterBalance;

    private Boolean checkSsDayAgainst31Day;


    private Long lineForDiffMaxId;

    private Long lineForDiffMinId;

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

    public Boolean isApplyPercentageForTotalday() {
        return applyPercentageForTotalday;
    }

    public void setApplyPercentageForTotalday(Boolean applyPercentageForTotalday) {
        this.applyPercentageForTotalday = applyPercentageForTotalday;
    }

    public Boolean isAddHourFromPreviousMonth() {
        return addHourFromPreviousMonth;
    }

    public void setAddHourFromPreviousMonth(Boolean addHourFromPreviousMonth) {
        this.addHourFromPreviousMonth = addHourFromPreviousMonth;
    }

    public Boolean isCalcSalary() {
        return calcSalary;
    }

    public void setCalcSalary(Boolean calcSalary) {
        this.calcSalary = calcSalary;
    }

    public Boolean isFindNoOfDayOffFromDaily() {
        return findNoOfDayOffFromDaily;
    }

    public void setFindNoOfDayOffFromDaily(Boolean findNoOfDayOffFromDaily) {
        this.findNoOfDayOffFromDaily = findNoOfDayOffFromDaily;
    }

    public Integer getMissingDayType() {
        return missingDayType;
    }

    public void setMissingDayType(Integer missingDayType) {
        this.missingDayType = missingDayType;
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

    public Boolean isCheckSsDayAgainst31Day() {
        return checkSsDayAgainst31Day;
    }

    public void setCheckSsDayAgainst31Day(Boolean checkSsDayAgainst31Day) {
        this.checkSsDayAgainst31Day = checkSsDayAgainst31Day;
    }

    public Long getLineForDiffMaxId() {
        return lineForDiffMaxId;
    }

    public void setLineForDiffMaxId(Long monthlyLineId) {
        this.lineForDiffMaxId = monthlyLineId;
    }

    public Long getLineForDiffMinId() {
        return lineForDiffMinId;
    }

    public void setLineForDiffMinId(Long monthlyLineId) {
        this.lineForDiffMinId = monthlyLineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessMonthlyDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessMonthlyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessMonthlyDTO{" +
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
            ", applyPercentageForTotalday='" + isApplyPercentageForTotalday() + "'" +
            ", addHourFromPreviousMonth='" + isAddHourFromPreviousMonth() + "'" +
            ", calcSalary='" + isCalcSalary() + "'" +
            ", findNoOfDayOffFromDaily='" + isFindNoOfDayOffFromDaily() + "'" +
            ", missingDayType=" + getMissingDayType() +
            ", checkMaxHour='" + isCheckMaxHour() + "'" +
            ", maxHour=" + getMaxHour() +
            ", completeMinHourAfterBalance='" + isCompleteMinHourAfterBalance() + "'" +
            ", checkSsDayAgainst31Day='" + isCheckSsDayAgainst31Day() + "'" +
            ", lineForDiffMaxId=" + getLineForDiffMaxId() +
            ", lineForDiffMinId=" + getLineForDiffMinId() +
            "}";
    }
}
