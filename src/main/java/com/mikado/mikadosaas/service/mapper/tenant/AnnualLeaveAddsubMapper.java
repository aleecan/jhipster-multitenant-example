package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveAddsubDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AnnualLeaveAddsub} and its DTO {@link AnnualLeaveAddsubDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface AnnualLeaveAddsubMapper extends EntityMapper<AnnualLeaveAddsubDTO, AnnualLeaveAddsub> {

    @Mapping(source = "employee.id", target = "employeeId")
    AnnualLeaveAddsubDTO toDto(AnnualLeaveAddsub annualLeaveAddsub);

    @Mapping(source = "employeeId", target = "employee")
    AnnualLeaveAddsub toEntity(AnnualLeaveAddsubDTO annualLeaveAddsubDTO);

    default AnnualLeaveAddsub fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnnualLeaveAddsub annualLeaveAddsub = new AnnualLeaveAddsub();
        annualLeaveAddsub.setId(id);
        return annualLeaveAddsub;
    }
}
