package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.AnnualLeave;
import com.mikado.mikadosaas.repository.tenant.AnnualLeaveRepository;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveDTO;
import com.mikado.mikadosaas.service.mapper.tenant.AnnualLeaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeave}.
 */
@Service
@Transactional
public class AnnualLeaveService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveService.class);

    private final AnnualLeaveRepository annualLeaveRepository;

    private final AnnualLeaveMapper annualLeaveMapper;

    public AnnualLeaveService(AnnualLeaveRepository annualLeaveRepository, AnnualLeaveMapper annualLeaveMapper) {
        this.annualLeaveRepository = annualLeaveRepository;
        this.annualLeaveMapper = annualLeaveMapper;
    }

    /**
     * Save a annualLeave.
     *
     * @param annualLeaveDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveDTO save(AnnualLeaveDTO annualLeaveDTO) {
        log.debug("Request to save AnnualLeave : {}", annualLeaveDTO);
        AnnualLeave annualLeave = annualLeaveMapper.toEntity(annualLeaveDTO);
        annualLeave = annualLeaveRepository.save(annualLeave);
        return annualLeaveMapper.toDto(annualLeave);
    }

    /**
     * Get all the annualLeaves.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaves");
        return annualLeaveRepository.findAll(pageable)
            .map(annualLeaveMapper::toDto);
    }


    /**
     * Get one annualLeave by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeave : {}", id);
        return annualLeaveRepository.findById(id)
            .map(annualLeaveMapper::toDto);
    }

    /**
     * Delete the annualLeave by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeave : {}", id);
        annualLeaveRepository.deleteById(id);
    }
}
