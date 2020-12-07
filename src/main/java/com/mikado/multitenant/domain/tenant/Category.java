package com.mikado.multitenant.domain.tenant;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(callSuper = false)
public class Category extends TenantAbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = -1029391000743265293L;

	@Column(nullable = false, unique = true,name = "code")
	private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Integer type;

	@Column(name = "color")
	private String color;

	@Column(name = "abbr")
	private String abbreviation;

    @Column(name = "hourly_excuse")
    private Boolean hourlyExcuse;

    @Column(name = "daily_excuse")
    private Boolean dailyExcuse;

    @Column(name = "overtime_approval")
    private Boolean overtimeApproval;

    @Column(name = "normal_group")
    private Boolean normalGroup;

    @Column(name = "not_change_weekly")
    private Boolean notChangeWeekly;

    @Column(name = "overtime_group")
    private Boolean overtimeGroup;

    @Column(name = "dayshift_multiplier")
    private Double dayShiftMultiplier;

    @Column(name = "dayshift_length")
    private String dayShiftLength;

    @Column(name = "dayshift_limit_low")
    private String dayShiftLimitLow;

    @Column(name = "dayshift_limit_up")
    private String dayShiftLimitUp;

    @Column(name = "shift_multiplier")
    private Double shiftMultiplier;

    @Column(name = "shift_day_length")
    private String shiftDayLength;

    @Column(name = "shift_limit_low")
    private String shiftLimitLow;

    @Column(name = "shift_limitup")
    private String shiftLimitUp;

    @Column(name = "rounding")
    private Boolean rounding;

    @Column(name = "round_step")
    private Integer roundStep;

    @Column(name = "round_time")
    private Integer roundTime;

    @Column(name = "round_day")
    private Integer roundDay;

    @Column(name = "round_day_monthly")
    private Integer roundDayMonthly;

    @Column(name = "include_task")
    private Boolean includeTask;

    @Column(name = "include_special_task")
    private Boolean includeSpecialTask;

    @Column(name = "reserved")
    private Boolean reserved;

    @Column(name = "addsub_annual_leave")
    private String addSubAnnualLeave;

}
