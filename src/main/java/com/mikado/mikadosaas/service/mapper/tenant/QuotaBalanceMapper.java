package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.QuotaBalanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link QuotaBalance} and its DTO {@link QuotaBalanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, QuotaTypeMapper.class})
public interface QuotaBalanceMapper extends EntityMapper<QuotaBalanceDTO, QuotaBalance> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "quotaType.id", target = "quotaTypeId")
    QuotaBalanceDTO toDto(QuotaBalance quotaBalance);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "quotaTypeId", target = "quotaType")
    QuotaBalance toEntity(QuotaBalanceDTO quotaBalanceDTO);

    default QuotaBalance fromId(Long id) {
        if (id == null) {
            return null;
        }
        QuotaBalance quotaBalance = new QuotaBalance();
        quotaBalance.setId(id);
        return quotaBalance;
    }
}
