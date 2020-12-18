package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A WeeklyTask.
 */
@Entity
@Table(name = "weekly_task")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WeeklyTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numday")
    private Double numday;

    @Column(name = "numhour")
    private Double numhour;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyTasks", allowSetters = true)
    private Weekly weekly;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyTasks", allowSetters = true)
    private Task task;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "weeklyTasks", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumday() {
        return numday;
    }

    public WeeklyTask numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public WeeklyTask numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Weekly getWeekly() {
        return weekly;
    }

    public WeeklyTask weekly(Weekly weekly) {
        this.weekly = weekly;
        return this;
    }

    public void setWeekly(Weekly weekly) {
        this.weekly = weekly;
    }

    public Task getTask() {
        return task;
    }

    public WeeklyTask task(Task task) {
        this.task = task;
        return this;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Category getCategory() {
        return category;
    }

    public WeeklyTask category(Category category) {
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
        if (!(o instanceof WeeklyTask)) {
            return false;
        }
        return id != null && id.equals(((WeeklyTask) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyTask{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
