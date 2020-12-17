package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.WorkContract;
import com.mikado.multitenant.repository.tenant.WorkContractRepository;
import com.mikado.multitenant.service.dto.tenant.WorkContractDTO;
import com.mikado.multitenant.service.mapper.tenant.WorkContractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WorkContract}.
 */
@Service
@Transactional
public class WorkContractService {

    private final Logger log = LoggerFactory.getLogger(WorkContractService.class);

    private final WorkContractRepository workContractRepository;

    private final WorkContractMapper workContractMapper;

    public WorkContractService(WorkContractRepository workContractRepository, WorkContractMapper workContractMapper) {
        this.workContractRepository = workContractRepository;
        this.workContractMapper = workContractMapper;
    }

    /**
     * Save a workContract.
     *
     * @param workContractDTO the entity to save.
     * @return the persisted entity.
     */
    public WorkContractDTO save(WorkContractDTO workContractDTO) {
        log.debug("Request to save WorkContract : {}", workContractDTO);
        WorkContract workContract = workContractMapper.toEntity(workContractDTO);
        workContract = workContractRepository.save(workContract);
        return workContractMapper.toDto(workContract);
    }

    /**
     * Get all the workContracts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WorkContractDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WorkContracts");
        return workContractRepository.findAll(pageable)
            .map(workContractMapper::toDto);
    }


    /**
     * Get one workContract by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WorkContractDTO> findOne(Long id) {
        log.debug("Request to get WorkContract : {}", id);
        return workContractRepository.findById(id)
            .map(workContractMapper::toDto);
    }

    /**
     * Delete the workContract by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WorkContract : {}", id);
        workContractRepository.deleteById(id);
    }
}
