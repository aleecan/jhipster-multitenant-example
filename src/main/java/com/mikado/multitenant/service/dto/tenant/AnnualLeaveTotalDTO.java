package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.AnnualLeaveTotal} entity.
 */
public class AnnualLeaveTotalDTO implements Serializable {

    private Long id;

    private Double alLeft;

    private Double alRight;

    private Double alUsed;


    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAlLeft() {
        return alLeft;
    }

    public void setAlLeft(Double alLeft) {
        this.alLeft = alLeft;
    }

    public Double getAlRight() {
        return alRight;
    }

    public void setAlRight(Double alRight) {
        this.alRight = alRight;
    }

    public Double getAlUsed() {
        return alUsed;
    }

    public void setAlUsed(Double alUsed) {
        this.alUsed = alUsed;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnualLeaveTotalDTO)) {
            return false;
        }

        return id != null && id.equals(((AnnualLeaveTotalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnnualLeaveTotalDTO{" +
            "id=" + getId() +
            ", alLeft=" + getAlLeft() +
            ", alRight=" + getAlRight() +
            ", alUsed=" + getAlUsed() +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
