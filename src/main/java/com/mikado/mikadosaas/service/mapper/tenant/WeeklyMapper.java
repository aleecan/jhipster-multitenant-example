package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Weekly} and its DTO {@link WeeklyDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface WeeklyMapper extends EntityMapper<WeeklyDTO, Weekly> {

    @Mapping(source = "employee.id", target = "employeeId")
    WeeklyDTO toDto(Weekly weekly);

    @Mapping(source = "employeeId", target = "employee")
    Weekly toEntity(WeeklyDTO weeklyDTO);

    default Weekly fromId(Long id) {
        if (id == null) {
            return null;
        }
        Weekly weekly = new Weekly();
        weekly.setId(id);
        return weekly;
    }
}
