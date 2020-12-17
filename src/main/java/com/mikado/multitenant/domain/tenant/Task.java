package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Task.
 */
@Entity
@Table(name = "task")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Size(max = 15)
    @Column(name = "color", length = 15)
    private String color;

    @Size(max = 80)
    @Column(name = "excuse_code", length = 80)
    private String excuseCode;

    @Size(max = 80)
    @Column(name = "terminal", length = 80)
    private String terminal;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Task code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public Task description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public Task color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExcuseCode() {
        return excuseCode;
    }

    public Task excuseCode(String excuseCode) {
        this.excuseCode = excuseCode;
        return this;
    }

    public void setExcuseCode(String excuseCode) {
        this.excuseCode = excuseCode;
    }

    public String getTerminal() {
        return terminal;
    }

    public Task terminal(String terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Instant getCreated() {
        return created;
    }

    public Task created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Task modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Task modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        return id != null && id.equals(((Task) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", color='" + getColor() + "'" +
            ", excuseCode='" + getExcuseCode() + "'" +
            ", terminal='" + getTerminal() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
