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
 * A EmployeeHistory.
 */
@Entity
@Table(name = "employee_history")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmployeeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "use_work_contract")
    private Boolean useWorkContract;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private CompanyFirm companyFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private CompanySubFirm companySubFirm;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private Department department;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private SubDepartment subDepartment;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private CostCenter costCenter;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private GroupCode groupCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private PrivateCode privateCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private Title title;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private Staff staff;

    @ManyToOne
    @JsonIgnoreProperties(value = "employeeHistories", allowSetters = true)
    private WorkContract workContract;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public EmployeeHistory startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EmployeeHistory endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean isUseWorkContract() {
        return useWorkContract;
    }

    public EmployeeHistory useWorkContract(Boolean useWorkContract) {
        this.useWorkContract = useWorkContract;
        return this;
    }

    public void setUseWorkContract(Boolean useWorkContract) {
        this.useWorkContract = useWorkContract;
    }

    public Double getSalary() {
        return salary;
    }

    public EmployeeHistory salary(Double salary) {
        this.salary = salary;
        return this;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Instant getCreated() {
        return created;
    }

    public EmployeeHistory created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public EmployeeHistory modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public EmployeeHistory modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeHistory employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CompanyFirm getCompanyFirm() {
        return companyFirm;
    }

    public EmployeeHistory companyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
        return this;
    }

    public void setCompanyFirm(CompanyFirm companyFirm) {
        this.companyFirm = companyFirm;
    }

    public CompanySubFirm getCompanySubFirm() {
        return companySubFirm;
    }

    public EmployeeHistory companySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
        return this;
    }

    public void setCompanySubFirm(CompanySubFirm companySubFirm) {
        this.companySubFirm = companySubFirm;
    }

    public Department getDepartment() {
        return department;
    }

    public EmployeeHistory department(Department department) {
        this.department = department;
        return this;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SubDepartment getSubDepartment() {
        return subDepartment;
    }

    public EmployeeHistory subDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
        return this;
    }

    public void setSubDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public EmployeeHistory costCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public EmployeeHistory groupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public PrivateCode getPrivateCode() {
        return privateCode;
    }

    public EmployeeHistory privateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
        return this;
    }

    public void setPrivateCode(PrivateCode privateCode) {
        this.privateCode = privateCode;
    }

    public Title getTitle() {
        return title;
    }

    public EmployeeHistory title(Title title) {
        this.title = title;
        return this;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Staff getStaff() {
        return staff;
    }

    public EmployeeHistory staff(Staff staff) {
        this.staff = staff;
        return this;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public WorkContract getWorkContract() {
        return workContract;
    }

    public EmployeeHistory workContract(WorkContract workContract) {
        this.workContract = workContract;
        return this;
    }

    public void setWorkContract(WorkContract workContract) {
        this.workContract = workContract;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeHistory)) {
            return false;
        }
        return id != null && id.equals(((EmployeeHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeHistory{" +
            "id=" + getId() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", useWorkContract='" + isUseWorkContract() + "'" +
            ", salary=" + getSalary() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
