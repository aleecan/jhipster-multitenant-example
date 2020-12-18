package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.EntryExitTask;
import com.mikado.mikadosaas.repository.tenant.EntryExitTaskRepository;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitTaskDTO;
import com.mikado.mikadosaas.service.mapper.tenant.EntryExitTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EntryExitTask}.
 */
@Service
@Transactional
public class EntryExitTaskService {

    private final Logger log = LoggerFactory.getLogger(EntryExitTaskService.class);

    private final EntryExitTaskRepository entryExitTaskRepository;

    private final EntryExitTaskMapper entryExitTaskMapper;

    public EntryExitTaskService(EntryExitTaskRepository entryExitTaskRepository, EntryExitTaskMapper entryExitTaskMapper) {
        this.entryExitTaskRepository = entryExitTaskRepository;
        this.entryExitTaskMapper = entryExitTaskMapper;
    }

    /**
     * Save a entryExitTask.
     *
     * @param entryExitTaskDTO the entity to save.
     * @return the persisted entity.
     */
    public EntryExitTaskDTO save(EntryExitTaskDTO entryExitTaskDTO) {
        log.debug("Request to save EntryExitTask : {}", entryExitTaskDTO);
        EntryExitTask entryExitTask = entryExitTaskMapper.toEntity(entryExitTaskDTO);
        entryExitTask = entryExitTaskRepository.save(entryExitTask);
        return entryExitTaskMapper.toDto(entryExitTask);
    }

    /**
     * Get all the entryExitTasks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EntryExitTaskDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntryExitTasks");
        return entryExitTaskRepository.findAll(pageable)
            .map(entryExitTaskMapper::toDto);
    }


    /**
     * Get one entryExitTask by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EntryExitTaskDTO> findOne(Long id) {
        log.debug("Request to get EntryExitTask : {}", id);
        return entryExitTaskRepository.findById(id)
            .map(entryExitTaskMapper::toDto);
    }

    /**
     * Delete the entryExitTask by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EntryExitTask : {}", id);
        entryExitTaskRepository.deleteById(id);
    }
}
