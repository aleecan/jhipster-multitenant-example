package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A TerminalActivitySchedule.
 */
@Entity
@Table(name = "terminal_activity_schedule")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TerminalActivitySchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private Instant endTime;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "min_attendance", length = 8, nullable = false)
    private String minAttendance;

    @NotNull
    @Size(max = 40)
    @Column(name = "location", length = 40, nullable = false)
    private String location;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalActivitySchedules", allowSetters = true)
    private Terminal terminal;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "terminalActivitySchedules", allowSetters = true)
    private TerminalActivity activity;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public TerminalActivitySchedule startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public TerminalActivitySchedule endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getMinAttendance() {
        return minAttendance;
    }

    public TerminalActivitySchedule minAttendance(String minAttendance) {
        this.minAttendance = minAttendance;
        return this;
    }

    public void setMinAttendance(String minAttendance) {
        this.minAttendance = minAttendance;
    }

    public String getLocation() {
        return location;
    }

    public TerminalActivitySchedule location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public TerminalActivitySchedule terminal(Terminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public TerminalActivity getActivity() {
        return activity;
    }

    public TerminalActivitySchedule activity(TerminalActivity terminalActivity) {
        this.activity = terminalActivity;
        return this;
    }

    public void setActivity(TerminalActivity terminalActivity) {
        this.activity = terminalActivity;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TerminalActivitySchedule)) {
            return false;
        }
        return id != null && id.equals(((TerminalActivitySchedule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TerminalActivitySchedule{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", minAttendance='" + getMinAttendance() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }
}
