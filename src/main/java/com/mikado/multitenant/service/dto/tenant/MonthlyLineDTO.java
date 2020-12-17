package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.MonthlyLine} entity.
 */
public class MonthlyLineDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer lineNo;

    @NotNull
    @Size(max = 80)
    private String description;

    @Size(max = 15)
    private String headerDay;

    @Size(max = 15)
    private String headerHour;

    @Size(max = 1)
    private String addSubSs;

    @Size(max = 1)
    private String addSubTax;

    @Size(max = 1)
    private String addSubTotal;

    private Boolean transferNextMonth;

    private Double initDay;

    private Double initHour;

    private Long completeLineNo;

    private Long differenceLineNo;

    private Long positiveValueLineNo;

    private Long negativeValueLineNo;

    private Integer balanceType;

    @Size(max = 3)
    private String missingSsDayType;

    private Double salaryDays;

    private Double salaryHours;

    private Boolean reserved;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeaderDay() {
        return headerDay;
    }

    public void setHeaderDay(String headerDay) {
        this.headerDay = headerDay;
    }

    public String getHeaderHour() {
        return headerHour;
    }

    public void setHeaderHour(String headerHour) {
        this.headerHour = headerHour;
    }

    public String getAddSubSs() {
        return addSubSs;
    }

    public void setAddSubSs(String addSubSs) {
        this.addSubSs = addSubSs;
    }

    public String getAddSubTax() {
        return addSubTax;
    }

    public void setAddSubTax(String addSubTax) {
        this.addSubTax = addSubTax;
    }

    public String getAddSubTotal() {
        return addSubTotal;
    }

    public void setAddSubTotal(String addSubTotal) {
        this.addSubTotal = addSubTotal;
    }

    public Boolean isTransferNextMonth() {
        return transferNextMonth;
    }

    public void setTransferNextMonth(Boolean transferNextMonth) {
        this.transferNextMonth = transferNextMonth;
    }

    public Double getInitDay() {
        return initDay;
    }

    public void setInitDay(Double initDay) {
        this.initDay = initDay;
    }

    public Double getInitHour() {
        return initHour;
    }

    public void setInitHour(Double initHour) {
        this.initHour = initHour;
    }

    public Long getCompleteLineNo() {
        return completeLineNo;
    }

    public void setCompleteLineNo(Long completeLineNo) {
        this.completeLineNo = completeLineNo;
    }

    public Long getDifferenceLineNo() {
        return differenceLineNo;
    }

    public void setDifferenceLineNo(Long differenceLineNo) {
        this.differenceLineNo = differenceLineNo;
    }

    public Long getPositiveValueLineNo() {
        return positiveValueLineNo;
    }

    public void setPositiveValueLineNo(Long positiveValueLineNo) {
        this.positiveValueLineNo = positiveValueLineNo;
    }

    public Long getNegativeValueLineNo() {
        return negativeValueLineNo;
    }

    public void setNegativeValueLineNo(Long negativeValueLineNo) {
        this.negativeValueLineNo = negativeValueLineNo;
    }

    public Integer getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(Integer balanceType) {
        this.balanceType = balanceType;
    }

    public String getMissingSsDayType() {
        return missingSsDayType;
    }

    public void setMissingSsDayType(String missingSsDayType) {
        this.missingSsDayType = missingSsDayType;
    }

    public Double getSalaryDays() {
        return salaryDays;
    }

    public void setSalaryDays(Double salaryDays) {
        this.salaryDays = salaryDays;
    }

    public Double getSalaryHours() {
        return salaryHours;
    }

    public void setSalaryHours(Double salaryHours) {
        this.salaryHours = salaryHours;
    }

    public Boolean isReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyLineDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyLineDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyLineDTO{" +
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
