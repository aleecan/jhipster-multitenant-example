package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.GateControl;
import com.mikado.mikadosaas.repository.tenant.GateControlRepository;
import com.mikado.mikadosaas.service.dto.tenant.GateControlDTO;
import com.mikado.mikadosaas.service.mapper.tenant.GateControlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GateControl}.
 */
@Service
@Transactional
public class GateControlService {

    private final Logger log = LoggerFactory.getLogger(GateControlService.class);

    private final GateControlRepository gateControlRepository;

    private final GateControlMapper gateControlMapper;

    public GateControlService(GateControlRepository gateControlRepository, GateControlMapper gateControlMapper) {
        this.gateControlRepository = gateControlRepository;
        this.gateControlMapper = gateControlMapper;
    }

    /**
     * Save a gateControl.
     *
     * @param gateControlDTO the entity to save.
     * @return the persisted entity.
     */
    public GateControlDTO save(GateControlDTO gateControlDTO) {
        log.debug("Request to save GateControl : {}", gateControlDTO);
        GateControl gateControl = gateControlMapper.toEntity(gateControlDTO);
        gateControl = gateControlRepository.save(gateControl);
        return gateControlMapper.toDto(gateControl);
    }

    /**
     * Get all the gateControls.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<GateControlDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GateControls");
        return gateControlRepository.findAll(pageable)
            .map(gateControlMapper::toDto);
    }


    /**
     * Get one gateControl by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<GateControlDTO> findOne(Long id) {
        log.debug("Request to get GateControl : {}", id);
        return gateControlRepository.findById(id)
            .map(gateControlMapper::toDto);
    }

    /**
     * Delete the gateControl by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete GateControl : {}", id);
        gateControlRepository.deleteById(id);
    }
}
