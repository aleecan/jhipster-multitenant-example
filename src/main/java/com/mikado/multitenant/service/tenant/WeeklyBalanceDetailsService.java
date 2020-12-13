package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.WeeklyBalanceDetails;
import com.mikado.multitenant.repository.tenant.WeeklyBalanceDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.WeeklyBalanceDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.WeeklyBalanceDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WeeklyBalanceDetails}.
 */
@Service
@Transactional
public class WeeklyBalanceDetailsService {

    private final Logger log = LoggerFactory.getLogger(WeeklyBalanceDetailsService.class);

    private final WeeklyBalanceDetailsRepository weeklyBalanceDetailsRepository;

    private final WeeklyBalanceDetailsMapper weeklyBalanceDetailsMapper;

    public WeeklyBalanceDetailsService(WeeklyBalanceDetailsRepository weeklyBalanceDetailsRepository, WeeklyBalanceDetailsMapper weeklyBalanceDetailsMapper) {
        this.weeklyBalanceDetailsRepository = weeklyBalanceDetailsRepository;
        this.weeklyBalanceDetailsMapper = weeklyBalanceDetailsMapper;
    }

    /**
     * Save a weeklyBalanceDetails.
     *
     * @param weeklyBalanceDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public WeeklyBalanceDetailsDTO save(WeeklyBalanceDetailsDTO weeklyBalanceDetailsDTO) {
        log.debug("Request to save WeeklyBalanceDetails : {}", weeklyBalanceDetailsDTO);
        WeeklyBalanceDetails weeklyBalanceDetails = weeklyBalanceDetailsMapper.toEntity(weeklyBalanceDetailsDTO);
        weeklyBalanceDetails = weeklyBalanceDetailsRepository.save(weeklyBalanceDetails);
        return weeklyBalanceDetailsMapper.toDto(weeklyBalanceDetails);
    }

    /**
     * Get all the weeklyBalanceDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<WeeklyBalanceDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WeeklyBalanceDetails");
        return weeklyBalanceDetailsRepository.findAll(pageable)
            .map(weeklyBalanceDetailsMapper::toDto);
    }


    /**
     * Get one weeklyBalanceDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<WeeklyBalanceDetailsDTO> findOne(Long id) {
        log.debug("Request to get WeeklyBalanceDetails : {}", id);
        return weeklyBalanceDetailsRepository.findById(id)
            .map(weeklyBalanceDetailsMapper::toDto);
    }

    /**
     * Delete the weeklyBalanceDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete WeeklyBalanceDetails : {}", id);
        weeklyBalanceDetailsRepository.deleteById(id);
    }
}
