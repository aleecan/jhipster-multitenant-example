package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AnnualLeaveAddsub;
import com.mikado.multitenant.repository.tenant.AnnualLeaveAddsubRepository;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveAddsubDTO;
import com.mikado.multitenant.service.mapper.tenant.AnnualLeaveAddsubMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AnnualLeaveAddsub}.
 */
@Service
@Transactional
public class AnnualLeaveAddsubService {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveAddsubService.class);

    private final AnnualLeaveAddsubRepository annualLeaveAddsubRepository;

    private final AnnualLeaveAddsubMapper annualLeaveAddsubMapper;

    public AnnualLeaveAddsubService(AnnualLeaveAddsubRepository annualLeaveAddsubRepository, AnnualLeaveAddsubMapper annualLeaveAddsubMapper) {
        this.annualLeaveAddsubRepository = annualLeaveAddsubRepository;
        this.annualLeaveAddsubMapper = annualLeaveAddsubMapper;
    }

    /**
     * Save a annualLeaveAddsub.
     *
     * @param annualLeaveAddsubDTO the entity to save.
     * @return the persisted entity.
     */
    public AnnualLeaveAddsubDTO save(AnnualLeaveAddsubDTO annualLeaveAddsubDTO) {
        log.debug("Request to save AnnualLeaveAddsub : {}", annualLeaveAddsubDTO);
        AnnualLeaveAddsub annualLeaveAddsub = annualLeaveAddsubMapper.toEntity(annualLeaveAddsubDTO);
        annualLeaveAddsub = annualLeaveAddsubRepository.save(annualLeaveAddsub);
        return annualLeaveAddsubMapper.toDto(annualLeaveAddsub);
    }

    /**
     * Get all the annualLeaveAddsubs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AnnualLeaveAddsubDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AnnualLeaveAddsubs");
        return annualLeaveAddsubRepository.findAll(pageable)
            .map(annualLeaveAddsubMapper::toDto);
    }


    /**
     * Get one annualLeaveAddsub by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AnnualLeaveAddsubDTO> findOne(Long id) {
        log.debug("Request to get AnnualLeaveAddsub : {}", id);
        return annualLeaveAddsubRepository.findById(id)
            .map(annualLeaveAddsubMapper::toDto);
    }

    /**
     * Delete the annualLeaveAddsub by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AnnualLeaveAddsub : {}", id);
        annualLeaveAddsubRepository.deleteById(id);
    }
}
