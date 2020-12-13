package com.mikado.multitenant.domain.tenant.process;

import com.mikado.multitenant.domain.base.EntityBase;
import com.mikado.multitenant.domain.tenant.mothly.MonthlyLine;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "process_monthly")
@Data
public class ProcessMonthly extends EntityBase {

    @Column(name = "description")
    private String description;

    @Column(name = "date_year")
    private Integer dateYear;

    @Column(name = "date_month")
    private Integer dateMonth;

    @Column(name = "select_start_end_date_of_month")
    private Boolean selectStartEndDateOfMonth;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "calc_wages_salary_type_as_monthly")
    private Boolean calcWagesSalaryTypeAsMonthly;

    @Column(name = "use_default_value_for_absence")
    private Boolean useDefaultValueForAbsence;

    @Column(name = "apply_percentage_for_regular_day")
    private Boolean applyPercentageForRegularDay;

    @Column(name = "apply_percentage_for_total_day")
    private Boolean applyPercentageForTotalDay;

    @Column(name = "add_hour_from_previous_month")
    private Boolean addHourFromPreviousMonth;

    @Column(name = "calc_salary")
    private Boolean calcSalary;

    @Column(name = "find_no_of_day_off_from_daily")
    private Boolean findNoOfDayOffFromDaily;

    @Column(name = "missing_day_type")
    private Integer missingDayType;

    @Column(name = "check_max_hour")
    private Boolean checkMaxHour;

    @Column(name = "max_hour")
    private Double maxHour;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "line_for_diff_max_id", referencedColumnName = "id")
    private MonthlyLine monthlyLineMax;

    @Column(name = "complete_min_hour_after_balance")
    private Boolean completeMinHourAfterBalance;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "line_for_diff_min_id", referencedColumnName = "id")
    private MonthlyLine monthlyLineMin;

    @Column(name = "check_ss_day_against_31_day")
    private Boolean checkSsDayAgainst31Day;

}
