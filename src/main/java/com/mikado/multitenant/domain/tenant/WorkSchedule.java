package com.mikado.multitenant.domain.tenant;


import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import com.mikado.multitenant.domain.tenant.groups.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "schedule")
@Data
public class WorkSchedule extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 6389719443860758343L;

	@Column(name = "code", nullable = false)
	private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Integer type;

    @Column(name = "color")
	private String color;

	@Column(name = "nastart")
	private String naStart;

	@Column(name = "nafinish")
	private String naFinish;

	@Column(name = "nalength")
	private String naLength;

	@Column(name = "nalength_max")
	private String naLengthMax;

	@Column(name = "end_of_day")
	private String endOfDay;

	@Column(name = "end_of_day_priority")
	private Boolean endOfDayPriority;

    @Column(name = "flex_nastart")
    private Boolean flexNAStart;

	@Column(name = "completena")
	private Boolean completeNA;

	@Column(name = "day_shift")
	private Boolean dayShift;

	@Column(name = "priority")
	private Boolean priority;

	@Column(name = "daily_excuse")
	private Boolean dailyExcuse;

	@Column(name = "cut_one_hour")
	private Boolean cutOneHour;

	@Column(name = "overtime_from_end")
	private Boolean overtimeFromEnd;

	@Column(name = "not_cut_meal_overtime")
	private Boolean notCutMealOvertime;

	@Column(name = "use_first_in_last_out")
	private Boolean useFirstInLastOut;

	@Column(name = "summary_group")
	private String summaryGroup;

    @OneToOne
    @JoinColumn(name = "normal_group_id", referencedColumnName = "id")
    private NormalGroup normalGroup;

    @OneToOne
    @JoinColumn(name = "tolerance_group_id", referencedColumnName = "id")
    private ToleranceGroup toleranceGroup;

    @OneToOne
    @JoinColumn(name = "overtime_group_id", referencedColumnName = "id")
    private OvertimeGroup overTimeGroup;

	@OneToOne
    @JoinColumn(name = "meal_group_id", referencedColumnName = "id")
	private MealGroup mealGroup;

    @OneToOne
    @JoinColumn(name = "additional_group_id", referencedColumnName = "id")
    private AdditionalGroup additionalGroup;

    @ManyToOne
    @JoinColumn(name = "absent_category_id", referencedColumnName = "id")
    private Category absentCategory;

	@ManyToOne
    @JoinColumn(name = "excess_ot_category_id", referencedColumnName = "id")
    private Category excessCategory;

}
