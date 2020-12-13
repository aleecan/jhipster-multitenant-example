package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ProcessMonthly;
import com.mikado.multitenant.repository.tenant.ProcessMonthlyRepository;
import com.mikado.multitenant.service.dto.tenant.ProcessMonthlyDTO;
import com.mikado.multitenant.service.mapper.tenant.ProcessMonthlyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessMonthly}.
 */
@Service
@Transactional
public class ProcessMonthlyService {

    private final Logger log = LoggerFactory.getLogger(ProcessMonthlyService.class);

    private final ProcessMonthlyRepository processMonthlyRepository;

    private final ProcessMonthlyMapper processMonthlyMapper;

    public ProcessMonthlyService(ProcessMonthlyRepository processMonthlyRepository, ProcessMonthlyMapper processMonthlyMapper) {
        this.processMonthlyRepository = processMonthlyRepository;
        this.processMonthlyMapper = processMonthlyMapper;
    }

    /**
     * Save a processMonthly.
     *
     * @param processMonthlyDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessMonthlyDTO save(ProcessMonthlyDTO processMonthlyDTO) {
        log.debug("Request to save ProcessMonthly : {}", processMonthlyDTO);
        ProcessMonthly processMonthly = processMonthlyMapper.toEntity(processMonthlyDTO);
        processMonthly = processMonthlyRepository.save(processMonthly);
        return processMonthlyMapper.toDto(processMonthly);
    }

    /**
     * Get all the processMonthlies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessMonthlyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessMonthlies");
        return processMonthlyRepository.findAll(pageable)
            .map(processMonthlyMapper::toDto);
    }


    /**
     * Get one processMonthly by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessMonthlyDTO> findOne(Long id) {
        log.debug("Request to get ProcessMonthly : {}", id);
        return processMonthlyRepository.findById(id)
            .map(processMonthlyMapper::toDto);
    }

    /**
     * Delete the processMonthly by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessMonthly : {}", id);
        processMonthlyRepository.deleteById(id);
    }
}
