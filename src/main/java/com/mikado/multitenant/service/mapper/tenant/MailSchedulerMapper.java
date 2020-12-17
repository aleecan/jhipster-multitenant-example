package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MailSchedulerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MailScheduler} and its DTO {@link MailSchedulerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MailSchedulerMapper extends EntityMapper<MailSchedulerDTO, MailScheduler> {



    default MailScheduler fromId(Long id) {
        if (id == null) {
            return null;
        }
        MailScheduler mailScheduler = new MailScheduler();
        mailScheduler.setId(id);
        return mailScheduler;
    }
}
