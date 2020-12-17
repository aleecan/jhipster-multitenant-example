package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.QuotaTypeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link QuotaType} and its DTO {@link QuotaTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface QuotaTypeMapper extends EntityMapper<QuotaTypeDTO, QuotaType> {

    @Mapping(source = "transferCategory.id", target = "transferCategoryId")
    QuotaTypeDTO toDto(QuotaType quotaType);

    @Mapping(source = "transferCategoryId", target = "transferCategory")
    QuotaType toEntity(QuotaTypeDTO quotaTypeDTO);

    default QuotaType fromId(Long id) {
        if (id == null) {
            return null;
        }
        QuotaType quotaType = new QuotaType();
        quotaType.setId(id);
        return quotaType;
    }
}
