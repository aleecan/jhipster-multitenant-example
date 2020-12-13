package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.WeeklyBalanceDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WeeklyBalanceDetails} and its DTO {@link WeeklyBalanceDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {WeeklyBalanceMapper.class, CategoryMapper.class})
public interface WeeklyBalanceDetailsMapper extends EntityMapper<WeeklyBalanceDetailsDTO, WeeklyBalanceDetails> {

    @Mapping(source = "weeklyBalance.id", target = "weeklyBalanceId")
    @Mapping(source = "category.id", target = "categoryId")
    WeeklyBalanceDetailsDTO toDto(WeeklyBalanceDetails weeklyBalanceDetails);

    @Mapping(source = "weeklyBalanceId", target = "weeklyBalance")
    @Mapping(source = "categoryId", target = "category")
    WeeklyBalanceDetails toEntity(WeeklyBalanceDetailsDTO weeklyBalanceDetailsDTO);

    default WeeklyBalanceDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        WeeklyBalanceDetails weeklyBalanceDetails = new WeeklyBalanceDetails();
        weeklyBalanceDetails.setId(id);
        return weeklyBalanceDetails;
    }
}
