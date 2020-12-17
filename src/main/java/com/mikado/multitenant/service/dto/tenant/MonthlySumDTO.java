package com.mikado.multitenant.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.MonthlySum} entity.
 */
public class MonthlySumDTO implements Serializable {

    private Long id;

    @NotNull
    private Long monthlyLineId;

    private Double annualLeaveDay;

    private Double workday;

    private Double paid;

    private Double regularDayHours;

    private Double regularNightHours;

    private Double sickLeavePaidCompanyHours;

    private Double sickLeavePaidSskHours;

    private Double sixthDayNotworkHours;

    private Double seventhDayNotworkHours;

    private Double holidayNotworkHours;

    private Double adminLeaveHours;

    private Double adminLeaveArt31Hours;

    private Double annualLeaveHours;

    private Double nurseLeaveHours;

    private Double otRegularDayHours;

    private Double otRegArt15b1Hours;

    private Double otRegArt15b2Hours;

    private Double otRegEmergencyHours;

    private Double otSixthDayNotworkHours;

    private Double otSixthDayOver5Hours;

    private Double otSixthDayEmergencyHours;

    private Double otSeventhDayWorkHours;

    private Double otSeventhDayOver75Hours;

    private Double otSeventhDayEmergencyHours;

    private Double otHolidayWorkHours;

    private Double otHolidayNightWorkHours;

    private Double otHolidayExcessHours;

    private Double otHolidayEmergencyHours;

    private Double regNightArt16gHours;

    private Double leaveWithoutPaidHours;

    private Double absenceWithoutPaidHours;

    private Integer birthCode;

    private Integer deathCode;

    @Size(max = 1)
    private String inccPermissionCode;

    private Double specialExemption;

    private Double specialExemption10;

    private Double specialExemption05;

    private Double unusedAllumpsum;

    private Double noticePay;

    private Double severance;

    @Size(max = 3)
    private String garnishSalary;

    @Size(max = 3)
    private String garnishBonus;

    private Double alimony;

    private Double sickLeaveDifferencePay;

    private Double annualLeaveAdvance;

    private Double tdyAdvance;

    private Double otherAdvance;

    private Double tdyNumber;

    private Double field1;

    private Double field2;

    private Double field3;


    private Long monthlyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonthlyLineId() {
        return monthlyLineId;
    }

    public void setMonthlyLineId(Long monthlyLineId) {
        this.monthlyLineId = monthlyLineId;
    }

    public Double getAnnualLeaveDay() {
        return annualLeaveDay;
    }

    public void setAnnualLeaveDay(Double annualLeaveDay) {
        this.annualLeaveDay = annualLeaveDay;
    }

    public Double getWorkday() {
        return workday;
    }

