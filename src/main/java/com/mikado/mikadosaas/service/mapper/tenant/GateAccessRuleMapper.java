package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.GateAccessRuleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link GateAccessRule} and its DTO {@link GateAccessRuleDTO}.
 */
@Mapper(componentModel = "spring", uses = {GateMapper.class, AccessCodeMapper.class, AuthorizationGroupMapper.class, TimezoneMapper.class})
public interface GateAccessRuleMapper extends EntityMapper<GateAccessRuleDTO, GateAccessRule> {

    @Mapping(source = "gate.id", target = "gateId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "authorizationGroup.id", target = "authorizationGroupId")
    @Mapping(source = "timezone.id", target = "timezoneId")
    GateAccessRuleDTO toDto(GateAccessRule gateAccessRule);

    @Mapping(source = "gateId", target = "gate")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "authorizationGroupId", target = "authorizationGroup")
    @Mapping(source = "timezoneId", target = "timezone")
    GateAccessRule toEntity(GateAccessRuleDTO gateAccessRuleDTO);

    default GateAccessRule fromId(Long id) {
        if (id == null) {
            return null;
        }
        GateAccessRule gateAccessRule = new GateAccessRule();
        gateAccessRule.setId(id);
        return gateAccessRule;
    }
}
