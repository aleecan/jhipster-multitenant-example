package com.mikado.mikadosaas.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.JobSchedulerDay} entity.
 */
public class JobSchedulerDayDTO implements Serializable {

    private Long id;

    private Integer jobDay;


    private Long jobSchedulerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJobDay() {
        return jobDay;
    }

    public void setJobDay(Integer jobDay) {
        this.jobDay = jobDay;
    }

    public Long getJobSchedulerId() {
        return jobSchedulerId;
    }

    public void setJobSchedulerId(Long jobSchedulerId) {
        this.jobSchedulerId = jobSchedulerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobSchedulerDayDTO)) {
            return false;
        }

        return id != null && id.equals(((JobSchedulerDayDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobSchedulerDayDTO{" +
            "id=" + getId() +
            ", jobDay=" + getJobDay() +
            ", jobSchedulerId=" + getJobSchedulerId() +
            "}";
    }
}