    public void setWorkday(Double workday) {
        this.workday = workday;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getRegularDayHours() {
        return regularDayHours;
    }

    public void setRegularDayHours(Double regularDayHours) {
        this.regularDayHours = regularDayHours;
    }

    public Double getRegularNightHours() {
        return regularNightHours;
    }

    public void setRegularNightHours(Double regularNightHours) {
        this.regularNightHours = regularNightHours;
    }

    public Double getSickLeavePaidCompanyHours() {
        return sickLeavePaidCompanyHours;
    }

    public void setSickLeavePaidCompanyHours(Double sickLeavePaidCompanyHours) {
        this.sickLeavePaidCompanyHours = sickLeavePaidCompanyHours;
    }

    public Double getSickLeavePaidSskHours() {
        return sickLeavePaidSskHours;
    }

    public void setSickLeavePaidSskHours(Double sickLeavePaidSskHours) {
        this.sickLeavePaidSskHours = sickLeavePaidSskHours;
    }

    public Double getSixthDayNotworkHours() {
        return sixthDayNotworkHours;
    }

    public void setSixthDayNotworkHours(Double sixthDayNotworkHours) {
        this.sixthDayNotworkHours = sixthDayNotworkHours;
    }

    public Double getSeventhDayNotworkHours() {
        return seventhDayNotworkHours;
    }

    public void setSeventhDayNotworkHours(Double seventhDayNotworkHours) {
        this.seventhDayNotworkHours = seventhDayNotworkHours;
    }

    public Double getHolidayNotworkHours() {
        return holidayNotworkHours;
    }

    public void setHolidayNotworkHours(Double holidayNotworkHours) {
        this.holidayNotworkHours = holidayNotworkHours;
    }

    public Double getAdminLeaveHours() {
        return adminLeaveHours;
    }

    public void setAdminLeaveHours(Double adminLeaveHours) {
        this.adminLeaveHours = adminLeaveHours;
    }

    public Double getAdminLeaveArt31Hours() {
        return adminLeaveArt31Hours;
    }

    public void setAdminLeaveArt31Hours(Double adminLeaveArt31Hours) {
        this.adminLeaveArt31Hours = adminLeaveArt31Hours;
    }

    public Double getAnnualLeaveHours() {
        return annualLeaveHours;
    }

    public void setAnnualLeaveHours(Double annualLeaveHours) {
        this.annualLeaveHours = annualLeaveHours;
    }

    public Double getNurseLeaveHours() {
        return nurseLeaveHours;
    }

    public void setNurseLeaveHours(Double nurseLeaveHours) {
        this.nurseLeaveHours = nurseLeaveHours;
    }

    public Double getOtRegularDayHours() {
        return otRegularDayHours;
    }

    public void setOtRegularDayHours(Double otRegularDayHours) {
        this.otRegularDayHours = otRegularDayHours;
    }

    public Double getOtRegArt15b1Hours() {
        return otRegArt15b1Hours;
    }

    public void setOtRegArt15b1Hours(Double otRegArt15b1Hours) {
        this.otRegArt15b1Hours = otRegArt15b1Hours;
    }

    public Double getOtRegArt15b2Hours() {
        return otRegArt15b2Hours;
    }

    public void setOtRegArt15b2Hours(Double otRegArt15b2Hours) {
        this.otRegArt15b2Hours = otRegArt15b2Hours;
    }

    public Double getOtRegEmergencyHours() {
        return otRegEmergencyHours;
    }

    public void setOtRegEmergencyHours(Double otRegEmergencyHours) {
        this.otRegEmergencyHours = otRegEmergencyHours;
    }

    public Double getOtSixthDayNotworkHours() {
        return otSixthDayNotworkHours;
    }

    public void setOtSixthDayNotworkHours(Double otSixthDayNotworkHours) {
        this.otSixthDayNotworkHours = otSixthDayNotworkHours;
    }

    public Double getOtSixthDayOver5Hours() {
        return otSixthDayOver5Hours;
    }

    public void setOtSixthDayOver5Hours(Double otSixthDayOver5Hours) {
        this.otSixthDayOver5Hours = otSixthDayOver5Hours;
    }

    public Double getOtSixthDayEmergencyHours() {
        return otSixthDayEmergencyHours;
    }

    public void setOtSixthDayEmergencyHours(Double otSixthDayEmergencyHours) {
        this.otSixthDayEmergencyHours = otSixthDayEmergencyHours;
    }

    public Double getOtSeventhDayWorkHours() {
        return otSeventhDayWorkHours;
    }

    public void setOtSeventhDayWorkHours(Double otSeventhDayWorkHours) {
        this.otSeventhDayWorkHours = otSeventhDayWorkHours;
    }

    public Double getOtSeventhDayOver75Hours() {
        return otSeventhDayOver75Hours;
    }

    public void setOtSeventhDayOver75Hours(Double otSeventhDayOver75Hours) {
        this.otSeventhDayOver75Hours = otSeventhDayOver75Hours;
    }

    public Double getOtSeventhDayEmergencyHours() {
        return otSeventhDayEmergencyHours;
    }

    public void setOtSeventhDayEmergencyHours(Double otSeventhDayEmergencyHours) {
        this.otSeventhDayEmergencyHours = otSeventhDayEmergencyHours;
    }

    public Double getOtHolidayWorkHours() {
        return otHolidayWorkHours;
    }

    public void setOtHolidayWorkHours(Double otHolidayWorkHours) {
        this.otHolidayWorkHours = otHolidayWorkHours;
    }

    public Double getOtHolidayNightWorkHours() {
        return otHolidayNightWorkHours;
    }

    public void setOtHolidayNightWorkHours(Double otHolidayNightWorkHours) {
        this.otHolidayNightWorkHours = otHolidayNightWorkHours;
    }

    public Double getOtHolidayExcessHours() {
        return otHolidayExcessHours;
    }

    public void setOtHolidayExcessHours(Double otHolidayExcessHours) {
        this.otHolidayExcessHours = otHolidayExcessHours;
    }

    public Double getOtHolidayEmergencyHours() {
        return otHolidayEmergencyHours;
    }

    public void setOtHolidayEmergencyHours(Double otHolidayEmergencyHours) {
        this.otHolidayEmergencyHours = otHolidayEmergencyHours;
    }

    public Double getRegNightArt16gHours() {
        return regNightArt16gHours;
    }

    public void setRegNightArt16gHours(Double regNightArt16gHours) {
        this.regNightArt16gHours = regNightArt16gHours;
    }

    public Double getLeaveWithoutPaidHours() {
        return leaveWithoutPaidHours;
    }

    public void setLeaveWithoutPaidHours(Double leaveWithoutPaidHours) {
        this.leaveWithoutPaidHours = leaveWithoutPaidHours;
    }

    public Double getAbsenceWithoutPaidHours() {
        return absenceWithoutPaidHours;
    }

    public void setAbsenceWithoutPaidHours(Double absenceWithoutPaidHours) {
        this.absenceWithoutPaidHours = absenceWithoutPaidHours;
    }

    public Integer getBirthCode() {
        return birthCode;
    }

    public void setBirthCode(Integer birthCode) {
        this.birthCode = birthCode;
    }

    public Integer getDeathCode() {
        return deathCode;
    }

    public void setDeathCode(Integer deathCode) {
        this.deathCode = deathCode;
    }

    public String getInccPermissionCode() {
        return inccPermissionCode;
    }

    public void setInccPermissionCode(String inccPermissionCode) {
        this.inccPermissionCode = inccPermissionCode;
    }

    public Double getSpecialExemption() {
        return specialExemption;
    }

    public void setSpecialExemption(Double specialExemption) {
        this.specialExemption = specialExemption;
    }

    public Double getSpecialExemption10() {
        return specialExemption10;
    }

    public void setSpecialExemption10(Double specialExemption10) {
        this.specialExemption10 = specialExemption10;
    }

    public Double getSpecialExemption05() {
        return specialExemption05;
    }

    public void setSpecialExemption05(Double specialExemption05) {
        this.specialExemption05 = specialExemption05;
    }

    public Double getUnusedAllumpsum() {
        return unusedAllumpsum;
    }

    public void setUnusedAllumpsum(Double unusedAllumpsum) {
        this.unusedAllumpsum = unusedAllumpsum;
    }

    public Double getNoticePay() {
        return noticePay;
    }

    public void setNoticePay(Double noticePay) {
        this.noticePay = noticePay;
    }

    public Double getSeverance() {
        return severance;
    }

    public void setSeverance(Double severance) {
        this.severance = severance;
    }

    public String getGarnishSalary() {
        return garnishSalary;
    }

    public void setGarnishSalary(String garnishSalary) {
        this.garnishSalary = garnishSalary;
    }

    public String getGarnishBonus() {
        return garnishBonus;
    }

    public void setGarnishBonus(String garnishBonus) {
        this.garnishBonus = garnishBonus;
    }

    public Double getAlimony() {
        return alimony;
    }

    public void setAlimony(Double alimony) {
        this.alimony = alimony;
    }

    public Double getSickLeaveDifferencePay() {
        return sickLeaveDifferencePay;
    }

    public void setSickLeaveDifferencePay(Double sickLeaveDifferencePay) {
        this.sickLeaveDifferencePay = sickLeaveDifferencePay;
    }

    public Double getAnnualLeaveAdvance() {
        return annualLeaveAdvance;
    }

    public void setAnnualLeaveAdvance(Double annualLeaveAdvance) {
        this.annualLeaveAdvance = annualLeaveAdvance;
    }

    public Double getTdyAdvance() {
        return tdyAdvance;
    }

    public void setTdyAdvance(Double tdyAdvance) {
        this.tdyAdvance = tdyAdvance;
    }

    public Double getOtherAdvance() {
        return otherAdvance;
    }

    public void setOtherAdvance(Double otherAdvance) {
        this.otherAdvance = otherAdvance;
    }

    public Double getTdyNumber() {
        return tdyNumber;
    }

    public void setTdyNumber(Double tdyNumber) {
        this.tdyNumber = tdyNumber;
    }

    public Double getField1() {
        return field1;
    }

    public void setField1(Double field1) {
        this.field1 = field1;
    }

    public Double getField2() {
        return field2;
    }

    public void setField2(Double field2) {
        this.field2 = field2;
    }

    public Double getField3() {
        return field3;
    }

    public void setField3(Double field3) {
        this.field3 = field3;
    }

    public Long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Long monthlyId) {
        this.monthlyId = monthlyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlySumDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlySumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlySumDTO{" +
            "id=" + getId() +
            ", monthlyLineId=" + getMonthlyLineId() +
            ", annualLeaveDay=" + getAnnualLeaveDay() +
            ", workday=" + getWorkday() +
            ", paid=" + getPaid() +
            ", regularDayHours=" + getRegularDayHours() +
            ", regularNightHours=" + getRegularNightHours() +
            ", sickLeavePaidCompanyHours=" + getSickLeavePaidCompanyHours() +
            ", sickLeavePaidSskHours=" + getSickLeavePaidSskHours() +
            ", sixthDayNotworkHours=" + getSixthDayNotworkHours() +
            ", seventhDayNotworkHours=" + getSeventhDayNotworkHours() +
            ", holidayNotworkHours=" + getHolidayNotworkHours() +
            ", adminLeaveHours=" + getAdminLeaveHours() +
            ", adminLeaveArt31Hours=" + getAdminLeaveArt31Hours() +
            ", annualLeaveHours=" + getAnnualLeaveHours() +
            ", nurseLeaveHours=" + getNurseLeaveHours() +
            ", otRegularDayHours=" + getOtRegularDayHours() +
            ", otRegArt15b1Hours=" + getOtRegArt15b1Hours() +
            ", otRegArt15b2Hours=" + getOtRegArt15b2Hours() +
            ", otRegEmergencyHours=" + getOtRegEmergencyHours() +
            ", otSixthDayNotworkHours=" + getOtSixthDayNotworkHours() +
            ", otSixthDayOver5Hours=" + getOtSixthDayOver5Hours() +
            ", otSixthDayEmergencyHours=" + getOtSixthDayEmergencyHours() +
            ", otSeventhDayWorkHours=" + getOtSeventhDayWorkHours() +
            ", otSeventhDayOver75Hours=" + getOtSeventhDayOver75Hours() +
            ", otSeventhDayEmergencyHours=" + getOtSeventhDayEmergencyHours() +
            ", otHolidayWorkHours=" + getOtHolidayWorkHours() +
            ", otHolidayNightWorkHours=" + getOtHolidayNightWorkHours() +
            ", otHolidayExcessHours=" + getOtHolidayExcessHours() +
            ", otHolidayEmergencyHours=" + getOtHolidayEmergencyHours() +
            ", regNightArt16gHours=" + getRegNightArt16gHours() +
            ", leaveWithoutPaidHours=" + getLeaveWithoutPaidHours() +
            ", absenceWithoutPaidHours=" + getAbsenceWithoutPaidHours() +
            ", birthCode=" + getBirthCode() +
            ", deathCode=" + getDeathCode() +
            ", inccPermissionCode='" + getInccPermissionCode() + "'" +
            ", specialExemption=" + getSpecialExemption() +
            ", specialExemption10=" + getSpecialExemption10() +
            ", specialExemption05=" + getSpecialExemption05() +
            ", unusedAllumpsum=" + getUnusedAllumpsum() +
            ", noticePay=" + getNoticePay() +
            ", severance=" + getSeverance() +
            ", garnishSalary='" + getGarnishSalary() + "'" +
            ", garnishBonus='" + getGarnishBonus() + "'" +
            ", alimony=" + getAlimony() +
            ", sickLeaveDifferencePay=" + getSickLeaveDifferencePay() +
            ", annualLeaveAdvance=" + getAnnualLeaveAdvance() +
            ", tdyAdvance=" + getTdyAdvance() +
            ", otherAdvance=" + getOtherAdvance() +
            ", tdyNumber=" + getTdyNumber() +
            ", field1=" + getField1() +
            ", field2=" + getField2() +
            ", field3=" + getField3() +
            ", monthlyId=" + getMonthlyId() +
            "}";
    }
}
