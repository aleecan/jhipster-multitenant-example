package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A ZoneGate.
 */
@Entity
@Table(name = "zone_gate")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ZoneGate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneGates", allowSetters = true)
    private Zone zone;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneGates", allowSetters = true)
    private Gate gate;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public ZoneGate zone(Zone zone) {
        this.zone = zone;
        return this;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Gate getGate() {
        return gate;
    }

    public ZoneGate gate(Gate gate) {
        this.gate = gate;
        return this;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneGate)) {
            return false;
        }
        return id != null && id.equals(((ZoneGate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneGate{" +
            "id=" + getId() +
            "}";
    }
}
