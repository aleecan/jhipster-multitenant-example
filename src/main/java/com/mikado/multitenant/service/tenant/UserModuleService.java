package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.UserModule;
import com.mikado.multitenant.repository.tenant.UserModuleRepository;
import com.mikado.multitenant.service.dto.tenant.UserModuleDTO;
import com.mikado.multitenant.service.mapper.tenant.UserModuleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserModule}.
 */
@Service
@Transactional
public class UserModuleService {

    private final Logger log = LoggerFactory.getLogger(UserModuleService.class);

    private final UserModuleRepository userModuleRepository;

    private final UserModuleMapper userModuleMapper;

    public UserModuleService(UserModuleRepository userModuleRepository, UserModuleMapper userModuleMapper) {
        this.userModuleRepository = userModuleRepository;
        this.userModuleMapper = userModuleMapper;
    }

    /**
     * Save a userModule.
     *
     * @param userModuleDTO the entity to save.
     * @return the persisted entity.
     */
    public UserModuleDTO save(UserModuleDTO userModuleDTO) {
        log.debug("Request to save UserModule : {}", userModuleDTO);
        UserModule userModule = userModuleMapper.toEntity(userModuleDTO);
        userModule = userModuleRepository.save(userModule);
        return userModuleMapper.toDto(userModule);
    }

    /**
     * Get all the userModules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserModuleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserModules");
        return userModuleRepository.findAll(pageable)
            .map(userModuleMapper::toDto);
    }


    /**
     * Get one userModule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserModuleDTO> findOne(Long id) {
        log.debug("Request to get UserModule : {}", id);
        return userModuleRepository.findById(id)
            .map(userModuleMapper::toDto);
    }

    /**
     * Delete the userModule by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserModule : {}", id);
        userModuleRepository.deleteById(id);
    }
}
