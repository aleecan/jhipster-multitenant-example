package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MonthlyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Monthly} and its DTO {@link MonthlyDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface MonthlyMapper extends EntityMapper<MonthlyDTO, Monthly> {

    @Mapping(source = "employee.id", target = "employeeId")
    MonthlyDTO toDto(Monthly monthly);

    @Mapping(source = "employeeId", target = "employee")
    Monthly toEntity(MonthlyDTO monthlyDTO);

    default Monthly fromId(Long id) {
        if (id == null) {
            return null;
        }
        Monthly monthly = new Monthly();
        monthly.setId(id);
        return monthly;
    }
}
