package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TimezoneRightsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TimezoneRights} and its DTO {@link TimezoneRightsDTO}.
 */
@Mapper(componentModel = "spring", uses = {TimezoneMapper.class, TimezoneDayMapper.class})
public interface TimezoneRightsMapper extends EntityMapper<TimezoneRightsDTO, TimezoneRights> {

    @Mapping(source = "timezone.id", target = "timezoneId")
    @Mapping(source = "timezoneDay.id", target = "timezoneDayId")
    TimezoneRightsDTO toDto(TimezoneRights timezoneRights);

    @Mapping(source = "timezoneId", target = "timezone")
    @Mapping(source = "timezoneDayId", target = "timezoneDay")
    TimezoneRights toEntity(TimezoneRightsDTO timezoneRightsDTO);

    default TimezoneRights fromId(Long id) {
        if (id == null) {
            return null;
        }
        TimezoneRights timezoneRights = new TimezoneRights();
        timezoneRights.setId(id);
        return timezoneRights;
    }
}
