package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TitleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Title} and its DTO {@link TitleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TitleMapper extends EntityMapper<TitleDTO, Title> {



    default Title fromId(Long id) {
        if (id == null) {
            return null;
        }
        Title title = new Title();
        title.setId(id);
        return title;
    }
}
