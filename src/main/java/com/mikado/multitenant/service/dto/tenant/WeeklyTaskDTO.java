package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.WeeklyTask} entity.
 */
public class WeeklyTaskDTO implements Serializable {

    private Long id;

    private Double numday;

    private Double numhour;


    private Long weeklyId;

    private Long taskId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumday() {
        return numday;
    }

    public void setNumday(Double numday) {
        this.numday = numday;
    }

    public Double getNumhour() {
        return numhour;
    }

    public void setNumhour(Double numhour) {
        this.numhour = numhour;
    }

    public Long getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Long weeklyId) {
        this.weeklyId = weeklyId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeeklyTaskDTO)) {
            return false;
        }

        return id != null && id.equals(((WeeklyTaskDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WeeklyTaskDTO{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            ", weeklyId=" + getWeeklyId() +
            ", taskId=" + getTaskId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
