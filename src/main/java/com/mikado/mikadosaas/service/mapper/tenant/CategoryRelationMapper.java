package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CategoryRelationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CategoryRelation} and its DTO {@link CategoryRelationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategoryRelationMapper extends EntityMapper<CategoryRelationDTO, CategoryRelation> {



    default CategoryRelation fromId(Long id) {
        if (id == null) {
            return null;
        }
        CategoryRelation categoryRelation = new CategoryRelation();
        categoryRelation.setId(id);
        return categoryRelation;
    }
}
