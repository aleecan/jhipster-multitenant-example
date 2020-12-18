package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.AuthorizationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Authorization} and its DTO {@link AuthorizationDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, VisitorBookMapper.class, CardMapper.class})
public interface AuthorizationMapper extends EntityMapper<AuthorizationDTO, Authorization> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    @Mapping(source = "card.id", target = "cardId")
    AuthorizationDTO toDto(Authorization authorization);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitorBookId", target = "visitorBook")
    @Mapping(source = "cardId", target = "card")
    Authorization toEntity(AuthorizationDTO authorizationDTO);

    default Authorization fromId(Long id) {
        if (id == null) {
            return null;
        }
        Authorization authorization = new Authorization();
        authorization.setId(id);
        return authorization;
    }
}
