package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.repository.tenant.AccessCodeRepository;
import com.mikado.multitenant.service.dto.tenant.AccessCodeDTO;
import com.mikado.multitenant.service.mapper.tenant.AccessCodeMapper;
import com.mikado.multitenant.domain.tenant.AccessCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccessCode}.
 */
@Service
@Transactional
public class AccessCodeService {

    private final Logger log = LoggerFactory.getLogger(AccessCodeService.class);

    private final AccessCodeRepository accessCodeRepository;

    private final AccessCodeMapper accessCodeMapper;

    public AccessCodeService(AccessCodeRepository accessCodeRepository, AccessCodeMapper accessCodeMapper) {
        this.accessCodeRepository = accessCodeRepository;
        this.accessCodeMapper = accessCodeMapper;
    }

    /**
     * Save a accessCode.
     *
     * @param accessCodeDTO the entity to save.
     * @return the persisted entity.
     */
    public AccessCodeDTO save(AccessCodeDTO accessCodeDTO) {
        log.debug("Request to save AccessCode : {}", accessCodeDTO);
        AccessCode accessCode = accessCodeMapper.toEntity(accessCodeDTO);
        accessCode = accessCodeRepository.save(accessCode);
        return accessCodeMapper.toDto(accessCode);
    }

    /**
     * Get all the accessCodes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccessCodeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccessCodes");
        return accessCodeRepository.findAll(pageable)
            .map(accessCodeMapper::toDto);
    }


    /**
     * Get one accessCode by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccessCodeDTO> findOne(Long id) {
        log.debug("Request to get AccessCode : {}", id);
        return accessCodeRepository.findById(id)
            .map(accessCodeMapper::toDto);
    }

    /**
     * Delete the accessCode by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccessCode : {}", id);
        accessCodeRepository.deleteById(id);
    }
}
