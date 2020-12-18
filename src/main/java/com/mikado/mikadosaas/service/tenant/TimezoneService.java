package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Timezone;
import com.mikado.mikadosaas.repository.tenant.TimezoneRepository;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TimezoneMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Timezone}.
 */
@Service
@Transactional
public class TimezoneService {

    private final Logger log = LoggerFactory.getLogger(TimezoneService.class);

    private final TimezoneRepository timezoneRepository;

    private final TimezoneMapper timezoneMapper;

    public TimezoneService(TimezoneRepository timezoneRepository, TimezoneMapper timezoneMapper) {
        this.timezoneRepository = timezoneRepository;
        this.timezoneMapper = timezoneMapper;
    }

    /**
     * Save a timezone.
     *
     * @param timezoneDTO the entity to save.
     * @return the persisted entity.
     */
    public TimezoneDTO save(TimezoneDTO timezoneDTO) {
        log.debug("Request to save Timezone : {}", timezoneDTO);
        Timezone timezone = timezoneMapper.toEntity(timezoneDTO);
        timezone = timezoneRepository.save(timezone);
        return timezoneMapper.toDto(timezone);
    }

    /**
     * Get all the timezones.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TimezoneDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Timezones");
        return timezoneRepository.findAll(pageable)
            .map(timezoneMapper::toDto);
    }


    /**
     * Get one timezone by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TimezoneDTO> findOne(Long id) {
        log.debug("Request to get Timezone : {}", id);
        return timezoneRepository.findById(id)
            .map(timezoneMapper::toDto);
    }

    /**
     * Delete the timezone by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Timezone : {}", id);
        timezoneRepository.deleteById(id);
    }
}
