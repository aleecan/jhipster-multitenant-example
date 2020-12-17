package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A QuotaTypeDetails.
 */
@Entity
@Table(name = "quota_type_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QuotaTypeDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 1)
    @Column(name = "add_sub", length = 1, nullable = false)
    private String addSub;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaTypeDetails", allowSetters = true)
    private QuotaType quota;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "quotaTypeDetails", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddSub() {
        return addSub;
    }

    public QuotaTypeDetails addSub(String addSub) {
        this.addSub = addSub;
        return this;
    }

    public void setAddSub(String addSub) {
        this.addSub = addSub;
    }

    public QuotaType getQuota() {
        return quota;
    }

    public QuotaTypeDetails quota(QuotaType quotaType) {
        this.quota = quotaType;
        return this;
    }

    public void setQuota(QuotaType quotaType) {
        this.quota = quotaType;
    }

    public Category getCategory() {
        return category;
    }

    public QuotaTypeDetails category(Category category) {
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
        if (!(o instanceof QuotaTypeDetails)) {
            return false;
        }
        return id != null && id.equals(((QuotaTypeDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuotaTypeDetails{" +
            "id=" + getId() +
            ", addSub='" + getAddSub() + "'" +
            "}";
    }
}
