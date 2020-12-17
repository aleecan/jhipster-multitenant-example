package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A MonthlyLineDetails.
 */
@Entity
@Table(name = "monthly_line_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonthlyLineDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 1)
    @Column(name = "add_sub", length = 1, nullable = false)
    private String addSub;

    @NotNull
    @Column(name = "source", nullable = false)
    private Integer source;

    @NotNull
    @Column(name = "oninit", nullable = false)
    private Boolean oninit;

    @NotNull
    @Column(name = "onnormal", nullable = false)
    private Boolean onnormal;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyLineDetails", allowSetters = true)
    private MonthlyLine monthlyLine;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "monthlyLineDetails", allowSetters = true)
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

    public MonthlyLineDetails addSub(String addSub) {
        this.addSub = addSub;
        return this;
    }

    public void setAddSub(String addSub) {
        this.addSub = addSub;
    }

    public Integer getSource() {
        return source;
    }

    public MonthlyLineDetails source(Integer source) {
        this.source = source;
        return this;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Boolean isOninit() {
        return oninit;
    }

    public MonthlyLineDetails oninit(Boolean oninit) {
        this.oninit = oninit;
        return this;
    }

    public void setOninit(Boolean oninit) {
        this.oninit = oninit;
    }

    public Boolean isOnnormal() {
        return onnormal;
    }

    public MonthlyLineDetails onnormal(Boolean onnormal) {
        this.onnormal = onnormal;
        return this;
    }

    public void setOnnormal(Boolean onnormal) {
        this.onnormal = onnormal;
    }

    public Instant getCreated() {
        return created;
    }

    public MonthlyLineDetails created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public MonthlyLineDetails modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public MonthlyLineDetails modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public MonthlyLine getMonthlyLine() {
        return monthlyLine;
    }

    public MonthlyLineDetails monthlyLine(MonthlyLine monthlyLine) {
        this.monthlyLine = monthlyLine;
        return this;
    }

    public void setMonthlyLine(MonthlyLine monthlyLine) {
        this.monthlyLine = monthlyLine;
    }

    public Category getCategory() {
        return category;
    }

    public MonthlyLineDetails category(Category category) {
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
        if (!(o instanceof MonthlyLineDetails)) {
            return false;
        }
        return id != null && id.equals(((MonthlyLineDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonthlyLineDetails{" +
            "id=" + getId() +
            ", addSub='" + getAddSub() + "'" +
            ", source=" + getSource() +
            ", oninit='" + isOninit() + "'" +
            ", onnormal='" + isOnnormal() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
