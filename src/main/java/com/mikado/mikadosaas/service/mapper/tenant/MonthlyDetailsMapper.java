package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyDetails} and its DTO {@link MonthlyDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyMapper.class, MonthlyLineMapper.class})
public interface MonthlyDetailsMapper extends EntityMapper<MonthlyDetailsDTO, MonthlyDetails> {

    @Mapping(source = "monthly.id", target = "monthlyId")
    @Mapping(source = "monthlyLine.id", target = "monthlyLineId")
    MonthlyDetailsDTO toDto(MonthlyDetails monthlyDetails);

    @Mapping(source = "monthlyId", target = "monthly")
    @Mapping(source = "monthlyLineId", target = "monthlyLine")
    MonthlyDetails toEntity(MonthlyDetailsDTO monthlyDetailsDTO);

    default MonthlyDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyDetails monthlyDetails = new MonthlyDetails();
        monthlyDetails.setId(id);
        return monthlyDetails;
    }
}
