package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ScheduleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Schedule} and its DTO {@link ScheduleDTO}.
 */
@Mapper(componentModel = "spring", uses = {NormalGroupMapper.class, ToleranceGroupMapper.class, OvertimeGroupMapper.class, MealGroupMapper.class, AdditionalGroupMapper.class, CategoryMapper.class})
public interface ScheduleMapper extends EntityMapper<ScheduleDTO, Schedule> {

    @Mapping(source = "normalGroup.id", target = "normalGroupId")
    @Mapping(source = "toleranceGroup.id", target = "toleranceGroupId")
    @Mapping(source = "overtimeGroup.id", target = "overtimeGroupId")
    @Mapping(source = "mealGroup.id", target = "mealGroupId")
    @Mapping(source = "additionalGroup.id", target = "additionalGroupId")
    @Mapping(source = "absentCategory.id", target = "absentCategoryId")
    @Mapping(source = "excessOtCategory.id", target = "excessOtCategoryId")
    ScheduleDTO toDto(Schedule schedule);

    @Mapping(source = "normalGroupId", target = "normalGroup")
    @Mapping(source = "toleranceGroupId", target = "toleranceGroup")
    @Mapping(source = "overtimeGroupId", target = "overtimeGroup")
    @Mapping(source = "mealGroupId", target = "mealGroup")
    @Mapping(source = "additionalGroupId", target = "additionalGroup")
    @Mapping(source = "absentCategoryId", target = "absentCategory")
    @Mapping(source = "excessOtCategoryId", target = "excessOtCategory")
    Schedule toEntity(ScheduleDTO scheduleDTO);

    default Schedule fromId(Long id) {
        if (id == null) {
            return null;
        }
        Schedule schedule = new Schedule();
        schedule.setId(id);
        return schedule;
    }
}
