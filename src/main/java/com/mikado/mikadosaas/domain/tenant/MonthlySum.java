package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A MonthlySum.
 */
@Entity
@Table(name = "monthly_sum")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlySum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "monthly_line_id", nullable = false)
    private Long monthlyLineId;

    @Column(name = "annual_leave_day")
    private Double annualLeaveDay;

    @Column(name = "workday")
    private Double workday;

    @Column(name = "paid")
    private Double paid;

    @Column(name = "regular_day_hours")
    private Double regularDayHours;

    @Column(name = "regular_night_hours")
    private Double regularNightHours;

    @Column(name = "sick_leave_paid_company_hours")
    private Double sickLeavePaidCompanyHours;

    @Column(name = "sick_leave_paid_ssk_hours")
    private Double sickLeavePaidSskHours;

    @Column(name = "sixth_day_notwork_hours")
    private Double sixthDayNotworkHours;

    @Column(name = "seventh_day_notwork_hours")
    private Double seventhDayNotworkHours;

    @Column(name = "holiday_notwork_hours")
    private Double holidayNotworkHours;

    @Column(name = "admin_leave_hours")
    private Double adminLeaveHours;

    @Column(name = "admin_leave_art_31_hours")
    private Double adminLeaveArt31Hours;

    @Column(name = "annual_leave_hours")
    private Double annualLeaveHours;

    @Column(name = "nurse_leave_hours")
    private Double nurseLeaveHours;

    @Column(name = "ot_regular_day_hours")
    private Double otRegularDayHours;

    @Column(name = "ot_reg_art_15_b_1_hours")
    private Double otRegArt15b1Hours;

    @Column(name = "ot_reg_art_15_b_2_hours")
    private Double otRegArt15b2Hours;

    @Column(name = "ot_reg_emergency_hours")
    private Double otRegEmergencyHours;

    @Column(name = "ot_sixth_day_notwork_hours")
    private Double otSixthDayNotworkHours;

    @Column(name = "ot_sixth_day_over_5_hours")
    private Double otSixthDayOver5Hours;

    @Column(name = "ot_sixth_day_emergency_hours")
    private Double otSixthDayEmergencyHours;

    @Column(name = "ot_seventh_day_work_hours")
    private Double otSeventhDayWorkHours;

    @Column(name = "ot_seventh_day_over_75_hours")
    private Double otSeventhDayOver75Hours;

    @Column(name = "ot_seventh_day_emergency_hours")
    private Double otSeventhDayEmergencyHours;

    @Column(name = "ot_holiday_work_hours")
    private Double otHolidayWorkHours;

    @Column(name = "ot_holiday_night_work_hours")
    private Double otHolidayNightWorkHours;

    @Column(name = "ot_holiday_excess_hours")
    private Double otHolidayExcessHours;

    @Column(name = "ot_holiday_emergency_hours")
    private Double otHolidayEmergencyHours;

    @Column(name = "reg_night_art_16_g_hours")
    private Double regNightArt16gHours;

    @Column(name = "leave_without_paid_hours")
    private Double leaveWithoutPaidHours;

    @Column(name = "absence_without_paid_hours")
    private Double absenceWithoutPaidHours;

    @Column(name = "birth_code")
    private Integer birthCode;

    @Column(name = "death_code")
    private Integer deathCode;

    @Size(max = 1)
    @Column(name = "incc_permission_code", length = 1)
    private String inccPermissionCode;

    @Column(name = "special_exemption")
    private Double specialExemption;

    @Column(name = "special_exemption_10")
    private Double specialExemption10;

    @Column(name = "special_exemption_05")
    private Double specialExemption05;

    @Column(name = "unused_allumpsum")
    private Double unusedAllumpsum;

    @Column(name = "notice_pay")
    private Double noticePay;

    @Column(name = "severance")
    private Double severance;

    @Size(max = 3)
    @Column(name = "garnish_salary", length = 3)
    private String garnishSalary;

    @Size(max = 3)
    @Column(name = "garnish_bonus", length = 3)
    private String garnishBonus;

    @Column(name = "alimony")
    private Double alimony;

    @Column(name = "sick_leave_difference_pay")
    private Double sickLeaveDifferencePay;

    @Column(name = "annual_leave_advance")
    private Double annualLeaveAdvance;

    @Column(name = "tdy_advance")
    private Double tdyAdvance;

    @Column(name = "other_advance")
    private Double otherAdvance;

    @Column(name = "tdy_number")
    private Double tdyNumber;

    @Column(name = "field_1")
    private Double field1;

    @Column(name = "field_2")
    private Double field2;

    @Column(name = "field_3")
    private Double field3;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlySums", allowSetters = true)
    private Monthly monthly;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonthlyLineId() {
        return monthlyLineId;
    }

    public MonthlySum monthlyLineId(Long monthlyLineId) {
        this.monthlyLineId = monthlyLineId;
        return this;
    }

    public void setMonthlyLineId(Long monthlyLineId) {
        this.monthlyLineId = monthlyLineId;
    }

    public Double getAnnualLeaveDay() {
        return annualLeaveDay;
    }

    public MonthlySum annualLeaveDay(Double annualLeaveDay) {
        this.annualLeaveDay = annualLeaveDay;
        return this;
    }

    public void setAnnualLeaveDay(Double annualLeaveDay) {
        this.annualLeaveDay = annualLeaveDay;
    }

    public Double getWorkday() {
        return workday;
    }

    public MonthlySum workday(Double workday) {
        this.workday = workday;
        return this;
    }

    public void setWorkday(Double workday) {
        this.workday = workday;
    }

    public Double getPaid() {
        return paid;
    }

    public MonthlySum paid(Double paid) {
        this.paid = paid;
        return this;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getRegularDayHours() {
        return regularDayHours;
    }

    public MonthlySum regularDayHours(Double regularDayHours) {
        this.regularDayHours = regularDayHours;
        return this;
    }

    public void setRegularDayHours(Double regularDayHours) {
        this.regularDayHours = regularDayHours;
    }

    public Double getRegularNightHours() {
        return regularNightHours;
    }

    public MonthlySum regularNightHours(Double regularNightHours) {
        this.regularNightHours = regularNightHours;
        return this;
    }

    public void setRegularNightHours(Double regularNightHours) {
        this.regularNightHours = regularNightHours;
    }

    public Double getSickLeavePaidCompanyHours() {
        return sickLeavePaidCompanyHours;
    }

    public MonthlySum sickLeavePaidCompanyHours(Double sickLeavePaidCompanyHours) {
        this.sickLeavePaidCompanyHours = sickLeavePaidCompanyHours;
        return this;
    }

    public void setSickLeavePaidCompanyHours(Double sickLeavePaidCompanyHours) {
        this.sickLeavePaidCompanyHours = sickLeavePaidCompanyHours;
    }

    public Double getSickLeavePaidSskHours() {
        return sickLeavePaidSskHours;
    }

    public MonthlySum sickLeavePaidSskHours(Double sickLeavePaidSskHours) {
        this.sickLeavePaidSskHours = sickLeavePaidSskHours;
        return this;
    }

    public void setSickLeavePaidSskHours(Double sickLeavePaidSskHours) {
        this.sickLeavePaidSskHours = sickLeavePaidSskHours;
    }

    public Double getSixthDayNotworkHours() {
        return sixthDayNotworkHours;
    }

    public MonthlySum sixthDayNotworkHours(Double sixthDayNotworkHours) {
        this.sixthDayNotworkHours = sixthDayNotworkHours;
        return this;
    }

    public void setSixthDayNotworkHours(Double sixthDayNotworkHours) {
        this.sixthDayNotworkHours = sixthDayNotworkHours;
    }

    public Double getSeventhDayNotworkHours() {
        return seventhDayNotworkHours;
    }

    public MonthlySum seventhDayNotworkHours(Double seventhDayNotworkHours) {
        this.seventhDayNotworkHours = seventhDayNotworkHours;
        return this;
    }

    public void setSeventhDayNotworkHours(Double seventhDayNotworkHours) {
        this.seventhDayNotworkHours = seventhDayNotworkHours;
    }

    public Double getHolidayNotworkHours() {
        return holidayNotworkHours;
    }

    public MonthlySum holidayNotworkHours(Double holidayNotworkHours) {
        this.holidayNotworkHours = holidayNotworkHours;
        return this;
    }

    public void setHolidayNotworkHours(Double holidayNotworkHours) {
        this.holidayNotworkHours = holidayNotworkHours;
    }

    public Double getAdminLeaveHours() {
        return adminLeaveHours;
    }

    public MonthlySum adminLeaveHours(Double adminLeaveHours) {
        this.adminLeaveHours = adminLeaveHours;
        return this;
    }

    public void setAdminLeaveHours(Double adminLeaveHours) {
        this.adminLeaveHours = adminLeaveHours;
    }

    public Double getAdminLeaveArt31Hours() {
        return adminLeaveArt31Hours;
    }

    public MonthlySum adminLeaveArt31Hours(Double adminLeaveArt31Hours) {
        this.adminLeaveArt31Hours = adminLeaveArt31Hours;
        return this;
    }

    public void setAdminLeaveArt31Hours(Double adminLeaveArt31Hours) {
        this.adminLeaveArt31Hours = adminLeaveArt31Hours;
    }

    public Double getAnnualLeaveHours() {
        return annualLeaveHours;
    }

    public MonthlySum annualLeaveHours(Double annualLeaveHours) {
        this.annualLeaveHours = annualLeaveHours;
        return this;
    }

    public void setAnnualLeaveHours(Double annualLeaveHours) {
        this.annualLeaveHours = annualLeaveHours;
    }

    public Double getNurseLeaveHours() {
        return nurseLeaveHours;
    }

    public MonthlySum nurseLeaveHours(Double nurseLeaveHours) {
        this.nurseLeaveHours = nurseLeaveHours;
        return this;
    }

    public void setNurseLeaveHours(Double nurseLeaveHours) {
        this.nurseLeaveHours = nurseLeaveHours;
    }

    public Double getOtRegularDayHours() {
        return otRegularDayHours;
    }

    public MonthlySum otRegularDayHours(Double otRegularDayHours) {
        this.otRegularDayHours = otRegularDayHours;
        return this;
    }

    public void setOtRegularDayHours(Double otRegularDayHours) {
        this.otRegularDayHours = otRegularDayHours;
    }

    public Double getOtRegArt15b1Hours() {
        return otRegArt15b1Hours;
    }

    public MonthlySum otRegArt15b1Hours(Double otRegArt15b1Hours) {
        this.otRegArt15b1Hours = otRegArt15b1Hours;
        return this;
    }

    public void setOtRegArt15b1Hours(Double otRegArt15b1Hours) {
        this.otRegArt15b1Hours = otRegArt15b1Hours;
    }

    public Double getOtRegArt15b2Hours() {
        return otRegArt15b2Hours;
    }

    public MonthlySum otRegArt15b2Hours(Double otRegArt15b2Hours) {
        this.otRegArt15b2Hours = otRegArt15b2Hours;
        return this;
    }

    public void setOtRegArt15b2Hours(Double otRegArt15b2Hours) {
        this.otRegArt15b2Hours = otRegArt15b2Hours;
    }

    public Double getOtRegEmergencyHours() {
        return otRegEmergencyHours;
    }

    public MonthlySum otRegEmergencyHours(Double otRegEmergencyHours) {
        this.otRegEmergencyHours = otRegEmergencyHours;
        return this;
    }

    public void setOtRegEmergencyHours(Double otRegEmergencyHours) {
        this.otRegEmergencyHours = otRegEmergencyHours;
    }

    public Double getOtSixthDayNotworkHours() {
        return otSixthDayNotworkHours;
    }

    public MonthlySum otSixthDayNotworkHours(Double otSixthDayNotworkHours) {
        this.otSixthDayNotworkHours = otSixthDayNotworkHours;
        return this;
    }

    public void setOtSixthDayNotworkHours(Double otSixthDayNotworkHours) {
        this.otSixthDayNotworkHours = otSixthDayNotworkHours;
    }

    public Double getOtSixthDayOver5Hours() {
        return otSixthDayOver5Hours;
    }

    public MonthlySum otSixthDayOver5Hours(Double otSixthDayOver5Hours) {
        this.otSixthDayOver5Hours = otSixthDayOver5Hours;
        return this;
    }

    public void setOtSixthDayOver5Hours(Double otSixthDayOver5Hours) {
        this.otSixthDayOver5Hours = otSixthDayOver5Hours;
    }

    public Double getOtSixthDayEmergencyHours() {
        return otSixthDayEmergencyHours;
    }

    public MonthlySum otSixthDayEmergencyHours(Double otSixthDayEmergencyHours) {
        this.otSixthDayEmergencyHours = otSixthDayEmergencyHours;
        return this;
    }

    public void setOtSixthDayEmergencyHours(Double otSixthDayEmergencyHours) {
        this.otSixthDayEmergencyHours = otSixthDayEmergencyHours;
    }

    public Double getOtSeventhDayWorkHours() {
        return otSeventhDayWorkHours;
    }

    public MonthlySum otSeventhDayWorkHours(Double otSeventhDayWorkHours) {
        this.otSeventhDayWorkHours = otSeventhDayWorkHours;
        return this;
    }

    public void setOtSeventhDayWorkHours(Double otSeventhDayWorkHours) {
        this.otSeventhDayWorkHours = otSeventhDayWorkHours;
    }

    public Double getOtSeventhDayOver75Hours() {
        return otSeventhDayOver75Hours;
    }

    public MonthlySum otSeventhDayOver75Hours(Double otSeventhDayOver75Hours) {
        this.otSeventhDayOver75Hours = otSeventhDayOver75Hours;
        return this;
    }

    public void setOtSeventhDayOver75Hours(Double otSeventhDayOver75Hours) {
        this.otSeventhDayOver75Hours = otSeventhDayOver75Hours;
    }

    public Double getOtSeventhDayEmergencyHours() {
        return otSeventhDayEmergencyHours;
    }

    public MonthlySum otSeventhDayEmergencyHours(Double otSeventhDayEmergencyHours) {
        this.otSeventhDayEmergencyHours = otSeventhDayEmergencyHours;
        return this;
    }

    public void setOtSeventhDayEmergencyHours(Double otSeventhDayEmergencyHours) {
        this.otSeventhDayEmergencyHours = otSeventhDayEmergencyHours;
    }

    public Double getOtHolidayWorkHours() {
        return otHolidayWorkHours;
    }

    public MonthlySum otHolidayWorkHours(Double otHolidayWorkHours) {
        this.otHolidayWorkHours = otHolidayWorkHours;
        return this;
    }

    public void setOtHolidayWorkHours(Double otHolidayWorkHours) {
        this.otHolidayWorkHours = otHolidayWorkHours;
    }

    public Double getOtHolidayNightWorkHours() {
        return otHolidayNightWorkHours;
    }

    public MonthlySum otHolidayNightWorkHours(Double otHolidayNightWorkHours) {
        this.otHolidayNightWorkHours = otHolidayNightWorkHours;
        return this;
    }

    public void setOtHolidayNightWorkHours(Double otHolidayNightWorkHours) {
        this.otHolidayNightWorkHours = otHolidayNightWorkHours;
    }

    public Double getOtHolidayExcessHours() {
        return otHolidayExcessHours;
    }

    public MonthlySum otHolidayExcessHours(Double otHolidayExcessHours) {
        this.otHolidayExcessHours = otHolidayExcessHours;
        return this;
    }

    public void setOtHolidayExcessHours(Double otHolidayExcessHours) {
        this.otHolidayExcessHours = otHolidayExcessHours;
    }

    public Double getOtHolidayEmergencyHours() {
        return otHolidayEmergencyHours;
    }

    public MonthlySum otHolidayEmergencyHours(Double otHolidayEmergencyHours) {
        this.otHolidayEmergencyHours = otHolidayEmergencyHours;
        return this;
    }

    public void setOtHolidayEmergencyHours(Double otHolidayEmergencyHours) {
        this.otHolidayEmergencyHours = otHolidayEmergencyHours;
    }

    public Double getRegNightArt16gHours() {
        return regNightArt16gHours;
    }

    public MonthlySum regNightArt16gHours(Double regNightArt16gHours) {
        this.regNightArt16gHours = regNightArt16gHours;
        return this;
    }

    public void setRegNightArt16gHours(Double regNightArt16gHours) {
        this.regNightArt16gHours = regNightArt16gHours;
    }

    public Double getLeaveWithoutPaidHours() {
        return leaveWithoutPaidHours;
    }

    public MonthlySum leaveWithoutPaidHours(Double leaveWithoutPaidHours) {
        this.leaveWithoutPaidHours = leaveWithoutPaidHours;
        return this;
    }

    public void setLeaveWithoutPaidHours(Double leaveWithoutPaidHours) {
        this.leaveWithoutPaidHours = leaveWithoutPaidHours;
    }

    public Double getAbsenceWithoutPaidHours() {
        return absenceWithoutPaidHours;
    }

    public MonthlySum absenceWithoutPaidHours(Double absenceWithoutPaidHours) {
        this.absenceWithoutPaidHours = absenceWithoutPaidHours;
        return this;
    }

    public void setAbsenceWithoutPaidHours(Double absenceWithoutPaidHours) {
        this.absenceWithoutPaidHours = absenceWithoutPaidHours;
    }

    public Integer getBirthCode() {
        return birthCode;
    }

    public MonthlySum birthCode(Integer birthCode) {
        this.birthCode = birthCode;
        return this;
    }

    public void setBirthCode(Integer birthCode) {
        this.birthCode = birthCode;
    }

    public Integer getDeathCode() {
        return deathCode;
    }

    public MonthlySum deathCode(Integer deathCode) {
        this.deathCode = deathCode;
        return this;
    }

    public void setDeathCode(Integer deathCode) {
        this.deathCode = deathCode;
    }

    public String getInccPermissionCode() {
        return inccPermissionCode;
    }

    public MonthlySum inccPermissionCode(String inccPermissionCode) {
        this.inccPermissionCode = inccPermissionCode;
        return this;
    }

    public void setInccPermissionCode(String inccPermissionCode) {
        this.inccPermissionCode = inccPermissionCode;
    }

    public Double getSpecialExemption() {
        return specialExemption;
    }

    public MonthlySum specialExemption(Double specialExemption) {
        this.specialExemption = specialExemption;
        return this;
    }

    public void setSpecialExemption(Double specialExemption) {
        this.specialExemption = specialExemption;
    }

    public Double getSpecialExemption10() {
        return specialExemption10;
    }

    public MonthlySum specialExemption10(Double specialExemption10) {
        this.specialExemption10 = specialExemption10;
        return this;
    }

    public void setSpecialExemption10(Double specialExemption10) {
        this.specialExemption10 = specialExemption10;
    }

    public Double getSpecialExemption05() {
        return specialExemption05;
    }

    public MonthlySum specialExemption05(Double specialExemption05) {
        this.specialExemption05 = specialExemption05;
        return this;
    }

    public void setSpecialExemption05(Double specialExemption05) {
        this.specialExemption05 = specialExemption05;
    }

    public Double getUnusedAllumpsum() {
        return unusedAllumpsum;
    }

    public MonthlySum unusedAllumpsum(Double unusedAllumpsum) {
        this.unusedAllumpsum = unusedAllumpsum;
        return this;
    }

    public void setUnusedAllumpsum(Double unusedAllumpsum) {
        this.unusedAllumpsum = unusedAllumpsum;
    }

    public Double getNoticePay() {
        return noticePay;
    }

    public MonthlySum noticePay(Double noticePay) {
        this.noticePay = noticePay;
        return this;
    }

    public void setNoticePay(Double noticePay) {
        this.noticePay = noticePay;
    }

    public Double getSeverance() {
        return severance;
    }

    public MonthlySum severance(Double severance) {
        this.severance = severance;
        return this;
    }

    public void setSeverance(Double severance) {
        this.severance = severance;
    }

    public String getGarnishSalary() {
        return garnishSalary;
    }

    public MonthlySum garnishSalary(String garnishSalary) {
        this.garnishSalary = garnishSalary;
        return this;
    }

    public void setGarnishSalary(String garnishSalary) {
        this.garnishSalary = garnishSalary;
    }

    public String getGarnishBonus() {
        return garnishBonus;
    }

    public MonthlySum garnishBonus(String garnishBonus) {
        this.garnishBonus = garnishBonus;
        return this;
    }

    public void setGarnishBonus(String garnishBonus) {
        this.garnishBonus = garnishBonus;
    }

    public Double getAlimony() {
        return alimony;
    }

    public MonthlySum alimony(Double alimony) {
        this.alimony = alimony;
        return this;
    }

    public void setAlimony(Double alimony) {
        this.alimony = alimony;
    }

    public Double getSickLeaveDifferencePay() {
        return sickLeaveDifferencePay;
    }

    public MonthlySum sickLeaveDifferencePay(Double sickLeaveDifferencePay) {
        this.sickLeaveDifferencePay = sickLeaveDifferencePay;
        return this;
    }

    public void setSickLeaveDifferencePay(Double sickLeaveDifferencePay) {
        this.sickLeaveDifferencePay = sickLeaveDifferencePay;
    }

    public Double getAnnualLeaveAdvance() {
        return annualLeaveAdvance;
    }

    public MonthlySum annualLeaveAdvance(Double annualLeaveAdvance) {
        this.annualLeaveAdvance = annualLeaveAdvance;
        return this;
    }

    public void setAnnualLeaveAdvance(Double annualLeaveAdvance) {
        this.annualLeaveAdvance = annualLeaveAdvance;
    }

    public Double getTdyAdvance() {
        return tdyAdvance;
    }

    public MonthlySum tdyAdvance(Double tdyAdvance) {
        this.tdyAdvance = tdyAdvance;
        return this;
    }

    public void setTdyAdvance(Double tdyAdvance) {
        this.tdyAdvance = tdyAdvance;
    }

    public Double getOtherAdvance() {
        return otherAdvance;
    }

    public MonthlySum otherAdvance(Double otherAdvance) {
        this.otherAdvance = otherAdvance;
        return this;
    }

    public void setOtherAdvance(Double otherAdvance) {
        this.otherAdvance = otherAdvance;
    }

    public Double getTdyNumber() {
        return tdyNumber;
    }

    public MonthlySum tdyNumber(Double tdyNumber) {
        this.tdyNumber = tdyNumber;
        return this;
    }

    public void setTdyNumber(Double tdyNumber) {
        this.tdyNumber = tdyNumber;
    }

    public Double getField1() {
        return field1;
    }

    public MonthlySum field1(Double field1) {
        this.field1 = field1;
        return this;
    }

    public void setField1(Double field1) {
        this.field1 = field1;
    }

    public Double getField2() {
        return field2;
    }

    public MonthlySum field2(Double field2) {
        this.field2 = field2;
        return this;
    }

    public void setField2(Double field2) {
        this.field2 = field2;
    }

    public Double getField3() {
        return field3;
    }

    public MonthlySum field3(Double field3) {
        this.field3 = field3;
        return this;
    }

    public void setField3(Double field3) {
        this.field3 = field3;
    }

    public Monthly getMonthly() {
        return monthly;
    }

    public MonthlySum monthly(Monthly monthly) {
        this.monthly = monthly;
        return this;
    }

    public void setMonthly(Monthly monthly) {
        this.monthly = monthly;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlySum)) {
            return false;
        }
        return id != null && id.equals(((MonthlySum) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlySum{" +
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
            "}";
    }
}
