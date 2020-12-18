package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.TerminalSlave} entity.
 */
public class TerminalSlaveDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer slaveGateNo;


    private Long terminalId;

    private Long slaveTerminalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSlaveGateNo() {
        return slaveGateNo;
    }

    public void setSlaveGateNo(Integer slaveGateNo) {
        this.slaveGateNo = slaveGateNo;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getSlaveTerminalId() {
        return slaveTerminalId;
    }

    public void setSlaveTerminalId(Long terminalId) {
        this.slaveTerminalId = terminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalSlaveDTO)) {
            return false;
        }

        return id != null && id.equals(((TerminalSlaveDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalSlaveDTO{" +
            "id=" + getId() +
            ", slaveGateNo=" + getSlaveGateNo() +
            ", terminalId=" + getTerminalId() +
            ", slaveTerminalId=" + getSlaveTerminalId() +
            "}";
    }
}
