package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.SchedulerHistory;
import com.mikado.mikadosaas.repository.tenant.SchedulerHistoryRepository;
import com.mikado.mikadosaas.service.dto.tenant.SchedulerHistoryDTO;
import com.mikado.mikadosaas.service.mapper.tenant.SchedulerHistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SchedulerHistory}.
 */
@Service
@Transactional
public class SchedulerHistoryService {

    private final Logger log = LoggerFactory.getLogger(SchedulerHistoryService.class);

    private final SchedulerHistoryRepository schedulerHistoryRepository;

    private final SchedulerHistoryMapper schedulerHistoryMapper;

    public SchedulerHistoryService(SchedulerHistoryRepository schedulerHistoryRepository, SchedulerHistoryMapper schedulerHistoryMapper) {
        this.schedulerHistoryRepository = schedulerHistoryRepository;
        this.schedulerHistoryMapper = schedulerHistoryMapper;
    }

    /**
     * Save a schedulerHistory.
     *
     * @param schedulerHistoryDTO the entity to save.
     * @return the persisted entity.
     */
    public SchedulerHistoryDTO save(SchedulerHistoryDTO schedulerHistoryDTO) {
        log.debug("Request to save SchedulerHistory : {}", schedulerHistoryDTO);
        SchedulerHistory schedulerHistory = schedulerHistoryMapper.toEntity(schedulerHistoryDTO);
        schedulerHistory = schedulerHistoryRepository.save(schedulerHistory);
        return schedulerHistoryMapper.toDto(schedulerHistory);
    }

    /**
     * Get all the schedulerHistories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<SchedulerHistoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SchedulerHistories");
        return schedulerHistoryRepository.findAll(pageable)
            .map(schedulerHistoryMapper::toDto);
    }


    /**
     * Get one schedulerHistory by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SchedulerHistoryDTO> findOne(Long id) {
        log.debug("Request to get SchedulerHistory : {}", id);
        return schedulerHistoryRepository.findById(id)
            .map(schedulerHistoryMapper::toDto);
    }

    /**
     * Delete the schedulerHistory by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SchedulerHistory : {}", id);
        schedulerHistoryRepository.deleteById(id);
    }
}
