package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.EntryExitDetails;
import com.mikado.multitenant.repository.tenant.EntryExitDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.EntryExitDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.EntryExitDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EntryExitDetails}.
 */
@Service
@Transactional
public class EntryExitDetailsService {

    private final Logger log = LoggerFactory.getLogger(EntryExitDetailsService.class);

    private final EntryExitDetailsRepository entryExitDetailsRepository;

    private final EntryExitDetailsMapper entryExitDetailsMapper;

    public EntryExitDetailsService(EntryExitDetailsRepository entryExitDetailsRepository, EntryExitDetailsMapper entryExitDetailsMapper) {
        this.entryExitDetailsRepository = entryExitDetailsRepository;
        this.entryExitDetailsMapper = entryExitDetailsMapper;
    }

    /**
     * Save a entryExitDetails.
     *
     * @param entryExitDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public EntryExitDetailsDTO save(EntryExitDetailsDTO entryExitDetailsDTO) {
        log.debug("Request to save EntryExitDetails : {}", entryExitDetailsDTO);
        EntryExitDetails entryExitDetails = entryExitDetailsMapper.toEntity(entryExitDetailsDTO);
        entryExitDetails = entryExitDetailsRepository.save(entryExitDetails);
        return entryExitDetailsMapper.toDto(entryExitDetails);
    }

    /**
     * Get all the entryExitDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EntryExitDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntryExitDetails");
        return entryExitDetailsRepository.findAll(pageable)
            .map(entryExitDetailsMapper::toDto);
    }


    /**
     * Get one entryExitDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EntryExitDetailsDTO> findOne(Long id) {
        log.debug("Request to get EntryExitDetails : {}", id);
        return entryExitDetailsRepository.findById(id)
            .map(entryExitDetailsMapper::toDto);
    }

    /**
     * Delete the entryExitDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EntryExitDetails : {}", id);
        entryExitDetailsRepository.deleteById(id);
    }
}
