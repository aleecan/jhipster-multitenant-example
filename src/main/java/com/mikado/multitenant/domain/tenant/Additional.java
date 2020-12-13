package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Additional.
 */
@Entity
@Table(name = "additional")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Additional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "additionals", allowSetters = true)
    private AdditionalGroup additionalGroup;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "additionals", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public Additional addTime(String addTime) {
        this.addTime = addTime;
        return this;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean isAddDay() {
        return addDay;
    }

    public Additional addDay(Boolean addDay) {
        this.addDay = addDay;
        return this;
    }

    public void setAddDay(Boolean addDay) {
        this.addDay = addDay;
    }

    public Boolean isAddNaHour() {
        return addNaHour;
    }

    public Additional addNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
        return this;
    }

    public void setAddNaHour(Boolean addNaHour) {
        this.addNaHour = addNaHour;
    }

    public Integer getAddingStatus() {
        return addingStatus;
    }

    public Additional addingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
        return this;
    }

    public void setAddingStatus(Integer addingStatus) {
        this.addingStatus = addingStatus;
    }

    public Instant getCreated() {
        return created;
    }

    public Additional created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Additional modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Additional modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public AdditionalGroup getAdditionalGroup() {
        return additionalGroup;
    }

    public Additional additionalGroup(AdditionalGroup additionalGroup) {
        this.additionalGroup = additionalGroup;
        return this;
    }

    public void setAdditionalGroup(AdditionalGroup additionalGroup) {
        this.additionalGroup = additionalGroup;
    }

    public Category getCategory() {
        return category;
    }

    public Additional category(Category category) {
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
        if (!(o instanceof Additional)) {
            return false;
        }
        return id != null && id.equals(((Additional) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Additional{" +
            "id=" + getId() +
            ", addTime='" + getAddTime() + "'" +
            ", addDay='" + isAddDay() + "'" +
            ", addNaHour='" + isAddNaHour() + "'" +
            ", addingStatus=" + getAddingStatus() +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
