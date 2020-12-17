package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.EmployeeHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EmployeeHistory} and its DTO {@link EmployeeHistoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CompanyFirmMapper.class, CompanySubFirmMapper.class, DepartmentMapper.class, SubDepartmentMapper.class, CostCenterMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class, TitleMapper.class, StaffMapper.class, WorkContractMapper.class})
public interface EmployeeHistoryMapper extends EntityMapper<EmployeeHistoryDTO, EmployeeHistory> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "subDepartment.id", target = "subDepartmentId")
    @Mapping(source = "costCenter.id", target = "costCenterId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    @Mapping(source = "title.id", target = "titleId")
    @Mapping(source = "staff.id", target = "staffId")
    @Mapping(source = "workContract.id", target = "workContractId")
    EmployeeHistoryDTO toDto(EmployeeHistory employeeHistory);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "subDepartmentId", target = "subDepartment")
    @Mapping(source = "costCenterId", target = "costCenter")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    @Mapping(source = "titleId", target = "title")
    @Mapping(source = "staffId", target = "staff")
    @Mapping(source = "workContractId", target = "workContract")
    EmployeeHistory toEntity(EmployeeHistoryDTO employeeHistoryDTO);

    default EmployeeHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmployeeHistory employeeHistory = new EmployeeHistory();
        employeeHistory.setId(id);
        return employeeHistory;
    }
}
