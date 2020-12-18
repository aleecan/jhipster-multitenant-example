package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.UserRole;
import com.mikado.mikadosaas.repository.tenant.UserRoleRepository;
import com.mikado.mikadosaas.service.dto.tenant.UserRoleDTO;
import com.mikado.mikadosaas.service.mapper.tenant.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserRole}.
 */
@Service
@Transactional
public class UserRoleService {

    private final Logger log = LoggerFactory.getLogger(UserRoleService.class);

    private final UserRoleRepository userRoleRepository;

    private final UserRoleMapper userRoleMapper;

    public UserRoleService(UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }

    /**
     * Save a userRole.
     *
     * @param userRoleDTO the entity to save.
     * @return the persisted entity.
     */
    public UserRoleDTO save(UserRoleDTO userRoleDTO) {
        log.debug("Request to save UserRole : {}", userRoleDTO);
        UserRole userRole = userRoleMapper.toEntity(userRoleDTO);
        userRole = userRoleRepository.save(userRole);
        return userRoleMapper.toDto(userRole);
    }

    /**
     * Get all the userRoles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserRoleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserRoles");
        return userRoleRepository.findAll(pageable)
            .map(userRoleMapper::toDto);
    }


    /**
     * Get one userRole by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserRoleDTO> findOne(Long id) {
        log.debug("Request to get UserRole : {}", id);
        return userRoleRepository.findById(id)
            .map(userRoleMapper::toDto);
    }

    /**
     * Delete the userRole by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserRole : {}", id);
        userRoleRepository.deleteById(id);
    }
}
