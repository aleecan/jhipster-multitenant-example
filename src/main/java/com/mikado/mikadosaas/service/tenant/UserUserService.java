package com.mikado.mikadosaas.service.tenant;

import com.mikado.mikadosaas.domain.tenant.UserUser;
import com.mikado.mikadosaas.repository.tenant.UserUserRepository;
import com.mikado.mikadosaas.service.dto.tenant.UserUserDTO;
import com.mikado.mikadosaas.service.mapper.tenant.UserUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserUser}.
 */
@Service
@Transactional
public class UserUserService {

    private final Logger log = LoggerFactory.getLogger(UserUserService.class);

    private final UserUserRepository userUserRepository;

    private final UserUserMapper userUserMapper;

    public UserUserService(UserUserRepository userUserRepository, UserUserMapper userUserMapper) {
        this.userUserRepository = userUserRepository;
        this.userUserMapper = userUserMapper;
    }

    /**
     * Save a userUser.
     *
     * @param userUserDTO the entity to save.
     * @return the persisted entity.
     */
    public UserUserDTO save(UserUserDTO userUserDTO) {
        log.debug("Request to save UserUser : {}", userUserDTO);
        UserUser userUser = userUserMapper.toEntity(userUserDTO);
        userUser = userUserRepository.save(userUser);
        return userUserMapper.toDto(userUser);
    }

    /**
     * Get all the userUsers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserUserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserUsers");
        return userUserRepository.findAll(pageable)
            .map(userUserMapper::toDto);
    }


    /**
     * Get one userUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserUserDTO> findOne(Long id) {
        log.debug("Request to get UserUser : {}", id);
        return userUserRepository.findById(id)
            .map(userUserMapper::toDto);
    }

    /**
     * Delete the userUser by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserUser : {}", id);
        userUserRepository.deleteById(id);
    }
}
