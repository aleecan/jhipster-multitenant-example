package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A RequestOvertime.
 */
@Entity
@Table(name = "request_overtime")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RequestOvertime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "daydate", nullable = false)
    private LocalDate daydate;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "overtime_hour", length = 8, nullable = false)
    private String overtimeHour;

    @Size(max = 80)
    @Column(name = "overtime_notes", length = 80)
    private String overtimeNotes;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @Column(name = "approved")
    private Boolean approved;

    @Size(max = 80)
    @Column(name = "approved_user", length = 80)
    private String approvedUser;

    @Column(name = "approved_daytime")
    private Instant approvedDaytime;

    @Column(name = "approved_1")
    private Boolean approved1;

    @Size(max = 80)
    @Column(name = "approved_1_user", length = 80)
    private String approved1User;

    @Column(name = "approved_1_daytime")
    private Instant approved1Daytime;

    @Column(name = "approved_2")
    private Boolean approved2;

    @Size(max = 80)
    @Column(name = "approved_2_user", length = 80)
    private String approved2User;

    @Column(name = "approved_2_daytime")
    private Instant approved2Daytime;

    @Column(name = "rejected")
    private Boolean rejected;

    @Column(name = "rejected_daytime")
    private Instant rejectedDaytime;

    @Size(max = 80)
    @Column(name = "rejected_user", length = 80)
    private String rejectedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "requestOvertimes", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "requestOvertimes", allowSetters = true)
    private OvertimeReason overtimeReason;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public RequestOvertime daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getOvertimeHour() {
        return overtimeHour;
    }

    public RequestOvertime overtimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
        return this;
    }

    public void setOvertimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public String getOvertimeNotes() {
        return overtimeNotes;
    }

    public RequestOvertime overtimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
        return this;
    }

    public void setOvertimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
    }

    public Instant getCreated() {
        return created;
    }

    public RequestOvertime created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public RequestOvertime modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public RequestOvertime modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Boolean isApproved() {
        return approved;
    }

    public RequestOvertime approved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public RequestOvertime approvedUser(String approvedUser) {
        this.approvedUser = approvedUser;
        return this;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Instant getApprovedDaytime() {
        return approvedDaytime;
    }

    public RequestOvertime approvedDaytime(Instant approvedDaytime) {
        this.approvedDaytime = approvedDaytime;
        return this;
    }

    public void setApprovedDaytime(Instant approvedDaytime) {
        this.approvedDaytime = approvedDaytime;
    }

    public Boolean isApproved1() {
        return approved1;
    }

    public RequestOvertime approved1(Boolean approved1) {
        this.approved1 = approved1;
        return this;
    }

    public void setApproved1(Boolean approved1) {
        this.approved1 = approved1;
    }

    public String getApproved1User() {
        return approved1User;
    }

    public RequestOvertime approved1User(String approved1User) {
        this.approved1User = approved1User;
        return this;
    }

    public void setApproved1User(String approved1User) {
        this.approved1User = approved1User;
    }

    public Instant getApproved1Daytime() {
        return approved1Daytime;
    }

    public RequestOvertime approved1Daytime(Instant approved1Daytime) {
        this.approved1Daytime = approved1Daytime;
        return this;
    }

    public void setApproved1Daytime(Instant approved1Daytime) {
        this.approved1Daytime = approved1Daytime;
    }

    public Boolean isApproved2() {
        return approved2;
    }

    public RequestOvertime approved2(Boolean approved2) {
        this.approved2 = approved2;
        return this;
    }

    public void setApproved2(Boolean approved2) {
        this.approved2 = approved2;
    }

    public String getApproved2User() {
        return approved2User;
    }

    public RequestOvertime approved2User(String approved2User) {
        this.approved2User = approved2User;
        return this;
    }

    public void setApproved2User(String approved2User) {
        this.approved2User = approved2User;
    }

    public Instant getApproved2Daytime() {
        return approved2Daytime;
    }

    public RequestOvertime approved2Daytime(Instant approved2Daytime) {
        this.approved2Daytime = approved2Daytime;
        return this;
    }

    public void setApproved2Daytime(Instant approved2Daytime) {
        this.approved2Daytime = approved2Daytime;
    }

    public Boolean isRejected() {
        return rejected;
    }

    public RequestOvertime rejected(Boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Instant getRejectedDaytime() {
        return rejectedDaytime;
    }

    public RequestOvertime rejectedDaytime(Instant rejectedDaytime) {
        this.rejectedDaytime = rejectedDaytime;
        return this;
    }

    public void setRejectedDaytime(Instant rejectedDaytime) {
        this.rejectedDaytime = rejectedDaytime;
    }

    public String getRejectedUser() {
        return rejectedUser;
    }

    public RequestOvertime rejectedUser(String rejectedUser) {
        this.rejectedUser = rejectedUser;
        return this;
    }

    public void setRejectedUser(String rejectedUser) {
        this.rejectedUser = rejectedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public RequestOvertime employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public OvertimeReason getOvertimeReason() {
        return overtimeReason;
    }

    public RequestOvertime overtimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
        return this;
    }

    public void setOvertimeReason(OvertimeReason overtimeReason) {
        this.overtimeReason = overtimeReason;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestOvertime)) {
            return false;
        }
        return id != null && id.equals(((RequestOvertime) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequestOvertime{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", overtimeHour='" + getOvertimeHour() + "'" +
            ", overtimeNotes='" + getOvertimeNotes() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", approved='" + isApproved() + "'" +
            ", approvedUser='" + getApprovedUser() + "'" +
            ", approvedDaytime='" + getApprovedDaytime() + "'" +
            ", approved1='" + isApproved1() + "'" +
            ", approved1User='" + getApproved1User() + "'" +
            ", approved1Daytime='" + getApproved1Daytime() + "'" +
            ", approved2='" + isApproved2() + "'" +
            ", approved2User='" + getApproved2User() + "'" +
            ", approved2Daytime='" + getApproved2Daytime() + "'" +
            ", rejected='" + isRejected() + "'" +
            ", rejectedDaytime='" + getRejectedDaytime() + "'" +
            ", rejectedUser='" + getRejectedUser() + "'" +
            "}";
    }
}
