package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.TerminalMessage;
import com.mikado.mikadosaas.repository.tenant.TerminalMessageRepository;
import com.mikado.mikadosaas.service.dto.tenant.TerminalMessageDTO;
import com.mikado.mikadosaas.service.mapper.tenant.TerminalMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TerminalMessage}.
 */
@Service
@Transactional
public class TerminalMessageService {

    private final Logger log = LoggerFactory.getLogger(TerminalMessageService.class);

    private final TerminalMessageRepository terminalMessageRepository;

    private final TerminalMessageMapper terminalMessageMapper;

    public TerminalMessageService(TerminalMessageRepository terminalMessageRepository, TerminalMessageMapper terminalMessageMapper) {
        this.terminalMessageRepository = terminalMessageRepository;
        this.terminalMessageMapper = terminalMessageMapper;
    }

    /**
     * Save a terminalMessage.
     *
     * @param terminalMessageDTO the entity to save.
     * @return the persisted entity.
     */
    public TerminalMessageDTO save(TerminalMessageDTO terminalMessageDTO) {
        log.debug("Request to save TerminalMessage : {}", terminalMessageDTO);
        TerminalMessage terminalMessage = terminalMessageMapper.toEntity(terminalMessageDTO);
        terminalMessage = terminalMessageRepository.save(terminalMessage);
        return terminalMessageMapper.toDto(terminalMessage);
    }

    /**
     * Get all the terminalMessages.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TerminalMessageDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TerminalMessages");
        return terminalMessageRepository.findAll(pageable)
            .map(terminalMessageMapper::toDto);
    }


    /**
     * Get one terminalMessage by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TerminalMessageDTO> findOne(Long id) {
        log.debug("Request to get TerminalMessage : {}", id);
        return terminalMessageRepository.findById(id)
            .map(terminalMessageMapper::toDto);
    }

    /**
     * Delete the terminalMessage by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TerminalMessage : {}", id);
        terminalMessageRepository.deleteById(id);
    }
}
