package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyTask;
import com.mikado.mikadosaas.repository.tenant.WeeklyTaskRepository;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyTaskDTO;
import com.mikado.mikadosaas.service.mapper.tenant.WeeklyTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WeeklyTask}.
 */
@Service
@Transactional
public class WeeklyTaskService {

    private final Logger log = LoggerFactory.getLogger(WeeklyTaskService.class);

    private final WeeklyTaskRepository weeklyTaskRepository;

    private final WeeklyTaskMapper weeklyTaskMapper;

    public WeeklyTaskService(WeeklyTaskRepository weeklyTaskRepository, WeeklyTaskMapper weeklyTaskMapper) {
        this.weeklyTaskRepository = weeklyTaskRepository;
        this.weeklyTaskMapper = weeklyTaskMapper;
    }

    /**
     * Save a weeklyTask.
     *
     * @param weeklyTaskDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyTaskDTO save(WeeklyTaskDTO weeklyTaskDTO) {
        log.debug("Request to save WeeklyTask : {}", weeklyTaskDTO);
        WeeklyTask weeklyTask = weeklyTaskMapper.toEntity(weeklyTaskDTO);
        weeklyTask = weeklyTaskRepository.save(weeklyTask);
        return weeklyTaskMapper.toDto(weeklyTask);
    }

    /**
     * Get all the weeklyTasks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyTaskDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WeeklyTasks");
        return weeklyTaskRepository.findAll(pageable)
            .map(weeklyTaskMapper::toDto);
    }


    /**
     * Get one weeklyTask by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyTaskDTO> findOne(Long id) {
        log.debug("Request to get WeeklyTask : {}", id);
        return weeklyTaskRepository.findById(id)
            .map(weeklyTaskMapper::toDto);
    }

    /**
     * Delete the weeklyTask by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WeeklyTask : {}", id);
        weeklyTaskRepository.deleteById(id);
    }
}
