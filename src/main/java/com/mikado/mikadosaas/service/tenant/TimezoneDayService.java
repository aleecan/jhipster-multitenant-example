package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.TimezoneDay;
import com.mikado.mikadosaas.repository.tenant.TimezoneDayRepository;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneDayDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TimezoneDayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TimezoneDay}.
 */
@Service
@Transactional
public class TimezoneDayService {

    private final Logger log = LoggerFactory.getLogger(TimezoneDayService.class);

    private final TimezoneDayRepository timezoneDayRepository;

    private final TimezoneDayMapper timezoneDayMapper;

    public TimezoneDayService(TimezoneDayRepository timezoneDayRepository, TimezoneDayMapper timezoneDayMapper) {
        this.timezoneDayRepository = timezoneDayRepository;
        this.timezoneDayMapper = timezoneDayMapper;
    }

    /**
     * Save a timezoneDay.
     *
     * @param timezoneDayDTO the entity to save.
     * @return the persisted entity.
     */
    public TimezoneDayDTO save(TimezoneDayDTO timezoneDayDTO) {
        log.debug("Request to save TimezoneDay : {}", timezoneDayDTO);
        TimezoneDay timezoneDay = timezoneDayMapper.toEntity(timezoneDayDTO);
        timezoneDay = timezoneDayRepository.save(timezoneDay);
        return timezoneDayMapper.toDto(timezoneDay);
    }

    /**
     * Get all the timezoneDays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TimezoneDayDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TimezoneDays");
        return timezoneDayRepository.findAll(pageable)
            .map(timezoneDayMapper::toDto);
    }


    /**
     * Get one timezoneDay by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TimezoneDayDTO> findOne(Long id) {
        log.debug("Request to get TimezoneDay : {}", id);
        return timezoneDayRepository.findById(id)
            .map(timezoneDayMapper::toDto);
    }

    /**
     * Delete the timezoneDay by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TimezoneDay : {}", id);
        timezoneDayRepository.deleteById(id);
    }
}
