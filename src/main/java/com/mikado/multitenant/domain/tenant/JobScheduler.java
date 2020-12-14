package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A JobScheduler.
 */
@Entity
@Table(name = "job_scheduler")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class JobScheduler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @Column(name = "job_name", length = 80)
    private String jobName;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(max = 80)
    @Column(name = "procedure_name", length = 80)
    private String procedureName;

    @Column(name = "start_datetime")
    private Instant startDatetime;

    @Column(name = "end_datetime")
    private Instant endDatetime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_fixed")
    private Boolean isFixed;

    @Column(name = "is_recursive")
    private Boolean isRecursive;

    @Column(name = "recursive_minute")
    private Integer recursiveMinute;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "start_time", length = 8)
    private String startTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "end_time", length = 8)
    private String endTime;

    @Column(name = "lastrun_datetime")
    private Instant lastrunDatetime;

    @Size(max = 80)
    @Column(name = "parameter", length = 80)
    private String parameter;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "daytime", length = 8)
    private String daytime;

    @Column(name = "type")
    private Integer type;

    @Column(name = "export_timecardrec")
    private Boolean exportTimecardrec;

    @Column(name = "import_transaction")
    private Boolean importTransaction;

    @Column(name = "import_timecardrec")
    private Boolean importTimecardrec;

    @Column(name = "process_dailyanalysis")
    private Boolean processDailyanalysis;

    @Column(name = "process_daily")
    private Boolean processDaily;

    @Column(name = "process_entry_exit")
    private Boolean processEntryExit;

    @Column(name = "process_holiday_leave")
    private Boolean processHolidayLeave;

    @Column(name = "process_monthly")
    private Boolean processMonthly;

    @Column(name = "update_unused_card")
    private Boolean updateUnusedCard;

    @Column(name = "process_type")
    private Integer processType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public JobScheduler jobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public JobScheduler description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public JobScheduler procedureName(String procedureName) {
        this.procedureName = procedureName;
        return this;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Instant getStartDatetime() {
        return startDatetime;
    }

    public JobScheduler startDatetime(Instant startDatetime) {
        this.startDatetime = startDatetime;
        return this;
    }

    public void setStartDatetime(Instant startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Instant getEndDatetime() {
        return endDatetime;
    }

    public JobScheduler endDatetime(Instant endDatetime) {
        this.endDatetime = endDatetime;
        return this;
    }

    public void setEndDatetime(Instant endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public JobScheduler isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsFixed() {
        return isFixed;
    }

    public JobScheduler isFixed(Boolean isFixed) {
        this.isFixed = isFixed;
        return this;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }

    public Boolean isIsRecursive() {
        return isRecursive;
    }

    public JobScheduler isRecursive(Boolean isRecursive) {
        this.isRecursive = isRecursive;
        return this;
    }

    public void setIsRecursive(Boolean isRecursive) {
        this.isRecursive = isRecursive;
    }

    public Integer getRecursiveMinute() {
        return recursiveMinute;
    }

    public JobScheduler recursiveMinute(Integer recursiveMinute) {
        this.recursiveMinute = recursiveMinute;
        return this;
    }

    public void setRecursiveMinute(Integer recursiveMinute) {
        this.recursiveMinute = recursiveMinute;
    }

    public String getStartTime() {
        return startTime;
    }

    public JobScheduler startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public JobScheduler endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Instant getLastrunDatetime() {
        return lastrunDatetime;
    }

    public JobScheduler lastrunDatetime(Instant lastrunDatetime) {
        this.lastrunDatetime = lastrunDatetime;
        return this;
    }

    public void setLastrunDatetime(Instant lastrunDatetime) {
        this.lastrunDatetime = lastrunDatetime;
    }

    public String getParameter() {
        return parameter;
    }

    public JobScheduler parameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDaytime() {
        return daytime;
    }

    public JobScheduler daytime(String daytime) {
        this.daytime = daytime;
        return this;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Integer getType() {
        return type;
    }

    public JobScheduler type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean isExportTimecardrec() {
        return exportTimecardrec;
    }

    public JobScheduler exportTimecardrec(Boolean exportTimecardrec) {
        this.exportTimecardrec = exportTimecardrec;
        return this;
    }

    public void setExportTimecardrec(Boolean exportTimecardrec) {
        this.exportTimecardrec = exportTimecardrec;
    }

    public Boolean isImportTransaction() {
        return importTransaction;
    }

    public JobScheduler importTransaction(Boolean importTransaction) {
        this.importTransaction = importTransaction;
        return this;
    }

    public void setImportTransaction(Boolean importTransaction) {
        this.importTransaction = importTransaction;
    }

    public Boolean isImportTimecardrec() {
        return importTimecardrec;
    }

    public JobScheduler importTimecardrec(Boolean importTimecardrec) {
        this.importTimecardrec = importTimecardrec;
        return this;
    }

    public void setImportTimecardrec(Boolean importTimecardrec) {
        this.importTimecardrec = importTimecardrec;
    }

    public Boolean isProcessDailyanalysis() {
        return processDailyanalysis;
    }

    public JobScheduler processDailyanalysis(Boolean processDailyanalysis) {
        this.processDailyanalysis = processDailyanalysis;
        return this;
    }

    public void setProcessDailyanalysis(Boolean processDailyanalysis) {
        this.processDailyanalysis = processDailyanalysis;
    }

    public Boolean isProcessDaily() {
        return processDaily;
    }

    public JobScheduler processDaily(Boolean processDaily) {
        this.processDaily = processDaily;
        return this;
    }

    public void setProcessDaily(Boolean processDaily) {
        this.processDaily = processDaily;
    }

    public Boolean isProcessEntryExit() {
        return processEntryExit;
    }

    public JobScheduler processEntryExit(Boolean processEntryExit) {
        this.processEntryExit = processEntryExit;
        return this;
    }

    public void setProcessEntryExit(Boolean processEntryExit) {
        this.processEntryExit = processEntryExit;
    }

    public Boolean isProcessHolidayLeave() {
        return processHolidayLeave;
    }

    public JobScheduler processHolidayLeave(Boolean processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
        return this;
    }

    public void setProcessHolidayLeave(Boolean processHolidayLeave) {
        this.processHolidayLeave = processHolidayLeave;
    }

    public Boolean isProcessMonthly() {
        return processMonthly;
    }

    public JobScheduler processMonthly(Boolean processMonthly) {
        this.processMonthly = processMonthly;
        return this;
    }

    public void setProcessMonthly(Boolean processMonthly) {
        this.processMonthly = processMonthly;
    }

    public Boolean isUpdateUnusedCard() {
        return updateUnusedCard;
    }

    public JobScheduler updateUnusedCard(Boolean updateUnusedCard) {
        this.updateUnusedCard = updateUnusedCard;
        return this;
    }

    public void setUpdateUnusedCard(Boolean updateUnusedCard) {
        this.updateUnusedCard = updateUnusedCard;
    }

    public Integer getProcessType() {
        return processType;
    }

    public JobScheduler processType(Integer processType) {
        this.processType = processType;
        return this;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobScheduler)) {
            return false;
        }
        return id != null && id.equals(((JobScheduler) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobScheduler{" +
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
