package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExitAdditional;
import com.mikado.mikadosaas.repository.tenant.EntryExitAdditionalRepository;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitAdditionalDTO;
import com.mikado.mikadosaas.service.mapper.tenant.EntryExitAdditionalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EntryExitAdditional}.
 */
@Service
@Transactional
public class EntryExitAdditionalService {

    private final Logger log = LoggerFactory.getLogger(EntryExitAdditionalService.class);

    private final EntryExitAdditionalRepository entryExitAdditionalRepository;

    private final EntryExitAdditionalMapper entryExitAdditionalMapper;

    public EntryExitAdditionalService(EntryExitAdditionalRepository entryExitAdditionalRepository, EntryExitAdditionalMapper entryExitAdditionalMapper) {
        this.entryExitAdditionalRepository = entryExitAdditionalRepository;
        this.entryExitAdditionalMapper = entryExitAdditionalMapper;
    }

    /**
     * Save a entryExitAdditional.
     *
     * @param entryExitAdditionalDTO the entity to save.
     * @return the persisted entity.
     */
    public EntryExitAdditionalDTO save(EntryExitAdditionalDTO entryExitAdditionalDTO) {
        log.debug("Request to save EntryExitAdditional : {}", entryExitAdditionalDTO);
        EntryExitAdditional entryExitAdditional = entryExitAdditionalMapper.toEntity(entryExitAdditionalDTO);
        entryExitAdditional = entryExitAdditionalRepository.save(entryExitAdditional);
        return entryExitAdditionalMapper.toDto(entryExitAdditional);
    }

    /**
     * Get all the entryExitAdditionals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EntryExitAdditionalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntryExitAdditionals");
        return entryExitAdditionalRepository.findAll(pageable)
            .map(entryExitAdditionalMapper::toDto);
    }


    /**
     * Get one entryExitAdditional by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EntryExitAdditionalDTO> findOne(Long id) {
        log.debug("Request to get EntryExitAdditional : {}", id);
        return entryExitAdditionalRepository.findById(id)
            .map(entryExitAdditionalMapper::toDto);
    }

    /**
     * Delete the entryExitAdditional by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EntryExitAdditional : {}", id);
        entryExitAdditionalRepository.deleteById(id);
    }
}
