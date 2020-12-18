package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyLineDetails;
import com.mikado.mikadosaas.repository.tenant.MonthlyLineDetailsRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyLineDetailsDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlyLineDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyLineDetails}.
 */
@Service
@Transactional
public class MonthlyLineDetailsService {

    private final Logger log = LoggerFactory.getLogger(MonthlyLineDetailsService.class);

    private final MonthlyLineDetailsRepository monthlyLineDetailsRepository;

    private final MonthlyLineDetailsMapper monthlyLineDetailsMapper;

    public MonthlyLineDetailsService(MonthlyLineDetailsRepository monthlyLineDetailsRepository, MonthlyLineDetailsMapper monthlyLineDetailsMapper) {
        this.monthlyLineDetailsRepository = monthlyLineDetailsRepository;
        this.monthlyLineDetailsMapper = monthlyLineDetailsMapper;
    }

    /**
     * Save a monthlyLineDetails.
     *
     * @param monthlyLineDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyLineDetailsDTO save(MonthlyLineDetailsDTO monthlyLineDetailsDTO) {
        log.debug("Request to save MonthlyLineDetails : {}", monthlyLineDetailsDTO);
        MonthlyLineDetails monthlyLineDetails = monthlyLineDetailsMapper.toEntity(monthlyLineDetailsDTO);
        monthlyLineDetails = monthlyLineDetailsRepository.save(monthlyLineDetails);
        return monthlyLineDetailsMapper.toDto(monthlyLineDetails);
    }

    /**
     * Get all the monthlyLineDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyLineDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyLineDetails");
        return monthlyLineDetailsRepository.findAll(pageable)
            .map(monthlyLineDetailsMapper::toDto);
    }


    /**
     * Get one monthlyLineDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyLineDetailsDTO> findOne(Long id) {
        log.debug("Request to get MonthlyLineDetails : {}", id);
        return monthlyLineDetailsRepository.findById(id)
            .map(monthlyLineDetailsMapper::toDto);
    }

    /**
     * Delete the monthlyLineDetails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyLineDetails : {}", id);
        monthlyLineDetailsRepository.deleteById(id);
    }
}
