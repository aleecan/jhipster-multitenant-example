package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.MonthlyPreviousDetails;
import com.mikado.multitenant.repository.tenant.MonthlyPreviousDetailsRepository;
import com.mikado.multitenant.service.dto.tenant.MonthlyPreviousDetailsDTO;
import com.mikado.multitenant.service.mapper.tenant.MonthlyPreviousDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyPreviousDetails}.
 */
@Service
@Transactional
public class MonthlyPreviousDetailsService {

    private final Logger log = LoggerFactory.getLogger(MonthlyPreviousDetailsService.class);

    private final MonthlyPreviousDetailsRepository monthlyPreviousDetailsRepository;

    private final MonthlyPreviousDetailsMapper monthlyPreviousDetailsMapper;

    public MonthlyPreviousDetailsService(MonthlyPreviousDetailsRepository monthlyPreviousDetailsRepository, MonthlyPreviousDetailsMapper monthlyPreviousDetailsMapper) {
        this.monthlyPreviousDetailsRepository = monthlyPreviousDetailsRepository;
        this.monthlyPreviousDetailsMapper = monthlyPreviousDetailsMapper;
    }

    /**
     * Save a monthlyPreviousDetails.
     *
     * @param monthlyPreviousDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyPreviousDetailsDTO save(MonthlyPreviousDetailsDTO monthlyPreviousDetailsDTO) {
        log.debug("Request to save MonthlyPreviousDetails : {}", monthlyPreviousDetailsDTO);
        MonthlyPreviousDetails monthlyPreviousDetails = monthlyPreviousDetailsMapper.toEntity(monthlyPreviousDetailsDTO);
        monthlyPreviousDetails = monthlyPreviousDetailsRepository.save(monthlyPreviousDetails);
        return monthlyPreviousDetailsMapper.toDto(monthlyPreviousDetails);
    }

    /**
     * Get all the monthlyPreviousDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyPreviousDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyPreviousDetails");
        return monthlyPreviousDetailsRepository.findAll(pageable)
            .map(monthlyPreviousDetailsMapper::toDto);
    }


    /**
     * Get one monthlyPreviousDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyPreviousDetailsDTO> findOne(Long id) {
        log.debug("Request to get MonthlyPreviousDetails : {}", id);
        return monthlyPreviousDetailsRepository.findById(id)
            .map(monthlyPreviousDetailsMapper::toDto);
    }

    /**
     * Delete the monthlyPreviousDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyPreviousDetails : {}", id);
        monthlyPreviousDetailsRepository.deleteById(id);
    }
}
