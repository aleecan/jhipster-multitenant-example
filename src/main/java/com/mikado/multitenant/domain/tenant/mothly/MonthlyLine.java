package com.mikado.multitenant.domain.tenant.mothly;

import com.mikado.multitenant.domain.base.TenantAbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "monthly_line")
@Data
public class MonthlyLine extends TenantAbstractAuditingEntity {

    private static final long serialVersionUID = -750740172680295765L;

    @Column(name = "line_no", nullable = false)
    private Integer lineNo;

    @Column(name = "description")
    private String description;

    @Column(name = "header_day")
    private String headerDay;

    @Column(name = "header_hour")
    private String headerHour;

    @Column(name = "add_sub_ss")
    private String addSubSs;

    @Column(name = "add_sub_tax")
    private String addSubTax;

    @Column(name = "add_sub_total")
    private String addSubTotal;

    @Column(name = "transfer_next_month")
    private Boolean transferNextMonth;

    @Column(name = "init_day")
    private Double initDay;

    @Column(name = "init_hour")
    private Double initHour;

    @Column(name = "balance_type")
    private Integer balanceType;

    @Column(name = "missing_ss_day_type")
    private String missingSsDayType;

    @Column(name = "salary_days")
    private Double salaryDays;

    @Column(name = "salary_hours")
    private Double salaryHours;

    @Column(name = "reserved")
    private Boolean reserved;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "complete_line_no_id", referencedColumnName = "id")
    private MonthlyLine completeMonthlyLine;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "difference_line_no_id", referencedColumnName = "id")
    private MonthlyLine differenceLineNoId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "positive_value_line_no_id", referencedColumnName = "id")
    private MonthlyLine positiveValueLineNoId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "negative_value_line_no_id", referencedColumnName = "id")
    private MonthlyLine negativeValueLineNoId;

}
