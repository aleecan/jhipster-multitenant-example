package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.JobSchedulerDayDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JobSchedulerDay} and its DTO {@link JobSchedulerDayDTO}.
 */
@Mapper(componentModel = "spring", uses = {JobSchedulerMapper.class})
public interface JobSchedulerDayMapper extends EntityMapper<JobSchedulerDayDTO, JobSchedulerDay> {

    @Mapping(source = "jobScheduler.id", target = "jobSchedulerId")
    JobSchedulerDayDTO toDto(JobSchedulerDay jobSchedulerDay);

    @Mapping(source = "jobSchedulerId", target = "jobScheduler")
    JobSchedulerDay toEntity(JobSchedulerDayDTO jobSchedulerDayDTO);

    default JobSchedulerDay fromId(Long id) {
        if (id == null) {
            return null;
        }
        JobSchedulerDay jobSchedulerDay = new JobSchedulerDay();
        jobSchedulerDay.setId(id);
        return jobSchedulerDay;
    }
}
