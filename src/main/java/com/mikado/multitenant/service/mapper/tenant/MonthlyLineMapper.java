package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MonthlyLineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyLine} and its DTO {@link MonthlyLineDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MonthlyLineMapper extends EntityMapper<MonthlyLineDTO, MonthlyLine> {



    default MonthlyLine fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyLine monthlyLine = new MonthlyLine();
        monthlyLine.setId(id);
        return monthlyLine;
    }
}
