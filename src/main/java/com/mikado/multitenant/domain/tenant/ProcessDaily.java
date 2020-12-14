package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A ProcessDaily.
 */
@Entity
@Table(name = "process_daily")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessDaily implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "close_month")
    private Boolean closeMonth;

    @Column(name = "check_early_entry_late_exit")
    private Boolean checkEarlyEntryLateExit;

    @Column(name = "check_late_entry_early_exit")
    private Boolean checkLateEntryEarlyExit;

    @Column(name = "apply_tolerance_first_entry_last_exit")
    private Boolean applyToleranceFirstEntryLastExit;

    @Column(name = "check_prev_and_next_day_schedule")
    private Boolean checkPrevAndNextDaySchedule;

    @Column(name = "use_prev_day_shift_group")
    private Boolean usePrevDayShiftGroup;

    @Column(name = "complete_work_when_missing_entry_exit")
    private Boolean completeWorkWhenMissingEntryExit;

    @Column(name = "check_weekly_work_hours")
    private Boolean checkWeeklyWorkHours;

    @Column(name = "calc_weekend_days_from_daily")
    private Boolean calcWeekendDaysFromDaily;

    @Column(name = "holiday_payment")
    private Boolean holidayPayment;

    @Column(name = "weekly_work_days_for_holiday_payment")
    private Integer weeklyWorkDaysForHolidayPayment;

    @Column(name = "min_weekly_work_hour_for_holiday_payment")
    private Double minWeeklyWorkHourForHolidayPayment;

    @Column(name = "check_only_last_consecutive_working_days")
    private Boolean checkOnlyLastConsecutiveWorkingDays;

    @Column(name = "apply_ratio")
    private Boolean applyRatio;

    @Column(name = "divide_the_no_of_worked_days")
    private Boolean divideTheNoOfWorkedDays;

    @Column(name = "no_holiday_payment_in_case_of_absence")
    private Boolean noHolidayPaymentInCaseOfAbsence;

    @Column(name = "at_least_one_day_absence")
    private Boolean atLeastOneDayAbsence;

    @Column(name = "transfer_extra_hours")
    private Boolean transferExtraHours;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "processDailies", allowSetters = true)
    private Category extraHourCategory;

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

    public ProcessDaily description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isCloseMonth() {
        return closeMonth;
    }

    public ProcessDaily closeMonth(Boolean closeMonth) {
        this.closeMonth = closeMonth;
        return this;
    }

    public void setCloseMonth(Boolean closeMonth) {
        this.closeMonth = closeMonth;
    }

    public Boolean isCheckEarlyEntryLateExit() {
        return checkEarlyEntryLateExit;
    }

    public ProcessDaily checkEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
        return this;
    }

    public void setCheckEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
    }

    public Boolean isCheckLateEntryEarlyExit() {
        return checkLateEntryEarlyExit;
    }

    public ProcessDaily checkLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
        return this;
    }

    public void setCheckLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
    }

    public Boolean isApplyToleranceFirstEntryLastExit() {
        return applyToleranceFirstEntryLastExit;
    }

    public ProcessDaily applyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
        return this;
    }

    public void setApplyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
    }

    public Boolean isCheckPrevAndNextDaySchedule() {
        return checkPrevAndNextDaySchedule;
    }

    public ProcessDaily checkPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
        return this;
    }

    public void setCheckPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public ProcessDaily usePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
        return this;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
    }

    public Boolean isCompleteWorkWhenMissingEntryExit() {
        return completeWorkWhenMissingEntryExit;
    }

    public ProcessDaily completeWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
        return this;
    }

    public void setCompleteWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
    }

    public Boolean isCheckWeeklyWorkHours() {
        return checkWeeklyWorkHours;
    }

    public ProcessDaily checkWeeklyWorkHours(Boolean checkWeeklyWorkHours) {
        this.checkWeeklyWorkHours = checkWeeklyWorkHours;
        return this;
    }

    public void setCheckWeeklyWorkHours(Boolean checkWeeklyWorkHours) {
        this.checkWeeklyWorkHours = checkWeeklyWorkHours;
    }

    public Boolean isCalcWeekendDaysFromDaily() {
        return calcWeekendDaysFromDaily;
    }

    public ProcessDaily calcWeekendDaysFromDaily(Boolean calcWeekendDaysFromDaily) {
        this.calcWeekendDaysFromDaily = calcWeekendDaysFromDaily;
        return this;
    }

    public void setCalcWeekendDaysFromDaily(Boolean calcWeekendDaysFromDaily) {
        this.calcWeekendDaysFromDaily = calcWeekendDaysFromDaily;
    }

    public Boolean isHolidayPayment() {
        return holidayPayment;
    }

    public ProcessDaily holidayPayment(Boolean holidayPayment) {
        this.holidayPayment = holidayPayment;
        return this;
    }

    public void setHolidayPayment(Boolean holidayPayment) {
        this.holidayPayment = holidayPayment;
    }

    public Integer getWeeklyWorkDaysForHolidayPayment() {
        return weeklyWorkDaysForHolidayPayment;
    }

    public ProcessDaily weeklyWorkDaysForHolidayPayment(Integer weeklyWorkDaysForHolidayPayment) {
        this.weeklyWorkDaysForHolidayPayment = weeklyWorkDaysForHolidayPayment;
        return this;
    }

    public void setWeeklyWorkDaysForHolidayPayment(Integer weeklyWorkDaysForHolidayPayment) {
        this.weeklyWorkDaysForHolidayPayment = weeklyWorkDaysForHolidayPayment;
    }

    public Double getMinWeeklyWorkHourForHolidayPayment() {
        return minWeeklyWorkHourForHolidayPayment;
    }

    public ProcessDaily minWeeklyWorkHourForHolidayPayment(Double minWeeklyWorkHourForHolidayPayment) {
        this.minWeeklyWorkHourForHolidayPayment = minWeeklyWorkHourForHolidayPayment;
        return this;
    }

    public void setMinWeeklyWorkHourForHolidayPayment(Double minWeeklyWorkHourForHolidayPayment) {
        this.minWeeklyWorkHourForHolidayPayment = minWeeklyWorkHourForHolidayPayment;
    }

    public Boolean isCheckOnlyLastConsecutiveWorkingDays() {
        return checkOnlyLastConsecutiveWorkingDays;
    }

    public ProcessDaily checkOnlyLastConsecutiveWorkingDays(Boolean checkOnlyLastConsecutiveWorkingDays) {
        this.checkOnlyLastConsecutiveWorkingDays = checkOnlyLastConsecutiveWorkingDays;
        return this;
    }

    public void setCheckOnlyLastConsecutiveWorkingDays(Boolean checkOnlyLastConsecutiveWorkingDays) {
        this.checkOnlyLastConsecutiveWorkingDays = checkOnlyLastConsecutiveWorkingDays;
    }

    public Boolean isApplyRatio() {
        return applyRatio;
    }

    public ProcessDaily applyRatio(Boolean applyRatio) {
        this.applyRatio = applyRatio;
        return this;
    }

    public void setApplyRatio(Boolean applyRatio) {
        this.applyRatio = applyRatio;
    }

    public Boolean isDivideTheNoOfWorkedDays() {
        return divideTheNoOfWorkedDays;
    }

    public ProcessDaily divideTheNoOfWorkedDays(Boolean divideTheNoOfWorkedDays) {
        this.divideTheNoOfWorkedDays = divideTheNoOfWorkedDays;
        return this;
    }

    public void setDivideTheNoOfWorkedDays(Boolean divideTheNoOfWorkedDays) {
        this.divideTheNoOfWorkedDays = divideTheNoOfWorkedDays;
    }

    public Boolean isNoHolidayPaymentInCaseOfAbsence() {
        return noHolidayPaymentInCaseOfAbsence;
    }

    public ProcessDaily noHolidayPaymentInCaseOfAbsence(Boolean noHolidayPaymentInCaseOfAbsence) {
        this.noHolidayPaymentInCaseOfAbsence = noHolidayPaymentInCaseOfAbsence;
        return this;
    }

    public void setNoHolidayPaymentInCaseOfAbsence(Boolean noHolidayPaymentInCaseOfAbsence) {
        this.noHolidayPaymentInCaseOfAbsence = noHolidayPaymentInCaseOfAbsence;
    }

    public Boolean isAtLeastOneDayAbsence() {
        return atLeastOneDayAbsence;
    }

    public ProcessDaily atLeastOneDayAbsence(Boolean atLeastOneDayAbsence) {
        this.atLeastOneDayAbsence = atLeastOneDayAbsence;
        return this;
    }

    public void setAtLeastOneDayAbsence(Boolean atLeastOneDayAbsence) {
        this.atLeastOneDayAbsence = atLeastOneDayAbsence;
    }

    public Boolean isTransferExtraHours() {
        return transferExtraHours;
    }

    public ProcessDaily transferExtraHours(Boolean transferExtraHours) {
        this.transferExtraHours = transferExtraHours;
        return this;
    }

    public void setTransferExtraHours(Boolean transferExtraHours) {
        this.transferExtraHours = transferExtraHours;
    }

    public Instant getCreated() {
        return created;
    }

    public ProcessDaily created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ProcessDaily modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ProcessDaily modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Category getExtraHourCategory() {
        return extraHourCategory;
    }

    public ProcessDaily extraHourCategory(Category category) {
        this.extraHourCategory = category;
        return this;
    }

    public void setExtraHourCategory(Category category) {
        this.extraHourCategory = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessDaily)) {
            return false;
        }
        return id != null && id.equals(((ProcessDaily) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessDaily{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", closeMonth='" + isCloseMonth() + "'" +
            ", checkEarlyEntryLateExit='" + isCheckEarlyEntryLateExit() + "'" +
            ", checkLateEntryEarlyExit='" + isCheckLateEntryEarlyExit() + "'" +
            ", applyToleranceFirstEntryLastExit='" + isApplyToleranceFirstEntryLastExit() + "'" +
            ", checkPrevAndNextDaySchedule='" + isCheckPrevAndNextDaySchedule() + "'" +
            ", usePrevDayShiftGroup='" + isUsePrevDayShiftGroup() + "'" +
            ", completeWorkWhenMissingEntryExit='" + isCompleteWorkWhenMissingEntryExit() + "'" +
            ", checkWeeklyWorkHours='" + isCheckWeeklyWorkHours() + "'" +
            ", calcWeekendDaysFromDaily='" + isCalcWeekendDaysFromDaily() + "'" +
            ", holidayPayment='" + isHolidayPayment() + "'" +
            ", weeklyWorkDaysForHolidayPayment=" + getWeeklyWorkDaysForHolidayPayment() +
            ", minWeeklyWorkHourForHolidayPayment=" + getMinWeeklyWorkHourForHolidayPayment() +
            ", checkOnlyLastConsecutiveWorkingDays='" + isCheckOnlyLastConsecutiveWorkingDays() + "'" +
            ", applyRatio='" + isApplyRatio() + "'" +
            ", divideTheNoOfWorkedDays='" + isDivideTheNoOfWorkedDays() + "'" +
            ", noHolidayPaymentInCaseOfAbsence='" + isNoHolidayPaymentInCaseOfAbsence() + "'" +
            ", atLeastOneDayAbsence='" + isAtLeastOneDayAbsence() + "'" +
            ", transferExtraHours='" + isTransferExtraHours() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
