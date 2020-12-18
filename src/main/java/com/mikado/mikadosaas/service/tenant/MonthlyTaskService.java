package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyTask;
import com.mikado.mikadosaas.repository.tenant.MonthlyTaskRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyTaskDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlyTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyTask}.
 */
@Service
@Transactional
public class MonthlyTaskService {

    private final Logger log = LoggerFactory.getLogger(MonthlyTaskService.class);

    private final MonthlyTaskRepository monthlyTaskRepository;

    private final MonthlyTaskMapper monthlyTaskMapper;

    public MonthlyTaskService(MonthlyTaskRepository monthlyTaskRepository, MonthlyTaskMapper monthlyTaskMapper) {
        this.monthlyTaskRepository = monthlyTaskRepository;
        this.monthlyTaskMapper = monthlyTaskMapper;
    }

    /**
     * Save a monthlyTask.
     *
     * @param monthlyTaskDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyTaskDTO save(MonthlyTaskDTO monthlyTaskDTO) {
        log.debug("Request to save MonthlyTask : {}", monthlyTaskDTO);
        MonthlyTask monthlyTask = monthlyTaskMapper.toEntity(monthlyTaskDTO);
        monthlyTask = monthlyTaskRepository.save(monthlyTask);
        return monthlyTaskMapper.toDto(monthlyTask);
    }

    /**
     * Get all the monthlyTasks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyTaskDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyTasks");
        return monthlyTaskRepository.findAll(pageable)
            .map(monthlyTaskMapper::toDto);
    }


    /**
     * Get one monthlyTask by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyTaskDTO> findOne(Long id) {
        log.debug("Request to get MonthlyTask : {}", id);
        return monthlyTaskRepository.findById(id)
            .map(monthlyTaskMapper::toDto);
    }

    /**
     * Delete the monthlyTask by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyTask : {}", id);
        monthlyTaskRepository.deleteById(id);
    }
}
