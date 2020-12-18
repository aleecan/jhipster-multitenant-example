package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessPreviousMonthly;
import com.mikado.mikadosaas.repository.tenant.ProcessPreviousMonthlyRepository;
import com.mikado.mikadosaas.service.dto.tenant.ProcessPreviousMonthlyDTO;
import com.mikado.mikadosaas.service.mapper.tenant.ProcessPreviousMonthlyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessPreviousMonthly}.
 */
@Service
@Transactional
public class ProcessPreviousMonthlyService {

    private final Logger log = LoggerFactory.getLogger(ProcessPreviousMonthlyService.class);

    private final ProcessPreviousMonthlyRepository processPreviousMonthlyRepository;

    private final ProcessPreviousMonthlyMapper processPreviousMonthlyMapper;

    public ProcessPreviousMonthlyService(ProcessPreviousMonthlyRepository processPreviousMonthlyRepository, ProcessPreviousMonthlyMapper processPreviousMonthlyMapper) {
        this.processPreviousMonthlyRepository = processPreviousMonthlyRepository;
        this.processPreviousMonthlyMapper = processPreviousMonthlyMapper;
    }

    /**
     * Save a processPreviousMonthly.
     *
     * @param processPreviousMonthlyDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessPreviousMonthlyDTO save(ProcessPreviousMonthlyDTO processPreviousMonthlyDTO) {
        log.debug("Request to save ProcessPreviousMonthly : {}", processPreviousMonthlyDTO);
        ProcessPreviousMonthly processPreviousMonthly = processPreviousMonthlyMapper.toEntity(processPreviousMonthlyDTO);
        processPreviousMonthly = processPreviousMonthlyRepository.save(processPreviousMonthly);
        return processPreviousMonthlyMapper.toDto(processPreviousMonthly);
    }

    /**
     * Get all the processPreviousMonthlies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessPreviousMonthlyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessPreviousMonthlies");
        return processPreviousMonthlyRepository.findAll(pageable)
            .map(processPreviousMonthlyMapper::toDto);
    }


    /**
     * Get one processPreviousMonthly by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessPreviousMonthlyDTO> findOne(Long id) {
        log.debug("Request to get ProcessPreviousMonthly : {}", id);
        return processPreviousMonthlyRepository.findById(id)
            .map(processPreviousMonthlyMapper::toDto);
    }

    /**
     * Delete the processPreviousMonthly by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessPreviousMonthly : {}", id);
        processPreviousMonthlyRepository.deleteById(id);
    }
}
