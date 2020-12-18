package com.mikado.mikadosaas.service.mapper.tenant;


import com.mikado.mikadosaas.domain.tenant.*;
import com.mikado.mikadosaas.service.dto.tenant.MusteringPointDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MusteringPoint} and its DTO {@link MusteringPointDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MusteringPointMapper extends EntityMapper<MusteringPointDTO, MusteringPoint> {



    default MusteringPoint fromId(Long id) {
        if (id == null) {
            return null;
        }
        MusteringPoint musteringPoint = new MusteringPoint();
        musteringPoint.setId(id);
        return musteringPoint;
    }
}
