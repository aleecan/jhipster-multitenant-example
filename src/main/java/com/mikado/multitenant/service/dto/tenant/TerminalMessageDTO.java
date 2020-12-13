package com.mikado.multitenant.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.TerminalMessage} entity.
 */
public class TerminalMessageDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String description;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String firstTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String lastTime;

    @Size(max = 32)
    private String messageYes;

    @Size(max = 32)
    private String messageNo;

    @Size(max = 32)
    private String resultMsgYes;

    @Size(max = 32)
    private String resultMsgNo;


    private Long terminalId;

    private Long accessCodeId;

    private Long authorizationGroupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getMessageYes() {
        return messageYes;
    }

    public void setMessageYes(String messageYes) {
        this.messageYes = messageYes;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getResultMsgYes() {
        return resultMsgYes;
    }

    public void setResultMsgYes(String resultMsgYes) {
        this.resultMsgYes = resultMsgYes;
    }

    public String getResultMsgNo() {
        return resultMsgNo;
    }

    public void setResultMsgNo(String resultMsgNo) {
        this.resultMsgNo = resultMsgNo;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getAccessCodeId() {
        return accessCodeId;
    }

    public void setAccessCodeId(Long accessCodeId) {
        this.accessCodeId = accessCodeId;
    }

    public Long getAuthorizationGroupId() {
        return authorizationGroupId;
    }

    public void setAuthorizationGroupId(Long authorizationGroupId) {
        this.authorizationGroupId = authorizationGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalMessageDTO)) {
            return false;
        }

        return id != null && id.equals(((TerminalMessageDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalMessageDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", messageYes='" + getMessageYes() + "'" +
            ", messageNo='" + getMessageNo() + "'" +
            ", resultMsgYes='" + getResultMsgYes() + "'" +
            ", resultMsgNo='" + getResultMsgNo() + "'" +
            ", terminalId=" + getTerminalId() +
            ", accessCodeId=" + getAccessCodeId() +
            ", authorizationGroupId=" + getAuthorizationGroupId() +
            "}";
    }
}
