package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.ZoneGate} entity.
 */
public class ZoneGateDTO implements Serializable {

    private Long id;


    private Long zoneId;

    private Long gateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneGateDTO)) {
            return false;
        }

        return id != null && id.equals(((ZoneGateDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneGateDTO{" +
            "id=" + getId() +
            ", zoneId=" + getZoneId() +
            ", gateId=" + getGateId() +
            "}";
    }
}
