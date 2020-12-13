package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.EntityBase;
import com.mikado.multitenant.domain.tenant.definitions.OvertimeReason;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "daily")
@Data
public class Daily extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date dayDate;

	@Column
	private Integer status;

	@Column(name = "total_hour")
	private Double totalHours;

	@Column(name = "normal_hour")
	private Double normalHours;

	@Column(name = "overtime_hour")
	private Double overTimeHours;

	@Column(name = "reason_hour")
	private Double reasonHours;

	@Column(name = "absent_hour")
	private Double absentHours;

	@Column(name = "week_overtime_hour")
	private Double weekOverTimeHours;

    @Column(name = "is_dayoff")
    private Boolean isDayOff;

    @Column(name = "week_day")
    private Double weekDays;

    @Column(name = "week_hour")
    private Double weekHours;

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "schedule_id", referencedColumnName = "id")
	private WorkSchedule schedule;

    @ManyToOne
    @JoinColumn(name = "overtime_reason_id", referencedColumnName = "id")
    private OvertimeReason overtimeReason;

    @ManyToOne
    @JoinColumn(name = "absent_category_id", referencedColumnName = "id")
    private Category absentCategory;

    @ManyToOne
    @JoinColumn(name = "week_overtime_category_id", referencedColumnName = "id")
    private Category weekOverTimeCategory;
}
