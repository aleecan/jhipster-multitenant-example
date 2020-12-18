package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalSlave;
import com.mikado.mikadosaas.repository.tenant.TerminalSlaveRepository;
import com.mikado.mikadosaas.service.dto.tenant.TerminalSlaveDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TerminalSlaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TerminalSlave}.
 */
@Service
@Transactional
public class TerminalSlaveService {

    private final Logger log = LoggerFactory.getLogger(TerminalSlaveService.class);

    private final TerminalSlaveRepository terminalSlaveRepository;

    private final TerminalSlaveMapper terminalSlaveMapper;

    public TerminalSlaveService(TerminalSlaveRepository terminalSlaveRepository, TerminalSlaveMapper terminalSlaveMapper) {
        this.terminalSlaveRepository = terminalSlaveRepository;
        this.terminalSlaveMapper = terminalSlaveMapper;
    }

    /**
     * Save a terminalSlave.
     *
     * @param terminalSlaveDTO the entity to save.
     * @return the persisted entity.
     */
    public TerminalSlaveDTO save(TerminalSlaveDTO terminalSlaveDTO) {
        log.debug("Request to save TerminalSlave : {}", terminalSlaveDTO);
        TerminalSlave terminalSlave = terminalSlaveMapper.toEntity(terminalSlaveDTO);
        terminalSlave = terminalSlaveRepository.save(terminalSlave);
        return terminalSlaveMapper.toDto(terminalSlave);
    }

    /**
     * Get all the terminalSlaves.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TerminalSlaveDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TerminalSlaves");
        return terminalSlaveRepository.findAll(pageable)
            .map(terminalSlaveMapper::toDto);
    }


    /**
     * Get one terminalSlave by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TerminalSlaveDTO> findOne(Long id) {
        log.debug("Request to get TerminalSlave : {}", id);
        return terminalSlaveRepository.findById(id)
            .map(terminalSlaveMapper::toDto);
    }

    /**
     * Delete the terminalSlave by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TerminalSlave : {}", id);
        terminalSlaveRepository.deleteById(id);
    }
}
