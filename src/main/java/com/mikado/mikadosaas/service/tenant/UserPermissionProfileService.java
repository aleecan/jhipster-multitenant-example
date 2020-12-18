package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.UserPermissionProfile;
import com.mikado.mikadosaas.repository.tenant.UserPermissionProfileRepository;
import com.mikado.mikadosaas.service.dto.tenant.UserPermissionProfileDTO;
import com.mikado.mikadosaas.service.mapper.tenant.UserPermissionProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserPermissionProfile}.
 */
@Service
@Transactional
public class UserPermissionProfileService {

    private final Logger log = LoggerFactory.getLogger(UserPermissionProfileService.class);

    private final UserPermissionProfileRepository userPermissionProfileRepository;

    private final UserPermissionProfileMapper userPermissionProfileMapper;

    public UserPermissionProfileService(UserPermissionProfileRepository userPermissionProfileRepository, UserPermissionProfileMapper userPermissionProfileMapper) {
        this.userPermissionProfileRepository = userPermissionProfileRepository;
        this.userPermissionProfileMapper = userPermissionProfileMapper;
    }

    /**
     * Save a userPermissionProfile.
     *
     * @param userPermissionProfileDTO the entity to save.
     * @return the persisted entity.
     */
    public UserPermissionProfileDTO save(UserPermissionProfileDTO userPermissionProfileDTO) {
        log.debug("Request to save UserPermissionProfile : {}", userPermissionProfileDTO);
        UserPermissionProfile userPermissionProfile = userPermissionProfileMapper.toEntity(userPermissionProfileDTO);
        userPermissionProfile = userPermissionProfileRepository.save(userPermissionProfile);
        return userPermissionProfileMapper.toDto(userPermissionProfile);
    }

    /**
     * Get all the userPermissionProfiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserPermissionProfileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserPermissionProfiles");
        return userPermissionProfileRepository.findAll(pageable)
            .map(userPermissionProfileMapper::toDto);
    }


    /**
     * Get one userPermissionProfile by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserPermissionProfileDTO> findOne(Long id) {
        log.debug("Request to get UserPermissionProfile : {}", id);
        return userPermissionProfileRepository.findById(id)
            .map(userPermissionProfileMapper::toDto);
    }

    /**
     * Delete the userPermissionProfile by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserPermissionProfile : {}", id);
        userPermissionProfileRepository.deleteById(id);
    }
}
