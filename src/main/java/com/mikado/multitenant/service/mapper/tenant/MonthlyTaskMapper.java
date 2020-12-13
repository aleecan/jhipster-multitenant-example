package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MonthlyTaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonthlyTask} and its DTO {@link MonthlyTaskDTO}.
 */
@Mapper(componentModel = "spring", uses = {MonthlyMapper.class, TaskMapper.class, CategoryMapper.class})
public interface MonthlyTaskMapper extends EntityMapper<MonthlyTaskDTO, MonthlyTask> {

    @Mapping(source = "monthly.id", target = "monthlyId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "category.id", target = "categoryId")
    MonthlyTaskDTO toDto(MonthlyTask monthlyTask);

    @Mapping(source = "monthlyId", target = "monthly")
    @Mapping(source = "taskId", target = "task")
    @Mapping(source = "categoryId", target = "category")
    MonthlyTask toEntity(MonthlyTaskDTO monthlyTaskDTO);

    default MonthlyTask fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonthlyTask monthlyTask = new MonthlyTask();
        monthlyTask.setId(id);
        return monthlyTask;
    }
}
