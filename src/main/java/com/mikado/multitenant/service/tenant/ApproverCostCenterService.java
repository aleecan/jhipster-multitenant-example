package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ApproverCostCenter;
import com.mikado.multitenant.repository.tenant.ApproverCostCenterRepository;
import com.mikado.multitenant.service.dto.tenant.ApproverCostCenterDTO;
import com.mikado.multitenant.service.mapper.tenant.ApproverCostCenterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ApproverCostCenter}.
 */
@Service
@Transactional
public class ApproverCostCenterService {

    private final Logger log = LoggerFactory.getLogger(ApproverCostCenterService.class);

    private final ApproverCostCenterRepository approverCostCenterRepository;

    private final ApproverCostCenterMapper approverCostCenterMapper;

    public ApproverCostCenterService(ApproverCostCenterRepository approverCostCenterRepository, ApproverCostCenterMapper approverCostCenterMapper) {
        this.approverCostCenterRepository = approverCostCenterRepository;
        this.approverCostCenterMapper = approverCostCenterMapper;
    }

    /**
     * Save a approverCostCenter.
     *
     * @param approverCostCenterDTO the entity to save.
     * @return the persisted entity.
     */
    public ApproverCostCenterDTO save(ApproverCostCenterDTO approverCostCenterDTO) {
        log.debug("Request to save ApproverCostCenter : {}", approverCostCenterDTO);
        ApproverCostCenter approverCostCenter = approverCostCenterMapper.toEntity(approverCostCenterDTO);
        approverCostCenter = approverCostCenterRepository.save(approverCostCenter);
        return approverCostCenterMapper.toDto(approverCostCenter);
    }

    /**
     * Get all the approverCostCenters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ApproverCostCenterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ApproverCostCenters");
        return approverCostCenterRepository.findAll(pageable)
            .map(approverCostCenterMapper::toDto);
    }


    /**
     * Get one approverCostCenter by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ApproverCostCenterDTO> findOne(Long id) {
        log.debug("Request to get ApproverCostCenter : {}", id);
        return approverCostCenterRepository.findById(id)
            .map(approverCostCenterMapper::toDto);
    }

    /**
     * Delete the approverCostCenter by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ApproverCostCenter : {}", id);
        approverCostCenterRepository.deleteById(id);
    }
}
