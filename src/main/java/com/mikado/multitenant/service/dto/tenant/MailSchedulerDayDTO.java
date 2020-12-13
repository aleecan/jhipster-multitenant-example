package com.mikado.multitenant.service.dto.tenant;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.MailSchedulerDay} entity.
 */
public class MailSchedulerDayDTO implements Serializable {

    private Long id;

    private Integer mailDay;


    private Long mailSchedulerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMailDay() {
        return mailDay;
    }

    public void setMailDay(Integer mailDay) {
        this.mailDay = mailDay;
    }

    public Long getMailSchedulerId() {
        return mailSchedulerId;
    }

    public void setMailSchedulerId(Long mailSchedulerId) {
        this.mailSchedulerId = mailSchedulerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MailSchedulerDayDTO)) {
            return false;
        }

        return id != null && id.equals(((MailSchedulerDayDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MailSchedulerDayDTO{" +
            "id=" + getId() +
            ", mailDay=" + getMailDay() +
            ", mailSchedulerId=" + getMailSchedulerId() +
            "}";
    }
}
