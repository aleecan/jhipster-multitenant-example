package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import com.mikado.multitenant.domain.tenant.definitions.*;
import com.mikado.multitenant.domain.tenant.groups.AnnualLeaveGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee")
@Data
public class Employee extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = -8458920900656473225L;

	@Column(name = "empno", nullable = false)
	private Integer employeeNumber;

	@Column(name = "full_name")
	private String fullName;

    @Column(name = "emptype", nullable = false)
    private Integer employeeType;

    @Column(name = "active")
    private Boolean active;

	@Column(name = "hire_date", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date hireDate;

	@Column(name = "terminated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminatedDate;

	@Column(name = "exit_reason")
	private Integer exitReason;

	@Column(name = "emergency_manager")
    private Boolean emergencyManager;

	@Column(name = "first_aid_officer")
    private Boolean firstAidOfficer;

	@Column(name = "email", nullable = true)
	private String email;

    @Column(name = "safety_check")
    private Boolean safetyCheck;

    @Column(name = "start_validity")
    private DateTime startValidity;

    @Column(name = "end_validity")
    private DateTime endValidity;

	@Column(name = "payroll_no", nullable = true)
	private String payrollNo;

	@Column(nullable = true)
	private Double salary;

	@Column(name = "identification_no", nullable = true)
	private String identificationNo;

	@Column(name = "social_security_no", nullable = true)
	private String socialSecurityNo;

    @Column(name = "tax_no", nullable = true)
    private String taxNo;

	@Column(name = "tax_office", nullable = true)
	private String taxoffice;

	@Column(name = "user_work_contract")
    private Boolean userWorkContract;

	@Column(name = "use_calendar")
    private Boolean useCalendar;

    @Column(name = "shift_group", nullable = true)
    private String shiftGroup;

    @Column(name = "payment_type", nullable = true)
    private String paymentType;

    @Column(name = "photourl", nullable = true)
    private String photoUrl;

    @Column(name = "join_union")
    private Boolean joinUnion;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "gender")
    private Boolean gender;

	@Column(name = "mobile_no", nullable = true)
	private String mobilePhoneNumber;

	@Column(name = "office_loc", nullable = true)
	private String officeLocation;

	@Column(name = "address_1", nullable = true)
	private String address1;

	@Column(name = "address_2", nullable = true)
	private String address2;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "zipcode", nullable = true)
	private String zipCode;

    @Column(name = "size_dress", nullable = true)
    private String sizeDress;

    @Column(name = "size_shirt", nullable = true)
    private String sizeShirt;

    @Column(name = "size_shoe", nullable = true)
    private String sizeShoe;

    @Column(name = "vehicle_no", nullable = true)
    private String vehicleNo;

    @Column(name = "bus_stop", nullable = true)
    private String busStop;

    @Column(name = "blood_group", nullable = true)
    private String bloodGroup;

    @Column(name = "back_layout", nullable = true)
    private String backLayout;

    @Column(name = "front_layout", nullable = true)
    private String frontLayout;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "company_firm_id", referencedColumnName = "id")
    private Firm firm;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "company_sub_firm_id", referencedColumnName = "id")
    private SubFirm subFirm;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sub_department_id", referencedColumnName = "id")
    private SubDepartment subDepartment;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cost_center_id", referencedColumnName = "id")
    private CostCenter costCenter;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "group_code_id", referencedColumnName = "id")
    private GroupCode groupCode;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "private_code_id", referencedColumnName = "id")
    private PrivateCode privateCode;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "title_id", referencedColumnName = "id")
    private Title title;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "mustering_point_id", referencedColumnName = "id")
    private MusteringPoint musteringPoint;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "annual_leave_group_id", referencedColumnName = "id")
    private AnnualLeaveGroup annualLeaveGroup;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "direct_manager_id", referencedColumnName = "id")
    private Employee directManager;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "work_contract_id", referencedColumnName = "id")
    private WorkContract workContract;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    private Calendar calendar;

}
