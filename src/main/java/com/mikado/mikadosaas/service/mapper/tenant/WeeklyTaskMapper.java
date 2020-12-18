package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyTaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WeeklyTask} and its DTO {@link WeeklyTaskDTO}.
 */
@Mapper(componentModel = "spring", uses = {WeeklyMapper.class, TaskMapper.class, CategoryMapper.class})
public interface WeeklyTaskMapper extends EntityMapper<WeeklyTaskDTO, WeeklyTask> {

    @Mapping(source = "weekly.id", target = "weeklyId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "category.id", target = "categoryId")
    WeeklyTaskDTO toDto(WeeklyTask weeklyTask);

    @Mapping(source = "weeklyId", target = "weekly")
    @Mapping(source = "taskId", target = "task")
    @Mapping(source = "categoryId", target = "category")
    WeeklyTask toEntity(WeeklyTaskDTO weeklyTaskDTO);

    default WeeklyTask fromId(Long id) {
        if (id == null) {
            return null;
        }
        WeeklyTask weeklyTask = new WeeklyTask();
        weeklyTask.setId(id);
        return weeklyTask;
    }
}
