package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalActivitySchedule;
import com.mikado.mikadosaas.repository.tenant.TerminalActivityScheduleRepository;
import com.mikado.mikadosaas.service.dto.tenant.TerminalActivityScheduleDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TerminalActivityScheduleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TerminalActivitySchedule}.
 */
@Service
@Transactional
public class TerminalActivityScheduleService {

    private final Logger log = LoggerFactory.getLogger(TerminalActivityScheduleService.class);

    private final TerminalActivityScheduleRepository terminalActivityScheduleRepository;

    private final TerminalActivityScheduleMapper terminalActivityScheduleMapper;

    public TerminalActivityScheduleService(TerminalActivityScheduleRepository terminalActivityScheduleRepository, TerminalActivityScheduleMapper terminalActivityScheduleMapper) {
        this.terminalActivityScheduleRepository = terminalActivityScheduleRepository;
        this.terminalActivityScheduleMapper = terminalActivityScheduleMapper;
    }

    /**
     * Save a terminalActivitySchedule.
     *
     * @param terminalActivityScheduleDTO the entity to save.
     * @return the persisted entity.
     */
    public TerminalActivityScheduleDTO save(TerminalActivityScheduleDTO terminalActivityScheduleDTO) {
        log.debug("Request to save TerminalActivitySchedule : {}", terminalActivityScheduleDTO);
        TerminalActivitySchedule terminalActivitySchedule = terminalActivityScheduleMapper.toEntity(terminalActivityScheduleDTO);
        terminalActivitySchedule = terminalActivityScheduleRepository.save(terminalActivitySchedule);
        return terminalActivityScheduleMapper.toDto(terminalActivitySchedule);
    }

    /**
     * Get all the terminalActivitySchedules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TerminalActivityScheduleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TerminalActivitySchedules");
        return terminalActivityScheduleRepository.findAll(pageable)
            .map(terminalActivityScheduleMapper::toDto);
    }


    /**
     * Get one terminalActivitySchedule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TerminalActivityScheduleDTO> findOne(Long id) {
        log.debug("Request to get TerminalActivitySchedule : {}", id);
        return terminalActivityScheduleRepository.findById(id)
            .map(terminalActivityScheduleMapper::toDto);
    }

    /**
     * Delete the terminalActivitySchedule by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TerminalActivitySchedule : {}", id);
        terminalActivityScheduleRepository.deleteById(id);
    }
}
