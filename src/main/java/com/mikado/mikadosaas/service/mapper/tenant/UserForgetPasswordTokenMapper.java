package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.UserForgetPasswordTokenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserForgetPasswordToken} and its DTO {@link UserForgetPasswordTokenDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserUserMapper.class})
public interface UserForgetPasswordTokenMapper extends EntityMapper<UserForgetPasswordTokenDTO, UserForgetPasswordToken> {

    @Mapping(source = "user.id", target = "userId")
    UserForgetPasswordTokenDTO toDto(UserForgetPasswordToken userForgetPasswordToken);

    @Mapping(source = "userId", target = "user")
    UserForgetPasswordToken toEntity(UserForgetPasswordTokenDTO userForgetPasswordTokenDTO);

    default UserForgetPasswordToken fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserForgetPasswordToken userForgetPasswordToken = new UserForgetPasswordToken();
        userForgetPasswordToken.setId(id);
        return userForgetPasswordToken;
    }
}
