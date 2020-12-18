package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.Gate;
import com.mikado.mikadosaas.repository.tenant.GateRepository;
import com.mikado.mikadosaas.service.dto.tenant.GateDTO;
import com.mikado.mikadosaas.service.mapper.tenant.GateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Gate}.
 */
@Service
@Transactional
public class GateService {

    private final Logger log = LoggerFactory.getLogger(GateService.class);

    private final GateRepository gateRepository;

    private final GateMapper gateMapper;

    public GateService(GateRepository gateRepository, GateMapper gateMapper) {
        this.gateRepository = gateRepository;
        this.gateMapper = gateMapper;
    }

    /**
     * Save a gate.
     *
     * @param gateDTO the entity to save.
     * @return the persisted entity.
     */
    public GateDTO save(GateDTO gateDTO) {
        log.debug("Request to save Gate : {}", gateDTO);
        Gate gate = gateMapper.toEntity(gateDTO);
        gate = gateRepository.save(gate);
        return gateMapper.toDto(gate);
    }

    /**
     * Get all the gates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<GateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Gates");
        return gateRepository.findAll(pageable)
            .map(gateMapper::toDto);
    }


    /**
     * Get one gate by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<GateDTO> findOne(Long id) {
        log.debug("Request to get Gate : {}", id);
        return gateRepository.findById(id)
            .map(gateMapper::toDto);
    }

    /**
     * Delete the gate by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Gate : {}", id);
        gateRepository.deleteById(id);
    }
}
