package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.DailyTaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DailyTask} and its DTO {@link DailyTaskDTO}.
 */
@Mapper(componentModel = "spring", uses = {DailyMapper.class, TaskMapper.class, CategoryMapper.class})
public interface DailyTaskMapper extends EntityMapper<DailyTaskDTO, DailyTask> {

    @Mapping(source = "daily.id", target = "dailyId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "category.id", target = "categoryId")
    DailyTaskDTO toDto(DailyTask dailyTask);

    @Mapping(source = "dailyId", target = "daily")
    @Mapping(source = "taskId", target = "task")
    @Mapping(source = "categoryId", target = "category")
    DailyTask toEntity(DailyTaskDTO dailyTaskDTO);

    default DailyTask fromId(Long id) {
        if (id == null) {
            return null;
        }
        DailyTask dailyTask = new DailyTask();
        dailyTask.setId(id);
        return dailyTask;
    }
}
