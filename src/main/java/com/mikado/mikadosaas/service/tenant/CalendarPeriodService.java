package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.CalendarPeriod;
import com.mikado.mikadosaas.repository.tenant.CalendarPeriodRepository;
import com.mikado.mikadosaas.service.dto.tenant.CalendarPeriodDTO;
import com.mikado.mikadosaas.service.mapper.tenant.CalendarPeriodMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CalendarPeriod}.
 */
@Service
@Transactional
public class CalendarPeriodService {

    private final Logger log = LoggerFactory.getLogger(CalendarPeriodService.class);

    private final CalendarPeriodRepository calendarPeriodRepository;

    private final CalendarPeriodMapper calendarPeriodMapper;

    public CalendarPeriodService(CalendarPeriodRepository calendarPeriodRepository, CalendarPeriodMapper calendarPeriodMapper) {
        this.calendarPeriodRepository = calendarPeriodRepository;
        this.calendarPeriodMapper = calendarPeriodMapper;
    }

    /**
     * Save a calendarPeriod.
     *
     * @param calendarPeriodDTO the entity to save.
     * @return the persisted entity.
     */
    public CalendarPeriodDTO save(CalendarPeriodDTO calendarPeriodDTO) {
        log.debug("Request to save CalendarPeriod : {}", calendarPeriodDTO);
        CalendarPeriod calendarPeriod = calendarPeriodMapper.toEntity(calendarPeriodDTO);
        calendarPeriod = calendarPeriodRepository.save(calendarPeriod);
        return calendarPeriodMapper.toDto(calendarPeriod);
    }

    /**
     * Get all the calendarPeriods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CalendarPeriodDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CalendarPeriods");
        return calendarPeriodRepository.findAll(pageable)
            .map(calendarPeriodMapper::toDto);
    }


    /**
     * Get one calendarPeriod by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CalendarPeriodDTO> findOne(Long id) {
        log.debug("Request to get CalendarPeriod : {}", id);
        return calendarPeriodRepository.findById(id)
            .map(calendarPeriodMapper::toDto);
    }

    /**
     * Delete the calendarPeriod by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CalendarPeriod : {}", id);
        calendarPeriodRepository.deleteById(id);
    }
}
