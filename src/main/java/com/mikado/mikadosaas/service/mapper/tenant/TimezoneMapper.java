package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Timezone} and its DTO {@link TimezoneDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TimezoneMapper extends EntityMapper<TimezoneDTO, Timezone> {



    default Timezone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Timezone timezone = new Timezone();
        timezone.setId(id);
        return timezone;
    }
}
