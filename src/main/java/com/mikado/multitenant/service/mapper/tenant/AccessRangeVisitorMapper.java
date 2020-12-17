package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.AccessRangeVisitorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccessRangeVisitor} and its DTO {@link AccessRangeVisitorDTO}.
 */
@Mapper(componentModel = "spring", uses = {VisitorBookMapper.class})
public interface AccessRangeVisitorMapper extends EntityMapper<AccessRangeVisitorDTO, AccessRangeVisitor> {

    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    AccessRangeVisitorDTO toDto(AccessRangeVisitor accessRangeVisitor);

    @Mapping(source = "visitorBookId", target = "visitorBook")
    AccessRangeVisitor toEntity(AccessRangeVisitorDTO accessRangeVisitorDTO);

    default AccessRangeVisitor fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccessRangeVisitor accessRangeVisitor = new AccessRangeVisitor();
        accessRangeVisitor.setId(id);
        return accessRangeVisitor;
    }
}
