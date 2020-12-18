package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessDailyAnalysis;
import com.mikado.mikadosaas.repository.tenant.ProcessDailyAnalysisRepository;
import com.mikado.mikadosaas.service.dto.tenant.ProcessDailyAnalysisDTO;
import com.mikado.mikadosaas.service.mapper.tenant.ProcessDailyAnalysisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessDailyAnalysis}.
 */
@Service
@Transactional
public class ProcessDailyAnalysisService {

    private final Logger log = LoggerFactory.getLogger(ProcessDailyAnalysisService.class);

    private final ProcessDailyAnalysisRepository processDailyAnalysisRepository;

    private final ProcessDailyAnalysisMapper processDailyAnalysisMapper;

    public ProcessDailyAnalysisService(ProcessDailyAnalysisRepository processDailyAnalysisRepository, ProcessDailyAnalysisMapper processDailyAnalysisMapper) {
        this.processDailyAnalysisRepository = processDailyAnalysisRepository;
        this.processDailyAnalysisMapper = processDailyAnalysisMapper;
    }

    /**
     * Save a processDailyAnalysis.
     *
     * @param processDailyAnalysisDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessDailyAnalysisDTO save(ProcessDailyAnalysisDTO processDailyAnalysisDTO) {
        log.debug("Request to save ProcessDailyAnalysis : {}", processDailyAnalysisDTO);
        ProcessDailyAnalysis processDailyAnalysis = processDailyAnalysisMapper.toEntity(processDailyAnalysisDTO);
        processDailyAnalysis = processDailyAnalysisRepository.save(processDailyAnalysis);
        return processDailyAnalysisMapper.toDto(processDailyAnalysis);
    }

    /**
     * Get all the processDailyAnalyses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessDailyAnalysisDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessDailyAnalyses");
        return processDailyAnalysisRepository.findAll(pageable)
            .map(processDailyAnalysisMapper::toDto);
    }


    /**
     * Get one processDailyAnalysis by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessDailyAnalysisDTO> findOne(Long id) {
        log.debug("Request to get ProcessDailyAnalysis : {}", id);
        return processDailyAnalysisRepository.findById(id)
            .map(processDailyAnalysisMapper::toDto);
    }

    /**
     * Delete the processDailyAnalysis by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessDailyAnalysis : {}", id);
        processDailyAnalysisRepository.deleteById(id);
    }
}
