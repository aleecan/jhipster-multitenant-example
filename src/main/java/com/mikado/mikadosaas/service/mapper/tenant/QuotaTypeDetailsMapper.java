package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.QuotaTypeDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link QuotaTypeDetails} and its DTO {@link QuotaTypeDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuotaTypeMapper.class, CategoryMapper.class})
public interface QuotaTypeDetailsMapper extends EntityMapper<QuotaTypeDetailsDTO, QuotaTypeDetails> {

    @Mapping(source = "quota.id", target = "quotaId")
    @Mapping(source = "category.id", target = "categoryId")
    QuotaTypeDetailsDTO toDto(QuotaTypeDetails quotaTypeDetails);

    @Mapping(source = "quotaId", target = "quota")
    @Mapping(source = "categoryId", target = "category")
    QuotaTypeDetails toEntity(QuotaTypeDetailsDTO quotaTypeDetailsDTO);

    default QuotaTypeDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        QuotaTypeDetails quotaTypeDetails = new QuotaTypeDetails();
        quotaTypeDetails.setId(id);
        return quotaTypeDetails;
    }
}
