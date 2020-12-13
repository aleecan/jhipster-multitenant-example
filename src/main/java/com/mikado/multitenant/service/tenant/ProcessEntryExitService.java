package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ProcessEntryExit;
import com.mikado.multitenant.repository.tenant.ProcessEntryExitRepository;
import com.mikado.multitenant.service.dto.tenant.ProcessEntryExitDTO;
import com.mikado.multitenant.service.mapper.tenant.ProcessEntryExitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessEntryExit}.
 */
@Service
@Transactional
public class ProcessEntryExitService {

    private final Logger log = LoggerFactory.getLogger(ProcessEntryExitService.class);

    private final ProcessEntryExitRepository processEntryExitRepository;

    private final ProcessEntryExitMapper processEntryExitMapper;

    public ProcessEntryExitService(ProcessEntryExitRepository processEntryExitRepository, ProcessEntryExitMapper processEntryExitMapper) {
        this.processEntryExitRepository = processEntryExitRepository;
        this.processEntryExitMapper = processEntryExitMapper;
    }

    /**
     * Save a processEntryExit.
     *
     * @param processEntryExitDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessEntryExitDTO save(ProcessEntryExitDTO processEntryExitDTO) {
        log.debug("Request to save ProcessEntryExit : {}", processEntryExitDTO);
        ProcessEntryExit processEntryExit = processEntryExitMapper.toEntity(processEntryExitDTO);
        processEntryExit = processEntryExitRepository.save(processEntryExit);
        return processEntryExitMapper.toDto(processEntryExit);
    }

    /**
     * Get all the processEntryExits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessEntryExitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessEntryExits");
        return processEntryExitRepository.findAll(pageable)
            .map(processEntryExitMapper::toDto);
    }


    /**
     * Get one processEntryExit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessEntryExitDTO> findOne(Long id) {
        log.debug("Request to get ProcessEntryExit : {}", id);
        return processEntryExitRepository.findById(id)
            .map(processEntryExitMapper::toDto);
    }

    /**
     * Delete the processEntryExit by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessEntryExit : {}", id);
        processEntryExitRepository.deleteById(id);
    }
}
