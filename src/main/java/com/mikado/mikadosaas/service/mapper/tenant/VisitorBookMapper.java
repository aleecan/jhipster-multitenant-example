package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.VisitorBookDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VisitorBook} and its DTO {@link VisitorBookDTO}.
 */
@Mapper(componentModel = "spring", uses = {VisitorMapper.class, EmployeeMapper.class, VisitReasonMapper.class})
public interface VisitorBookMapper extends EntityMapper<VisitorBookDTO, VisitorBook> {

    @Mapping(source = "visitor.id", target = "visitorId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitReason.id", target = "visitReasonId")
    VisitorBookDTO toDto(VisitorBook visitorBook);

    @Mapping(source = "visitorId", target = "visitor")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitReasonId", target = "visitReason")
    VisitorBook toEntity(VisitorBookDTO visitorBookDTO);

    default VisitorBook fromId(Long id) {
        if (id == null) {
            return null;
        }
        VisitorBook visitorBook = new VisitorBook();
        visitorBook.setId(id);
        return visitorBook;
    }
}
