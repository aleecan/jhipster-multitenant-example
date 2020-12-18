package com.mikado.mikadosaas.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A UserForgetPasswordToken.
 */
@Entity
@Table(name = "user_forget_password_token")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserForgetPasswordToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "token", length = 255, nullable = false)
    private String token;

    @Size(max = 255)
    @Column(name = "status", length = 255)
    private String status;

    @NotNull
    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private UserUser user;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public UserForgetPasswordToken token(String token) {
        this.token = token;
        return this;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public UserForgetPasswordToken status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public UserForgetPasswordToken createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public UserUser getUser() {
        return user;
    }

    public UserForgetPasswordToken user(UserUser userUser) {
        this.user = userUser;
        return this;
    }

    public void setUser(UserUser userUser) {
        this.user = userUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserForgetPasswordToken)) {
            return false;
        }
        return id != null && id.equals(((UserForgetPasswordToken) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserForgetPasswordToken{" +
            "id=" + getId() +
            ", token='" + getToken() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            "}";
    }
}
