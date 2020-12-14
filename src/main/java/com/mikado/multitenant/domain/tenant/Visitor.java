package com.mikado.multitenant.domain.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A Visitor.
 */
@Entity
@Table(name = "visitor")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 10)
    @Column(name = "code", length = 10)
    private String code;

    @Size(max = 40)
    @Column(name = "full_name", length = 40)
    private String fullName;

    @Size(max = 80)
    @Column(name = "description", length = 80)
    private String description;

    @Column(name = "gender")
    private Boolean gender;

    @Size(max = 40)
    @Column(name = "email", length = 40)
    private String email;

    @Size(max = 15)
    @Column(name = "phone", length = 15)
    private String phone;

    @Size(max = 25)
    @Column(name = "father_name", length = 25)
    private String fatherName;

    @Size(max = 20)
    @Column(name = "birth_place", length = 20)
    private String birthPlace;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "private_permission")
    private Boolean privatePermission;

    @Size(max = 10)
    @Column(name = "location", length = 10)
    private String location;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "visitors", allowSetters = true)
    private VisitorCompany company;

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

    public Visitor code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public Visitor fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public Visitor description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isGender() {
        return gender;
    }

    public Visitor gender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public Visitor email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public Visitor phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Visitor fatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Visitor birthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
        return this;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Visitor birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isPrivatePermission() {
        return privatePermission;
    }

    public Visitor privatePermission(Boolean privatePermission) {
        this.privatePermission = privatePermission;
        return this;
    }

    public void setPrivatePermission(Boolean privatePermission) {
        this.privatePermission = privatePermission;
    }

    public String getLocation() {
        return location;
    }

    public Visitor location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getCreated() {
        return created;
    }

    public Visitor created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public Visitor modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public Visitor modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public VisitorCompany getCompany() {
        return company;
    }

    public Visitor company(VisitorCompany visitorCompany) {
        this.company = visitorCompany;
        return this;
    }

    public void setCompany(VisitorCompany visitorCompany) {
        this.company = visitorCompany;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Visitor)) {
            return false;
        }
        return id != null && id.equals(((Visitor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Visitor{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", description='" + getDescription() + "'" +
            ", gender='" + isGender() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", fatherName='" + getFatherName() + "'" +
            ", birthPlace='" + getBirthPlace() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", privatePermission='" + isPrivatePermission() + "'" +
            ", location='" + getLocation() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
