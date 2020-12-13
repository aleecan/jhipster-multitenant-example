package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.EmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompanyFirmMapper.class, CompanySubFirmMapper.class, DepartmentMapper.class, SubDepartmentMapper.class, CostCenterMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class, TitleMapper.class, StaffMapper.class, LocationMapper.class, MusteringPointMapper.class, AnnualLeaveGroupMapper.class, TaskMapper.class, WorkContractMapper.class, CalendarMapper.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {

    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "subDepartment.id", target = "subDepartmentId")
    @Mapping(source = "costCenter.id", target = "costCenterId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    @Mapping(source = "title.id", target = "titleId")
    @Mapping(source = "staff.id", target = "staffId")
    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "musteringPoint.id", target = "musteringPointId")
    @Mapping(source = "annualLeaveGroup.id", target = "annualLeaveGroupId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "directManager.id", target = "directManagerId")
    @Mapping(source = "workContract.id", target = "workContractId")
    @Mapping(source = "calendar.id", target = "calendarId")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "subDepartmentId", target = "subDepartment")
    @Mapping(source = "costCenterId", target = "costCenter")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    @Mapping(source = "titleId", target = "title")
    @Mapping(source = "staffId", target = "staff")
    @Mapping(source = "locationId", target = "location")
    @Mapping(source = "musteringPointId", target = "musteringPoint")
    @Mapping(source = "annualLeaveGroupId", target = "annualLeaveGroup")
    @Mapping(source = "taskId", target = "task")
    @Mapping(source = "directManagerId", target = "directManager")
    @Mapping(source = "workContractId", target = "workContract")
    @Mapping(source = "calendarId", target = "calendar")
    Employee toEntity(EmployeeDTO employeeDTO);

    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
