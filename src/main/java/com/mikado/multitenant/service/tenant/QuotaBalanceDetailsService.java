package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.QuotaBalanceDetails;
import com.mikado.multitenant.repository.tenant.QuotaBalanceDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.QuotaBalanceDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.QuotaBalanceDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link QuotaBalanceDetails}.
 */
@Service
@Transactional
public class QuotaBalanceDetailsService {

    private final Logger log = LoggerFactory.getLogger(QuotaBalanceDetailsService.class);

    private final QuotaBalanceDetailsRepository quotaBalanceDetailsRepository;

    private final QuotaBalanceDetailsMapper quotaBalanceDetailsMapper;

    public QuotaBalanceDetailsService(QuotaBalanceDetailsRepository quotaBalanceDetailsRepository, QuotaBalanceDetailsMapper quotaBalanceDetailsMapper) {
        this.quotaBalanceDetailsRepository = quotaBalanceDetailsRepository;
        this.quotaBalanceDetailsMapper = quotaBalanceDetailsMapper;
    }

    /**
     * Save a quotaBalanceDetails.
     *
     * @param quotaBalanceDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public QuotaBalanceDetailsDTO save(QuotaBalanceDetailsDTO quotaBalanceDetailsDTO) {
        log.debug("Request to save QuotaBalanceDetails : {}", quotaBalanceDetailsDTO);
        QuotaBalanceDetails quotaBalanceDetails = quotaBalanceDetailsMapper.toEntity(quotaBalanceDetailsDTO);
        quotaBalanceDetails = quotaBalanceDetailsRepository.save(quotaBalanceDetails);
        return quotaBalanceDetailsMapper.toDto(quotaBalanceDetails);
    }

    /**
     * Get all the quotaBalanceDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuotaBalanceDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuotaBalanceDetails");
        return quotaBalanceDetailsRepository.findAll(pageable)
            .map(quotaBalanceDetailsMapper::toDto);
    }


    /**
     * Get one quotaBalanceDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuotaBalanceDetailsDTO> findOne(Long id) {
        log.debug("Request to get QuotaBalanceDetails : {}", id);
        return quotaBalanceDetailsRepository.findById(id)
            .map(quotaBalanceDetailsMapper::toDto);
    }

    /**
     * Delete the quotaBalanceDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuotaBalanceDetails : {}", id);
        quotaBalanceDetailsRepository.deleteById(id);
    }
}
