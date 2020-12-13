package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.GateTerminal} entity.
 */
public class GateTerminalDTO implements Serializable {

    private Long id;


    private Long gateId;

    private Long terminalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GateTerminalDTO)) {
            return false;
        }

        return id != null && id.equals(((GateTerminalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GateTerminalDTO{" +
            "id=" + getId() +
            ", gateId=" + getGateId() +
            ", terminalId=" + getTerminalId() +
            "}";
    }
}
