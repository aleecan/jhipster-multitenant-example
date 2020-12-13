package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.TextFileFormat;
import com.mikado.multitenant.repository.tenant.TextFileFormatRepository;
import com.mikado.multitenant.service.dto.tenant.TextFileFormatDTO;
import com.mikado.multitenant.service.mapper.tenant.TextFileFormatMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TextFileFormat}.
 */
@Service
@Transactional
public class TextFileFormatService {

    private final Logger log = LoggerFactory.getLogger(TextFileFormatService.class);

    private final TextFileFormatRepository textFileFormatRepository;

    private final TextFileFormatMapper textFileFormatMapper;

    public TextFileFormatService(TextFileFormatRepository textFileFormatRepository, TextFileFormatMapper textFileFormatMapper) {
        this.textFileFormatRepository = textFileFormatRepository;
        this.textFileFormatMapper = textFileFormatMapper;
    }

    /**
     * Save a textFileFormat.
     *
     * @param textFileFormatDTO the entity to save.
     * @return the persisted entity.
     */
    public TextFileFormatDTO save(TextFileFormatDTO textFileFormatDTO) {
        log.debug("Request to save TextFileFormat : {}", textFileFormatDTO);
        TextFileFormat textFileFormat = textFileFormatMapper.toEntity(textFileFormatDTO);
        textFileFormat = textFileFormatRepository.save(textFileFormat);
        return textFileFormatMapper.toDto(textFileFormat);
    }

    /**
     * Get all the textFileFormats.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TextFileFormatDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TextFileFormats");
        return textFileFormatRepository.findAll(pageable)
            .map(textFileFormatMapper::toDto);
    }


    /**
     * Get one textFileFormat by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TextFileFormatDTO> findOne(Long id) {
        log.debug("Request to get TextFileFormat : {}", id);
        return textFileFormatRepository.findById(id)
            .map(textFileFormatMapper::toDto);
    }

    /**
     * Delete the textFileFormat by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TextFileFormat : {}", id);
        textFileFormatRepository.deleteById(id);
    }
}
