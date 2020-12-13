package com.mikado.multitenant.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.multitenant.domain.UserForgetPasswordToken} entity.
 */
public class UserForgetPasswordTokenDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String token;

    @Size(max = 255)
    private String status;

    @NotNull
    private Instant createdOn;


    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userUserId) {
        this.userId = userUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserForgetPasswordTokenDTO)) {
            return false;
        }

        return id != null && id.equals(((UserForgetPasswordTokenDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserForgetPasswordTokenDTO{" +
            "id=" + getId() +
            ", token='" + getToken() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", userId=" + getUserId() +
            "}";
    }
}
