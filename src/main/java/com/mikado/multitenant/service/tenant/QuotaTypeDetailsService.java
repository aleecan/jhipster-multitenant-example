package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.QuotaTypeDetails;
import com.mikado.multitenant.repository.tenant.QuotaTypeDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.QuotaTypeDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.QuotaTypeDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link QuotaTypeDetails}.
 */
@Service
@Transactional
public class QuotaTypeDetailsService {

    private final Logger log = LoggerFactory.getLogger(QuotaTypeDetailsService.class);

    private final QuotaTypeDetailsRepository quotaTypeDetailsRepository;

    private final QuotaTypeDetailsMapper quotaTypeDetailsMapper;

    public QuotaTypeDetailsService(QuotaTypeDetailsRepository quotaTypeDetailsRepository, QuotaTypeDetailsMapper quotaTypeDetailsMapper) {
        this.quotaTypeDetailsRepository = quotaTypeDetailsRepository;
        this.quotaTypeDetailsMapper = quotaTypeDetailsMapper;
    }

    /**
     * Save a quotaTypeDetails.
     *
     * @param quotaTypeDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public QuotaTypeDetailsDTO save(QuotaTypeDetailsDTO quotaTypeDetailsDTO) {
        log.debug("Request to save QuotaTypeDetails : {}", quotaTypeDetailsDTO);
        QuotaTypeDetails quotaTypeDetails = quotaTypeDetailsMapper.toEntity(quotaTypeDetailsDTO);
        quotaTypeDetails = quotaTypeDetailsRepository.save(quotaTypeDetails);
        return quotaTypeDetailsMapper.toDto(quotaTypeDetails);
    }

    /**
     * Get all the quotaTypeDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuotaTypeDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuotaTypeDetails");
        return quotaTypeDetailsRepository.findAll(pageable)
            .map(quotaTypeDetailsMapper::toDto);
    }


    /**
     * Get one quotaTypeDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuotaTypeDetailsDTO> findOne(Long id) {
        log.debug("Request to get QuotaTypeDetails : {}", id);
        return quotaTypeDetailsRepository.findById(id)
            .map(quotaTypeDetailsMapper::toDto);
    }

    /**
     * Delete the quotaTypeDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuotaTypeDetails : {}", id);
        quotaTypeDetailsRepository.deleteById(id);
    }
}
