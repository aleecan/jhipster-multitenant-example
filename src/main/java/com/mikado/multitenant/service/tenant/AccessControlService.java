package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AccessControl;
import com.mikado.multitenant.repository.tenant.AccessControlRepository;
import com.mikado.multitenant.service.dto.tenant.AccessControlDTO;
import com.mikado.multitenant.service.mapper.tenant.AccessControlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccessControl}.
 */
@Service
@Transactional
public class AccessControlService {

    private final Logger log = LoggerFactory.getLogger(AccessControlService.class);

    private final AccessControlRepository accessControlRepository;

    private final AccessControlMapper accessControlMapper;

    public AccessControlService(AccessControlRepository accessControlRepository, AccessControlMapper accessControlMapper) {
        this.accessControlRepository = accessControlRepository;
        this.accessControlMapper = accessControlMapper;
    }

    /**
     * Save a accessControl.
     *
     * @param accessControlDTO the entity to save.
     * @return the persisted entity.
     */
    public AccessControlDTO save(AccessControlDTO accessControlDTO) {
        log.debug("Request to save AccessControl : {}", accessControlDTO);
        AccessControl accessControl = accessControlMapper.toEntity(accessControlDTO);
        accessControl = accessControlRepository.save(accessControl);
        return accessControlMapper.toDto(accessControl);
    }

    /**
     * Get all the accessControls.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccessControlDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccessControls");
        return accessControlRepository.findAll(pageable)
            .map(accessControlMapper::toDto);
    }


    /**
     * Get one accessControl by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccessControlDTO> findOne(Long id) {
        log.debug("Request to get AccessControl : {}", id);
        return accessControlRepository.findById(id)
            .map(accessControlMapper::toDto);
    }

    /**
     * Delete the accessControl by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccessControl : {}", id);
        accessControlRepository.deleteById(id);
    }
}
