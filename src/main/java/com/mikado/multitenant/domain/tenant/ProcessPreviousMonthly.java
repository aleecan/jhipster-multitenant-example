package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ProcessPreviousMonthly.
 */
@Entity
@Table(name = "process_previous_monthly")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessPreviousMonthly implements Serializable {

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

    @Column(name = "check_max_hour")
    private Boolean checkMaxHour;

    @Column(name = "max_hour")
    private Double maxHour;

    @Column(name = "complete_min_hour_after_balance")
    private Boolean completeMinHourAfterBalance;

    @ManyToOne
    @JsonIgnoreProperties(value = "processPreviousMonthlies", allowSetters = true)
    private MonthlyLine lineForDiffMax;

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

    public ProcessPreviousMonthly description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public ProcessPreviousMonthly dateYear(Integer dateYear) {
        this.dateYear = dateYear;
        return this;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public ProcessPreviousMonthly dateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
        return this;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Boolean isSelectStartEndDateOfMonth() {
        return selectStartEndDateOfMonth;
    }

    public ProcessPreviousMonthly selectStartEndDateOfMonth(Boolean selectStartEndDateOfMonth) {
        this.selectStartEndDateOfMonth = selectStartEndDateOfMonth;
        return this;
    }

    public void setSelectStartEndDateOfMonth(Boolean selectStartEndDateOfMonth) {
        this.selectStartEndDateOfMonth = selectStartEndDateOfMonth;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public ProcessPreviousMonthly startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProcessPreviousMonthly endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isCalcWagesSalaryTypeAsMonthly() {
        return calcWagesSalaryTypeAsMonthly;
    }

    public ProcessPreviousMonthly calcWagesSalaryTypeAsMonthly(Boolean calcWagesSalaryTypeAsMonthly) {
        this.calcWagesSalaryTypeAsMonthly = calcWagesSalaryTypeAsMonthly;
        return this;
    }

    public void setCalcWagesSalaryTypeAsMonthly(Boolean calcWagesSalaryTypeAsMonthly) {
        this.calcWagesSalaryTypeAsMonthly = calcWagesSalaryTypeAsMonthly;
    }

    public Boolean isUseDefaultValueForAbsence() {
        return useDefaultValueForAbsence;
    }

    public ProcessPreviousMonthly useDefaultValueForAbsence(Boolean useDefaultValueForAbsence) {
        this.useDefaultValueForAbsence = useDefaultValueForAbsence;
        return this;
    }

    public void setUseDefaultValueForAbsence(Boolean useDefaultValueForAbsence) {
        this.useDefaultValueForAbsence = useDefaultValueForAbsence;
    }

    public Boolean isApplyPercentageForRegularday() {
        return applyPercentageForRegularday;
    }

    public ProcessPreviousMonthly applyPercentageForRegularday(Boolean applyPercentageForRegularday) {
        this.applyPercentageForRegularday = applyPercentageForRegularday;
        return this;
    }

    public void setApplyPercentageForRegularday(Boolean applyPercentageForRegularday) {
        this.applyPercentageForRegularday = applyPercentageForRegularday;
    }

    public Boolean isCheckMaxHour() {
        return checkMaxHour;
    }

    public ProcessPreviousMonthly checkMaxHour(Boolean checkMaxHour) {
        this.checkMaxHour = checkMaxHour;
        return this;
    }

    public void setCheckMaxHour(Boolean checkMaxHour) {
        this.checkMaxHour = checkMaxHour;
    }

    public Double getMaxHour() {
        return maxHour;
    }

    public ProcessPreviousMonthly maxHour(Double maxHour) {
        this.maxHour = maxHour;
        return this;
    }

    public void setMaxHour(Double maxHour) {
        this.maxHour = maxHour;
    }

    public Boolean isCompleteMinHourAfterBalance() {
        return completeMinHourAfterBalance;
    }

    public ProcessPreviousMonthly completeMinHourAfterBalance(Boolean completeMinHourAfterBalance) {
        this.completeMinHourAfterBalance = completeMinHourAfterBalance;
        return this;
    }

    public void setCompleteMinHourAfterBalance(Boolean completeMinHourAfterBalance) {
        this.completeMinHourAfterBalance = completeMinHourAfterBalance;
    }

    public MonthlyLine getLineForDiffMax() {
        return lineForDiffMax;
    }

    public ProcessPreviousMonthly lineForDiffMax(MonthlyLine monthlyLine) {
        this.lineForDiffMax = monthlyLine;
        return this;
    }

    public void setLineForDiffMax(MonthlyLine monthlyLine) {
        this.lineForDiffMax = monthlyLine;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessPreviousMonthly)) {
            return false;
        }
        return id != null && id.equals(((ProcessPreviousMonthly) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessPreviousMonthly{" +
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
            "}";
    }
}
