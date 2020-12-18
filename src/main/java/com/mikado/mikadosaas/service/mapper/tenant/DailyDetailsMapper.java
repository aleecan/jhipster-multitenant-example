package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.DailyDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DailyDetails} and its DTO {@link DailyDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {DailyMapper.class, CategoryMapper.class})
public interface DailyDetailsMapper extends EntityMapper<DailyDetailsDTO, DailyDetails> {

    @Mapping(source = "daily.id", target = "dailyId")
    @Mapping(source = "category.id", target = "categoryId")
    DailyDetailsDTO toDto(DailyDetails dailyDetails);

    @Mapping(source = "dailyId", target = "daily")
    @Mapping(source = "categoryId", target = "category")
    DailyDetails toEntity(DailyDetailsDTO dailyDetailsDTO);

    default DailyDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        DailyDetails dailyDetails = new DailyDetails();
        dailyDetails.setId(id);
        return dailyDetails;
    }
}
