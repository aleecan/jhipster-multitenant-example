package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.MonthlySumDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlySum} and its DTO {@link MonthlySumDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyMapper.class})
public interface MonthlySumMapper extends EntityMapper<MonthlySumDTO, MonthlySum> {

    @Mapping(source = "monthly.id", target = "monthlyId")
    MonthlySumDTO toDto(MonthlySum monthlySum);

    @Mapping(source = "monthlyId", target = "monthly")
    MonthlySum toEntity(MonthlySumDTO monthlySumDTO);

    default MonthlySum fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlySum monthlySum = new MonthlySum();
        monthlySum.setId(id);
        return monthlySum;
    }
}
