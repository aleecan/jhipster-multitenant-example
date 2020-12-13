package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ZoneGate;
import com.mikado.multitenant.repository.tenant.ZoneGateRepository;
import com.mikado.multitenant.service.dto.tenant.ZoneGateDTO;
import com.mikado.multitenant.service.mapper.tenant.ZoneGateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ZoneGate}.
 */
@Service
@Transactional
public class ZoneGateService {

    private final Logger log = LoggerFactory.getLogger(ZoneGateService.class);

    private final ZoneGateRepository zoneGateRepository;

    private final ZoneGateMapper zoneGateMapper;

    public ZoneGateService(ZoneGateRepository zoneGateRepository, ZoneGateMapper zoneGateMapper) {
        this.zoneGateRepository = zoneGateRepository;
        this.zoneGateMapper = zoneGateMapper;
    }

    /**
     * Save a zoneGate.
     *
     * @param zoneGateDTO the entity to save.
     * @return the persisted entity.
     */
    public ZoneGateDTO save(ZoneGateDTO zoneGateDTO) {
        log.debug("Request to save ZoneGate : {}", zoneGateDTO);
        ZoneGate zoneGate = zoneGateMapper.toEntity(zoneGateDTO);
        zoneGate = zoneGateRepository.save(zoneGate);
        return zoneGateMapper.toDto(zoneGate);
    }

    /**
     * Get all the zoneGates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ZoneGateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ZoneGates");
        return zoneGateRepository.findAll(pageable)
            .map(zoneGateMapper::toDto);
    }


    /**
     * Get one zoneGate by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ZoneGateDTO> findOne(Long id) {
        log.debug("Request to get ZoneGate : {}", id);
        return zoneGateRepository.findById(id)
            .map(zoneGateMapper::toDto);
    }

    /**
     * Delete the zoneGate by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ZoneGate : {}", id);
        zoneGateRepository.deleteById(id);
    }
}
