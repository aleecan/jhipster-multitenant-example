package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.DailyAnalysis;
import com.mikado.mikadosaas.repository.tenant.DailyAnalysisRepository;
import com.mikado.mikadosaas.service.dto.tenant.DailyAnalysisDTO;
import com.mikado.mikadosaas.service.mapper.tenant.DailyAnalysisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DailyAnalysis}.
 */
@Service
@Transactional
public class DailyAnalysisService {

    private final Logger log = LoggerFactory.getLogger(DailyAnalysisService.class);

    private final DailyAnalysisRepository dailyAnalysisRepository;

    private final DailyAnalysisMapper dailyAnalysisMapper;

    public DailyAnalysisService(DailyAnalysisRepository dailyAnalysisRepository, DailyAnalysisMapper dailyAnalysisMapper) {
        this.dailyAnalysisRepository = dailyAnalysisRepository;
        this.dailyAnalysisMapper = dailyAnalysisMapper;
    }

    /**
     * Save a dailyAnalysis.
     *
     * @param dailyAnalysisDTO the entity to save.
     * @return the persisted entity.
     */
    public DailyAnalysisDTO save(DailyAnalysisDTO dailyAnalysisDTO) {
        log.debug("Request to save DailyAnalysis : {}", dailyAnalysisDTO);
        DailyAnalysis dailyAnalysis = dailyAnalysisMapper.toEntity(dailyAnalysisDTO);
        dailyAnalysis = dailyAnalysisRepository.save(dailyAnalysis);
        return dailyAnalysisMapper.toDto(dailyAnalysis);
    }

    /**
     * Get all the dailyAnalyses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DailyAnalysisDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DailyAnalyses");
        return dailyAnalysisRepository.findAll(pageable)
            .map(dailyAnalysisMapper::toDto);
    }


    /**
     * Get one dailyAnalysis by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DailyAnalysisDTO> findOne(Long id) {
        log.debug("Request to get DailyAnalysis : {}", id);
        return dailyAnalysisRepository.findById(id)
            .map(dailyAnalysisMapper::toDto);
    }

    /**
     * Delete the dailyAnalysis by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DailyAnalysis : {}", id);
        dailyAnalysisRepository.deleteById(id);
    }
}
