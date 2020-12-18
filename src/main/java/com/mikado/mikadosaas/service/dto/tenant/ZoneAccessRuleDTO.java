package com.mikado.mikadosaas.service.dto.tenant;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.ZoneAccessRule} entity.
 */
public class ZoneAccessRuleDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    private Integer accessType;

    private Boolean useTimezoneCalendar;

    @NotNull
    private Boolean accessResult;

    private Integer accessCount;

    private Integer accessTotalCount;

    private Integer counterDay;

    private Integer counterWeek;

    private Integer counterMonth;

    @Size(min = 8, max = 8)
    @Pattern(regexp = "^(([0-1]\\d)|(2[0-3])):([0-5]\\d):([0-5]\\d)$")
    private String counterResetTime;

    @Size(max = 32)
    private String messageNo;

    @Size(max = 32)
    private String messageYes;

    private Instant created;

    private Instant modified;

    @Size(max = 80)
    private String modifiedUser;


    private Long zoneId;

    private Long accessCodeId;

    private Long authorizationGroupId;

    private Long timezoneId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Boolean isUseTimezoneCalendar() {
        return useTimezoneCalendar;
    }

    public void setUseTimezoneCalendar(Boolean useTimezoneCalendar) {
        this.useTimezoneCalendar = useTimezoneCalendar;
    }

    public Boolean isAccessResult() {
        return accessResult;
    }

    public void setAccessResult(Boolean accessResult) {
        this.accessResult = accessResult;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Integer getAccessTotalCount() {
        return accessTotalCount;
    }

    public void setAccessTotalCount(Integer accessTotalCount) {
        this.accessTotalCount = accessTotalCount;
    }

    public Integer getCounterDay() {
        return counterDay;
    }

    public void setCounterDay(Integer counterDay) {
        this.counterDay = counterDay;
    }

    public Integer getCounterWeek() {
        return counterWeek;
    }

    public void setCounterWeek(Integer counterWeek) {
        this.counterWeek = counterWeek;
    }

    public Integer getCounterMonth() {
        return counterMonth;
    }

    public void setCounterMonth(Integer counterMonth) {
        this.counterMonth = counterMonth;
    }

    public String getCounterResetTime() {
        return counterResetTime;
    }

    public void setCounterResetTime(String counterResetTime) {
        this.counterResetTime = counterResetTime;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getMessageYes() {
        return messageYes;
    }

    public void setMessageYes(String messageYes) {
        this.messageYes = messageYes;
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

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getAccessCodeId() {
        return accessCodeId;
    }

    public void setAccessCodeId(Long accessCodeId) {
        this.accessCodeId = accessCodeId;
    }

    public Long getAuthorizationGroupId() {
        return authorizationGroupId;
    }

    public void setAuthorizationGroupId(Long authorizationGroupId) {
        this.authorizationGroupId = authorizationGroupId;
    }

    public Long getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Long timezoneId) {
        this.timezoneId = timezoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneAccessRuleDTO)) {
            return false;
        }

        return id != null && id.equals(((ZoneAccessRuleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneAccessRuleDTO{" +
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
            ", zoneId=" + getZoneId() +
            ", accessCodeId=" + getAccessCodeId() +
            ", authorizationGroupId=" + getAuthorizationGroupId() +
            ", timezoneId=" + getTimezoneId() +
            "}";
    }
}
