package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Additional;
import com.mikado.mikadosaas.repository.tenant.AdditionalRepository;
import com.mikado.mikadosaas.service.dto.tenant.AdditionalDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AdditionalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Additional}.
 */
@Service
@Transactional
public class AdditionalService {

    private final Logger log = LoggerFactory.getLogger(AdditionalService.class);

    private final AdditionalRepository additionalRepository;

    private final AdditionalMapper additionalMapper;

    public AdditionalService(AdditionalRepository additionalRepository, AdditionalMapper additionalMapper) {
        this.additionalRepository = additionalRepository;
        this.additionalMapper = additionalMapper;
    }

    /**
     * Save a additional.
     *
     * @param additionalDTO the entity to save.
     * @return the persisted entity.
     */
    public AdditionalDTO save(AdditionalDTO additionalDTO) {
        log.debug("Request to save Additional : {}", additionalDTO);
        Additional additional = additionalMapper.toEntity(additionalDTO);
        additional = additionalRepository.save(additional);
        return additionalMapper.toDto(additional);
    }

    /**
     * Get all the additionals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AdditionalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Additionals");
        return additionalRepository.findAll(pageable)
            .map(additionalMapper::toDto);
    }


    /**
     * Get one additional by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AdditionalDTO> findOne(Long id) {
        log.debug("Request to get Additional : {}", id);
        return additionalRepository.findById(id)
            .map(additionalMapper::toDto);
    }

    /**
     * Delete the additional by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Additional : {}", id);
        additionalRepository.deleteById(id);
    }
}
