package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyDetails;
import com.mikado.mikadosaas.repository.tenant.MonthlyDetailsRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyDetailsDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlyDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyDetails}.
 */
@Service
@Transactional
public class MonthlyDetailsService {

    private final Logger log = LoggerFactory.getLogger(MonthlyDetailsService.class);

    private final MonthlyDetailsRepository monthlyDetailsRepository;

    private final MonthlyDetailsMapper monthlyDetailsMapper;

    public MonthlyDetailsService(MonthlyDetailsRepository monthlyDetailsRepository, MonthlyDetailsMapper monthlyDetailsMapper) {
        this.monthlyDetailsRepository = monthlyDetailsRepository;
        this.monthlyDetailsMapper = monthlyDetailsMapper;
    }

    /**
     * Save a monthlyDetails.
     *
     * @param monthlyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyDetailsDTO save(MonthlyDetailsDTO monthlyDetailsDTO) {
        log.debug("Request to save MonthlyDetails : {}", monthlyDetailsDTO);
        MonthlyDetails monthlyDetails = monthlyDetailsMapper.toEntity(monthlyDetailsDTO);
        monthlyDetails = monthlyDetailsRepository.save(monthlyDetails);
        return monthlyDetailsMapper.toDto(monthlyDetails);
    }

    /**
     * Get all the monthlyDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyDetails");
        return monthlyDetailsRepository.findAll(pageable)
            .map(monthlyDetailsMapper::toDto);
    }


    /**
     * Get one monthlyDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyDetailsDTO> findOne(Long id) {
        log.debug("Request to get MonthlyDetails : {}", id);
        return monthlyDetailsRepository.findById(id)
            .map(monthlyDetailsMapper::toDto);
    }

    /**
     * Delete the monthlyDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyDetails : {}", id);
        monthlyDetailsRepository.deleteById(id);
    }
}
