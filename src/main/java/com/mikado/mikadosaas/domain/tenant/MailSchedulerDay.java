package com.mikado.mikadosaas.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A MailSchedulerDay.
 */
@Entity
@Table(name = "mail_scheduler_day")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MailSchedulerDay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mail_day")
    private Integer mailDay;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "mailSchedulerDays", allowSetters = true)
    private MailScheduler mailScheduler;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMailDay() {
        return mailDay;
    }

    public MailSchedulerDay mailDay(Integer mailDay) {
        this.mailDay = mailDay;
        return this;
    }

    public void setMailDay(Integer mailDay) {
        this.mailDay = mailDay;
    }

    public MailScheduler getMailScheduler() {
        return mailScheduler;
    }

    public MailSchedulerDay mailScheduler(MailScheduler mailScheduler) {
        this.mailScheduler = mailScheduler;
        return this;
    }

    public void setMailScheduler(MailScheduler mailScheduler) {
        this.mailScheduler = mailScheduler;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MailSchedulerDay)) {
            return false;
        }
        return id != null && id.equals(((MailSchedulerDay) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MailSchedulerDay{" +
            "id=" + getId() +
            ", mailDay=" + getMailDay() +
            "}";
    }
}
