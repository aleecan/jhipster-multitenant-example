package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.NormalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Normal} and its DTO {@link NormalDTO}.
 */
@Mapper(componentModel = "spring", uses = {NormalGroupMapper.class, CategoryMapper.class})
public interface NormalMapper extends EntityMapper<NormalDTO, Normal> {

    @Mapping(source = "normalGroup.id", target = "normalGroupId")
    @Mapping(source = "category.id", target = "categoryId")
    NormalDTO toDto(Normal normal);

    @Mapping(source = "normalGroupId", target = "normalGroup")
    @Mapping(source = "categoryId", target = "category")
    Normal toEntity(NormalDTO normalDTO);

    default Normal fromId(Long id) {
        if (id == null) {
            return null;
        }
        Normal normal = new Normal();
        normal.setId(id);
        return normal;
    }
}
