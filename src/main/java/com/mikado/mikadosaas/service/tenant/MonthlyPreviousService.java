package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyPrevious;
import com.mikado.mikadosaas.repository.tenant.MonthlyPreviousRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyPreviousDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlyPreviousMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyPrevious}.
 */
@Service
@Transactional
public class MonthlyPreviousService {

    private final Logger log = LoggerFactory.getLogger(MonthlyPreviousService.class);

    private final MonthlyPreviousRepository monthlyPreviousRepository;

    private final MonthlyPreviousMapper monthlyPreviousMapper;

    public MonthlyPreviousService(MonthlyPreviousRepository monthlyPreviousRepository, MonthlyPreviousMapper monthlyPreviousMapper) {
        this.monthlyPreviousRepository = monthlyPreviousRepository;
        this.monthlyPreviousMapper = monthlyPreviousMapper;
    }

    /**
     * Save a monthlyPrevious.
     *
     * @param monthlyPreviousDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyPreviousDTO save(MonthlyPreviousDTO monthlyPreviousDTO) {
        log.debug("Request to save MonthlyPrevious : {}", monthlyPreviousDTO);
        MonthlyPrevious monthlyPrevious = monthlyPreviousMapper.toEntity(monthlyPreviousDTO);
        monthlyPrevious = monthlyPreviousRepository.save(monthlyPrevious);
        return monthlyPreviousMapper.toDto(monthlyPrevious);
    }

    /**
     * Get all the monthlyPrevious.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyPreviousDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyPrevious");
        return monthlyPreviousRepository.findAll(pageable)
            .map(monthlyPreviousMapper::toDto);
    }


    /**
     * Get one monthlyPrevious by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyPreviousDTO> findOne(Long id) {
        log.debug("Request to get MonthlyPrevious : {}", id);
        return monthlyPreviousRepository.findById(id)
            .map(monthlyPreviousMapper::toDto);
    }

    /**
     * Delete the monthlyPrevious by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyPrevious : {}", id);
        monthlyPreviousRepository.deleteById(id);
    }
}
