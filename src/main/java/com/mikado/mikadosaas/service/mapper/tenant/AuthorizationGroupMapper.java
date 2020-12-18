package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AuthorizationGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AuthorizationGroup} and its DTO {@link AuthorizationGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorizationGroupMapper extends EntityMapper<AuthorizationGroupDTO, AuthorizationGroup> {



    default AuthorizationGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuthorizationGroup authorizationGroup = new AuthorizationGroup();
        authorizationGroup.setId(id);
        return authorizationGroup;
    }
}
