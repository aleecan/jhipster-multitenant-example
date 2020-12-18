package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.TerminalActivitySchedule} entity.
 */
public class TerminalActivityScheduleDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant startTime;

    @NotNull
    private Instant endTime;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String minAttendance;

    @NotNull
    @Size(max = 40)
    private String location;


    private Long terminalId;

    private Long activityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getMinAttendance() {
        return minAttendance;
    }

    public void setMinAttendance(String minAttendance) {
        this.minAttendance = minAttendance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long terminalActivityId) {
        this.activityId = terminalActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalActivityScheduleDTO)) {
            return false;
        }

        return id != null && id.equals(((TerminalActivityScheduleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalActivityScheduleDTO{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", minAttendance='" + getMinAttendance() + "'" +
            ", location='" + getLocation() + "'" +
            ", terminalId=" + getTerminalId() +
            ", activityId=" + getActivityId() +
            "}";
    }
}
