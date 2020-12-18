package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.DailyTask;
import com.mikado.mikadosaas.repository.tenant.DailyTaskRepository;
import com.mikado.mikadosaas.service.dto.tenant.DailyTaskDTO;
import com.mikado.mikadosaas.service.mapper.tenant.DailyTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DailyTask}.
 */
@Service
@Transactional
public class DailyTaskService {

    private final Logger log = LoggerFactory.getLogger(DailyTaskService.class);

    private final DailyTaskRepository dailyTaskRepository;

    private final DailyTaskMapper dailyTaskMapper;

    public DailyTaskService(DailyTaskRepository dailyTaskRepository, DailyTaskMapper dailyTaskMapper) {
        this.dailyTaskRepository = dailyTaskRepository;
        this.dailyTaskMapper = dailyTaskMapper;
    }

    /**
     * Save a dailyTask.
     *
     * @param dailyTaskDTO the entity to save.
     * @return the persisted entity.
     */
    public DailyTaskDTO save(DailyTaskDTO dailyTaskDTO) {
        log.debug("Request to save DailyTask : {}", dailyTaskDTO);
        DailyTask dailyTask = dailyTaskMapper.toEntity(dailyTaskDTO);
        dailyTask = dailyTaskRepository.save(dailyTask);
        return dailyTaskMapper.toDto(dailyTask);
    }

    /**
     * Get all the dailyTasks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DailyTaskDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DailyTasks");
        return dailyTaskRepository.findAll(pageable)
            .map(dailyTaskMapper::toDto);
    }


    /**
     * Get one dailyTask by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DailyTaskDTO> findOne(Long id) {
        log.debug("Request to get DailyTask : {}", id);
        return dailyTaskRepository.findById(id)
            .map(dailyTaskMapper::toDto);
    }

    /**
     * Delete the dailyTask by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DailyTask : {}", id);
        dailyTaskRepository.deleteById(id);
    }
}
