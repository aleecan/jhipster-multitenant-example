package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.TimezoneRights;
import com.mikado.multitenant.repository.tenant.TimezoneRightsRepository;
import com.mikado.multitenant.service.dto.tenant.TimezoneRightsDTO;
import com.mikado.multitenant.service.mapper.tenant.TimezoneRightsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TimezoneRights}.
 */
@Service
@Transactional
public class TimezoneRightsService {

    private final Logger log = LoggerFactory.getLogger(TimezoneRightsService.class);

    private final TimezoneRightsRepository timezoneRightsRepository;

    private final TimezoneRightsMapper timezoneRightsMapper;

    public TimezoneRightsService(TimezoneRightsRepository timezoneRightsRepository, TimezoneRightsMapper timezoneRightsMapper) {
        this.timezoneRightsRepository = timezoneRightsRepository;
        this.timezoneRightsMapper = timezoneRightsMapper;
    }

    /**
     * Save a timezoneRights.
     *
     * @param timezoneRightsDTO the entity to save.
     * @return the persisted entity.
     */
    public TimezoneRightsDTO save(TimezoneRightsDTO timezoneRightsDTO) {
        log.debug("Request to save TimezoneRights : {}", timezoneRightsDTO);
        TimezoneRights timezoneRights = timezoneRightsMapper.toEntity(timezoneRightsDTO);
        timezoneRights = timezoneRightsRepository.save(timezoneRights);
        return timezoneRightsMapper.toDto(timezoneRights);
    }

    /**
     * Get all the timezoneRights.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TimezoneRightsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TimezoneRights");
        return timezoneRightsRepository.findAll(pageable)
            .map(timezoneRightsMapper::toDto);
    }


    /**
     * Get one timezoneRights by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TimezoneRightsDTO> findOne(Long id) {
        log.debug("Request to get TimezoneRights : {}", id);
        return timezoneRightsRepository.findById(id)
            .map(timezoneRightsMapper::toDto);
    }

    /**
     * Delete the timezoneRights by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TimezoneRights : {}", id);
        timezoneRightsRepository.deleteById(id);
    }
}
