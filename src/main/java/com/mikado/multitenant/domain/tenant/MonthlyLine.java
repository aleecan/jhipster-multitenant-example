package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A MonthlyLine.
 */
@Entity
@Table(name = "monthly_line")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlyLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "line_no", nullable = false)
    private Integer lineNo;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Size(max = 15)
    @Column(name = "header_day", length = 15)
    private String headerDay;

    @Size(max = 15)
    @Column(name = "header_hour", length = 15)
    private String headerHour;

    @Size(max = 1)
    @Column(name = "add_sub_ss", length = 1)
    private String addSubSs;

    @Size(max = 1)
    @Column(name = "add_sub_tax", length = 1)
    private String addSubTax;

    @Size(max = 1)
    @Column(name = "add_sub_total", length = 1)
    private String addSubTotal;

    @Column(name = "transfer_next_month")
    private Boolean transferNextMonth;

    @Column(name = "init_day")
    private Double initDay;

    @Column(name = "init_hour")
    private Double initHour;

    @Column(name = "complete_line_no")
    private Long completeLineNo;

    @Column(name = "difference_line_no")
    private Long differenceLineNo;

    @Column(name = "positive_value_line_no")
    private Long positiveValueLineNo;

    @Column(name = "negative_value_line_no")
    private Long negativeValueLineNo;

    @Column(name = "balance_type")
    private Integer balanceType;

    @Size(max = 3)
    @Column(name = "missing_ss_day_type", length = 3)
    private String missingSsDayType;

    @Column(name = "salary_days")
    private Double salaryDays;

    @Column(name = "salary_hours")
    private Double salaryHours;

    @Column(name = "reserved")
    private Boolean reserved;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public MonthlyLine lineNo(Integer lineNo) {
        this.lineNo = lineNo;
        return this;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getDescription() {
        return description;
    }

    public MonthlyLine description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeaderDay() {
        return headerDay;
    }

    public MonthlyLine headerDay(String headerDay) {
        this.headerDay = headerDay;
        return this;
    }

    public void setHeaderDay(String headerDay) {
        this.headerDay = headerDay;
    }

    public String getHeaderHour() {
        return headerHour;
    }

    public MonthlyLine headerHour(String headerHour) {
        this.headerHour = headerHour;
        return this;
    }

    public void setHeaderHour(String headerHour) {
        this.headerHour = headerHour;
    }

    public String getAddSubSs() {
        return addSubSs;
    }

    public MonthlyLine addSubSs(String addSubSs) {
        this.addSubSs = addSubSs;
        return this;
    }

    public void setAddSubSs(String addSubSs) {
        this.addSubSs = addSubSs;
    }

    public String getAddSubTax() {
        return addSubTax;
    }

    public MonthlyLine addSubTax(String addSubTax) {
        this.addSubTax = addSubTax;
        return this;
    }

    public void setAddSubTax(String addSubTax) {
        this.addSubTax = addSubTax;
    }

    public String getAddSubTotal() {
        return addSubTotal;
    }

    public MonthlyLine addSubTotal(String addSubTotal) {
        this.addSubTotal = addSubTotal;
        return this;
    }

    public void setAddSubTotal(String addSubTotal) {
        this.addSubTotal = addSubTotal;
    }

    public Boolean isTransferNextMonth() {
        return transferNextMonth;
    }

    public MonthlyLine transferNextMonth(Boolean transferNextMonth) {
        this.transferNextMonth = transferNextMonth;
        return this;
    }

    public void setTransferNextMonth(Boolean transferNextMonth) {
        this.transferNextMonth = transferNextMonth;
    }

    public Double getInitDay() {
        return initDay;
    }

    public MonthlyLine initDay(Double initDay) {
        this.initDay = initDay;
        return this;
    }

    public void setInitDay(Double initDay) {
        this.initDay = initDay;
    }

    public Double getInitHour() {
        return initHour;
    }

    public MonthlyLine initHour(Double initHour) {
        this.initHour = initHour;
        return this;
    }

    public void setInitHour(Double initHour) {
        this.initHour = initHour;
    }

    public Long getCompleteLineNo() {
        return completeLineNo;
    }

    public MonthlyLine completeLineNo(Long completeLineNo) {
        this.completeLineNo = completeLineNo;
        return this;
    }

    public void setCompleteLineNo(Long completeLineNo) {
        this.completeLineNo = completeLineNo;
    }

    public Long getDifferenceLineNo() {
        return differenceLineNo;
    }

    public MonthlyLine differenceLineNo(Long differenceLineNo) {
        this.differenceLineNo = differenceLineNo;
        return this;
    }

    public void setDifferenceLineNo(Long differenceLineNo) {
        this.differenceLineNo = differenceLineNo;
    }

    public Long getPositiveValueLineNo() {
        return positiveValueLineNo;
    }

    public MonthlyLine positiveValueLineNo(Long positiveValueLineNo) {
        this.positiveValueLineNo = positiveValueLineNo;
        return this;
    }

    public void setPositiveValueLineNo(Long positiveValueLineNo) {
        this.positiveValueLineNo = positiveValueLineNo;
    }

    public Long getNegativeValueLineNo() {
        return negativeValueLineNo;
    }

    public MonthlyLine negativeValueLineNo(Long negativeValueLineNo) {
        this.negativeValueLineNo = negativeValueLineNo;
        return this;
    }

    public void setNegativeValueLineNo(Long negativeValueLineNo) {
        this.negativeValueLineNo = negativeValueLineNo;
    }

    public Integer getBalanceType() {
        return balanceType;
    }

    public MonthlyLine balanceType(Integer balanceType) {
        this.balanceType = balanceType;
        return this;
    }

    public void setBalanceType(Integer balanceType) {
        this.balanceType = balanceType;
    }

    public String getMissingSsDayType() {
        return missingSsDayType;
    }

    public MonthlyLine missingSsDayType(String missingSsDayType) {
        this.missingSsDayType = missingSsDayType;
        return this;
    }

    public void setMissingSsDayType(String missingSsDayType) {
        this.missingSsDayType = missingSsDayType;
    }

    public Double getSalaryDays() {
        return salaryDays;
    }

    public MonthlyLine salaryDays(Double salaryDays) {
        this.salaryDays = salaryDays;
        return this;
    }

    public void setSalaryDays(Double salaryDays) {
        this.salaryDays = salaryDays;
    }

    public Double getSalaryHours() {
        return salaryHours;
    }

    public MonthlyLine salaryHours(Double salaryHours) {
        this.salaryHours = salaryHours;
        return this;
    }

    public void setSalaryHours(Double salaryHours) {
        this.salaryHours = salaryHours;
    }

    public Boolean isReserved() {
        return reserved;
    }

    public MonthlyLine reserved(Boolean reserved) {
        this.reserved = reserved;
        return this;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Instant getCreated() {
        return created;
    }

    public MonthlyLine created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public MonthlyLine modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public MonthlyLine modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyLine)) {
            return false;
        }
        return id != null && id.equals(((MonthlyLine) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyLine{" +
            "id=" + getId() +
            ", lineNo=" + getLineNo() +
            ", description='" + getDescription() + "'" +
            ", headerDay='" + getHeaderDay() + "'" +
            ", headerHour='" + getHeaderHour() + "'" +
            ", addSubSs='" + getAddSubSs() + "'" +
            ", addSubTax='" + getAddSubTax() + "'" +
            ", addSubTotal='" + getAddSubTotal() + "'" +
            ", transferNextMonth='" + isTransferNextMonth() + "'" +
            ", initDay=" + getInitDay() +
            ", initHour=" + getInitHour() +
            ", completeLineNo=" + getCompleteLineNo() +
            ", differenceLineNo=" + getDifferenceLineNo() +
            ", positiveValueLineNo=" + getPositiveValueLineNo() +
            ", negativeValueLineNo=" + getNegativeValueLineNo() +
            ", balanceType=" + getBalanceType() +
            ", missingSsDayType='" + getMissingSsDayType() + "'" +
            ", salaryDays=" + getSalaryDays() +
            ", salaryHours=" + getSalaryHours() +
            ", reserved='" + isReserved() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
