package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitTaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntryExitTask} and its DTO {@link EntryExitTaskDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, TaskMapper.class})
public interface EntryExitTaskMapper extends EntityMapper<EntryExitTaskDTO, EntryExitTask> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "task.id", target = "taskId")
    EntryExitTaskDTO toDto(EntryExitTask entryExitTask);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "taskId", target = "task")
    EntryExitTask toEntity(EntryExitTaskDTO entryExitTaskDTO);

    default EntryExitTask fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntryExitTask entryExitTask = new EntryExitTask();
        entryExitTask.setId(id);
        return entryExitTask;
    }
}
