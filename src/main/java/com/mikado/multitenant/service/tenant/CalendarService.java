package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Calendar;
import com.mikado.multitenant.repository.tenant.CalendarRepository;
import com.mikado.multitenant.service.dto.tenant.CalendarDTO;
import com.mikado.multitenant.service.mapper.tenant.CalendarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Calendar}.
 */
@Service
@Transactional
public class CalendarService {

    private final Logger log = LoggerFactory.getLogger(CalendarService.class);

    private final CalendarRepository calendarRepository;

    private final CalendarMapper calendarMapper;

    public CalendarService(CalendarRepository calendarRepository, CalendarMapper calendarMapper) {
        this.calendarRepository = calendarRepository;
        this.calendarMapper = calendarMapper;
    }

    /**
     * Save a calendar.
     *
     * @param calendarDTO the entity to save.
     * @return the persisted entity.
     */
    public CalendarDTO save(CalendarDTO calendarDTO) {
        log.debug("Request to save Calendar : {}", calendarDTO);
        Calendar calendar = calendarMapper.toEntity(calendarDTO);
        calendar = calendarRepository.save(calendar);
        return calendarMapper.toDto(calendar);
    }

    /**
     * Get all the calendars.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CalendarDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Calendars");
        return calendarRepository.findAll(pageable)
            .map(calendarMapper::toDto);
    }


    /**
     * Get one calendar by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CalendarDTO> findOne(Long id) {
        log.debug("Request to get Calendar : {}", id);
        return calendarRepository.findById(id)
            .map(calendarMapper::toDto);
    }

    /**
     * Delete the calendar by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Calendar : {}", id);
        calendarRepository.deleteById(id);
    }
}
