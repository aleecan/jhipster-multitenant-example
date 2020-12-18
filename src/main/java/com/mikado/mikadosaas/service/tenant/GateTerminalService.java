package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.GateTerminal;
import com.mikado.mikadosaas.repository.tenant.GateTerminalRepository;
import com.mikado.mikadosaas.service.dto.tenant.GateTerminalDTO;
import com.mikado.mikadosaas.service.mapper.tenant.GateTerminalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GateTerminal}.
 */
@Service
@Transactional
public class GateTerminalService {

    private final Logger log = LoggerFactory.getLogger(GateTerminalService.class);

    private final GateTerminalRepository gateTerminalRepository;

    private final GateTerminalMapper gateTerminalMapper;

    public GateTerminalService(GateTerminalRepository gateTerminalRepository, GateTerminalMapper gateTerminalMapper) {
        this.gateTerminalRepository = gateTerminalRepository;
        this.gateTerminalMapper = gateTerminalMapper;
    }

    /**
     * Save a gateTerminal.
     *
     * @param gateTerminalDTO the entity to save.
     * @return the persisted entity.
     */
    public GateTerminalDTO save(GateTerminalDTO gateTerminalDTO) {
        log.debug("Request to save GateTerminal : {}", gateTerminalDTO);
        GateTerminal gateTerminal = gateTerminalMapper.toEntity(gateTerminalDTO);
        gateTerminal = gateTerminalRepository.save(gateTerminal);
        return gateTerminalMapper.toDto(gateTerminal);
    }

    /**
     * Get all the gateTerminals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<GateTerminalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GateTerminals");
        return gateTerminalRepository.findAll(pageable)
            .map(gateTerminalMapper::toDto);
    }


    /**
     * Get one gateTerminal by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<GateTerminalDTO> findOne(Long id) {
        log.debug("Request to get GateTerminal : {}", id);
        return gateTerminalRepository.findById(id)
            .map(gateTerminalMapper::toDto);
    }

    /**
     * Delete the gateTerminal by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete GateTerminal : {}", id);
        gateTerminalRepository.deleteById(id);
    }
}
