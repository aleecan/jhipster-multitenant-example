package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ToleranceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Tolerance} and its DTO {@link ToleranceDTO}.
 */
@Mapper(componentModel = "spring", uses = {ToleranceGroupMapper.class})
public interface ToleranceMapper extends EntityMapper<ToleranceDTO, Tolerance> {

    @Mapping(source = "toleranceGroup.id", target = "toleranceGroupId")
    ToleranceDTO toDto(Tolerance tolerance);

    @Mapping(source = "toleranceGroupId", target = "toleranceGroup")
    Tolerance toEntity(ToleranceDTO toleranceDTO);

    default Tolerance fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tolerance tolerance = new Tolerance();
        tolerance.setId(id);
        return tolerance;
    }
}
