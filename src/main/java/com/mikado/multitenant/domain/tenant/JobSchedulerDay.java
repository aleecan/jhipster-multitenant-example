package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A JobSchedulerDay.
 */
@Entity
@Table(name = "job_scheduler_day")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class JobSchedulerDay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_day")
    private Integer jobDay;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "jobSchedulerDays", allowSetters = true)
    private JobScheduler jobScheduler;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJobDay() {
        return jobDay;
    }

    public JobSchedulerDay jobDay(Integer jobDay) {
        this.jobDay = jobDay;
        return this;
    }

    public void setJobDay(Integer jobDay) {
        this.jobDay = jobDay;
    }

    public JobScheduler getJobScheduler() {
        return jobScheduler;
    }

    public JobSchedulerDay jobScheduler(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
        return this;
    }

    public void setJobScheduler(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobSchedulerDay)) {
            return false;
        }
        return id != null && id.equals(((JobSchedulerDay) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobSchedulerDay{" +
            "id=" + getId() +
            ", jobDay=" + getJobDay() +
            "}";
    }
}
