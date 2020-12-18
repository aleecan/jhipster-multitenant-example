package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A GateTerminal.
 */
@Entity
@Table(name = "gate_terminal")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GateTerminal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "gateTerminals", allowSetters = true)
    private Gate gate;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "gateTerminals", allowSetters = true)
    private Terminal terminal;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gate getGate() {
        return gate;
    }

    public GateTerminal gate(Gate gate) {
        this.gate = gate;
        return this;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public GateTerminal terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GateTerminal)) {
            return false;
        }
        return id != null && id.equals(((GateTerminal) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GateTerminal{" +
            "id=" + getId() +
            "}";
    }
}
