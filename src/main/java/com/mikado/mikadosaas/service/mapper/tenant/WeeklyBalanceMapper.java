package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyBalanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WeeklyBalance} and its DTO {@link WeeklyBalanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface WeeklyBalanceMapper extends EntityMapper<WeeklyBalanceDTO, WeeklyBalance> {

    @Mapping(source = "employee.id", target = "employeeId")
    WeeklyBalanceDTO toDto(WeeklyBalance weeklyBalance);

    @Mapping(source = "employeeId", target = "employee")
    WeeklyBalance toEntity(WeeklyBalanceDTO weeklyBalanceDTO);

    default WeeklyBalance fromId(Long id) {
        if (id == null) {
            return null;
        }
        WeeklyBalance weeklyBalance = new WeeklyBalance();
        weeklyBalance.setId(id);
        return weeklyBalance;
    }
}
