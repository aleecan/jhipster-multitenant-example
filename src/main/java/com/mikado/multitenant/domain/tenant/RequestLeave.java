package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A RequestLeave.
 */
@Entity
@Table(name = "request_leave")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RequestLeave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "paid_day")
    private Double paidDay;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "paid_hour", length = 8)
    private String paidHour;

    @Column(name = "day_off")
    private Double dayOff;

    @Column(name = "holiday")
    private Double holiday;

    @Column(name = "military")
    private Double military;

    @Column(name = "travel")
    private Double travel;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

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
    @JsonIgnoreProperties(value = "requestLeaves", allowSetters = true)
    private Employee employee;

    @ManyToOne
    @JsonIgnoreProperties(value = "requestLeaves", allowSetters = true)
    private Schedule schedule;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public RequestLeave startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public RequestLeave endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPaidDay() {
        return paidDay;
    }

    public RequestLeave paidDay(Double paidDay) {
        this.paidDay = paidDay;
        return this;
    }

    public void setPaidDay(Double paidDay) {
        this.paidDay = paidDay;
    }

    public String getPaidHour() {
        return paidHour;
    }

    public RequestLeave paidHour(String paidHour) {
        this.paidHour = paidHour;
        return this;
    }

    public void setPaidHour(String paidHour) {
        this.paidHour = paidHour;
    }

    public Double getDayOff() {
        return dayOff;
    }

    public RequestLeave dayOff(Double dayOff) {
        this.dayOff = dayOff;
        return this;
    }

    public void setDayOff(Double dayOff) {
        this.dayOff = dayOff;
    }

    public Double getHoliday() {
        return holiday;
    }

    public RequestLeave holiday(Double holiday) {
        this.holiday = holiday;
        return this;
    }

    public void setHoliday(Double holiday) {
        this.holiday = holiday;
    }

    public Double getMilitary() {
        return military;
    }

    public RequestLeave military(Double military) {
        this.military = military;
        return this;
    }

    public void setMilitary(Double military) {
        this.military = military;
    }

    public Double getTravel() {
        return travel;
    }

    public RequestLeave travel(Double travel) {
        this.travel = travel;
        return this;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public String getDescription() {
        return description;
    }

    public RequestLeave description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreated() {
        return created;
    }

    public RequestLeave created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public RequestLeave modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public RequestLeave modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Boolean isApproved() {
        return approved;
    }

    public RequestLeave approved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public RequestLeave approvedUser(String approvedUser) {
        this.approvedUser = approvedUser;
        return this;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Instant getApprovedDaytime() {
        return approvedDaytime;
    }

    public RequestLeave approvedDaytime(Instant approvedDaytime) {
        this.approvedDaytime = approvedDaytime;
        return this;
    }

    public void setApprovedDaytime(Instant approvedDaytime) {
        this.approvedDaytime = approvedDaytime;
    }

    public Boolean isApproved1() {
        return approved1;
    }

    public RequestLeave approved1(Boolean approved1) {
        this.approved1 = approved1;
        return this;
    }

    public void setApproved1(Boolean approved1) {
        this.approved1 = approved1;
    }

    public String getApproved1User() {
        return approved1User;
    }

    public RequestLeave approved1User(String approved1User) {
        this.approved1User = approved1User;
        return this;
    }

    public void setApproved1User(String approved1User) {
        this.approved1User = approved1User;
    }

    public Instant getApproved1Daytime() {
        return approved1Daytime;
    }

    public RequestLeave approved1Daytime(Instant approved1Daytime) {
        this.approved1Daytime = approved1Daytime;
        return this;
    }

    public void setApproved1Daytime(Instant approved1Daytime) {
        this.approved1Daytime = approved1Daytime;
    }

    public Boolean isApproved2() {
        return approved2;
    }

    public RequestLeave approved2(Boolean approved2) {
        this.approved2 = approved2;
        return this;
    }

    public void setApproved2(Boolean approved2) {
        this.approved2 = approved2;
    }

    public String getApproved2User() {
        return approved2User;
    }

    public RequestLeave approved2User(String approved2User) {
        this.approved2User = approved2User;
        return this;
    }

    public void setApproved2User(String approved2User) {
        this.approved2User = approved2User;
    }

    public Instant getApproved2Daytime() {
        return approved2Daytime;
    }

    public RequestLeave approved2Daytime(Instant approved2Daytime) {
        this.approved2Daytime = approved2Daytime;
        return this;
    }

    public void setApproved2Daytime(Instant approved2Daytime) {
        this.approved2Daytime = approved2Daytime;
    }

    public Boolean isRejected() {
        return rejected;
    }

    public RequestLeave rejected(Boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Instant getRejectedDaytime() {
        return rejectedDaytime;
    }

    public RequestLeave rejectedDaytime(Instant rejectedDaytime) {
        this.rejectedDaytime = rejectedDaytime;
        return this;
    }

    public void setRejectedDaytime(Instant rejectedDaytime) {
        this.rejectedDaytime = rejectedDaytime;
    }

    public String getRejectedUser() {
        return rejectedUser;
    }

    public RequestLeave rejectedUser(String rejectedUser) {
        this.rejectedUser = rejectedUser;
        return this;
    }

    public void setRejectedUser(String rejectedUser) {
        this.rejectedUser = rejectedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public RequestLeave employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public RequestLeave schedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestLeave)) {
            return false;
        }
        return id != null && id.equals(((RequestLeave) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequestLeave{" +
            "id=" + getId() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", paidDay=" + getPaidDay() +
            ", paidHour='" + getPaidHour() + "'" +
            ", dayOff=" + getDayOff() +
            ", holiday=" + getHoliday() +
            ", military=" + getMilitary() +
            ", travel=" + getTravel() +
            ", description='" + getDescription() + "'" +
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
