package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A SchedulerHistory.
 */
@Entity
@Table(name = "scheduler_history")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SchedulerHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "in_manual")
    private Boolean inManual;

    @Column(name = "in_process")
    private Boolean inProcess;

    @Column(name = "is_finish")
    private Boolean isFinish;

    @Size(max = 255)
    @Column(name = "process_no", length = 255)
    private String processNo;

    @Size(max = 255)
    @Column(name = "process_status", length = 255)
    private String processStatus;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedulerHistories", allowSetters = true)
    private JobScheduler jobScheduler;

    @ManyToOne
    @JsonIgnoreProperties(value = "schedulerHistories", allowSetters = true)
    private MailScheduler mailScheduler;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public SchedulerHistory startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public SchedulerHistory endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Boolean isInManual() {
        return inManual;
    }

    public SchedulerHistory inManual(Boolean inManual) {
        this.inManual = inManual;
        return this;
    }

    public void setInManual(Boolean inManual) {
        this.inManual = inManual;
    }

    public Boolean isInProcess() {
        return inProcess;
    }

    public SchedulerHistory inProcess(Boolean inProcess) {
        this.inProcess = inProcess;
        return this;
    }

    public void setInProcess(Boolean inProcess) {
        this.inProcess = inProcess;
    }

    public Boolean isIsFinish() {
        return isFinish;
    }

    public SchedulerHistory isFinish(Boolean isFinish) {
        this.isFinish = isFinish;
        return this;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public String getProcessNo() {
        return processNo;
    }

    public SchedulerHistory processNo(String processNo) {
        this.processNo = processNo;
        return this;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public SchedulerHistory processStatus(String processStatus) {
        this.processStatus = processStatus;
        return this;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public JobScheduler getJobScheduler() {
        return jobScheduler;
    }

    public SchedulerHistory jobScheduler(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
        return this;
    }

    public void setJobScheduler(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
    }

    public MailScheduler getMailScheduler() {
        return mailScheduler;
    }

    public SchedulerHistory mailScheduler(MailScheduler mailScheduler) {
        this.mailScheduler = mailScheduler;
        return this;
    }

    public void setMailScheduler(MailScheduler mailScheduler) {
        this.mailScheduler = mailScheduler;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchedulerHistory)) {
            return false;
        }
        return id != null && id.equals(((SchedulerHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SchedulerHistory{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", inManual='" + isInManual() + "'" +
            ", inProcess='" + isInProcess() + "'" +
            ", isFinish='" + isIsFinish() + "'" +
            ", processNo='" + getProcessNo() + "'" +
            ", processStatus='" + getProcessStatus() + "'" +
            "}";
    }
}
