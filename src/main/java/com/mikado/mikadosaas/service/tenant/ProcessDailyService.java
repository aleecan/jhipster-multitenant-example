package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.ProcessDaily;
import com.mikado.mikadosaas.repository.tenant.ProcessDailyRepository;
import com.mikado.mikadosaas.service.dto.tenant.ProcessDailyDTO;
import com.mikado.mikadosaas.service.mapper.tenant.ProcessDailyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProcessDaily}.
 */
@Service
@Transactional
public class ProcessDailyService {

    private final Logger log = LoggerFactory.getLogger(ProcessDailyService.class);

    private final ProcessDailyRepository processDailyRepository;

    private final ProcessDailyMapper processDailyMapper;

    public ProcessDailyService(ProcessDailyRepository processDailyRepository, ProcessDailyMapper processDailyMapper) {
        this.processDailyRepository = processDailyRepository;
        this.processDailyMapper = processDailyMapper;
    }

    /**
     * Save a processDaily.
     *
     * @param processDailyDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessDailyDTO save(ProcessDailyDTO processDailyDTO) {
        log.debug("Request to save ProcessDaily : {}", processDailyDTO);
        ProcessDaily processDaily = processDailyMapper.toEntity(processDailyDTO);
        processDaily = processDailyRepository.save(processDaily);
        return processDailyMapper.toDto(processDaily);
    }

    /**
     * Get all the processDailies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProcessDailyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ProcessDailies");
        return processDailyRepository.findAll(pageable)
            .map(processDailyMapper::toDto);
    }


    /**
     * Get one processDaily by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessDailyDTO> findOne(Long id) {
        log.debug("Request to get ProcessDaily : {}", id);
        return processDailyRepository.findById(id)
            .map(processDailyMapper::toDto);
    }

    /**
     * Delete the processDaily by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ProcessDaily : {}", id);
        processDailyRepository.deleteById(id);
    }
}
