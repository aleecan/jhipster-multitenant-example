package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ProcessDailyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProcessDaily} and its DTO {@link ProcessDailyDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProcessDailyMapper extends EntityMapper<ProcessDailyDTO, ProcessDaily> {

    @Mapping(source = "extraHourCategory.id", target = "extraHourCategoryId")
    ProcessDailyDTO toDto(ProcessDaily processDaily);

    @Mapping(source = "extraHourCategoryId", target = "extraHourCategory")
    ProcessDaily toEntity(ProcessDailyDTO processDailyDTO);

    default ProcessDaily fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProcessDaily processDaily = new ProcessDaily();
        processDaily.setId(id);
        return processDaily;
    }
}
