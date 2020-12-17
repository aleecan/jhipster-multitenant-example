package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.UserUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserUser} and its DTO {@link UserUserDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserFilterMapper.class, UserPermissionProfileMapper.class, UserRoleMapper.class})
public interface UserUserMapper extends EntityMapper<UserUserDTO, UserUser> {

    @Mapping(source = "profile.id", target = "profileId")
    @Mapping(source = "role.id", target = "roleId")
    UserUserDTO toDto(UserUser userUser);

    @Mapping(source = "profileId", target = "profile")
    @Mapping(source = "roleId", target = "role")
    UserUser toEntity(UserUserDTO userUserDTO);

    default UserUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserUser userUser = new UserUser();
        userUser.setId(id);
        return userUser;
    }
}
