package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.WeeklyDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WeeklyDetails} and its DTO {@link WeeklyDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {WeeklyMapper.class, CategoryMapper.class})
public interface WeeklyDetailsMapper extends EntityMapper<WeeklyDetailsDTO, WeeklyDetails> {

    @Mapping(source = "weekly.id", target = "weeklyId")
    @Mapping(source = "category.id", target = "categoryId")
    WeeklyDetailsDTO toDto(WeeklyDetails weeklyDetails);

    @Mapping(source = "weeklyId", target = "weekly")
    @Mapping(source = "categoryId", target = "category")
    WeeklyDetails toEntity(WeeklyDetailsDTO weeklyDetailsDTO);

    default WeeklyDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        WeeklyDetails weeklyDetails = new WeeklyDetails();
        weeklyDetails.setId(id);
        return weeklyDetails;
    }
}
