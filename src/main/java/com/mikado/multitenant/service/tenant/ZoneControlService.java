package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.ZoneControl;
import com.mikado.multitenant.repository.tenant.ZoneControlRepository;
import com.mikado.multitenant.service.dto.tenant.ZoneControlDTO;
import com.mikado.multitenant.service.mapper.tenant.ZoneControlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ZoneControl}.
 */
@Service
@Transactional
public class ZoneControlService {

    private final Logger log = LoggerFactory.getLogger(ZoneControlService.class);

    private final ZoneControlRepository zoneControlRepository;

    private final ZoneControlMapper zoneControlMapper;

    public ZoneControlService(ZoneControlRepository zoneControlRepository, ZoneControlMapper zoneControlMapper) {
        this.zoneControlRepository = zoneControlRepository;
        this.zoneControlMapper = zoneControlMapper;
    }

    /**
     * Save a zoneControl.
     *
     * @param zoneControlDTO the entity to save.
     * @return the persisted entity.
     */
    public ZoneControlDTO save(ZoneControlDTO zoneControlDTO) {
        log.debug("Request to save ZoneControl : {}", zoneControlDTO);
        ZoneControl zoneControl = zoneControlMapper.toEntity(zoneControlDTO);
        zoneControl = zoneControlRepository.save(zoneControl);
        return zoneControlMapper.toDto(zoneControl);
    }

    /**
     * Get all the zoneControls.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ZoneControlDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ZoneControls");
        return zoneControlRepository.findAll(pageable)
            .map(zoneControlMapper::toDto);
    }


    /**
     * Get one zoneControl by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ZoneControlDTO> findOne(Long id) {
        log.debug("Request to get ZoneControl : {}", id);
        return zoneControlRepository.findById(id)
            .map(zoneControlMapper::toDto);
    }

    /**
     * Delete the zoneControl by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ZoneControl : {}", id);
        zoneControlRepository.deleteById(id);
    }
}
