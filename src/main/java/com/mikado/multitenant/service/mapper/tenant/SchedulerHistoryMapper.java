package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.SchedulerHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SchedulerHistory} and its DTO {@link SchedulerHistoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {JobSchedulerMapper.class, MailSchedulerMapper.class})
public interface SchedulerHistoryMapper extends EntityMapper<SchedulerHistoryDTO, SchedulerHistory> {

    @Mapping(source = "jobScheduler.id", target = "jobSchedulerId")
    @Mapping(source = "mailScheduler.id", target = "mailSchedulerId")
    SchedulerHistoryDTO toDto(SchedulerHistory schedulerHistory);

    @Mapping(source = "jobSchedulerId", target = "jobScheduler")
    @Mapping(source = "mailSchedulerId", target = "mailScheduler")
    SchedulerHistory toEntity(SchedulerHistoryDTO schedulerHistoryDTO);

    default SchedulerHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        SchedulerHistory schedulerHistory = new SchedulerHistory();
        schedulerHistory.setId(id);
        return schedulerHistory;
    }
}
