package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.CalendarHoliday;
import com.mikado.mikadosaas.repository.tenant.CalendarHolidayRepository;
import com.mikado.mikadosaas.service.dto.tenant.CalendarHolidayDTO;
import com.mikado.mikadosaas.service.mapper.tenant.CalendarHolidayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CalendarHoliday}.
 */
@Service
@Transactional
public class CalendarHolidayService {

    private final Logger log = LoggerFactory.getLogger(CalendarHolidayService.class);

    private final CalendarHolidayRepository calendarHolidayRepository;

    private final CalendarHolidayMapper calendarHolidayMapper;

    public CalendarHolidayService(CalendarHolidayRepository calendarHolidayRepository, CalendarHolidayMapper calendarHolidayMapper) {
        this.calendarHolidayRepository = calendarHolidayRepository;
        this.calendarHolidayMapper = calendarHolidayMapper;
    }

    /**
     * Save a calendarHoliday.
     *
     * @param calendarHolidayDTO the entity to save.
     * @return the persisted entity.
     */
    public CalendarHolidayDTO save(CalendarHolidayDTO calendarHolidayDTO) {
        log.debug("Request to save CalendarHoliday : {}", calendarHolidayDTO);
        CalendarHoliday calendarHoliday = calendarHolidayMapper.toEntity(calendarHolidayDTO);
        calendarHoliday = calendarHolidayRepository.save(calendarHoliday);
        return calendarHolidayMapper.toDto(calendarHoliday);
    }

    /**
     * Get all the calendarHolidays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CalendarHolidayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CalendarHolidays");
        return calendarHolidayRepository.findAll(pageable)
            .map(calendarHolidayMapper::toDto);
    }


    /**
     * Get one calendarHoliday by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CalendarHolidayDTO> findOne(Long id) {
        log.debug("Request to get CalendarHoliday : {}", id);
        return calendarHolidayRepository.findById(id)
            .map(calendarHolidayMapper::toDto);
    }

    /**
     * Delete the calendarHoliday by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CalendarHoliday : {}", id);
        calendarHolidayRepository.deleteById(id);
    }
}
