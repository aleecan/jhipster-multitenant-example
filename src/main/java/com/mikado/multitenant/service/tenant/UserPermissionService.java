package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.UserPermission;
import com.mikado.multitenant.repository.tenant.UserPermissionRepository;
import com.mikado.multitenant.service.dto.tenant.UserPermissionDTO;
import com.mikado.multitenant.service.mapper.tenant.UserPermissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserPermission}.
 */
@Service
@Transactional
public class UserPermissionService {

    private final Logger log = LoggerFactory.getLogger(UserPermissionService.class);

    private final UserPermissionRepository userPermissionRepository;

    private final UserPermissionMapper userPermissionMapper;

    public UserPermissionService(UserPermissionRepository userPermissionRepository, UserPermissionMapper userPermissionMapper) {
        this.userPermissionRepository = userPermissionRepository;
        this.userPermissionMapper = userPermissionMapper;
    }

    /**
     * Save a userPermission.
     *
     * @param userPermissionDTO the entity to save.
     * @return the persisted entity.
     */
    public UserPermissionDTO save(UserPermissionDTO userPermissionDTO) {
        log.debug("Request to save UserPermission : {}", userPermissionDTO);
        UserPermission userPermission = userPermissionMapper.toEntity(userPermissionDTO);
        userPermission = userPermissionRepository.save(userPermission);
        return userPermissionMapper.toDto(userPermission);
    }

    /**
     * Get all the userPermissions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserPermissionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserPermissions");
        return userPermissionRepository.findAll(pageable)
            .map(userPermissionMapper::toDto);
    }


    /**
     * Get one userPermission by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserPermissionDTO> findOne(Long id) {
        log.debug("Request to get UserPermission : {}", id);
        return userPermissionRepository.findById(id)
            .map(userPermissionMapper::toDto);
    }

    /**
     * Delete the userPermission by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserPermission : {}", id);
        userPermissionRepository.deleteById(id);
    }
}
