package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.VwTimecardMovement;
import com.mikado.multitenant.repository.tenant.VwTimecardMovementRepository;
import com.mikado.multitenant.service.dto.tenant.VwTimecardMovementDTO;
import com.mikado.multitenant.service.mapper.tenant.VwTimecardMovementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VwTimecardMovement}.
 */
@Service
@Transactional
public class VwTimecardMovementService {

    private final Logger log = LoggerFactory.getLogger(VwTimecardMovementService.class);

    private final VwTimecardMovementRepository vwTimecardMovementRepository;

    private final VwTimecardMovementMapper vwTimecardMovementMapper;

    public VwTimecardMovementService(VwTimecardMovementRepository vwTimecardMovementRepository, VwTimecardMovementMapper vwTimecardMovementMapper) {
        this.vwTimecardMovementRepository = vwTimecardMovementRepository;
        this.vwTimecardMovementMapper = vwTimecardMovementMapper;
    }

    /**
     * Save a vwTimecardMovement.
     *
     * @param vwTimecardMovementDTO the entity to save.
     * @return the persisted entity.
     */
    public VwTimecardMovementDTO save(VwTimecardMovementDTO vwTimecardMovementDTO) {
        log.debug("Request to save VwTimecardMovement : {}", vwTimecardMovementDTO);
        VwTimecardMovement vwTimecardMovement = vwTimecardMovementMapper.toEntity(vwTimecardMovementDTO);
        vwTimecardMovement = vwTimecardMovementRepository.save(vwTimecardMovement);
        return vwTimecardMovementMapper.toDto(vwTimecardMovement);
    }

    /**
     * Get all the vwTimecardMovements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<VwTimecardMovementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VwTimecardMovements");
        return vwTimecardMovementRepository.findAll(pageable)
            .map(vwTimecardMovementMapper::toDto);
    }


    /**
     * Get one vwTimecardMovement by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VwTimecardMovementDTO> findOne(Long id) {
        log.debug("Request to get VwTimecardMovement : {}", id);
        return vwTimecardMovementRepository.findById(id)
            .map(vwTimecardMovementMapper::toDto);
    }

    /**
     * Delete the vwTimecardMovement by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete VwTimecardMovement : {}", id);
        vwTimecardMovementRepository.deleteById(id);
    }
}
