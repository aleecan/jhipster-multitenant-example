package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.UserFilterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserFilter} and its DTO {@link UserFilterDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserFilterMapper extends EntityMapper<UserFilterDTO, UserFilter> {



    default UserFilter fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserFilter userFilter = new UserFilter();
        userFilter.setId(id);
        return userFilter;
    }
}
