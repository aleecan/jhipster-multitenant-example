package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.Employee} entity.
 */
public class EmployeeDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer empNo;

    @NotNull
    @Size(max = 40)
    private String fullName;

    @NotNull
    private Integer empType;

    @NotNull
    private Boolean active;

    @NotNull
    private LocalDate hireDate;

    private LocalDate terminatedDate;

    private Integer exitReason;

    private Boolean emergencyManager;

    private Boolean firstAidOfficer;

    @Size(max = 40)
    private String email;

    private Boolean safetyCheck;

    private Instant startValidity;

    private Instant endValidity;

    @Size(max = 10)
    private String payrollNo;

    private Double salary;

    @Size(max = 15)
    private String identificationNo;

    @Size(max = 20)
    private String socialSecurityNo;

    @Size(max = 20)
    private String taxNo;

    @Size(max = 80)
    private String taxOffice;

    private Boolean userWorkContract;

    private Boolean useCalendar;

    @Size(max = 1)
    private String shiftGroup;

    @Size(max = 1)
    private String paymentType;

    @Size(max = 80)
    private String photourl;

    private Boolean joinUnion;

    private Boolean disabled;

    private Boolean gender;

    @Size(max = 15)
    private String mobileNo;

    @Size(max = 15)
    private String officeLoc;

    @Size(max = 80)
    private String address1;

    @Size(max = 80)
    private String address2;

    @Size(max = 40)
    private String city;

    @Size(max = 10)
    private String zipcode;

    private Long countryId;

    @Size(max = 10)
    private String sizeDress;

    @Size(max = 10)
    private String sizeShirt;

    @Size(max = 10)
    private String sizeShoe;

    @Size(max = 10)
    private String vehicleNo;

    @Size(max = 80)
    private String busStop;

    @Size(max = 80)
    private String bloodGroup;

    @Size(max = 80)
    private String backLayout;

    @Size(max = 80)
    private String frontLayout;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long companyFirmId;

    private Long companySubFirmId;

    private Long departmentId;

    private Long subDepartmentId;

    private Long costCenterId;

    private Long groupCodeId;

    private Long privateCodeId;

    private Long titleId;

    private Long staffId;

    private Long locationId;

    private Long musteringPointId;

    private Long annualLeaveGroupId;

    private Long taskId;

    private Long directManagerId;

    private Long workContractId;

    private Long calendarId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getEmpType() {
        return empType;
    }

    public void setEmpType(Integer empType) {
        this.empType = empType;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminatedDate() {
        return terminatedDate;
    }

    public void setTerminatedDate(LocalDate terminatedDate) {
        this.terminatedDate = terminatedDate;
    }

    public Integer getExitReason() {
        return exitReason;
    }

    public void setExitReason(Integer exitReason) {
        this.exitReason = exitReason;
    }

    public Boolean isEmergencyManager() {
        return emergencyManager;
    }

    public void setEmergencyManager(Boolean emergencyManager) {
        this.emergencyManager = emergencyManager;
    }

    public Boolean isFirstAidOfficer() {
        return firstAidOfficer;
    }

    public void setFirstAidOfficer(Boolean firstAidOfficer) {
        this.firstAidOfficer = firstAidOfficer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isSafetyCheck() {
        return safetyCheck;
    }

    public void setSafetyCheck(Boolean safetyCheck) {
        this.safetyCheck = safetyCheck;
    }

    public Instant getStartValidity() {
        return startValidity;
    }

    public void setStartValidity(Instant startValidity) {
        this.startValidity = startValidity;
    }

    public Instant getEndValidity() {
        return endValidity;
    }

    public void setEndValidity(Instant endValidity) {
        this.endValidity = endValidity;
    }

    public String getPayrollNo() {
        return payrollNo;
    }

    public void setPayrollNo(String payrollNo) {
        this.payrollNo = payrollNo;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public void setSocialSecurityNo(String socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public Boolean isUserWorkContract() {
        return userWorkContract;
    }

    public void setUserWorkContract(Boolean userWorkContract) {
        this.userWorkContract = userWorkContract;
    }

    public Boolean isUseCalendar() {
        return useCalendar;
    }

    public void setUseCalendar(Boolean useCalendar) {
        this.useCalendar = useCalendar;
    }

    public String getShiftGroup() {
        return shiftGroup;
    }

    public void setShiftGroup(String shiftGroup) {
        this.shiftGroup = shiftGroup;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public Boolean isJoinUnion() {
        return joinUnion;
    }

    public void setJoinUnion(Boolean joinUnion) {
        this.joinUnion = joinUnion;
    }

    public Boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOfficeLoc() {
        return officeLoc;
    }

    public void setOfficeLoc(String officeLoc) {
        this.officeLoc = officeLoc;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getSizeDress() {
        return sizeDress;
    }

    public void setSizeDress(String sizeDress) {
        this.sizeDress = sizeDress;
    }

    public String getSizeShirt() {
        return sizeShirt;
    }

    public void setSizeShirt(String sizeShirt) {
        this.sizeShirt = sizeShirt;
    }

    public String getSizeShoe() {
        return sizeShoe;
    }

    public void setSizeShoe(String sizeShoe) {
        this.sizeShoe = sizeShoe;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getBusStop() {
        return busStop;
    }

    public void setBusStop(String busStop) {
        this.busStop = busStop;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBackLayout() {
        return backLayout;
    }

    public void setBackLayout(String backLayout) {
        this.backLayout = backLayout;
    }

    public String getFrontLayout() {
        return frontLayout;
    }

    public void setFrontLayout(String frontLayout) {
        this.frontLayout = frontLayout;
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

    public Long getCompanyFirmId() {
        return companyFirmId;
    }

    public void setCompanyFirmId(Long companyFirmId) {
        this.companyFirmId = companyFirmId;
    }

    public Long getCompanySubFirmId() {
        return companySubFirmId;
    }

    public void setCompanySubFirmId(Long companySubFirmId) {
        this.companySubFirmId = companySubFirmId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getSubDepartmentId() {
        return subDepartmentId;
    }

    public void setSubDepartmentId(Long subDepartmentId) {
        this.subDepartmentId = subDepartmentId;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public Long getGroupCodeId() {
        return groupCodeId;
    }

    public void setGroupCodeId(Long groupCodeId) {
        this.groupCodeId = groupCodeId;
    }

    public Long getPrivateCodeId() {
        return privateCodeId;
    }

    public void setPrivateCodeId(Long privateCodeId) {
        this.privateCodeId = privateCodeId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getMusteringPointId() {
        return musteringPointId;
    }

    public void setMusteringPointId(Long musteringPointId) {
        this.musteringPointId = musteringPointId;
    }

    public Long getAnnualLeaveGroupId() {
        return annualLeaveGroupId;
    }

    public void setAnnualLeaveGroupId(Long annualLeaveGroupId) {
        this.annualLeaveGroupId = annualLeaveGroupId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getDirectManagerId() {
        return directManagerId;
    }

    public void setDirectManagerId(Long employeeId) {
        this.directManagerId = employeeId;
    }

    public Long getWorkContractId() {
        return workContractId;
    }

    public void setWorkContractId(Long workContractId) {
        this.workContractId = workContractId;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeDTO)) {
            return false;
        }

        return id != null && id.equals(((EmployeeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeDTO{" +
            "id=" + getId() +
            ", empNo=" + getEmpNo() +
            ", fullName='" + getFullName() + "'" +
            ", empType=" + getEmpType() +
            ", active='" + isActive() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", terminatedDate='" + getTerminatedDate() + "'" +
            ", exitReason=" + getExitReason() +
            ", emergencyManager='" + isEmergencyManager() + "'" +
            ", firstAidOfficer='" + isFirstAidOfficer() + "'" +
            ", email='" + getEmail() + "'" +
            ", safetyCheck='" + isSafetyCheck() + "'" +
            ", startValidity='" + getStartValidity() + "'" +
            ", endValidity='" + getEndValidity() + "'" +
            ", payrollNo='" + getPayrollNo() + "'" +
            ", salary=" + getSalary() +
            ", identificationNo='" + getIdentificationNo() + "'" +
            ", socialSecurityNo='" + getSocialSecurityNo() + "'" +
            ", taxNo='" + getTaxNo() + "'" +
            ", taxOffice='" + getTaxOffice() + "'" +
            ", userWorkContract='" + isUserWorkContract() + "'" +
            ", useCalendar='" + isUseCalendar() + "'" +
            ", shiftGroup='" + getShiftGroup() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", photourl='" + getPhotourl() + "'" +
            ", joinUnion='" + isJoinUnion() + "'" +
            ", disabled='" + isDisabled() + "'" +
            ", gender='" + isGender() + "'" +
            ", mobileNo='" + getMobileNo() + "'" +
            ", officeLoc='" + getOfficeLoc() + "'" +
            ", address1='" + getAddress1() + "'" +
            ", address2='" + getAddress2() + "'" +
            ", city='" + getCity() + "'" +
            ", zipcode='" + getZipcode() + "'" +
            ", countryId=" + getCountryId() +
            ", sizeDress='" + getSizeDress() + "'" +
            ", sizeShirt='" + getSizeShirt() + "'" +
            ", sizeShoe='" + getSizeShoe() + "'" +
            ", vehicleNo='" + getVehicleNo() + "'" +
            ", busStop='" + getBusStop() + "'" +
            ", bloodGroup='" + getBloodGroup() + "'" +
            ", backLayout='" + getBackLayout() + "'" +
            ", frontLayout='" + getFrontLayout() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", companyFirmId=" + getCompanyFirmId() +
            ", companySubFirmId=" + getCompanySubFirmId() +
            ", departmentId=" + getDepartmentId() +
            ", subDepartmentId=" + getSubDepartmentId() +
            ", costCenterId=" + getCostCenterId() +
            ", groupCodeId=" + getGroupCodeId() +
            ", privateCodeId=" + getPrivateCodeId() +
            ", titleId=" + getTitleId() +
            ", staffId=" + getStaffId() +
            ", locationId=" + getLocationId() +
            ", musteringPointId=" + getMusteringPointId() +
            ", annualLeaveGroupId=" + getAnnualLeaveGroupId() +
            ", taskId=" + getTaskId() +
            ", directManagerId=" + getDirectManagerId() +
            ", workContractId=" + getWorkContractId() +
            ", calendarId=" + getCalendarId() +
            "}";
    }
}
