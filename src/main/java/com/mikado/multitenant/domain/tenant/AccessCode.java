package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A AccessCode.
 */
@Entity
@Table(name = "access_code")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private Integer code;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "timekeeping")
    private Boolean timekeeping;

    @Size(max = 10)
    @Column(name = "reason_code", length = 10)
    private String reasonCode;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "first_time", length = 8)
    private String firstTime;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "last_time", length = 8)
    private String lastTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public AccessCode code(Integer code) {
        this.code = code;
        return this;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public AccessCode description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isTimekeeping() {
        return timekeeping;
    }

    public AccessCode timekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
        return this;
    }

    public void setTimekeeping(Boolean timekeeping) {
        this.timekeeping = timekeeping;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public AccessCode reasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
        return this;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public AccessCode firstTime(String firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public AccessCode lastTime(String lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessCode)) {
            return false;
        }
        return id != null && id.equals(((AccessCode) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccessCode{" +
            "id=" + getId() +
            ", code=" + getCode() +
            ", description='" + getDescription() + "'" +
            ", timekeeping='" + isTimekeeping() + "'" +
            ", reasonCode='" + getReasonCode() + "'" +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            "}";
    }
}
