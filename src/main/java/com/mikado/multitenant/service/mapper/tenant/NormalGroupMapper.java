package com.mikado.multitenant.service.mapper.tenant;

import com.mikado.multitenant.domain.tenant.NormalGroup;
import com.mikado.multitenant.service.dto.tenant.NormalGroupDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link NormalGroup} and its DTO {@link NormalGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NormalGroupMapper extends EntityMapper<NormalGroupDTO, NormalGroup> {



    default NormalGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        NormalGroup normalGroup = new NormalGroup();
        normalGroup.setId(id);
        return normalGroup;
    }
}
