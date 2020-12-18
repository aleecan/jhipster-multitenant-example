package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.QuotaBalance;
import com.mikado.mikadosaas.repository.tenant.QuotaBalanceRepository;
import com.mikado.mikadosaas.service.dto.tenant.QuotaBalanceDTO;
import com.mikado.mikadosaas.service.mapper.tenant.QuotaBalanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link QuotaBalance}.
 */
@Service
@Transactional
public class QuotaBalanceService {

    private final Logger log = LoggerFactory.getLogger(QuotaBalanceService.class);

    private final QuotaBalanceRepository quotaBalanceRepository;

    private final QuotaBalanceMapper quotaBalanceMapper;

    public QuotaBalanceService(QuotaBalanceRepository quotaBalanceRepository, QuotaBalanceMapper quotaBalanceMapper) {
        this.quotaBalanceRepository = quotaBalanceRepository;
        this.quotaBalanceMapper = quotaBalanceMapper;
    }

    /**
     * Save a quotaBalance.
     *
     * @param quotaBalanceDTO the entity to save.
     * @return the persisted entity.
     */
    public QuotaBalanceDTO save(QuotaBalanceDTO quotaBalanceDTO) {
        log.debug("Request to save QuotaBalance : {}", quotaBalanceDTO);
        QuotaBalance quotaBalance = quotaBalanceMapper.toEntity(quotaBalanceDTO);
        quotaBalance = quotaBalanceRepository.save(quotaBalance);
        return quotaBalanceMapper.toDto(quotaBalance);
    }

    /**
     * Get all the quotaBalances.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuotaBalanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuotaBalances");
        return quotaBalanceRepository.findAll(pageable)
            .map(quotaBalanceMapper::toDto);
    }


    /**
     * Get one quotaBalance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuotaBalanceDTO> findOne(Long id) {
        log.debug("Request to get QuotaBalance : {}", id);
        return quotaBalanceRepository.findById(id)
            .map(quotaBalanceMapper::toDto);
    }

    /**
     * Delete the quotaBalance by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuotaBalance : {}", id);
        quotaBalanceRepository.deleteById(id);
    }
}
