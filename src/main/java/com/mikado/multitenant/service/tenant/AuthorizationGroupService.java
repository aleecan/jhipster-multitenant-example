package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.AuthorizationGroup;
import com.mikado.multitenant.repository.tenant.AuthorizationGroupRepository;
import com.mikado.multitenant.service.dto.tenant.AuthorizationGroupDTO;
import com.mikado.multitenant.service.mapper.tenant.AuthorizationGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AuthorizationGroup}.
 */
@Service
@Transactional
public class AuthorizationGroupService {

    private final Logger log = LoggerFactory.getLogger(AuthorizationGroupService.class);

    private final AuthorizationGroupRepository authorizationGroupRepository;

    private final AuthorizationGroupMapper authorizationGroupMapper;

    public AuthorizationGroupService(AuthorizationGroupRepository authorizationGroupRepository, AuthorizationGroupMapper authorizationGroupMapper) {
        this.authorizationGroupRepository = authorizationGroupRepository;
        this.authorizationGroupMapper = authorizationGroupMapper;
    }

    /**
     * Save a authorizationGroup.
     *
     * @param authorizationGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public AuthorizationGroupDTO save(AuthorizationGroupDTO authorizationGroupDTO) {
        log.debug("Request to save AuthorizationGroup : {}", authorizationGroupDTO);
        AuthorizationGroup authorizationGroup = authorizationGroupMapper.toEntity(authorizationGroupDTO);
        authorizationGroup = authorizationGroupRepository.save(authorizationGroup);
        return authorizationGroupMapper.toDto(authorizationGroup);
    }

    /**
     * Get all the authorizationGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthorizationGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AuthorizationGroups");
        return authorizationGroupRepository.findAll(pageable)
            .map(authorizationGroupMapper::toDto);
    }


    /**
     * Get one authorizationGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AuthorizationGroupDTO> findOne(Long id) {
        log.debug("Request to get AuthorizationGroup : {}", id);
        return authorizationGroupRepository.findById(id)
            .map(authorizationGroupMapper::toDto);
    }

    /**
     * Delete the authorizationGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AuthorizationGroup : {}", id);
        authorizationGroupRepository.deleteById(id);
    }
}
