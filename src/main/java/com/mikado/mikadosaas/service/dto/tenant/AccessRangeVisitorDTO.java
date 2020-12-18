package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.AccessRangeVisitor} entity.
 */
public class AccessRangeVisitorDTO implements Serializable {

    private Long id;

    private Instant firstTime;

    private Instant lastTime;

    private Instant lastInTime;

    private Instant lastOutTime;


    private Long visitorBookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Instant firstTime) {
        this.firstTime = firstTime;
    }

    public Instant getLastTime() {
        return lastTime;
    }

    public void setLastTime(Instant lastTime) {
        this.lastTime = lastTime;
    }

    public Instant getLastInTime() {
        return lastInTime;
    }

    public void setLastInTime(Instant lastInTime) {
        this.lastInTime = lastInTime;
    }

    public Instant getLastOutTime() {
        return lastOutTime;
    }

    public void setLastOutTime(Instant lastOutTime) {
        this.lastOutTime = lastOutTime;
    }

    public Long getVisitorBookId() {
        return visitorBookId;
    }

    public void setVisitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessRangeVisitorDTO)) {
            return false;
        }

        return id != null && id.equals(((AccessRangeVisitorDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessRangeVisitorDTO{" +
            "id=" + getId() +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", lastInTime='" + getLastInTime() + "'" +
            ", lastOutTime='" + getLastOutTime() + "'" +
            ", visitorBookId=" + getVisitorBookId() +
            "}";
    }
}
