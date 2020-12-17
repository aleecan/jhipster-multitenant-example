package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Weekly;
import com.mikado.multitenant.repository.tenant.WeeklyRepository;
import com.mikado.multitenant.service.dto.tenant.WeeklyDTO;
import com.mikado.multitenant.service.mapper.tenant.WeeklyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Weekly}.
 */
@Service
@Transactional
public class WeeklyService {

    private final Logger log = LoggerFactory.getLogger(WeeklyService.class);

    private final WeeklyRepository weeklyRepository;

    private final WeeklyMapper weeklyMapper;

    public WeeklyService(WeeklyRepository weeklyRepository, WeeklyMapper weeklyMapper) {
        this.weeklyRepository = weeklyRepository;
        this.weeklyMapper = weeklyMapper;
    }

    /**
     * Save a weekly.
     *
     * @param weeklyDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyDTO save(WeeklyDTO weeklyDTO) {
        log.debug("Request to save Weekly : {}", weeklyDTO);
        Weekly weekly = weeklyMapper.toEntity(weeklyDTO);
        weekly = weeklyRepository.save(weekly);
        return weeklyMapper.toDto(weekly);
    }

    /**
     * Get all the weeklies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Weeklies");
        return weeklyRepository.findAll(pageable)
            .map(weeklyMapper::toDto);
    }


    /**
     * Get one weekly by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyDTO> findOne(Long id) {
        log.debug("Request to get Weekly : {}", id);
        return weeklyRepository.findById(id)
            .map(weeklyMapper::toDto);
    }

    /**
     * Delete the weekly by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Weekly : {}", id);
        weeklyRepository.deleteById(id);
    }
}
