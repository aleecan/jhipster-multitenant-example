package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.MonthlyTask} entity.
 */
public class MonthlyTaskDTO implements Serializable {

    private Long id;

    private Double numday;

    private Double numhour;


    private Long monthlyId;

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

    public Long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Long monthlyId) {
        this.monthlyId = monthlyId;
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
        if (!(o instanceof MonthlyTaskDTO)) {
            return false;
        }

        return id != null && id.equals(((MonthlyTaskDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyTaskDTO{" +
            "id=" + getId() +
            ", numday=" + getNumday() +
            ", numhour=" + getNumhour() +
            ", monthlyId=" + getMonthlyId() +
            ", taskId=" + getTaskId() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
