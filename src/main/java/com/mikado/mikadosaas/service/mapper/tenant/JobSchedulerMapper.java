package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.JobSchedulerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JobScheduler} and its DTO {@link JobSchedulerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JobSchedulerMapper extends EntityMapper<JobSchedulerDTO, JobScheduler> {



    default JobScheduler fromId(Long id) {
        if (id == null) {
            return null;
        }
        JobScheduler jobScheduler = new JobScheduler();
        jobScheduler.setId(id);
        return jobScheduler;
    }
}
