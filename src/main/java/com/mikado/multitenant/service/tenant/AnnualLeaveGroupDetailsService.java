package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveGroupDetails;
import com.mikado.multitenant.repository.tenant.AnnualLeaveGroupDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveGroupDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.AnnualLeaveGroupDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeaveGroupDetails}.
 */
@Service
@Transactional
public class AnnualLeaveGroupDetailsService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveGroupDetailsService.class);

    private final AnnualLeaveGroupDetailsRepository annualLeaveGroupDetailsRepository;

    private final AnnualLeaveGroupDetailsMapper annualLeaveGroupDetailsMapper;

    public AnnualLeaveGroupDetailsService(AnnualLeaveGroupDetailsRepository annualLeaveGroupDetailsRepository, AnnualLeaveGroupDetailsMapper annualLeaveGroupDetailsMapper) {
        this.annualLeaveGroupDetailsRepository = annualLeaveGroupDetailsRepository;
        this.annualLeaveGroupDetailsMapper = annualLeaveGroupDetailsMapper;
    }

    /**
     * Save a annualLeaveGroupDetails.
     *
     * @param annualLeaveGroupDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveGroupDetailsDTO save(AnnualLeaveGroupDetailsDTO annualLeaveGroupDetailsDTO) {
        log.debug("Request to save AnnualLeaveGroupDetails : {}", annualLeaveGroupDetailsDTO);
        AnnualLeaveGroupDetails annualLeaveGroupDetails = annualLeaveGroupDetailsMapper.toEntity(annualLeaveGroupDetailsDTO);
        annualLeaveGroupDetails = annualLeaveGroupDetailsRepository.save(annualLeaveGroupDetails);
        return annualLeaveGroupDetailsMapper.toDto(annualLeaveGroupDetails);
    }

    /**
     * Get all the annualLeaveGroupDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveGroupDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaveGroupDetails");
        return annualLeaveGroupDetailsRepository.findAll(pageable)
            .map(annualLeaveGroupDetailsMapper::toDto);
    }


    /**
     * Get one annualLeaveGroupDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveGroupDetailsDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeaveGroupDetails : {}", id);
        return annualLeaveGroupDetailsRepository.findById(id)
            .map(annualLeaveGroupDetailsMapper::toDto);
    }

    /**
     * Delete the annualLeaveGroupDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeaveGroupDetails : {}", id);
        annualLeaveGroupDetailsRepository.deleteById(id);
    }
}
