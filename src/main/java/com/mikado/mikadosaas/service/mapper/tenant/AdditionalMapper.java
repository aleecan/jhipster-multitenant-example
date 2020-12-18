package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AdditionalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Additional} and its DTO {@link AdditionalDTO}.
 */
@Mapper(componentModel = "spring", uses = {AdditionalGroupMapper.class, CategoryMapper.class})
public interface AdditionalMapper extends EntityMapper<AdditionalDTO, Additional> {

    @Mapping(source = "additionalGroup.id", target = "additionalGroupId")
    @Mapping(source = "category.id", target = "categoryId")
    AdditionalDTO toDto(Additional additional);

    @Mapping(source = "additionalGroupId", target = "additionalGroup")
    @Mapping(source = "categoryId", target = "category")
    Additional toEntity(AdditionalDTO additionalDTO);

    default Additional fromId(Long id) {
        if (id == null) {
            return null;
        }
        Additional additional = new Additional();
        additional.setId(id);
        return additional;
    }
}
