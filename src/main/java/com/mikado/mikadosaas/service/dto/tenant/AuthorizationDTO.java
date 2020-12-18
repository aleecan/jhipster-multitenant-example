package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.Authorization} entity.
 */
public class AuthorizationDTO implements Serializable {

    private Long id;

    @NotNull
    private Long authorizationGroupId;

    private Instant validityStart;

    private Instant validityEnd;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long employeeId;

    private Long visitorBookId;

    private Long cardId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorizationGroupId() {
        return authorizationGroupId;
    }

    public void setAuthorizationGroupId(Long authorizationGroupId) {
        this.authorizationGroupId = authorizationGroupId;
    }

    public Instant getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(Instant validityStart) {
        this.validityStart = validityStart;
    }

    public Instant getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(Instant validityEnd) {
        this.validityEnd = validityEnd;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getVisitorBookId() {
        return visitorBookId;
    }

    public void setVisitorBookId(Long visitorBookId) {
        this.visitorBookId = visitorBookId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthorizationDTO)) {
            return false;
        }

        return id != null && id.equals(((AuthorizationDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthorizationDTO{" +
            "id=" + getId() +
            ", authorizationGroupId=" + getAuthorizationGroupId() +
            ", validityStart='" + getValidityStart() + "'" +
            ", validityEnd='" + getValidityEnd() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            ", employeeId=" + getEmployeeId() +
            ", visitorBookId=" + getVisitorBookId() +
            ", cardId=" + getCardId() +
            "}";
    }
}
