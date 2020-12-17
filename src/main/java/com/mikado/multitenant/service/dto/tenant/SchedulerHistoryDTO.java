package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.SchedulerHistory} entity.
 */
public class SchedulerHistoryDTO implements Serializable {

    private Long id;

    private Instant startTime;

    private Instant endTime;

    private Boolean inManual;

    private Boolean inProcess;

    private Boolean isFinish;

    @Size(max = 255)
    private String processNo;

    @Size(max = 255)
    private String processStatus;


    private Long jobSchedulerId;

    private Long mailSchedulerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Boolean isInManual() {
        return inManual;
    }

    public void setInManual(Boolean inManual) {
        this.inManual = inManual;
    }

    public Boolean isInProcess() {
        return inProcess;
    }

    public void setInProcess(Boolean inProcess) {
        this.inProcess = inProcess;
    }

    public Boolean isIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Long getJobSchedulerId() {
        return jobSchedulerId;
    }

    public void setJobSchedulerId(Long jobSchedulerId) {
        this.jobSchedulerId = jobSchedulerId;
    }

    public Long getMailSchedulerId() {
        return mailSchedulerId;
    }

    public void setMailSchedulerId(Long mailSchedulerId) {
        this.mailSchedulerId = mailSchedulerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchedulerHistoryDTO)) {
            return false;
        }

        return id != null && id.equals(((SchedulerHistoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SchedulerHistoryDTO{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", inManual='" + isInManual() + "'" +
            ", inProcess='" + isInProcess() + "'" +
            ", isFinish='" + isIsFinish() + "'" +
            ", processNo='" + getProcessNo() + "'" +
            ", processStatus='" + getProcessStatus() + "'" +
            ", jobSchedulerId=" + getJobSchedulerId() +
            ", mailSchedulerId=" + getMailSchedulerId() +
            "}";
    }
}
