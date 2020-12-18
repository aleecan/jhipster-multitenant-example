package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.OvertimeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Overtime} and its DTO {@link OvertimeDTO}.
 */
@Mapper(componentModel = "spring", uses = {OvertimeGroupMapper.class, CategoryMapper.class})
public interface OvertimeMapper extends EntityMapper<OvertimeDTO, Overtime> {

    @Mapping(source = "overtimeGroup.id", target = "overtimeGroupId")
    @Mapping(source = "category.id", target = "categoryId")
    OvertimeDTO toDto(Overtime overtime);

    @Mapping(source = "overtimeGroupId", target = "overtimeGroup")
    @Mapping(source = "categoryId", target = "category")
    Overtime toEntity(OvertimeDTO overtimeDTO);

    default Overtime fromId(Long id) {
        if (id == null) {
            return null;
        }
        Overtime overtime = new Overtime();
        overtime.setId(id);
        return overtime;
    }
}
