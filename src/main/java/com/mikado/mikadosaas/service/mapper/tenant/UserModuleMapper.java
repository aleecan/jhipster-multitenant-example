package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.UserModuleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserModule} and its DTO {@link UserModuleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserModuleMapper extends EntityMapper<UserModuleDTO, UserModule> {



    default UserModule fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserModule userModule = new UserModule();
        userModule.setId(id);
        return userModule;
    }
}
