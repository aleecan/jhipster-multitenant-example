package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.CostCenter;
import com.mikado.multitenant.repository.tenant.CostCenterRepository;
import com.mikado.multitenant.service.dto.tenant.CostCenterDTO;
import com.mikado.multitenant.service.mapper.tenant.CostCenterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CostCenter}.
 */
@Service
@Transactional
public class CostCenterService {

    private final Logger log = LoggerFactory.getLogger(CostCenterService.class);

    private final CostCenterRepository costCenterRepository;

    private final CostCenterMapper costCenterMapper;

    public CostCenterService(CostCenterRepository costCenterRepository, CostCenterMapper costCenterMapper) {
        this.costCenterRepository = costCenterRepository;
        this.costCenterMapper = costCenterMapper;
    }

    /**
     * Save a costCenter.
     *
     * @param costCenterDTO the entity to save.
     * @return the persisted entity.
     */
    public CostCenterDTO save(CostCenterDTO costCenterDTO) {
        log.debug("Request to save CostCenter : {}", costCenterDTO);
        CostCenter costCenter = costCenterMapper.toEntity(costCenterDTO);
        costCenter = costCenterRepository.save(costCenter);
        return costCenterMapper.toDto(costCenter);
    }

    /**
     * Get all the costCenters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CostCenterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CostCenters");
        return costCenterRepository.findAll(pageable)
            .map(costCenterMapper::toDto);
    }


    /**
     * Get one costCenter by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CostCenterDTO> findOne(Long id) {
        log.debug("Request to get CostCenter : {}", id);
        return costCenterRepository.findById(id)
            .map(costCenterMapper::toDto);
    }

    /**
     * Delete the costCenter by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CostCenter : {}", id);
        costCenterRepository.deleteById(id);
    }
}
