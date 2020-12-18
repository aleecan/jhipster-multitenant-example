package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.VisitorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Visitor} and its DTO {@link VisitorDTO}.
 */
@Mapper(componentModel = "spring", uses = {VisitorCompanyMapper.class})
public interface VisitorMapper extends EntityMapper<VisitorDTO, Visitor> {

    @Mapping(source = "company.id", target = "companyId")
    VisitorDTO toDto(Visitor visitor);

    @Mapping(source = "companyId", target = "company")
    Visitor toEntity(VisitorDTO visitorDTO);

    default Visitor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Visitor visitor = new Visitor();
        visitor.setId(id);
        return visitor;
    }
}
