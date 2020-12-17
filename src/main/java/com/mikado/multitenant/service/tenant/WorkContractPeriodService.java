package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.WorkContractPeriod;
import com.mikado.multitenant.repository.tenant.WorkContractPeriodRepository;
import com.mikado.multitenant.service.dto.tenant.WorkContractPeriodDTO;
import com.mikado.multitenant.service.mapper.tenant.WorkContractPeriodMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WorkContractPeriod}.
 */
@Service
@Transactional
public class WorkContractPeriodService {

    private final Logger log = LoggerFactory.getLogger(WorkContractPeriodService.class);

    private final WorkContractPeriodRepository workContractPeriodRepository;

    private final WorkContractPeriodMapper workContractPeriodMapper;

    public WorkContractPeriodService(WorkContractPeriodRepository workContractPeriodRepository, WorkContractPeriodMapper workContractPeriodMapper) {
        this.workContractPeriodRepository = workContractPeriodRepository;
        this.workContractPeriodMapper = workContractPeriodMapper;
    }

    /**
     * Save a workContractPeriod.
     *
     * @param workContractPeriodDTO the entity to save.
     * @return the persisted entity.
     */
    public WorkContractPeriodDTO save(WorkContractPeriodDTO workContractPeriodDTO) {
        log.debug("Request to save WorkContractPeriod : {}", workContractPeriodDTO);
        WorkContractPeriod workContractPeriod = workContractPeriodMapper.toEntity(workContractPeriodDTO);
        workContractPeriod = workContractPeriodRepository.save(workContractPeriod);
        return workContractPeriodMapper.toDto(workContractPeriod);
    }

    /**
     * Get all the workContractPeriods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WorkContractPeriodDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WorkContractPeriods");
        return workContractPeriodRepository.findAll(pageable)
            .map(workContractPeriodMapper::toDto);
    }


    /**
     * Get one workContractPeriod by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WorkContractPeriodDTO> findOne(Long id) {
        log.debug("Request to get WorkContractPeriod : {}", id);
        return workContractPeriodRepository.findById(id)
            .map(workContractPeriodMapper::toDto);
    }

    /**
     * Delete the workContractPeriod by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WorkContractPeriod : {}", id);
        workContractPeriodRepository.deleteById(id);
    }
}
