package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A EntryExitAdditional.
 */
@Entity
@Table(name = "entry_exit_additional")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EntryExitAdditional implements Serializable {

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
    @Column(name = "add_time", length = 8, nullable = false)
    private String addTime;

    @Column(name = "add_day")
    private Boolean addDay;

    @Column(name = "add_na_hour")
    private Boolean addNaHour;

    @Column(name = "adding_status")
    private Integer addingStatus;

    @NotNull
    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "manual")
    private Boolean manual;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExitAdditionals", allowSetters = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "entryExitAdditionals", allowSetters = true)
    private Category category;

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

    public EntryExitAdditional daydate(LocalDate daydate) {
        this.daydate = daydate;
        return this;
    }

    public void setDaydate(LocalDate daydate) {
        this.daydate = daydate;
    }

    public String getAddTime() {
        return addTime;
    }

    public EntryExitAdditional addTime(String addTime) {
        this.addTime = addTime;
        return this;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean isAddDay() {
        return addDay;
    }

    public EntryExitAdditional addDay(Boolean addDay) {
        this.addDay = addDay;
        return this;
    }

    public void setAddDay(Boolean addDay) {
        this.addDay = addDay;
    }

    public Boolean isAddNaHour() {
        return addNaHour;
    }

    public EntryExitAdditional addNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
        return this;
    }

    public void setAddNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
    }

    public Integer getAddingStatus() {
        return addingStatus;
    }

    public EntryExitAdditional addingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
        return this;
    }

    public void setAddingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public EntryExitAdditional taskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Boolean isManual() {
        return manual;
    }

    public EntryExitAdditional manual(Boolean manual) {
        this.manual = manual;
        return this;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public Instant getCreated() {
        return created;
    }

    public EntryExitAdditional created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public EntryExitAdditional modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public EntryExitAdditional modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EntryExitAdditional employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Category getCategory() {
        return category;
    }

    public EntryExitAdditional category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryExitAdditional)) {
            return false;
        }
        return id != null && id.equals(((EntryExitAdditional) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntryExitAdditional{" +
            "id=" + getId() +
            ", daydate='" + getDaydate() + "'" +
            ", addTime='" + getAddTime() + "'" +
            ", addDay='" + isAddDay() + "'" +
            ", addNaHour='" + isAddNaHour() + "'" +
            ", addingStatus=" + getAddingStatus() +
            ", taskId=" + getTaskId() +
            ", manual='" + isManual() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
