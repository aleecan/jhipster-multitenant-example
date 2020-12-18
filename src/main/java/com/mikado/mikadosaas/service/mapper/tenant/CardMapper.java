package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.CardDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Card} and its DTO {@link CardDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, VisitorBookMapper.class, CompanyFirmMapper.class, CompanySubFirmMapper.class, GroupCodeMapper.class, PrivateCodeMapper.class})
public interface CardMapper extends EntityMapper<CardDTO, Card> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    @Mapping(source = "companyFirm.id", target = "companyFirmId")
    @Mapping(source = "companySubFirm.id", target = "companySubFirmId")
    @Mapping(source = "groupCode.id", target = "groupCodeId")
    @Mapping(source = "privateCode.id", target = "privateCodeId")
    CardDTO toDto(Card card);

    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitorBookId", target = "visitorBook")
    @Mapping(source = "companyFirmId", target = "companyFirm")
    @Mapping(source = "companySubFirmId", target = "companySubFirm")
    @Mapping(source = "groupCodeId", target = "groupCode")
    @Mapping(source = "privateCodeId", target = "privateCode")
    Card toEntity(CardDTO cardDTO);

    default Card fromId(Long id) {
        if (id == null) {
            return null;
        }
        Card card = new Card();
        card.setId(id);
        return card;
    }
}
