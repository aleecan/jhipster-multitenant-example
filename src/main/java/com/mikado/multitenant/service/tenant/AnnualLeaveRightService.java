package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveRight;
import com.mikado.multitenant.repository.tenant.AnnualLeaveRightRepository;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveRightDTO;
import com.mikado.multitenant.service.mapper.tenant.AnnualLeaveRightMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeaveRight}.
 */
@Service
@Transactional
public class AnnualLeaveRightService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveRightService.class);

    private final AnnualLeaveRightRepository annualLeaveRightRepository;

    private final AnnualLeaveRightMapper annualLeaveRightMapper;

    public AnnualLeaveRightService(AnnualLeaveRightRepository annualLeaveRightRepository, AnnualLeaveRightMapper annualLeaveRightMapper) {
        this.annualLeaveRightRepository = annualLeaveRightRepository;
        this.annualLeaveRightMapper = annualLeaveRightMapper;
    }

    /**
     * Save a annualLeaveRight.
     *
     * @param annualLeaveRightDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveRightDTO save(AnnualLeaveRightDTO annualLeaveRightDTO) {
        log.debug("Request to save AnnualLeaveRight : {}", annualLeaveRightDTO);
        AnnualLeaveRight annualLeaveRight = annualLeaveRightMapper.toEntity(annualLeaveRightDTO);
        annualLeaveRight = annualLeaveRightRepository.save(annualLeaveRight);
        return annualLeaveRightMapper.toDto(annualLeaveRight);
    }

    /**
     * Get all the annualLeaveRights.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveRightDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaveRights");
        return annualLeaveRightRepository.findAll(pageable)
            .map(annualLeaveRightMapper::toDto);
    }


    /**
     * Get one annualLeaveRight by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveRightDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeaveRight : {}", id);
        return annualLeaveRightRepository.findById(id)
            .map(annualLeaveRightMapper::toDto);
    }

    /**
     * Delete the annualLeaveRight by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeaveRight : {}", id);
        annualLeaveRightRepository.deleteById(id);
    }
}
