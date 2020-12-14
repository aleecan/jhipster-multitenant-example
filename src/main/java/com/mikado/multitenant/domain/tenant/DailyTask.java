package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DailyTask.
 */
@Entity
@Table(name = "daily_task")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DailyTask implements Serializable {

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
    @JsonIgnoreProperties(value = "dailyTasks", allowSetters = true)
    private Daily daily;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "dailyTasks", allowSetters = true)
    private Task task;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "dailyTasks", allowSetters = true)
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

    public DailyTask numday(Double numday) {
        this.numday = numday;
        return this;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public DailyTask numhour(Double numhour) {
        this.numhour = numhour;
        return this;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Daily getDaily() {
        return daily;
    }

    public DailyTask daily(Daily daily) {
        this.daily = daily;
        return this;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Task getTask() {
        return task;
    }

    public DailyTask task(Task task) {
        this.task = task;
        return this;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Category getCategory() {
        return category;
    }

    public DailyTask category(Category category) {
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
        if (!(o instanceof DailyTask)) {
            return false;
        }
        return id != null && id.equals(((DailyTask) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DailyTask{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            "}";
    }
}
