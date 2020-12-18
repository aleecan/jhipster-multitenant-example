package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A AccessLog.
 */
@Entity
@Table(name = "access_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_time")
    private Instant dayTime;

    @Size(max = 3)
    @Column(name = "function_key", length = 3)
    private String functionKey;

    @Column(name = "access_code")
    private Integer accessCode;

    @Size(max = 80)
    @Column(name = "access_name", length = 80)
    private String accessName;

    @Size(max = 4)
    @Column(name = "terminal_no", length = 4)
    private String terminalNo;

    @Size(max = 80)
    @Column(name = "terminal_name", length = 80)
    private String terminalName;

    @Size(max = 20)
    @Column(name = "card_no", length = 20)
    private String cardNo;

    @Size(max = 1)
    @Column(name = "card_type", length = 1)
    private String cardType;

    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "visitor_book_id")
    private Long visitorBookId;

    @Size(max = 80)
    @Column(name = "card_holder", length = 80)
    private String cardHolder;

    @Size(max = 80)
    @Column(name = "reply_display", length = 80)
    private String replyDisplay;

    @Size(max = 80)
    @Column(name = "reply_ac_server", length = 80)
    private String replyAcServer;

    @Column(name = "control_time_sec")
    private Integer controlTimeSec;

    @Column(name = "total_time_sec")
    private Integer totalTimeSec;

    @Column(name = "log_status")
    private Integer logStatus;

    @Column(name = "access_no")
    private Integer accessNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDayTime() {
        return dayTime;
    }

    public AccessLog dayTime(Instant dayTime) {
        this.dayTime = dayTime;
        return this;
    }

    public void setDayTime(Instant dayTime) {
        this.dayTime = dayTime;
    }

    public String getFunctionKey() {
        return functionKey;
    }

    public AccessLog functionKey(String functionKey) {
        this.functionKey = functionKey;
        return this;
    }

    public void setFunctionKey(String functionKey) {
        this.functionKey = functionKey;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public AccessLog accessCode(Integer accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public String getAccessName() {
        return accessName;
    }

    public AccessLog accessName(String accessName) {
        this.accessName = accessName;
        return this;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public AccessLog terminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
        return this;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public AccessLog terminalName(String terminalName) {
        this.terminalName = terminalName;
        return this;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public AccessLog cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public AccessLog cardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public AccessLog empNo(Integer empNo) {
        this.empNo = empNo;
        return this;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Long getVisitorBookId() {
        return visitorBookId;
    }

    public AccessLog visitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
        return this;
    }

    public void setVisitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public AccessLog cardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
        return this;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getReplyDisplay() {
        return replyDisplay;
    }

    public AccessLog replyDisplay(String replyDisplay) {
        this.replyDisplay = replyDisplay;
        return this;
    }

    public void setReplyDisplay(String replyDisplay) {
        this.replyDisplay = replyDisplay;
    }

    public String getReplyAcServer() {
        return replyAcServer;
    }

    public AccessLog replyAcServer(String replyAcServer) {
        this.replyAcServer = replyAcServer;
        return this;
    }

    public void setReplyAcServer(String replyAcServer) {
        this.replyAcServer = replyAcServer;
    }

    public Integer getControlTimeSec() {
        return controlTimeSec;
    }

    public AccessLog controlTimeSec(Integer controlTimeSec) {
        this.controlTimeSec = controlTimeSec;
        return this;
    }

    public void setControlTimeSec(Integer controlTimeSec) {
        this.controlTimeSec = controlTimeSec;
    }

    public Integer getTotalTimeSec() {
        return totalTimeSec;
    }

    public AccessLog totalTimeSec(Integer totalTimeSec) {
        this.totalTimeSec = totalTimeSec;
        return this;
    }

    public void setTotalTimeSec(Integer totalTimeSec) {
        this.totalTimeSec = totalTimeSec;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public AccessLog logStatus(Integer logStatus) {
        this.logStatus = logStatus;
        return this;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public Integer getAccessNo() {
        return accessNo;
    }

    public AccessLog accessNo(Integer accessNo) {
        this.accessNo = accessNo;
        return this;
    }

    public void setAccessNo(Integer accessNo) {
        this.accessNo = accessNo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessLog)) {
            return false;
        }
        return id != null && id.equals(((AccessLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessLog{" +
            "id=" + getId() +
            ", dayTime='" + getDayTime() + "'" +
            ", functionKey='" + getFunctionKey() + "'" +
            ", accessCode=" + getAccessCode() +
            ", accessName='" + getAccessName() + "'" +
            ", terminalNo='" + getTerminalNo() + "'" +
            ", terminalName='" + getTerminalName() + "'" +
            ", cardNo='" + getCardNo() + "'" +
            ", cardType='" + getCardType() + "'" +
            ", empNo=" + getEmpNo() +
            ", visitorBookId=" + getVisitorBookId() +
            ", cardHolder='" + getCardHolder() + "'" +
            ", replyDisplay='" + getReplyDisplay() + "'" +
            ", replyAcServer='" + getReplyAcServer() + "'" +
            ", controlTimeSec=" + getControlTimeSec() +
            ", totalTimeSec=" + getTotalTimeSec() +
            ", logStatus=" + getLogStatus() +
            ", accessNo=" + getAccessNo() +
            "}";
    }
}
