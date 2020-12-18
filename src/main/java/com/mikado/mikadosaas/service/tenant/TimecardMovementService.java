package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.TimecardMovement;
import com.mikado.mikadosaas.repository.tenant.TimecardMovementRepository;
import com.mikado.mikadosaas.service.dto.tenant.TimecardMovementDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TimecardMovementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TimecardMovement}.
 */
@Service
@Transactional
public class TimecardMovementService {

    private final Logger log = LoggerFactory.getLogger(TimecardMovementService.class);

    private final TimecardMovementRepository timecardMovementRepository;

    private final TimecardMovementMapper timecardMovementMapper;

    public TimecardMovementService(TimecardMovementRepository timecardMovementRepository, TimecardMovementMapper timecardMovementMapper) {
        this.timecardMovementRepository = timecardMovementRepository;
        this.timecardMovementMapper = timecardMovementMapper;
    }

    /**
     * Save a timecardMovement.
     *
     * @param timecardMovementDTO the entity to save.
     * @return the persisted entity.
     */
    public TimecardMovementDTO save(TimecardMovementDTO timecardMovementDTO) {
        log.debug("Request to save TimecardMovement : {}", timecardMovementDTO);
        TimecardMovement timecardMovement = timecardMovementMapper.toEntity(timecardMovementDTO);
        timecardMovement = timecardMovementRepository.save(timecardMovement);
        return timecardMovementMapper.toDto(timecardMovement);
    }

    /**
     * Get all the timecardMovements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TimecardMovementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TimecardMovements");
        return timecardMovementRepository.findAll(pageable)
            .map(timecardMovementMapper::toDto);
    }


    /**
     * Get one timecardMovement by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TimecardMovementDTO> findOne(Long id) {
        log.debug("Request to get TimecardMovement : {}", id);
        return timecardMovementRepository.findById(id)
            .map(timecardMovementMapper::toDto);
    }

    /**
     * Delete the timecardMovement by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TimecardMovement : {}", id);
        timecardMovementRepository.deleteById(id);
    }
}
