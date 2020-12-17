package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveGroupDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeaveGroupDetails} and its DTO {@link AnnualLeaveGroupDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {AnnualLeaveGroupMapper.class})
public interface AnnualLeaveGroupDetailsMapper extends EntityMapper<AnnualLeaveGroupDetailsDTO, AnnualLeaveGroupDetails> {

    @Mapping(source = "annualLeaveGroup.id", target = "annualLeaveGroupId")
    AnnualLeaveGroupDetailsDTO toDto(AnnualLeaveGroupDetails annualLeaveGroupDetails);

    @Mapping(source = "annualLeaveGroupId", target = "annualLeaveGroup")
    AnnualLeaveGroupDetails toEntity(AnnualLeaveGroupDetailsDTO annualLeaveGroupDetailsDTO);

    default AnnualLeaveGroupDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeaveGroupDetails annualLeaveGroupDetails = new AnnualLeaveGroupDetails();
        annualLeaveGroupDetails.setId(id);
        return annualLeaveGroupDetails;
    }
}
