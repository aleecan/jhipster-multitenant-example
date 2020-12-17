package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.ZoneControlDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ZoneControl} and its DTO {@link ZoneControlDTO}.
 */
@Mapper(componentModel = "spring", uses = {ZoneMapper.class, AccessCodeMapper.class, EmployeeMapper.class, VisitorBookMapper.class, AccessControlMapper.class})
public interface ZoneControlMapper extends EntityMapper<ZoneControlDTO, ZoneControl> {

    @Mapping(source = "zone.id", target = "zoneId")
    @Mapping(source = "accessCode.id", target = "accessCodeId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "visitorBook.id", target = "visitorBookId")
    @Mapping(source = "access.id", target = "accessId")
    @Mapping(source = "exitAccessCode.id", target = "exitAccessCodeId")
    ZoneControlDTO toDto(ZoneControl zoneControl);

    @Mapping(source = "zoneId", target = "zone")
    @Mapping(source = "accessCodeId", target = "accessCode")
    @Mapping(source = "employeeId", target = "employee")
    @Mapping(source = "visitorBookId", target = "visitorBook")
    @Mapping(source = "accessId", target = "access")
    @Mapping(source = "exitAccessCodeId", target = "exitAccessCode")
    ZoneControl toEntity(ZoneControlDTO zoneControlDTO);

    default ZoneControl fromId(Long id) {
        if (id == null) {
            return null;
        }
        ZoneControl zoneControl = new ZoneControl();
        zoneControl.setId(id);
        return zoneControl;
    }
}
