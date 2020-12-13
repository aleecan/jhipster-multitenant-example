package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.TerminalActivity;
import com.mikado.multitenant.repository.tenant.TerminalActivityRepository;
import com.mikado.multitenant.service.dto.tenant.TerminalActivityDTO;
import com.mikado.multitenant.service.mapper.tenant.TerminalActivityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TerminalActivity}.
 */
@Service
@Transactional
public class TerminalActivityService {

    private final Logger log = LoggerFactory.getLogger(TerminalActivityService.class);

    private final TerminalActivityRepository terminalActivityRepository;

    private final TerminalActivityMapper terminalActivityMapper;

    public TerminalActivityService(TerminalActivityRepository terminalActivityRepository, TerminalActivityMapper terminalActivityMapper) {
        this.terminalActivityRepository = terminalActivityRepository;
        this.terminalActivityMapper = terminalActivityMapper;
    }

    /**
     * Save a terminalActivity.
     *
     * @param terminalActivityDTO the entity to save.
     * @return the persisted entity.
     */
    public TerminalActivityDTO save(TerminalActivityDTO terminalActivityDTO) {
        log.debug("Request to save TerminalActivity : {}", terminalActivityDTO);
        TerminalActivity terminalActivity = terminalActivityMapper.toEntity(terminalActivityDTO);
        terminalActivity = terminalActivityRepository.save(terminalActivity);
        return terminalActivityMapper.toDto(terminalActivity);
    }

    /**
     * Get all the terminalActivities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TerminalActivityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TerminalActivities");
        return terminalActivityRepository.findAll(pageable)
            .map(terminalActivityMapper::toDto);
    }


    /**
     * Get one terminalActivity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TerminalActivityDTO> findOne(Long id) {
        log.debug("Request to get TerminalActivity : {}", id);
        return terminalActivityRepository.findById(id)
            .map(terminalActivityMapper::toDto);
    }

    /**
     * Delete the terminalActivity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TerminalActivity : {}", id);
        terminalActivityRepository.deleteById(id);
    }
}
