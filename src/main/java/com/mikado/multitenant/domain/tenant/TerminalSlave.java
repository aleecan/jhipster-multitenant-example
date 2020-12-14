package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A TerminalSlave.
 */
@Entity
@Table(name = "terminal_slave")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TerminalSlave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "slave_gate_no", nullable = false)
    private Integer slaveGateNo;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalSlaves", allowSetters = true)
    private Terminal terminal;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalSlaves", allowSetters = true)
    private Terminal slaveTerminal;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSlaveGateNo() {
        return slaveGateNo;
    }

    public TerminalSlave slaveGateNo(Integer slaveGateNo) {
        this.slaveGateNo = slaveGateNo;
        return this;
    }

    public void setSlaveGateNo(Integer slaveGateNo) {
        this.slaveGateNo = slaveGateNo;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public TerminalSlave terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Terminal getSlaveTerminal() {
        return slaveTerminal;
    }

    public TerminalSlave slaveTerminal(Terminal terminal) {
        this.slaveTerminal = terminal;
        return this;
    }

    public void setSlaveTerminal(Terminal terminal) {
        this.slaveTerminal = terminal;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalSlave)) {
            return false;
        }
        return id != null && id.equals(((TerminalSlave) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalSlave{" +
            "id=" + getId() +
            ", slaveGateNo=" + getSlaveGateNo() +
            "}";
    }
}
