package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyPreviousDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyPreviousDetails} and its DTO {@link MonthlyPreviousDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyPreviousMapper.class, MonthlyLineMapper.class})
public interface MonthlyPreviousDetailsMapper extends EntityMapper<MonthlyPreviousDetailsDTO, MonthlyPreviousDetails> {

    @Mapping(source = "monthlyPrevious.id", target = "monthlyPreviousId")
    @Mapping(source = "monthlyLine.id", target = "monthlyLineId")
    MonthlyPreviousDetailsDTO toDto(MonthlyPreviousDetails monthlyPreviousDetails);

    @Mapping(source = "monthlyPreviousId", target = "monthlyPrevious")
    @Mapping(source = "monthlyLineId", target = "monthlyLine")
    MonthlyPreviousDetails toEntity(MonthlyPreviousDetailsDTO monthlyPreviousDetailsDTO);

    default MonthlyPreviousDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyPreviousDetails monthlyPreviousDetails = new MonthlyPreviousDetails();
        monthlyPreviousDetails.setId(id);
        return monthlyPreviousDetails;
    }
}
