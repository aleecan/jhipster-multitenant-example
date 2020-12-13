package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveTotal;
import com.mikado.multitenant.repository.tenant.AnnualLeaveTotalRepository;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveTotalDTO;
import com.mikado.multitenant.service.mapper.tenant.AnnualLeaveTotalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeaveTotal}.
 */
@Service
@Transactional
public class AnnualLeaveTotalService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveTotalService.class);

    private final AnnualLeaveTotalRepository annualLeaveTotalRepository;

    private final AnnualLeaveTotalMapper annualLeaveTotalMapper;

    public AnnualLeaveTotalService(AnnualLeaveTotalRepository annualLeaveTotalRepository, AnnualLeaveTotalMapper annualLeaveTotalMapper) {
        this.annualLeaveTotalRepository = annualLeaveTotalRepository;
        this.annualLeaveTotalMapper = annualLeaveTotalMapper;
    }

    /**
     * Save a annualLeaveTotal.
     *
     * @param annualLeaveTotalDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveTotalDTO save(AnnualLeaveTotalDTO annualLeaveTotalDTO) {
        log.debug("Request to save AnnualLeaveTotal : {}", annualLeaveTotalDTO);
        AnnualLeaveTotal annualLeaveTotal = annualLeaveTotalMapper.toEntity(annualLeaveTotalDTO);
        annualLeaveTotal = annualLeaveTotalRepository.save(annualLeaveTotal);
        return annualLeaveTotalMapper.toDto(annualLeaveTotal);
    }

    /**
     * Get all the annualLeaveTotals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveTotalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaveTotals");
        return annualLeaveTotalRepository.findAll(pageable)
            .map(annualLeaveTotalMapper::toDto);
    }


    /**
     * Get one annualLeaveTotal by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveTotalDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeaveTotal : {}", id);
        return annualLeaveTotalRepository.findById(id)
            .map(annualLeaveTotalMapper::toDto);
    }

    /**
     * Delete the annualLeaveTotal by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeaveTotal : {}", id);
        annualLeaveTotalRepository.deleteById(id);
    }
}
