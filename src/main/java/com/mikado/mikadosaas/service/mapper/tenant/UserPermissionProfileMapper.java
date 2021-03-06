package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.UserPermissionProfileDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserPermissionProfile} and its DTO {@link UserPermissionProfileDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserPermissionProfileMapper extends EntityMapper<UserPermissionProfileDTO, UserPermissionProfile> {



    default UserPermissionProfile fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserPermissionProfile userPermissionProfile = new UserPermissionProfile();
        userPermissionProfile.setId(id);
        return userPermissionProfile;
    }
}
