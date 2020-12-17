package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Monthly;
import com.mikado.multitenant.repository.tenant.MonthlyRepository;
import com.mikado.multitenant.service.dto.tenant.MonthlyDTO;
import com.mikado.multitenant.service.mapper.tenant.MonthlyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Monthly}.
 */
@Service
@Transactional
public class MonthlyService {

    private final Logger log = LoggerFactory.getLogger(MonthlyService.class);

    private final MonthlyRepository monthlyRepository;

    private final MonthlyMapper monthlyMapper;

    public MonthlyService(MonthlyRepository monthlyRepository, MonthlyMapper monthlyMapper) {
        this.monthlyRepository = monthlyRepository;
        this.monthlyMapper = monthlyMapper;
    }

    /**
     * Save a monthly.
     *
     * @param monthlyDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyDTO save(MonthlyDTO monthlyDTO) {
        log.debug("Request to save Monthly : {}", monthlyDTO);
        Monthly monthly = monthlyMapper.toEntity(monthlyDTO);
        monthly = monthlyRepository.save(monthly);
        return monthlyMapper.toDto(monthly);
    }

    /**
     * Get all the monthlies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Monthlies");
        return monthlyRepository.findAll(pageable)
            .map(monthlyMapper::toDto);
    }


    /**
     * Get one monthly by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyDTO> findOne(Long id) {
        log.debug("Request to get Monthly : {}", id);
        return monthlyRepository.findById(id)
            .map(monthlyMapper::toDto);
    }

    /**
     * Delete the monthly by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Monthly : {}", id);
        monthlyRepository.deleteById(id);
    }
}
