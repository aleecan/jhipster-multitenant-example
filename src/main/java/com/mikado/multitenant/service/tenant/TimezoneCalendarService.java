package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.TimezoneCalendar;
import com.mikado.multitenant.repository.tenant.TimezoneCalendarRepository;
import com.mikado.multitenant.service.dto.tenant.TimezoneCalendarDTO;
import com.mikado.multitenant.service.mapper.tenant.TimezoneCalendarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TimezoneCalendar}.
 */
@Service
@Transactional
public class TimezoneCalendarService {

    private final Logger log = LoggerFactory.getLogger(TimezoneCalendarService.class);

    private final TimezoneCalendarRepository timezoneCalendarRepository;

    private final TimezoneCalendarMapper timezoneCalendarMapper;

    public TimezoneCalendarService(TimezoneCalendarRepository timezoneCalendarRepository, TimezoneCalendarMapper timezoneCalendarMapper) {
        this.timezoneCalendarRepository = timezoneCalendarRepository;
        this.timezoneCalendarMapper = timezoneCalendarMapper;
    }

    /**
     * Save a timezoneCalendar.
     *
     * @param timezoneCalendarDTO the entity to save.
     * @return the persisted entity.
     */
    public TimezoneCalendarDTO save(TimezoneCalendarDTO timezoneCalendarDTO) {
        log.debug("Request to save TimezoneCalendar : {}", timezoneCalendarDTO);
        TimezoneCalendar timezoneCalendar = timezoneCalendarMapper.toEntity(timezoneCalendarDTO);
        timezoneCalendar = timezoneCalendarRepository.save(timezoneCalendar);
        return timezoneCalendarMapper.toDto(timezoneCalendar);
    }

    /**
     * Get all the timezoneCalendars.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TimezoneCalendarDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TimezoneCalendars");
        return timezoneCalendarRepository.findAll(pageable)
            .map(timezoneCalendarMapper::toDto);
    }


    /**
     * Get one timezoneCalendar by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TimezoneCalendarDTO> findOne(Long id) {
        log.debug("Request to get TimezoneCalendar : {}", id);
        return timezoneCalendarRepository.findById(id)
            .map(timezoneCalendarMapper::toDto);
    }

    /**
     * Delete the timezoneCalendar by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TimezoneCalendar : {}", id);
        timezoneCalendarRepository.deleteById(id);
    }
}
