package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.RequestOvertime} entity.
 */
public class RequestOvertimeDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate daydate;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String overtimeHour;

    @Size(max = 80)
    private String overtimeNotes;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;

    private Boolean approved;

    @Size(max = 80)
    private String approvedUser;

    private Instant approvedDaytime;

    private Boolean approved1;

    @Size(max = 80)
    private String approved1User;

    private Instant approved1Daytime;

    private Boolean approved2;

    @Size(max = 80)
    private String approved2User;

    private Instant approved2Daytime;

    private Boolean rejected;

    private Instant rejectedDaytime;

    @Size(max = 80)
    private String rejectedUser;


    private Long employeeId;

    private Long overtimeReasonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDaydate() {
        return daydate;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(String overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public String getOvertimeNotes() {
        return overtimeNotes;
    }

    public void setOvertimeNotes(String overtimeNotes) {
        this.overtimeNotes = overtimeNotes;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Boolean isApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Instant getApprovedDaytime() {
        return approvedDaytime;
    }

    public void setApprovedDaytime(Instant approvedDaytime) {
        this.approvedDaytime = approvedDaytime;
    }

    public Boolean isApproved1() {
        return approved1;
    }

    public void setApproved1(Boolean approved1) {
        this.approved1 = approved1;
    }

    public String getApproved1User() {
        return approved1User;
    }

    public void setApproved1User(String approved1User) {
        this.approved1User = approved1User;
    }

    public Instant getApproved1Daytime() {
        return approved1Daytime;
    }

    public void setApproved1Daytime(Instant approved1Daytime) {
        this.approved1Daytime = approved1Daytime;
    }

    public Boolean isApproved2() {
        return approved2;
    }

    public void setApproved2(Boolean approved2) {
        this.approved2 = approved2;
    }

    public String getApproved2User() {
        return approved2User;
    }

    public void setApproved2User(String approved2User) {
        this.approved2User = approved2User;
    }

    public Instant getApproved2Daytime() {
        return approved2Daytime;
    }

    public void setApproved2Daytime(Instant approved2Daytime) {
        this.approved2Daytime = approved2Daytime;
    }

    public Boolean isRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Instant getRejectedDaytime() {
        return rejectedDaytime;
    }

    public void setRejectedDaytime(Instant rejectedDaytime) {
        this.rejectedDaytime = rejectedDaytime;
    }

    public String getRejectedUser() {
        return rejectedUser;
    }

    public void setRejectedUser(String rejectedUser) {
        this.rejectedUser = rejectedUser;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOvertimeReasonId() {
        return overtimeReasonId;
    }

    public void setOvertimeReasonId(Long overtimeReasonId) {
        this.overtimeReasonId = overtimeReasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestOvertimeDTO)) {
            return false;
        }

        return id != null && id.equals(((RequestOvertimeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequestOvertimeDTO{" +
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
            ", employeeId=" + getEmployeeId() +
            ", overtimeReasonId=" + getOvertimeReasonId() +
            "}";
    }
}
