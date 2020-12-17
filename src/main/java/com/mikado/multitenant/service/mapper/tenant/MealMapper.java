package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MealDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Meal} and its DTO {@link MealDTO}.
 */
@Mapper(componentModel = "spring", uses = {MealGroupMapper.class, CategoryMapper.class})
public interface MealMapper extends EntityMapper<MealDTO, Meal> {

    @Mapping(source = "mealGroup.id", target = "mealGroupId")
    @Mapping(source = "category.id", target = "categoryId")
    MealDTO toDto(Meal meal);

    @Mapping(source = "mealGroupId", target = "mealGroup")
    @Mapping(source = "categoryId", target = "category")
    Meal toEntity(MealDTO mealDTO);

    default Meal fromId(Long id) {
        if (id == null) {
            return null;
        }
        Meal meal = new Meal();
        meal.setId(id);
        return meal;
    }
}
