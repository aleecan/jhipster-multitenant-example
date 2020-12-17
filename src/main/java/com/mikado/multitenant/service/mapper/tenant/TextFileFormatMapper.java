package com.mikado.multitenant.service.mapper.tenant;


import com.mikado.multitenant.domain.tenant.*;
import com.mikado.multitenant.service.dto.tenant.TextFileFormatDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TextFileFormat} and its DTO {@link TextFileFormatDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TextFileFormatMapper extends EntityMapper<TextFileFormatDTO, TextFileFormat> {



    default TextFileFormat fromId(Long id) {
        if (id == null) {
            return null;
        }
        TextFileFormat textFileFormat = new TextFileFormat();
        textFileFormat.setId(id);
        return textFileFormat;
    }
}
