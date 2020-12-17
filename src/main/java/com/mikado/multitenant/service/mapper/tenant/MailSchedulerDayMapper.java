package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.MailSchedulerDayDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MailSchedulerDay} and its DTO {@link MailSchedulerDayDTO}.
 */
@Mapper(componentModel = "spring", uses = {MailSchedulerMapper.class})
public interface MailSchedulerDayMapper extends EntityMapper<MailSchedulerDayDTO, MailSchedulerDay> {

    @Mapping(source = "mailScheduler.id", target = "mailSchedulerId")
    MailSchedulerDayDTO toDto(MailSchedulerDay mailSchedulerDay);

    @Mapping(source = "mailSchedulerId", target = "mailScheduler")
    MailSchedulerDay toEntity(MailSchedulerDayDTO mailSchedulerDayDTO);

    default MailSchedulerDay fromId(Long id) {
        if (id == null) {
            return null;
        }
        MailSchedulerDay mailSchedulerDay = new MailSchedulerDay();
        mailSchedulerDay.setId(id);
        return mailSchedulerDay;
    }
}
