package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.WeeklyBalance;
import com.mikado.multitenant.repository.tenant.WeeklyBalanceRepository;
import com.mikado.multitenant.service.dto.tenant.WeeklyBalanceDTO;
import com.mikado.multitenant.service.mapper.tenant.WeeklyBalanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WeeklyBalance}.
 */
@Service
@Transactional
public class WeeklyBalanceService {

    private final Logger log = LoggerFactory.getLogger(WeeklyBalanceService.class);

    private final WeeklyBalanceRepository weeklyBalanceRepository;

    private final WeeklyBalanceMapper weeklyBalanceMapper;

    public WeeklyBalanceService(WeeklyBalanceRepository weeklyBalanceRepository, WeeklyBalanceMapper weeklyBalanceMapper) {
        this.weeklyBalanceRepository = weeklyBalanceRepository;
        this.weeklyBalanceMapper = weeklyBalanceMapper;
    }

    /**
     * Save a weeklyBalance.
     *
     * @param weeklyBalanceDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyBalanceDTO save(WeeklyBalanceDTO weeklyBalanceDTO) {
        log.debug("Request to save WeeklyBalance : {}", weeklyBalanceDTO);
        WeeklyBalance weeklyBalance = weeklyBalanceMapper.toEntity(weeklyBalanceDTO);
        weeklyBalance = weeklyBalanceRepository.save(weeklyBalance);
        return weeklyBalanceMapper.toDto(weeklyBalance);
    }

    /**
     * Get all the weeklyBalances.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyBalanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WeeklyBalances");
        return weeklyBalanceRepository.findAll(pageable)
            .map(weeklyBalanceMapper::toDto);
    }


    /**
     * Get one weeklyBalance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyBalanceDTO> findOne(Long id) {
        log.debug("Request to get WeeklyBalance : {}", id);
        return weeklyBalanceRepository.findById(id)
            .map(weeklyBalanceMapper::toDto);
    }

    /**
     * Delete the weeklyBalance by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WeeklyBalance : {}", id);
        weeklyBalanceRepository.deleteById(id);
    }
}
