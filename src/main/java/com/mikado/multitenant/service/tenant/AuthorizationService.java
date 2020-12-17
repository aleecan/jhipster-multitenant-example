package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Authorization;
import com.mikado.multitenant.repository.tenant.AuthorizationRepository;
import com.mikado.multitenant.service.dto.tenant.AuthorizationDTO;
import com.mikado.multitenant.service.mapper.tenant.AuthorizationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Authorization}.
 */
@Service
@Transactional
public class AuthorizationService {

    private final Logger log = LoggerFactory.getLogger(AuthorizationService.class);

    private final AuthorizationRepository authorizationRepository;

    private final AuthorizationMapper authorizationMapper;

    public AuthorizationService(AuthorizationRepository authorizationRepository, AuthorizationMapper authorizationMapper) {
        this.authorizationRepository = authorizationRepository;
        this.authorizationMapper = authorizationMapper;
    }

    /**
     * Save a authorization.
     *
     * @param authorizationDTO the entity to save.
     * @return the persisted entity.
     */
    public AuthorizationDTO save(AuthorizationDTO authorizationDTO) {
        log.debug("Request to save Authorization : {}", authorizationDTO);
        Authorization authorization = authorizationMapper.toEntity(authorizationDTO);
        authorization = authorizationRepository.save(authorization);
        return authorizationMapper.toDto(authorization);
    }

    /**
     * Get all the authorizations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthorizationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Authorizations");
        return authorizationRepository.findAll(pageable)
            .map(authorizationMapper::toDto);
    }


    /**
     * Get one authorization by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AuthorizationDTO> findOne(Long id) {
        log.debug("Request to get Authorization : {}", id);
        return authorizationRepository.findById(id)
            .map(authorizationMapper::toDto);
    }

    /**
     * Delete the authorization by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Authorization : {}", id);
        authorizationRepository.deleteById(id);
    }
}
