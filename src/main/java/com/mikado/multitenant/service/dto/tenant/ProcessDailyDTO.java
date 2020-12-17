package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.ProcessDaily} entity.
 */
public class ProcessDailyDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    private Boolean closeMonth;

    private Boolean checkEarlyEntryLateExit;

    private Boolean checkLateEntryEarlyExit;

    private Boolean applyToleranceFirstEntryLastExit;

    private Boolean checkPrevAndNextDaySchedule;

    private Boolean usePrevDayShiftGroup;

    private Boolean completeWorkWhenMissingEntryExit;

    private Boolean checkWeeklyWorkHours;

    private Boolean calcWeekendDaysFromDaily;

    private Boolean holidayPayment;

    private Integer weeklyWorkDaysForHolidayPayment;

    private Double minWeeklyWorkHourForHolidayPayment;

    private Boolean checkOnlyLastConsecutiveWorkingDays;

    private Boolean applyRatio;

    private Boolean divideTheNoOfWorkedDays;

    private Boolean noHolidayPaymentInCaseOfAbsence;

    private Boolean atLeastOneDayAbsence;

    private Boolean transferExtraHours;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long extraHourCategoryId;

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

    public Boolean isCloseMonth() {
        return closeMonth;
    }

    public void setCloseMonth(Boolean closeMonth) {
        this.closeMonth = closeMonth;
    }

    public Boolean isCheckEarlyEntryLateExit() {
        return checkEarlyEntryLateExit;
    }

    public void setCheckEarlyEntryLateExit(Boolean checkEarlyEntryLateExit) {
        this.checkEarlyEntryLateExit = checkEarlyEntryLateExit;
    }

    public Boolean isCheckLateEntryEarlyExit() {
        return checkLateEntryEarlyExit;
    }

    public void setCheckLateEntryEarlyExit(Boolean checkLateEntryEarlyExit) {
        this.checkLateEntryEarlyExit = checkLateEntryEarlyExit;
    }

    public Boolean isApplyToleranceFirstEntryLastExit() {
        return applyToleranceFirstEntryLastExit;
    }

    public void setApplyToleranceFirstEntryLastExit(Boolean applyToleranceFirstEntryLastExit) {
        this.applyToleranceFirstEntryLastExit = applyToleranceFirstEntryLastExit;
    }

    public Boolean isCheckPrevAndNextDaySchedule() {
        return checkPrevAndNextDaySchedule;
    }

    public void setCheckPrevAndNextDaySchedule(Boolean checkPrevAndNextDaySchedule) {
        this.checkPrevAndNextDaySchedule = checkPrevAndNextDaySchedule;
    }

    public Boolean isUsePrevDayShiftGroup() {
        return usePrevDayShiftGroup;
    }

    public void setUsePrevDayShiftGroup(Boolean usePrevDayShiftGroup) {
        this.usePrevDayShiftGroup = usePrevDayShiftGroup;
    }

    public Boolean isCompleteWorkWhenMissingEntryExit() {
        return completeWorkWhenMissingEntryExit;
    }

    public void setCompleteWorkWhenMissingEntryExit(Boolean completeWorkWhenMissingEntryExit) {
        this.completeWorkWhenMissingEntryExit = completeWorkWhenMissingEntryExit;
    }

    public Boolean isCheckWeeklyWorkHours() {
        return checkWeeklyWorkHours;
    }

    public void setCheckWeeklyWorkHours(Boolean checkWeeklyWorkHours) {
        this.checkWeeklyWorkHours = checkWeeklyWorkHours;
    }

    public Boolean isCalcWeekendDaysFromDaily() {
        return calcWeekendDaysFromDaily;
    }

    public void setCalcWeekendDaysFromDaily(Boolean calcWeekendDaysFromDaily) {
        this.calcWeekendDaysFromDaily = calcWeekendDaysFromDaily;
    }

    public Boolean isHolidayPayment() {
        return holidayPayment;
    }

    public void setHolidayPayment(Boolean holidayPayment) {
        this.holidayPayment = holidayPayment;
    }

    public Integer getWeeklyWorkDaysForHolidayPayment() {
        return weeklyWorkDaysForHolidayPayment;
    }

    public void setWeeklyWorkDaysForHolidayPayment(Integer weeklyWorkDaysForHolidayPayment) {
        this.weeklyWorkDaysForHolidayPayment = weeklyWorkDaysForHolidayPayment;
    }

    public Double getMinWeeklyWorkHourForHolidayPayment() {
        return minWeeklyWorkHourForHolidayPayment;
    }

    public void setMinWeeklyWorkHourForHolidayPayment(Double minWeeklyWorkHourForHolidayPayment) {
        this.minWeeklyWorkHourForHolidayPayment = minWeeklyWorkHourForHolidayPayment;
    }

    public Boolean isCheckOnlyLastConsecutiveWorkingDays() {
        return checkOnlyLastConsecutiveWorkingDays;
    }

    public void setCheckOnlyLastConsecutiveWorkingDays(Boolean checkOnlyLastConsecutiveWorkingDays) {
        this.checkOnlyLastConsecutiveWorkingDays = checkOnlyLastConsecutiveWorkingDays;
    }

    public Boolean isApplyRatio() {
        return applyRatio;
    }

    public void setApplyRatio(Boolean applyRatio) {
        this.applyRatio = applyRatio;
    }

    public Boolean isDivideTheNoOfWorkedDays() {
        return divideTheNoOfWorkedDays;
    }

    public void setDivideTheNoOfWorkedDays(Boolean divideTheNoOfWorkedDays) {
        this.divideTheNoOfWorkedDays = divideTheNoOfWorkedDays;
    }

    public Boolean isNoHolidayPaymentInCaseOfAbsence() {
        return noHolidayPaymentInCaseOfAbsence;
    }

    public void setNoHolidayPaymentInCaseOfAbsence(Boolean noHolidayPaymentInCaseOfAbsence) {
        this.noHolidayPaymentInCaseOfAbsence = noHolidayPaymentInCaseOfAbsence;
    }

    public Boolean isAtLeastOneDayAbsence() {
        return atLeastOneDayAbsence;
    }

    public void setAtLeastOneDayAbsence(Boolean atLeastOneDayAbsence) {
        this.atLeastOneDayAbsence = atLeastOneDayAbsence;
    }

    public Boolean isTransferExtraHours() {
        return transferExtraHours;
    }

    public void setTransferExtraHours(Boolean transferExtraHours) {
        this.transferExtraHours = transferExtraHours;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getExtraHourCategoryId() {
        return extraHourCategoryId;
    }

    public void setExtraHourCategoryId(Long categoryId) {
        this.extraHourCategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProcessDailyDTO)) {
            return false;
        }

        return id != null && id.equals(((ProcessDailyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProcessDailyDTO{" +
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
            ", extraHourCategoryId=" + getExtraHourCategoryId() +
            "}";
    }
}
