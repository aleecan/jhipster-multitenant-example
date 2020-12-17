package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.JobScheduler} entity.
 */
public class JobSchedulerDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String jobName;

    @Size(max = 80)
    private String description;

    @Size(max = 80)
    private String procedureName;

    private Instant startDatetime;

    private Instant endDatetime;

    private Boolean isActive;

    private Boolean isFixed;

    private Boolean isRecursive;

    private Integer recursiveMinute;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String startTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String endTime;

    private Instant lastrunDatetime;

    @Size(max = 80)
    private String parameter;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String daytime;

    private Integer type;

    private Boolean exportTimecardrec;

    private Boolean importTransaction;

    private Boolean importTimecardrec;

    private Boolean processDailyanalysis;

    private Boolean processDaily;

    private Boolean processEntryExit;

    private Boolean processHolidayLeave;

    private Boolean processMonthly;

    private Boolean updateUnusedCard;

    private Integer processType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Instant getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Instant startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Instant getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Instant endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }

    public Boolean isIsRecursive() {
        return isRecursive;
    }

    public void setIsRecursive(Boolean isRecursive) {
        this.isRecursive = isRecursive;
    }

    public Integer getRecursiveMinute() {
        return recursiveMinute;
    }

    public void setRecursiveMinute(Integer recursiveMinute) {
        this.recursiveMinute = recursiveMinute;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Instant getLastrunDatetime() {
        return lastrunDatetime;
    }

    public void setLastrunDatetime(Instant lastrunDatetime) {
        this.lastrunDatetime = lastrunDatetime;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean isExportTimecardrec() {
        return exportTimecardrec;
    }

    public void setExportTimecardrec(Boolean exportTimecardrec) {
        this.exportTimecardrec = exportTimecardrec;
    }

    public Boolean isImportTransaction() {
        return importTransaction;
    }

    public void setImportTransaction(Boolean importTransaction) {
        this.importTransaction = importTransaction;
    }

    public Boolean isImportTimecardrec() {
        return importTimecardrec;
    }

    public void setImportTimecardrec(Boolean importTimecardrec) {
        this.importTimecardrec = importTimecardrec;
    }

    public Boolean isProcessDailyanalysis() {
        return processDailyanalysis;
    }

    public void setProcessDailyanalysis(Boolean processDailyanalysis) {
        this.processDailyanalysis = processDailyanalysis;
    }

    public Boolean isProcessDaily() {
        return processDaily;
    }

    public void setProcessDaily(Boolean processDaily) {
        this.processDaily = processDaily;
    }

    public Boolean isProcessEntryExit() {
        return processEntryExit;
    }

    public void setProcessEntryExit(Boolean processEntryExit) {
        this.processEntryExit = processEntryExit;
    }

    public Boolean isProcessHolidayLeave() {
        return processHolidayLeave;
    }

    public void setProcessHolidayLeave(Boolean processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
    }

    public Boolean isProcessMonthly() {
        return processMonthly;
    }

    public void setProcessMonthly(Boolean processMonthly) {
        this.processMonthly = processMonthly;
    }

    public Boolean isUpdateUnusedCard() {
        return updateUnusedCard;
    }

    public void setUpdateUnusedCard(Boolean updateUnusedCard) {
        this.updateUnusedCard = updateUnusedCard;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobSchedulerDTO)) {
            return false;
        }

        return id != null && id.equals(((JobSchedulerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobSchedulerDTO{" +
            "id=" + getId() +
            ", jobName='" + getJobName() + "'" +
            ", description='" + getDescription() + "'" +
            ", procedureName='" + getProcedureName() + "'" +
            ", startDatetime='" + getStartDatetime() + "'" +
            ", endDatetime='" + getEndDatetime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isFixed='" + isIsFixed() + "'" +
            ", isRecursive='" + isIsRecursive() + "'" +
            ", recursiveMinute=" + getRecursiveMinute() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", lastrunDatetime='" + getLastrunDatetime() + "'" +
            ", parameter='" + getParameter() + "'" +
            ", daytime='" + getDaytime() + "'" +
            ", type=" + getType() +
            ", exportTimecardrec='" + isExportTimecardrec() + "'" +
            ", importTransaction='" + isImportTransaction() + "'" +
            ", importTimecardrec='" + isImportTimecardrec() + "'" +
            ", processDailyanalysis='" + isProcessDailyanalysis() + "'" +
            ", processDaily='" + isProcessDaily() + "'" +
            ", processEntryExit='" + isProcessEntryExit() + "'" +
            ", processHolidayLeave='" + isProcessHolidayLeave() + "'" +
            ", processMonthly='" + isProcessMonthly() + "'" +
            ", updateUnusedCard='" + isUpdateUnusedCard() + "'" +
            ", processType=" + getProcessType() +
            "}";
    }
}
