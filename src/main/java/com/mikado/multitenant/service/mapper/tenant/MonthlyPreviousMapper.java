package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MonthlyPreviousDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyPrevious} and its DTO {@link MonthlyPreviousDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface MonthlyPreviousMapper extends EntityMapper<MonthlyPreviousDTO, MonthlyPrevious> {

    @Mapping(source = "employee.id", target = "employeeId")
    MonthlyPreviousDTO toDto(MonthlyPrevious monthlyPrevious);

    @Mapping(source = "employeeId", target = "employee")
    MonthlyPrevious toEntity(MonthlyPreviousDTO monthlyPreviousDTO);

    default MonthlyPrevious fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyPrevious monthlyPrevious = new MonthlyPrevious();
        monthlyPrevious.setId(id);
        return monthlyPrevious;
    }
}
