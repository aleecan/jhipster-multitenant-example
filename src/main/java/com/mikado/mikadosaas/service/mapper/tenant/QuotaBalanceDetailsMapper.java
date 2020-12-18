package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.QuotaBalanceDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link QuotaBalanceDetails} and its DTO {@link QuotaBalanceDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuotaBalanceMapper.class, CategoryMapper.class})
public interface QuotaBalanceDetailsMapper extends EntityMapper<QuotaBalanceDetailsDTO, QuotaBalanceDetails> {

    @Mapping(source = "quotaBalance.id", target = "quotaBalanceId")
    @Mapping(source = "category.id", target = "categoryId")
    QuotaBalanceDetailsDTO toDto(QuotaBalanceDetails quotaBalanceDetails);

    @Mapping(source = "quotaBalanceId", target = "quotaBalance")
    @Mapping(source = "categoryId", target = "category")
    QuotaBalanceDetails toEntity(QuotaBalanceDetailsDTO quotaBalanceDetailsDTO);

    default QuotaBalanceDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        QuotaBalanceDetails quotaBalanceDetails = new QuotaBalanceDetails();
        quotaBalanceDetails.setId(id);
        return quotaBalanceDetails;
    }
}
