package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.EntryExitChange;
import com.mikado.multitenant.repository.tenant.EntryExitChangeRepository;
import com.mikado.multitenant.service.dto.tenant.EntryExitChangeDTO;
import com.mikado.multitenant.service.mapper.tenant.EntryExitChangeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EntryExitChange}.
 */
@Service
@Transactional
public class EntryExitChangeService {

    private final Logger log = LoggerFactory.getLogger(EntryExitChangeService.class);

    private final EntryExitChangeRepository entryExitChangeRepository;

    private final EntryExitChangeMapper entryExitChangeMapper;

    public EntryExitChangeService(EntryExitChangeRepository entryExitChangeRepository, EntryExitChangeMapper entryExitChangeMapper) {
        this.entryExitChangeRepository = entryExitChangeRepository;
        this.entryExitChangeMapper = entryExitChangeMapper;
    }

    /**
     * Save a entryExitChange.
     *
     * @param entryExitChangeDTO the entity to save.
     * @return the persisted entity.
     */
    public EntryExitChangeDTO save(EntryExitChangeDTO entryExitChangeDTO) {
        log.debug("Request to save EntryExitChange : {}", entryExitChangeDTO);
        EntryExitChange entryExitChange = entryExitChangeMapper.toEntity(entryExitChangeDTO);
        entryExitChange = entryExitChangeRepository.save(entryExitChange);
        return entryExitChangeMapper.toDto(entryExitChange);
    }

    /**
     * Get all the entryExitChanges.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EntryExitChangeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntryExitChanges");
        return entryExitChangeRepository.findAll(pageable)
            .map(entryExitChangeMapper::toDto);
    }


    /**
     * Get one entryExitChange by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EntryExitChangeDTO> findOne(Long id) {
        log.debug("Request to get EntryExitChange : {}", id);
        return entryExitChangeRepository.findById(id)
            .map(entryExitChangeMapper::toDto);
    }

    /**
     * Delete the entryExitChange by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EntryExitChange : {}", id);
        entryExitChangeRepository.deleteById(id);
    }
}
