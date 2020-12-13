package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @NotNull
    @Size(max = 40)
    @Column(name = "full_name", length = 40, nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "emp_type", nullable = false)
    private Integer empType;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @NotNull
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "terminated_date")
    private LocalDate terminatedDate;

    @Column(name = "exit_reason")
    private Integer exitReason;

    @Column(name = "emergency_manager")
    private Boolean emergencyManager;

    @Column(name = "first_aid_officer")
    private Boolean firstAidOfficer;

    @Size(max = 40)
    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "safety_check")
    private Boolean safetyCheck;

    @Column(name = "start_validity")
    private Instant startValidity;

    @Column(name = "end_validity")
    private Instant endValidity;

    @Size(max = 10)
    @Column(name = "payroll_no", length = 10)
    private String payrollNo;

    @Column(name = "salary")
    private Double salary;

    @Size(max = 15)
    @Column(name = "identification_no", length = 15)
    private String identificationNo;

    @Size(max = 20)
    @Column(name = "social_security_no", length = 20)
    private String socialSecurityNo;

    @Size(max = 20)
    @Column(name = "tax_no", length = 20)
    private String taxNo;

    @Size(max = 80)
    @Column(name = "tax_office", length = 80)
    private String taxOffice;

    @Column(name = "user_work_contract")
    private Boolean userWorkContract;

    @Column(name = "use_calendar")
    private Boolean useCalendar;

    @Size(max = 1)
    @Column(name = "shift_group", length = 1)
    private String shiftGroup;

    @Size(max = 1)
    @Column(name = "payment_type", length = 1)
    private String paymentType;

    @Size(max = 80)
    @Column(name = "photourl", length = 80)
    private String photourl;

    @Column(name = "join_union")
    private Boolean joinUnion;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "gender")
    private Boolean gender;

    @Size(max = 15)
    @Column(name = "mobile_no", length = 15)
    private String mobileNo;

    @Size(max = 15)
    @Column(name = "office_loc", length = 15)
    private String officeLoc;

    @Size(max = 80)
    @Column(name = "address_1", length = 80)
    private String address1;

    @Size(max = 80)
    @Column(name = "address_2", length = 80)
    private String address2;

    @Size(max = 40)
    @Column(name = "city", length = 40)
    private String city;

    @Size(max = 10)
    @Column(name = "zipcode", length = 10)
    private String zipcode;

    @Column(name = "country_id")
    private Long countryId;

    @Size(max = 10)
    @Column(name = "size_dress", length = 10)
    private String sizeDress;

    @Size(max = 10)
    @Column(name = "size_shirt", length = 10)
    private String sizeShirt;

    @Size(max = 10)
    @Column(name = "size_shoe", length = 10)
    private String sizeShoe;

    @Size(max = 10)
    @Column(name = "vehicle_no", length = 10)
    private String vehicleNo;

    @Size(max = 80)
    @Column(name = "bus_stop", length = 80)
    private String busStop;

    @Size(max = 80)
    @Column(name = "blood_group", length = 80)
    private String bloodGroup;

    @Size(max = 80)
    @Column(name = "back_layout", length = 80)
    private String backLayout;

    @Size(max = 80)
    @Column(name = "front_layout", length = 80)
    private String frontLayout;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Department department;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private SubDepartment subDepartment;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private CostCenter costCenter;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private PrivateCode privateCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Title title;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Staff staff;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Location location;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private MusteringPoint musteringPoint;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private AnnualLeaveGroup annualLeaveGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Task task;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Employee directManager;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private WorkContract workContract;

    @ManyToOne
    @JsonIgnoreProperties(value = "employees", allowSetters = true)
    private Calendar calendar;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public Employee empNo(Integer empNo) {
        this.empNo = empNo;
        return this;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public Employee fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getEmpType() {
        return empType;
    }

    public Employee empType(Integer empType) {
        this.empType = empType;
        return this;
    }

    public void setEmpType(Integer empType) {
        this.empType = empType;
    }

    public Boolean isActive() {
        return active;
    }

    public Employee active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Employee hireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminatedDate() {
        return terminatedDate;
    }

    public Employee terminatedDate(LocalDate terminatedDate) {
        this.terminatedDate = terminatedDate;
        return this;
    }

    public void setTerminatedDate(LocalDate terminatedDate) {
        this.terminatedDate = terminatedDate;
    }

    public Integer getExitReason() {
        return exitReason;
    }

    public Employee exitReason(Integer exitReason) {
        this.exitReason = exitReason;
        return this;
    }

    public void setExitReason(Integer exitReason) {
        this.exitReason = exitReason;
    }

    public Boolean isEmergencyManager() {
        return emergencyManager;
    }

    public Employee emergencyManager(Boolean emergencyManager) {
        this.emergencyManager = emergencyManager;
        return this;
    }

    public void setEmergencyManager(Boolean emergencyManager) {
        this.emergencyManager = emergencyManager;
    }

    public Boolean isFirstAidOfficer() {
        return firstAidOfficer;
    }

    public Employee firstAidOfficer(Boolean firstAidOfficer) {
        this.firstAidOfficer = firstAidOfficer;
        return this;
    }

    public void setFirstAidOfficer(Boolean firstAidOfficer) {
        this.firstAidOfficer = firstAidOfficer;
    }

    public String getEmail() {
        return email;
    }

    public Employee email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isSafetyCheck() {
        return safetyCheck;
    }

    public Employee safetyCheck(Boolean safetyCheck) {
        this.safetyCheck = safetyCheck;
        return this;
    }

    public void setSafetyCheck(Boolean safetyCheck) {
        this.safetyCheck = safetyCheck;
    }

    public Instant getStartValidity() {
        return startValidity;
    }

    public Employee startValidity(Instant startValidity) {
        this.startValidity = startValidity;
        return this;
    }

    public void setStartValidity(Instant startValidity) {
        this.startValidity = startValidity;
    }

    public Instant getEndValidity() {
        return endValidity;
    }

    public Employee endValidity(Instant endValidity) {
        this.endValidity = endValidity;
        return this;
    }

    public void setEndValidity(Instant endValidity) {
        this.endValidity = endValidity;
    }

    public String getPayrollNo() {
        return payrollNo;
    }

    public Employee payrollNo(String payrollNo) {
        this.payrollNo = payrollNo;
        return this;
    }

    public void setPayrollNo(String payrollNo) {
        this.payrollNo = payrollNo;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee salary(Double salary) {
        this.salary = salary;
        return this;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public Employee identificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
        return this;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public Employee socialSecurityNo(String socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
        return this;
    }

    public void setSocialSecurityNo(String socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public Employee taxNo(String taxNo) {
        this.taxNo = taxNo;
        return this;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public Employee taxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
        return this;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public Boolean isUserWorkContract() {
        return userWorkContract;
    }

    public Employee userWorkContract(Boolean userWorkContract) {
        this.userWorkContract = userWorkContract;
        return this;
    }

    public void setUserWorkContract(Boolean userWorkContract) {
        this.userWorkContract = userWorkContract;
    }

    public Boolean isUseCalendar() {
        return useCalendar;
    }

    public Employee useCalendar(Boolean useCalendar) {
        this.useCalendar = useCalendar;
        return this;
    }

    public void setUseCalendar(Boolean useCalendar) {
        this.useCalendar = useCalendar;
    }

    public String getShiftGroup() {
        return shiftGroup;
    }

    public Employee shiftGroup(String shiftGroup) {
        this.shiftGroup = shiftGroup;
        return this;
    }

    public void setShiftGroup(String shiftGroup) {
        this.shiftGroup = shiftGroup;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Employee paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPhotourl() {
        return photourl;
    }

    public Employee photourl(String photourl) {
        this.photourl = photourl;
        return this;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public Boolean isJoinUnion() {
        return joinUnion;
    }

    public Employee joinUnion(Boolean joinUnion) {
        this.joinUnion = joinUnion;
        return this;
    }

    public void setJoinUnion(Boolean joinUnion) {
        this.joinUnion = joinUnion;
    }

    public Boolean isDisabled() {
        return disabled;
    }

    public Employee disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean isGender() {
        return gender;
    }

    public Employee gender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Employee mobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOfficeLoc() {
        return officeLoc;
    }

    public Employee officeLoc(String officeLoc) {
        this.officeLoc = officeLoc;
        return this;
    }

    public void setOfficeLoc(String officeLoc) {
        this.officeLoc = officeLoc;
    }

    public String getAddress1() {
        return address1;
    }

    public Employee address1(String address1) {
        this.address1 = address1;
        return this;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public Employee address2(String address2) {
        this.address2 = address2;
        return this;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public Employee city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Employee zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Employee countryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getSizeDress() {
        return sizeDress;
    }

    public Employee sizeDress(String sizeDress) {
        this.sizeDress = sizeDress;
        return this;
    }

    public void setSizeDress(String sizeDress) {
        this.sizeDress = sizeDress;
    }

    public String getSizeShirt() {
        return sizeShirt;
    }

    public Employee sizeShirt(String sizeShirt) {
        this.sizeShirt = sizeShirt;
        return this;
    }

    public void setSizeShirt(String sizeShirt) {
        this.sizeShirt = sizeShirt;
    }

    public String getSizeShoe() {
        return sizeShoe;
    }

    public Employee sizeShoe(String sizeShoe) {
        this.sizeShoe = sizeShoe;
        return this;
    }

    public void setSizeShoe(String sizeShoe) {
        this.sizeShoe = sizeShoe;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public Employee vehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        return this;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getBusStop() {
        return busStop;
    }

    public Employee busStop(String busStop) {
        this.busStop = busStop;
        return this;
    }

    public void setBusStop(String busStop) {
        this.busStop = busStop;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public Employee bloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBackLayout() {
        return backLayout;
    }

    public Employee backLayout(String backLayout) {
        this.backLayout = backLayout;
        return this;
    }

    public void setBackLayout(String backLayout) {
        this.backLayout = backLayout;
    }

    public String getFrontLayout() {
        return frontLayout;
    }

    public Employee frontLayout(String frontLayout) {
        this.frontLayout = frontLayout;
        return this;
    }

    public void setFrontLayout(String frontLayout) {
        this.frontLayout = frontLayout;
    }

    public Instant getCreated() {
        return created;
    }

    public Employee created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Employee modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Employee modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public Employee companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public Employee companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee department(Department department) {
        this.department = department;
        return this;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SubDepartment getSubDepartment() {
        return subDepartment;
    }

    public Employee subDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
        return this;
    }

    public void setSubDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public Employee costCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public Employee groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public Employee privateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
        return this;
    }

    public void setPrivateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
    }

    public Title getTitle() {
        return title;
    }

    public Employee title(Title title) {
        this.title = title;
        return this;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Staff getStaff() {
        return staff;
    }

    public Employee staff(Staff staff) {
        this.staff = staff;
        return this;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Location getLocation() {
        return location;
    }

    public Employee location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MusteringPoint getMusteringPoint() {
        return musteringPoint;
    }

    public Employee musteringPoint(MusteringPoint musteringPoint) {
        this.musteringPoint = musteringPoint;
        return this;
    }

    public void setMusteringPoint(MusteringPoint musteringPoint) {
        this.musteringPoint = musteringPoint;
    }

    public AnnualLeaveGroup getAnnualLeaveGroup() {
        return annualLeaveGroup;
    }

    public Employee annualLeaveGroup(AnnualLeaveGroup annualLeaveGroup) {
        this.annualLeaveGroup = annualLeaveGroup;
        return this;
    }

    public void setAnnualLeaveGroup(AnnualLeaveGroup annualLeaveGroup) {
        this.annualLeaveGroup = annualLeaveGroup;
    }

    public Task getTask() {
        return task;
    }

    public Employee task(Task task) {
        this.task = task;
        return this;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getDirectManager() {
        return directManager;
    }

    public Employee directManager(Employee employee) {
        this.directManager = employee;
        return this;
    }

    public void setDirectManager(Employee employee) {
        this.directManager = employee;
    }

    public WorkContract getWorkContract() {
        return workContract;
    }

    public Employee workContract(WorkContract workContract) {
        this.workContract = workContract;
        return this;
    }

    public void setWorkContract(WorkContract workContract) {
        this.workContract = workContract;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Employee calendar(Calendar calendar) {
        this.calendar = calendar;
        return this;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Employee{" +
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
            "}";
    }
}
