package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Visitor} entity.
 */
public class VisitorDTO implements Serializable {

    private Long id;

    @Size(max = 10)
    private String code;

    @Size(max = 40)
    private String fullName;

    @Size(max = 80)
    private String description;

    private Boolean gender;

    @Size(max = 40)
    private String email;

    @Size(max = 15)
    private String phone;

    @Size(max = 25)
    private String fatherName;

    @Size(max = 20)
    private String birthPlace;

    private LocalDate birthDate;

    private Boolean privatePermission;

    @Size(max = 10)
    private String location;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isPrivatePermission() {
        return privatePermission;
    }

    public void setPrivatePermission(Boolean privatePermission) {
        this.privatePermission = privatePermission;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long visitorCompanyId) {
        this.companyId = visitorCompanyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisitorDTO)) {
            return false;
        }

        return id != null && id.equals(((VisitorDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VisitorDTO{" +
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
            ", companyId=" + getCompanyId() +
            "}";
    }
}
