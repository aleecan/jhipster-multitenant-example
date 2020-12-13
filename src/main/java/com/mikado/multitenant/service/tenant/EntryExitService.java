package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.EntryExit;
import com.mikado.multitenant.repository.tenant.EntryExitRepository;
import com.mikado.multitenant.service.dto.tenant.EntryExitDTO;
import com.mikado.multitenant.service.mapper.tenant.EntryExitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EntryExit}.
 */
@Service
@Transactional
public class EntryExitService {

    private final Logger log = LoggerFactory.getLogger(EntryExitService.class);

    private final EntryExitRepository entryExitRepository;

    private final EntryExitMapper entryExitMapper;

    public EntryExitService(EntryExitRepository entryExitRepository, EntryExitMapper entryExitMapper) {
        this.entryExitRepository = entryExitRepository;
        this.entryExitMapper = entryExitMapper;
    }

    /**
     * Save a entryExit.
     *
     * @param entryExitDTO the entity to save.
     * @return the persisted entity.
     */
    public EntryExitDTO save(EntryExitDTO entryExitDTO) {
        log.debug("Request to save EntryExit : {}", entryExitDTO);
        EntryExit entryExit = entryExitMapper.toEntity(entryExitDTO);
        entryExit = entryExitRepository.save(entryExit);
        return entryExitMapper.toDto(entryExit);
    }

    /**
     * Get all the entryExits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EntryExitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntryExits");
        return entryExitRepository.findAll(pageable)
            .map(entryExitMapper::toDto);
    }


    /**
     * Get one entryExit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EntryExitDTO> findOne(Long id) {
        log.debug("Request to get EntryExit : {}", id);
        return entryExitRepository.findById(id)
            .map(entryExitMapper::toDto);
    }

    /**
     * Delete the entryExit by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EntryExit : {}", id);
        entryExitRepository.deleteById(id);
    }
}
