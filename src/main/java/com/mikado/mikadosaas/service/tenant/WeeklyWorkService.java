package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.WeeklyWork;
import com.mikado.mikadosaas.repository.tenant.WeeklyWorkRepository;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyWorkDTO;
import com.mikado.mikadosaas.service.mapper.tenant.WeeklyWorkMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WeeklyWork}.
 */
@Service
@Transactional
public class WeeklyWorkService {

    private final Logger log = LoggerFactory.getLogger(WeeklyWorkService.class);

    private final WeeklyWorkRepository weeklyWorkRepository;

    private final WeeklyWorkMapper weeklyWorkMapper;

    public WeeklyWorkService(WeeklyWorkRepository weeklyWorkRepository, WeeklyWorkMapper weeklyWorkMapper) {
        this.weeklyWorkRepository = weeklyWorkRepository;
        this.weeklyWorkMapper = weeklyWorkMapper;
    }

    /**
     * Save a weeklyWork.
     *
     * @param weeklyWorkDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyWorkDTO save(WeeklyWorkDTO weeklyWorkDTO) {
        log.debug("Request to save WeeklyWork : {}", weeklyWorkDTO);
        WeeklyWork weeklyWork = weeklyWorkMapper.toEntity(weeklyWorkDTO);
        weeklyWork = weeklyWorkRepository.save(weeklyWork);
        return weeklyWorkMapper.toDto(weeklyWork);
    }

    /**
     * Get all the weeklyWorks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyWorkDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WeeklyWorks");
        return weeklyWorkRepository.findAll(pageable)
            .map(weeklyWorkMapper::toDto);
    }


    /**
     * Get one weeklyWork by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyWorkDTO> findOne(Long id) {
        log.debug("Request to get WeeklyWork : {}", id);
        return weeklyWorkRepository.findById(id)
            .map(weeklyWorkMapper::toDto);
    }

    /**
     * Delete the weeklyWork by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WeeklyWork : {}", id);
        weeklyWorkRepository.deleteById(id);
    }
}
