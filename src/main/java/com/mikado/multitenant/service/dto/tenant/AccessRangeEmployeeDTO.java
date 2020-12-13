package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.AccessRangeEmployee} entity.
 */
public class AccessRangeEmployeeDTO implements Serializable {

    private Long id;

    private Instant firstTime;

    private Instant lastTime;

    private Instant lastInTime;

    private Instant lastOutTime;


    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Instant firstTime) {
        this.firstTime = firstTime;
    }

    public Instant getLastTime() {
        return lastTime;
    }

    public void setLastTime(Instant lastTime) {
        this.lastTime = lastTime;
    }

    public Instant getLastInTime() {
        return lastInTime;
    }

    public void setLastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
    }

    public Instant getLastOutTime() {
        return lastOutTime;
    }

    public void setLastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
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
        if (!(o instanceof AccessRangeEmployeeDTO)) {
            return false;
        }

        return id != null && id.equals(((AccessRangeEmployeeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessRangeEmployeeDTO{" +
            "id=" + getId() +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", lastInTime='" + getLastInTime() + "'" +
            ", lastOutTime='" + getLastOutTime() + "'" +
            ", employeeId=" + getEmployeeId() +
            "}";
    }
}
