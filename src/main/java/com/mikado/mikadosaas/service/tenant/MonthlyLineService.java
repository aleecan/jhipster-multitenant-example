package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.MonthlyLine;
import com.mikado.mikadosaas.repository.tenant.MonthlyLineRepository;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyLineDTO;
import com.mikado.mikadosaas.service.mapper.tenant.MonthlyLineMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonthlyLine}.
 */
@Service
@Transactional
public class MonthlyLineService {

    private final Logger log = LoggerFactory.getLogger(MonthlyLineService.class);

    private final MonthlyLineRepository monthlyLineRepository;

    private final MonthlyLineMapper monthlyLineMapper;

    public MonthlyLineService(MonthlyLineRepository monthlyLineRepository, MonthlyLineMapper monthlyLineMapper) {
        this.monthlyLineRepository = monthlyLineRepository;
        this.monthlyLineMapper = monthlyLineMapper;
    }

    /**
     * Save a monthlyLine.
     *
     * @param monthlyLineDTO the entity to save.
     * @return the persisted entity.
     */
    public MonthlyLineDTO save(MonthlyLineDTO monthlyLineDTO) {
        log.debug("Request to save MonthlyLine : {}", monthlyLineDTO);
        MonthlyLine monthlyLine = monthlyLineMapper.toEntity(monthlyLineDTO);
        monthlyLine = monthlyLineRepository.save(monthlyLine);
        return monthlyLineMapper.toDto(monthlyLine);
    }

    /**
     * Get all the monthlyLines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MonthlyLineDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonthlyLines");
        return monthlyLineRepository.findAll(pageable)
            .map(monthlyLineMapper::toDto);
    }


    /**
     * Get one monthlyLine by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MonthlyLineDTO> findOne(Long id) {
        log.debug("Request to get MonthlyLine : {}", id);
        return monthlyLineRepository.findById(id)
            .map(monthlyLineMapper::toDto);
    }

    /**
     * Delete the monthlyLine by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MonthlyLine : {}", id);
        monthlyLineRepository.deleteById(id);
    }
}
