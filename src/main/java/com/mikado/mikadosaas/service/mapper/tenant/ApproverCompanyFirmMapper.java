package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.ApproverCompanyFirmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ApproverCompanyFirm} and its DTO {@link ApproverCompanyFirmDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CompanyFirmMapper.class, CompanySubFirmMapper.class})
public interface ApproverCompanyFirmMapper extends EntityMapper<ApproverCompanyFirmDTO, ApproverCompanyFirm> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    ApproverCompanyFirmDTO toDto(ApproverCompanyFirm approverCompanyFirm);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    ApproverCompanyFirm toEntity(ApproverCompanyFirmDTO approverCompanyFirmDTO);

    default ApproverCompanyFirm fromId(Long id) {
        if (id == null) {
            return null;
        }
        ApproverCompanyFirm approverCompanyFirm = new ApproverCompanyFirm();
        approverCompanyFirm.setId(id);
        return approverCompanyFirm;
    }
}
