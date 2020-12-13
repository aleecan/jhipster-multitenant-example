package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A TerminalMessage.
 */
@Entity
@Table(name = "terminal_message")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TerminalMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "first_time", length = 8)
    private String firstTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "last_time", length = 8)
    private String lastTime;

    @Size(max = 32)
    @Column(name = "message_yes", length = 32)
    private String messageYes;

    @Size(max = 32)
    @Column(name = "message_no", length = 32)
    private String messageNo;

    @Size(max = 32)
    @Column(name = "result_msg_yes", length = 32)
    private String resultMsgYes;

    @Size(max = 32)
    @Column(name = "result_msg_no", length = 32)
    private String resultMsgNo;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalMessages", allowSetters = true)
    private Terminal terminal;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalMessages", allowSetters = true)
    private AccessCode accessCode;

    @ManyToOne
    @JsonIgnoreProperties(value = "terminalMessages", allowSetters = true)
    private AuthorizationGroup authorizationGroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public TerminalMessage description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public TerminalMessage firstTime(String firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public TerminalMessage lastTime(String lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getMessageYes() {
        return messageYes;
    }

    public TerminalMessage messageYes(String messageYes) {
        this.messageYes = messageYes;
        return this;
    }

    public void setMessageYes(String messageYes) {
        this.messageYes = messageYes;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public TerminalMessage messageNo(String messageNo) {
        this.messageNo = messageNo;
        return this;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getResultMsgYes() {
        return resultMsgYes;
    }

    public TerminalMessage resultMsgYes(String resultMsgYes) {
        this.resultMsgYes = resultMsgYes;
        return this;
    }

    public void setResultMsgYes(String resultMsgYes) {
        this.resultMsgYes = resultMsgYes;
    }

    public String getResultMsgNo() {
        return resultMsgNo;
    }

    public TerminalMessage resultMsgNo(String resultMsgNo) {
        this.resultMsgNo = resultMsgNo;
        return this;
    }

    public void setResultMsgNo(String resultMsgNo) {
        this.resultMsgNo = resultMsgNo;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public TerminalMessage terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public TerminalMessage accessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public AuthorizationGroup getAuthorizationGroup() {
        return authorizationGroup;
    }

    public TerminalMessage authorizationGroup(AuthorizationGroup authorizationGroup) {
        this.authorizationGroup = authorizationGroup;
        return this;
    }

    public void setAuthorizationGroup(AuthorizationGroup authorizationGroup) {
        this.authorizationGroup = authorizationGroup;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalMessage)) {
            return false;
        }
        return id != null && id.equals(((TerminalMessage) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalMessage{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", messageYes='" + getMessageYes() + "'" +
            ", messageNo='" + getMessageNo() + "'" +
            ", resultMsgYes='" + getResultMsgYes() + "'" +
            ", resultMsgNo='" + getResultMsgNo() + "'" +
            "}";
    }
}
