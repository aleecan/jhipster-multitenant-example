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

/**
 * A Tolerance.
 */
@Entity
@Table(name = "tolerance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tolerance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direction")
    private Boolean direction;

    @Column(name = "entry_exit")
    private Integer entryExit;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "first_time", length = 8, nullable = false)
    private String firstTime;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "last_time", length = 8, nullable = false)
    private String lastTime;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "new_time", length = 8, nullable = false)
    private String newTime;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "tolerances", allowSetters = true)
    private ToleranceGroup toleranceGroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isDirection() {
        return direction;
    }

    public Tolerance direction(Boolean direction) {
        this.direction = direction;
        return this;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

    public Integer getEntryExit() {
        return entryExit;
    }

    public Tolerance entryExit(Integer entryExit) {
        this.entryExit = entryExit;
        return this;
    }

    public void setEntryExit(Integer entryExit) {
        this.entryExit = entryExit;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public Tolerance firstTime(String firstTime) {
        this.firstTime = firstTime;
        return this;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public Tolerance lastTime(String lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getNewTime() {
        return newTime;
    }

    public Tolerance newTime(String newTime) {
        this.newTime = newTime;
        return this;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public Instant getCreated() {
        return created;
    }

    public Tolerance created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Tolerance modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Tolerance modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public ToleranceGroup getToleranceGroup() {
        return toleranceGroup;
    }

    public Tolerance toleranceGroup(ToleranceGroup toleranceGroup) {
        this.toleranceGroup = toleranceGroup;
        return this;
    }

    public void setToleranceGroup(ToleranceGroup toleranceGroup) {
        this.toleranceGroup = toleranceGroup;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tolerance)) {
            return false;
        }
        return id != null && id.equals(((Tolerance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Tolerance{" +
            "id=" + getId() +
            ", direction='" + isDirection() + "'" +
            ", entryExit=" + getEntryExit() +
            ", firstTime='" + getFirstTime() + "'" +
            ", lastTime='" + getLastTime() + "'" +
            ", newTime='" + getNewTime() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
