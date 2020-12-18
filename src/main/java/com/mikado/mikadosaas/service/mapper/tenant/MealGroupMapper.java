package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.MealGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MealGroup} and its DTO {@link MealGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MealGroupMapper extends EntityMapper<MealGroupDTO, MealGroup> {



    default MealGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        MealGroup mealGroup = new MealGroup();
        mealGroup.setId(id);
        return mealGroup;
    }
}
