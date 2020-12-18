package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyWorkDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WeeklyWork} and its DTO {@link WeeklyWorkDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface WeeklyWorkMapper extends EntityMapper<WeeklyWorkDTO, WeeklyWork> {

    @Mapping(source = "normalCategory.id", target = "normalCategoryId")
    @Mapping(source = "overtimeCategory.id", target = "overtimeCategoryId")
    @Mapping(source = "overworkCategory.id", target = "overworkCategoryId")
    @Mapping(source = "overtimeUsedCategory.id", target = "overtimeUsedCategoryId")
    @Mapping(source = "leaveCreditCategory.id", target = "leaveCreditCategoryId")
    @Mapping(source = "leaveNormalCategory.id", target = "leaveNormalCategoryId")
    @Mapping(source = "leaveDebitCategory.id", target = "leaveDebitCategoryId")
    @Mapping(source = "balanceLeftCategory.id", target = "balanceLeftCategoryId")
    @Mapping(source = "balanceOverCategory.id", target = "balanceOverCategoryId")
    WeeklyWorkDTO toDto(WeeklyWork weeklyWork);

    @Mapping(source = "normalCategoryId", target = "normalCategory")
    @Mapping(source = "overtimeCategoryId", target = "overtimeCategory")
    @Mapping(source = "overworkCategoryId", target = "overworkCategory")
    @Mapping(source = "overtimeUsedCategoryId", target = "overtimeUsedCategory")
    @Mapping(source = "leaveCreditCategoryId", target = "leaveCreditCategory")
    @Mapping(source = "leaveNormalCategoryId", target = "leaveNormalCategory")
    @Mapping(source = "leaveDebitCategoryId", target = "leaveDebitCategory")
    @Mapping(source = "balanceLeftCategoryId", target = "balanceLeftCategory")
    @Mapping(source = "balanceOverCategoryId", target = "balanceOverCategory")
    WeeklyWork toEntity(WeeklyWorkDTO weeklyWorkDTO);

    default WeeklyWork fromId(Long id) {
        if (id == null) {
            return null;
        }
        WeeklyWork weeklyWork = new WeeklyWork();
        weeklyWork.setId(id);
        return weeklyWork;
    }
}
