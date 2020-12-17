package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.EntryExitAdditionalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntryExitAdditional} and its DTO {@link EntryExitAdditionalDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CategoryMapper.class})
public interface EntryExitAdditionalMapper extends EntityMapper<EntryExitAdditionalDTO, EntryExitAdditional> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "category.id", target = "categoryId")
    EntryExitAdditionalDTO toDto(EntryExitAdditional entryExitAdditional);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "categoryId", target = "category")
    EntryExitAdditional toEntity(EntryExitAdditionalDTO entryExitAdditionalDTO);

    default EntryExitAdditional fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntryExitAdditional entryExitAdditional = new EntryExitAdditional();
        entryExitAdditional.setId(id);
        return entryExitAdditional;
    }
}
