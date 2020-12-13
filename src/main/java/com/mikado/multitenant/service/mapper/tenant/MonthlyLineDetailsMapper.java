package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MonthlyLineDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyLineDetails} and its DTO {@link MonthlyLineDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyLineMapper.class, CategoryMapper.class})
public interface MonthlyLineDetailsMapper extends EntityMapper<MonthlyLineDetailsDTO, MonthlyLineDetails> {

    @Mapping(source = "monthlyLine.id", target = "monthlyLineId")
    @Mapping(source = "category.id", target = "categoryId")
    MonthlyLineDetailsDTO toDto(MonthlyLineDetails monthlyLineDetails);

    @Mapping(source = "monthlyLineId", target = "monthlyLine")
    @Mapping(source = "categoryId", target = "category")
    MonthlyLineDetails toEntity(MonthlyLineDetailsDTO monthlyLineDetailsDTO);

    default MonthlyLineDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyLineDetails monthlyLineDetails = new MonthlyLineDetails();
        monthlyLineDetails.setId(id);
        return monthlyLineDetails;
    }
}
