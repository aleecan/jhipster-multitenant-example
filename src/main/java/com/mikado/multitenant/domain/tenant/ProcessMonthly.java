package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ProcessMonthly.
 */
@Entity
@Table(name = "process_monthly")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessMonthly implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "date_year")
    private Integer dateYear;

    @Column(name = "date_month")
    private Integer dateMonth;

    @Column(name = "select_start_end_date_of_month")
    private Boolean selectStartEndDateOfMonth;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "calc_wages_salary_type_as_monthly")
    private Boolean calcWagesSalaryTypeAsMonthly;

    @Column(name = "use_default_value_for_absence")
    private Boolean useDefaultValueForAbsence;

    @Column(name = "apply_percentage_for_regularday")
    private Boolean applyPercentageForRegularday;

    @Column(name = "apply_percentage_for_totalday")
    private Boolean applyPercentageForTotalday;

    @Column(name = "add_hour_from_previous_month")
    private Boolean addHourFromPreviousMonth;

    @Column(name = "calc_salary")
    private Boolean calcSalary;

    @Column(name = "find_no_of_day_off_from_daily")
    private Boolean findNoOfDayOffFromDaily;

    @Column(name = "missing_day_type")
    private Integer missingDayType;

    @Column(name = "check_max_hour")
    private Boolean checkMaxHour;

    @Column(name = "max_hour")
    private Double maxHour;

    @Column(name = "complete_min_hour_after_balance")
    private Boolean completeMinHourAfterBalance;

    @Column(name = "check_ss_day_against_31_day")
    private Boolean checkSsDayAgainst31Day;

    @ManyToOne
    @JsonIgnoreProperties(value = "processMonthlies", allowSetters = true)
    private MonthlyLine lineForDiffMax;

    @ManyToOne
    @JsonIgnoreProperties(value = "processMonthlies", allowSetters = true)
    private MonthlyLine lineForDiffMin;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public ProcessMonthly description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public ProcessMonthly dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public ProcessMonthly dateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
        return this;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Boolean isSelectStartEndDateOfMonth() {
        return selectStartEndDateOfMonth;
    }

    public ProcessMonthly selectStartEndDateOfMonth(Boolean selectStartEndDateOfMonth) {
        this.selectStartEndDateOfMonth = selectStartEndDateOfMonth;
        return this;
    }

    public void setSelectStartEndDateOfMonth(Boolean selectStartEndDateOfMonth) {
        this.selectStartEndDateOfMonth = selectStartEndDateOfMonth;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public ProcessMonthly startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProcessMonthly endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isCalcWagesSalaryTypeAsMonthly() {
        return calcWagesSalaryTypeAsMonthly;
    }

    public ProcessMonthly calcWagesSalaryTypeAsMonthly(Boolean calcWagesSalaryTypeAsMonthly) {
        this.calcWagesSalaryTypeAsMonthly = calcWagesSalaryTypeAsMonthly;
        return this;
    }

    public void setCalcWagesSalaryTypeAsMonthly(Boolean calcWagesSalaryTypeAsMonthly) {
        this.calcWagesSalaryTypeAsMonthly = calcWagesSalaryTypeAsMonthly;
    }

    public Boolean isUseDefaultValueForAbsence() {
        return useDefaultValueForAbsence;
    }

    public ProcessMonthly useDefaultValueForAbsence(Boolean useDefaultValueForAbsence) {
        this.useDefaultValueForAbsence = useDefaultValueForAbsence;
        return this;
    }

    public void setUseDefaultValueForAbsence(Boolean useDefaultValueForAbsence) {
        this.useDefaultValueForAbsence = useDefaultValueForAbsence;
    }

    public Boolean isApplyPercentageForRegularday() {
        return applyPercentageForRegularday;
    }

    public ProcessMonthly applyPercentageForRegularday(Boolean applyPercentageForRegularday) {
        this.applyPercentageForRegularday = applyPercentageForRegularday;
        return this;
    }

    public void setApplyPercentageForRegularday(Boolean applyPercentageForRegularday) {
        this.applyPercentageForRegularday = applyPercentageForRegularday;
    }

    public Boolean isApplyPercentageForTotalday() {
        return applyPercentageForTotalday;
    }

    public ProcessMonthly applyPercentageForTotalday(Boolean applyPercentageForTotalday) {
        this.applyPercentageForTotalday = applyPercentageForTotalday;
        return this;
    }

    public void setApplyPercentageForTotalday(Boolean applyPercentageForTotalday) {
        this.applyPercentageForTotalday = applyPercentageForTotalday;
    }

    public Boolean isAddHourFromPreviousMonth() {
        return addHourFromPreviousMonth;
    }

    public ProcessMonthly addHourFromPreviousMonth(Boolean addHourFromPreviousMonth) {
        this.addHourFromPreviousMonth = addHourFromPreviousMonth;
        return this;
    }

    public void setAddHourFromPreviousMonth(Boolean addHourFromPreviousMonth) {
        this.addHourFromPreviousMonth = addHourFromPreviousMonth;
    }

    public Boolean isCalcSalary() {
        return calcSalary;
    }

    public ProcessMonthly calcSalary(Boolean calcSalary) {
        this.calcSalary = calcSalary;
        return this;
    }

    public void setCalcSalary(Boolean calcSalary) {
        this.calcSalary = calcSalary;
    }

    public Boolean isFindNoOfDayOffFromDaily() {
        return findNoOfDayOffFromDaily;
    }

    public ProcessMonthly findNoOfDayOffFromDaily(Boolean findNoOfDayOffFromDaily) {
        this.findNoOfDayOffFromDaily = findNoOfDayOffFromDaily;
        return this;
    }

    public void setFindNoOfDayOffFromDaily(Boolean findNoOfDayOffFromDaily) {
        this.findNoOfDayOffFromDaily = findNoOfDayOffFromDaily;
    }

    public Integer getMissingDayType() {
        return missingDayType;
    }

    public ProcessMonthly missingDayType(Integer missingDayType) {
        this.missingDayType = missingDayType;
        return this;
    }

    public void setMissingDayType(Integer missingDayType) {
        this.missingDayType = missingDayType;
    }

    public Boolean isCheckMaxHour() {
        return checkMaxHour;
    }

    public ProcessMonthly checkMaxHour(Boolean checkMaxHour) {
        this.checkMaxHour = checkMaxHour;
        return this;
    }

    public void setCheckMaxHour(Boolean checkMaxHour) {
        this.checkMaxHour = checkMaxHour;
    }

    public Double getMaxHour() {
        return maxHour;
    }

    public ProcessMonthly maxHour(Double maxHour) {
        this.maxHour = maxHour;
        return this;
    }

    public void setMaxHour(Double maxHour) {
        this.maxHour = maxHour;
    }

    public Boolean isCompleteMinHourAfterBalance() {
        return completeMinHourAfterBalance;
    }

    public ProcessMonthly completeMinHourAfterBalance(Boolean completeMinHourAfterBalance) {
        this.completeMinHourAfterBalance = completeMinHourAfterBalance;
        return this;
    }

    public void setCompleteMinHourAfterBalance(Boolean completeMinHourAfterBalance) {
        this.completeMinHourAfterBalance = completeMinHourAfterBalance;
    }

    public Boolean isCheckSsDayAgainst31Day() {
        return checkSsDayAgainst31Day;
    }

    public ProcessMonthly checkSsDayAgainst31Day(Boolean checkSsDayAgainst31Day) {
        this.checkSsDayAgainst31Day = checkSsDayAgainst31Day;
        return this;
    }

    public void setCheckSsDayAgainst31Day(Boolean checkSsDayAgainst31Day) {
        this.checkSsDayAgainst31Day = checkSsDayAgainst31Day;
    }

    public MonthlyLine getLineForDiffMax() {
        return lineForDiffMax;
    }

    public ProcessMonthly lineForDiffMax(MonthlyLine monthlyLine) {
        this.lineForDiffMax = monthlyLine;
        return this;
    }

    public void setLineForDiffMax(MonthlyLine monthlyLine) {
        this.lineForDiffMax = monthlyLine;
    }

    public MonthlyLine getLineForDiffMin() {
        return lineForDiffMin;
    }

    public ProcessMonthly lineForDiffMin(MonthlyLine monthlyLine) {
        this.lineForDiffMin = monthlyLine;
        return this;
    }

    public void setLineForDiffMin(MonthlyLine monthlyLine) {
        this.lineForDiffMin = monthlyLine;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessMonthly)) {
            return false;
        }
        return id != null && id.equals(((ProcessMonthly) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessMonthly{" +
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
            "}";
    }
}
