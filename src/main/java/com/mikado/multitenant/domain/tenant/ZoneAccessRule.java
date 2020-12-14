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
 * A ZoneAccessRule.
 */
@Entity
@Table(name = "zone_access_rule")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ZoneAccessRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @NotNull
    @Column(name = "access_type", nullable = false)
    private Integer accessType;

    @Column(name = "use_timezone_calendar")
    private Boolean useTimezoneCalendar;

    @NotNull
    @Column(name = "access_result", nullable = false)
    private Boolean accessResult;

    @Column(name = "access_count")
    private Integer accessCount;

    @Column(name = "access_total_count")
    private Integer accessTotalCount;

    @Column(name = "counter_day")
    private Integer counterDay;

    @Column(name = "counter_week")
    private Integer counterWeek;

    @Column(name = "counter_month")
    private Integer counterMonth;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    @Column(name = "counter_reset_time", length = 8)
    private String counterResetTime;

    @Size(max = 32)
    @Column(name = "message_no", length = 32)
    private String messageNo;

    @Size(max = 32)
    @Column(name = "message_yes", length = 32)
    private String messageYes;

    @Column(name = "created")
    private Instant created;

    @Column(name = "modified")
    private Instant modified;

    @Size(max = 80)
    @Column(name = "modified_user", length = 80)
    private String modifiedUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneAccessRules", allowSetters = true)
    private Zone zone;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneAccessRules", allowSetters = true)
    private AccessCode accessCode;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "zoneAccessRules", allowSetters = true)
    private AuthorizationGroup authorizationGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "zoneAccessRules", allowSetters = true)
    private Timezone timezone;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public ZoneAccessRule description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public ZoneAccessRule accessType(Integer accessType) {
        this.accessType = accessType;
        return this;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Boolean isUseTimezoneCalendar() {
        return useTimezoneCalendar;
    }

    public ZoneAccessRule useTimezoneCalendar(Boolean useTimezoneCalendar) {
        this.useTimezoneCalendar = useTimezoneCalendar;
        return this;
    }

    public void setUseTimezoneCalendar(Boolean useTimezoneCalendar) {
        this.useTimezoneCalendar = useTimezoneCalendar;
    }

    public Boolean isAccessResult() {
        return accessResult;
    }

    public ZoneAccessRule accessResult(Boolean accessResult) {
        this.accessResult = accessResult;
        return this;
    }

    public void setAccessResult(Boolean accessResult) {
        this.accessResult = accessResult;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public ZoneAccessRule accessCount(Integer accessCount) {
        this.accessCount = accessCount;
        return this;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Integer getAccessTotalCount() {
        return accessTotalCount;
    }

    public ZoneAccessRule accessTotalCount(Integer accessTotalCount) {
        this.accessTotalCount = accessTotalCount;
        return this;
    }

    public void setAccessTotalCount(Integer accessTotalCount) {
        this.accessTotalCount = accessTotalCount;
    }

    public Integer getCounterDay() {
        return counterDay;
    }

    public ZoneAccessRule counterDay(Integer counterDay) {
        this.counterDay = counterDay;
        return this;
    }

    public void setCounterDay(Integer counterDay) {
        this.counterDay = counterDay;
    }

    public Integer getCounterWeek() {
        return counterWeek;
    }

    public ZoneAccessRule counterWeek(Integer counterWeek) {
        this.counterWeek = counterWeek;
        return this;
    }

    public void setCounterWeek(Integer counterWeek) {
        this.counterWeek = counterWeek;
    }

    public Integer getCounterMonth() {
        return counterMonth;
    }

    public ZoneAccessRule counterMonth(Integer counterMonth) {
        this.counterMonth = counterMonth;
        return this;
    }

    public void setCounterMonth(Integer counterMonth) {
        this.counterMonth = counterMonth;
    }

    public String getCounterResetTime() {
        return counterResetTime;
    }

    public ZoneAccessRule counterResetTime(String counterResetTime) {
        this.counterResetTime = counterResetTime;
        return this;
    }

    public void setCounterResetTime(String counterResetTime) {
        this.counterResetTime = counterResetTime;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public ZoneAccessRule messageNo(String messageNo) {
        this.messageNo = messageNo;
        return this;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getMessageYes() {
        return messageYes;
    }

    public ZoneAccessRule messageYes(String messageYes) {
        this.messageYes = messageYes;
        return this;
    }

    public void setMessageYes(String messageYes) {
        this.messageYes = messageYes;
    }

    public Instant getCreated() {
        return created;
    }

    public ZoneAccessRule created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public ZoneAccessRule modified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public ZoneAccessRule modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Zone getZone() {
        return zone;
    }

    public ZoneAccessRule zone(Zone zone) {
        this.zone = zone;
        return this;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public ZoneAccessRule accessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
        return this;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public AuthorizationGroup getAuthorizationGroup() {
        return authorizationGroup;
    }

    public ZoneAccessRule authorizationGroup(AuthorizationGroup authorizationGroup) {
        this.authorizationGroup = authorizationGroup;
        return this;
    }

    public void setAuthorizationGroup(AuthorizationGroup authorizationGroup) {
        this.authorizationGroup = authorizationGroup;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public ZoneAccessRule timezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneAccessRule)) {
            return false;
        }
        return id != null && id.equals(((ZoneAccessRule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneAccessRule{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", accessType=" + getAccessType() +
            ", useTimezoneCalendar='" + isUseTimezoneCalendar() + "'" +
            ", accessResult='" + isAccessResult() + "'" +
            ", accessCount=" + getAccessCount() +
            ", accessTotalCount=" + getAccessTotalCount() +
            ", counterDay=" + getCounterDay() +
            ", counterWeek=" + getCounterWeek() +
            ", counterMonth=" + getCounterMonth() +
            ", counterResetTime='" + getCounterResetTime() + "'" +
            ", messageNo='" + getMessageNo() + "'" +
            ", messageYes='" + getMessageYes() + "'" +
            ", created='" + getCreated() + "'" +
            ", modified='" + getModified() + "'" +
            ", modifiedUser='" + getModifiedUser() + "'" +
            "}";
    }
}
