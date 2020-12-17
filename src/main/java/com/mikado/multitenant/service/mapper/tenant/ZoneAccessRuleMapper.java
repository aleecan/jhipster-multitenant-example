package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ZoneAccessRuleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ZoneAccessRule} and its DTO {@link ZoneAccessRuleDTO}.
 */
@Mapper(componentModel = "spring", uses = {ZoneMapper.class, AccessCodeMapper.class, AuthorizationGroupMapper.class, TimezoneMapper.class})
public interface ZoneAccessRuleMapper extends EntityMapper<ZoneAccessRuleDTO, ZoneAccessRule> {

    @Mapping(source = "zone.id", target = "zoneId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "authorizationGroup.id", target = "authorizationGroupId")
    @Mapping(source = "timezone.id", target = "timezoneId")
    ZoneAccessRuleDTO toDto(ZoneAccessRule zoneAccessRule);

    @Mapping(source = "zoneId", target = "zone")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "authorizationGroupId", target = "authorizationGroup")
    @Mapping(source = "timezoneId", target = "timezone")
    ZoneAccessRule toEntity(ZoneAccessRuleDTO zoneAccessRuleDTO);

    default ZoneAccessRule fromId(Long id) {
        if (id == null) {
            return null;
        }
        ZoneAccessRule zoneAccessRule = new ZoneAccessRule();
        zoneAccessRule.setId(id);
        return zoneAccessRule;
    }
}
