package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.UserPermissionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserPermission} and its DTO {@link UserPermissionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserPermissionMapper extends EntityMapper<UserPermissionDTO, UserPermission> {



    default UserPermission fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserPermission userPermission = new UserPermission();
        userPermission.setId(id);
        return userPermission;
    }
}
