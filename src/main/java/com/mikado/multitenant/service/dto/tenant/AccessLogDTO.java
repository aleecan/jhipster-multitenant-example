package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.AccessLog} entity.
 */
public class AccessLogDTO implements Serializable {

    private Long id;

    private Instant dayTime;

    @Size(max = 3)
    private String functionKey;

    private Integer accessCode;

    @Size(max = 80)
    private String accessName;

    @Size(max = 4)
    private String terminalNo;

    @Size(max = 80)
    private String terminalName;

    @Size(max = 20)
    private String cardNo;

    @Size(max = 1)
    private String cardType;

    private Integer empNo;

    private Long visitorBookId;

    @Size(max = 80)
    private String cardHolder;

    @Size(max = 80)
    private String replyDisplay;

    @Size(max = 80)
    private String replyAcServer;

    private Integer controlTimeSec;

    private Integer totalTimeSec;

    private Integer logStatus;

    private Integer accessNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDayTime() {
        return dayTime;
    }

    public void setDayTime(Instant dayTime) {
        this.dayTime = dayTime;
    }

    public String getFunctionKey() {
        return functionKey;
    }

    public void setFunctionKey(String functionKey) {
        this.functionKey = functionKey;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Long getVisitorBookId() {
        return visitorBookId;
    }

    public void setVisitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getReplyDisplay() {
        return replyDisplay;
    }

    public void setReplyDisplay(String replyDisplay) {
        this.replyDisplay = replyDisplay;
    }

    public String getReplyAcServer() {
        return replyAcServer;
    }

    public void setReplyAcServer(String replyAcServer) {
        this.replyAcServer = replyAcServer;
    }

    public Integer getControlTimeSec() {
        return controlTimeSec;
    }

    public void setControlTimeSec(Integer controlTimeSec) {
        this.controlTimeSec = controlTimeSec;
    }

    public Integer getTotalTimeSec() {
        return totalTimeSec;
    }

    public void setTotalTimeSec(Integer totalTimeSec) {
        this.totalTimeSec = totalTimeSec;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public Integer getAccessNo() {
        return accessNo;
    }

    public void setAccessNo(Integer accessNo) {
        this.accessNo = accessNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessLogDTO)) {
            return false;
        }

        return id != null && id.equals(((AccessLogDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessLogDTO{" +
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
